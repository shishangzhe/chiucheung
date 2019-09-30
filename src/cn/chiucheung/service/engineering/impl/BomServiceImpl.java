package cn.chiucheung.service.engineering.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.activiti.engine.impl.pvm.process.TransitionImpl;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.engineering.bom.EngBomMapper;
import cn.chiucheung.dao.mapper.engineering.bom.EngBomSubsidiaryMapper;
import cn.chiucheung.dao.mapper.system.message.SysMessageMapper;
import cn.chiucheung.dao.mapper.system.user.SysUserMapper;
import cn.chiucheung.dao.mapper.warehouse.standardaccessories.WarStandardAccessoriesMapper;
import cn.chiucheung.po.engineering.bom.EngBom;
import cn.chiucheung.po.engineering.bom.EngBomExample;
import cn.chiucheung.po.engineering.bom.EngBomSubsidiary;
import cn.chiucheung.po.engineering.bom.EngBomSubsidiaryExample;
import cn.chiucheung.po.system.message.SysMessage;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.pojo.engineering.bom.EngBomCustom;
import cn.chiucheung.pojo.engineering.bom.EngBomQueryVo;
import cn.chiucheung.pojo.engineering.bom.SalWorkCardItemCustomForEngBom;
import cn.chiucheung.pojo.system.user.SysUserQueryVo;
import cn.chiucheung.service.engineering.BomService;
import cn.chiucheung.utils.ActivitiUtils;
import cn.chiucheung.utils.ResourcesUtil;
import cn.chiucheung.utils.UUIDBuild;
import cn.chiucheung.utils.UserUtils;

@Service
public class BomServiceImpl implements BomService{
	
	@Autowired
	EngBomMapper bomMapper;
	
	@Autowired
	EngBomSubsidiaryMapper bomSubsidiaryMapper;
	
	@Autowired
	WarStandardAccessoriesMapper standardAccessoriesMapper;
	
	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private SysMessageMapper messageMapper;

	@Override
	public List<EngBom> findAllBomList(EngBomQueryVo bomQueryVo) {
		return bomMapper.findAllBomList(bomQueryVo);
	}

	@Override
	public String findAllBomTotal(EngBomQueryVo bomQueryVo) {
		return bomMapper.findAllBomTotal(bomQueryVo);
	}

	@Override
	public List<EngBomSubsidiary> findAllBomSubsidiaryListByEngBomId(String id) {
		EngBomSubsidiaryExample example = new EngBomSubsidiaryExample();
		example.createCriteria().andEngBomIdEqualTo(id).andWarMaterialIdIsNull();
		example.setOrderByClause("order_number");
		List<EngBomSubsidiary> list = bomSubsidiaryMapper.selectByExample(example);
		
		EngBomSubsidiary bomSubsidiary = new EngBomSubsidiary();
		bomSubsidiary.setEngBomId(id);
		
		list.addAll(bomSubsidiaryMapper.findAllEngBomSubsidiaryList(bomSubsidiary));
		Collections.sort(list);
		for (EngBomSubsidiary engBomSubsidiary : list) {
			engBomSubsidiary.setChildren(findAllBomSubsidiaryListByEngBomSubsidiaryId(engBomSubsidiary.getId()));
		}
		return list;
	}
	
	/**
	 * 递归查找子项-递归
	 * @param id
	 * @return
	 */
	private List<EngBomSubsidiary> findAllBomSubsidiaryListByEngBomSubsidiaryId(String id) {
		EngBomSubsidiaryExample example = new EngBomSubsidiaryExample();
		example.createCriteria().andEngBomSubsidiaryIdEqualTo(id).andWarMaterialIdIsNull();
		List<EngBomSubsidiary> list = bomSubsidiaryMapper.selectByExample(example);
		
		EngBomSubsidiary bomSubsidiary = new EngBomSubsidiary();
		bomSubsidiary.setEngBomSubsidiaryId(id);
		
		list.addAll(bomSubsidiaryMapper.findAllEngBomSubsidiaryList(bomSubsidiary));
		Collections.sort(list);
		for (EngBomSubsidiary engBomSubsidiary : list) {
			if (engBomSubsidiary.getState().equals("closed")){
				engBomSubsidiary.setChildren(findAllBomSubsidiaryListByEngBomSubsidiaryId(engBomSubsidiary.getId()));
			}
		}
		return list;
	}
	
	@Override
	public List<SalWorkCardItemCustomForEngBom> findAllWorkCardSubsidiaryList(EngBomQueryVo bomQueryVo) {
		return bomMapper.findAllWorkCardSubsidiaryList(bomQueryVo);
	}
	

	@Override
	public String findAllWorkCardSubsidiaryTotal(EngBomQueryVo bomQueryVo) {
		return bomMapper.findAllWorkCardSubsidiaryTotal(bomQueryVo);
	}
	
	@Override
	public int saveEngBom(Map<String, Object> map) {
		JSONObject bomJSONObject = JSONObject.fromObject(map.get("bom"));
		JSONArray bomSubsidiaryJSONArray = JSONArray.fromObject(map.get("bomSubsidiary"));
		
		EngBom bom = (EngBom) JSONObject.toBean(bomJSONObject, EngBom.class);
		String id = UUIDBuild.getUUID();
		bom.setId(id);
		bom.setState("closed");
		bom.setProcessInstanceId(null);
		
		int i = bomMapper.insert(bom);
		
		for (int j=0;j<bomSubsidiaryJSONArray.size();j++) {//先把children取出来，然后在remove掉，否则会报bean中无children的setting方法
			JSONObject bomSubsidiaryJSONObject = bomSubsidiaryJSONArray.getJSONObject(j);
			JSONArray childrenJSONArray = null;
			if (bomSubsidiaryJSONObject.containsKey("children")){
				if (StringUtils.isNotBlank(bomSubsidiaryJSONObject.getString("children"))){
					childrenJSONArray = bomSubsidiaryJSONObject.getJSONArray("children");
				}
				bomSubsidiaryJSONObject.remove("children");
			}
			
			
			EngBomSubsidiary bomSubsidiary = (EngBomSubsidiary) JSONObject.toBean(bomSubsidiaryJSONObject, EngBomSubsidiary.class);
			
			if (StringUtils.isBlank(bomSubsidiary.getWarMaterialId())){//如果为空，说明是不关联物料，则传过来的所有数据就要
				bomSubsidiary.setWarMaterialId(null);
			}else{//如果不为空，说明是物料，则传过来的数据，只有serialNumber、materialId、version、singletonConsumption、remark、engBomId/engBomSubsidiaryId、id、serialNumber,如果需要存
				String materialId = bomSubsidiary.getWarMaterialId();
				BigDecimal singletonConsumption = bomSubsidiary.getSingletonConsumption();
				String remark = bomSubsidiary.getRemark();
				String serialNumber = bomSubsidiary.getSerialNumber();
				
				bomSubsidiary = new EngBomSubsidiary();
				bomSubsidiary.setSerialNumber(serialNumber);
				bomSubsidiary.setWarMaterialId(materialId);
				bomSubsidiary.setSingletonConsumption(singletonConsumption);
				bomSubsidiary.setRemark(remark);
			}
			
			bomSubsidiary.setId(UUIDBuild.getUUID());
			bomSubsidiary.setEngBomId(id);
			bomSubsidiary.setEngBomSubsidiaryId(null);
			bomSubsidiary.setOrderNumber(j+1);
			
			if (childrenJSONArray != null && childrenJSONArray.size() > 0){
				bomSubsidiary.setState("closed");
			}else{
				bomSubsidiary.setState("");
			}
			bomSubsidiaryMapper.insert(bomSubsidiary);
			
			if (childrenJSONArray != null && childrenJSONArray.size() > 0){
				recursionEngBomSubsidiaryForSave(childrenJSONArray, bomSubsidiary.getId());
			}
		}
		
		return i;
	}
	
	/**
	 * 用于新增保存的递归遍历
	 * @param bomSubsidiaryJSONArray
	 * @param id
	 */
	private void recursionEngBomSubsidiaryForSave(JSONArray bomSubsidiaryJSONArray, String id){
		for (int j=0;j<bomSubsidiaryJSONArray.size();j++) {//先把children取出来，然后在remove掉，否则会报bean中无children的setting方法
			JSONObject bomSubsidiaryJSONObject = bomSubsidiaryJSONArray.getJSONObject(j);
			JSONArray childrenJSONArray = null;
			if (bomSubsidiaryJSONObject.containsKey("children")){
				if (StringUtils.isNotBlank(bomSubsidiaryJSONObject.getString("children"))){
					childrenJSONArray = bomSubsidiaryJSONObject.getJSONArray("children");
				}
				bomSubsidiaryJSONObject.remove("children");
			}
			
			EngBomSubsidiary bomSubsidiary = (EngBomSubsidiary) JSONObject.toBean(bomSubsidiaryJSONObject, EngBomSubsidiary.class);
			
			if (StringUtils.isBlank(bomSubsidiary.getWarMaterialId())){//如果为空，说明是不关联物料，则传过来的所有数据就要
				bomSubsidiary.setWarMaterialId(null);
			}else{//如果不为空，说明是物料，则传过来的数据，只有serialNumber、materialId、singletonConsumption、engBomId/engBomSubsidiaryId、id、serialNumber,如果需要存
				String materialId = bomSubsidiary.getWarMaterialId();
				BigDecimal singletonConsumption = bomSubsidiary.getSingletonConsumption();
				String remark = bomSubsidiary.getRemark();
				String serialNumber = bomSubsidiary.getSerialNumber();
				
				bomSubsidiary = new EngBomSubsidiary();
				bomSubsidiary.setSerialNumber(serialNumber);
				bomSubsidiary.setWarMaterialId(materialId);
				bomSubsidiary.setSingletonConsumption(singletonConsumption);
				bomSubsidiary.setRemark(remark);
			}
			
			bomSubsidiary.setId(UUIDBuild.getUUID());
			bomSubsidiary.setEngBomId(null);
			bomSubsidiary.setEngBomSubsidiaryId(id);
			bomSubsidiary.setOrderNumber(j+1);
			
			if (StringUtils.isBlank(bomSubsidiary.getWarMaterialId())){
				bomSubsidiary.setWarMaterialId(null);
			}
			if (childrenJSONArray != null && childrenJSONArray.size() > 0){
				bomSubsidiary.setState("closed");
			}else{
				bomSubsidiary.setState("");
			}
			bomSubsidiaryMapper.insert(bomSubsidiary);
			
			if (childrenJSONArray != null && childrenJSONArray.size() > 0){
				recursionEngBomSubsidiaryForSave(childrenJSONArray, bomSubsidiary.getId());
			}
		}
	}

	@Override
	public Map<String, Object> findEngBomByIdForEdit(String id, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		EngBom bom = bomMapper.selectByPrimaryKey(id);
		map.put("bom", bom);
		
		if(bom.getProcessInstanceId() != null){
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(bom.getProcessInstanceId());//设置查询条件，流程实例id
			Task task = taskQuery.singleResult();
			if (task != null){//流程进行中！
				if (task.getAssignee().equals(UserUtils.getUserFromSession(session).getAssignee())){//当前审核人才能修改
					map.put("isEdit", true);
				}else{
					map.put("isEdit", false);
					map.put("doNotEditMessage", "您不是当前审核人");
				}
			}else{//流程已结束
				map.put("isEdit", false);
				map.put("doNotEditMessage", "流程已结束");
			}
		}else{
			map.put("isEdit", true);
		}
		EngBomSubsidiaryExample example = new EngBomSubsidiaryExample();
		example.createCriteria().andEngBomIdEqualTo(id).andWarMaterialIdIsNull();

		List<EngBomSubsidiary> bomSubsidiaries = bomSubsidiaryMapper.selectByExample(example);
		
		EngBomSubsidiary bomSubsidiaryQueryVo = new EngBomSubsidiary();
		bomSubsidiaryQueryVo.setEngBomId(id);
		
		bomSubsidiaries.addAll(bomSubsidiaryMapper.findAllEngBomSubsidiaryList(bomSubsidiaryQueryVo));
		Collections.sort(bomSubsidiaries);
		
		for (EngBomSubsidiary bomSubsidiary : bomSubsidiaries) {
			if (bomSubsidiary.getIsMaterial().equals("false")){
				recursionEngBomSubsidiaryForEdit(bomSubsidiary);
			}
		}
		
		map.put("bomSubsidiaries", bomSubsidiaries);
		
		return map;
	}

	@Override
	public Map<String, Object> findEngBomByIdForView(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		EngBom bom = bomMapper.selectByPrimaryKey(id);
		map.put("bom", bom);
		
		EngBomSubsidiaryExample example = new EngBomSubsidiaryExample();
		example.createCriteria().andEngBomIdEqualTo(id).andWarMaterialIdIsNull();

		List<EngBomSubsidiary> bomSubsidiaries = bomSubsidiaryMapper.selectByExample(example);
		
		EngBomSubsidiary bomSubsidiaryQueryVo = new EngBomSubsidiary();
		bomSubsidiaryQueryVo.setEngBomId(id);
		
		bomSubsidiaries.addAll(bomSubsidiaryMapper.findAllEngBomSubsidiaryList(bomSubsidiaryQueryVo));
		Collections.sort(bomSubsidiaries);
		
		for (EngBomSubsidiary bomSubsidiary : bomSubsidiaries) {
			if (bomSubsidiary.getIsMaterial().equals("false")){
				recursionEngBomSubsidiaryForEdit(bomSubsidiary);
			}
		}
		
		map.put("bomSubsidiaries", bomSubsidiaries);
		
		return map;
	}
	
	@Override
	public Map<String, Object> findEngBomByIdForCopy(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		EngBomSubsidiaryExample example = new EngBomSubsidiaryExample();
		example.createCriteria().andEngBomIdEqualTo(id).andWarMaterialIdIsNull();

		List<EngBomSubsidiary> bomSubsidiaries = bomSubsidiaryMapper.selectByExample(example);
		
		EngBomSubsidiary bomSubsidiaryQueryVo = new EngBomSubsidiary();
		bomSubsidiaryQueryVo.setEngBomId(id);
		
		bomSubsidiaries.addAll(bomSubsidiaryMapper.findAllEngBomSubsidiaryList(bomSubsidiaryQueryVo));
		Collections.sort(bomSubsidiaries);
		
		for (EngBomSubsidiary bomSubsidiary : bomSubsidiaries) {
			if (bomSubsidiary.getIsMaterial().equals("false")){
				recursionEngBomSubsidiaryForEdit(bomSubsidiary);
			}
		}
		map.put("bomSubsidiaries", bomSubsidiaries);
		return map;
	}
	
	/**
	 * 用于查找给页面修改的递归
	 * @param bomSubsidiary
	 */
	private void recursionEngBomSubsidiaryForEdit(EngBomSubsidiary engBomSubsidiary) {
		EngBomSubsidiaryExample example = new EngBomSubsidiaryExample();
		example.createCriteria().andEngBomSubsidiaryIdEqualTo(engBomSubsidiary.getId()).andWarMaterialIdIsNull();
		
		List<EngBomSubsidiary> bomSubsidiaries = bomSubsidiaryMapper.selectByExample(example);
		
		EngBomSubsidiary bomSubsidiaryQueryVo = new EngBomSubsidiary();
		bomSubsidiaryQueryVo.setEngBomSubsidiaryId(engBomSubsidiary.getId());
		
		bomSubsidiaries.addAll(bomSubsidiaryMapper.findAllEngBomSubsidiaryList(bomSubsidiaryQueryVo));
		Collections.sort(bomSubsidiaries);
		
		if (bomSubsidiaries != null && bomSubsidiaries.size() > 0){
			engBomSubsidiary.setChildren(bomSubsidiaries);
			for (EngBomSubsidiary bomSubsidiary : bomSubsidiaries) {
				if (bomSubsidiary.getIsMaterial().equals("false")){
					recursionEngBomSubsidiaryForEdit(bomSubsidiary);
				}
			}
		}
	}

	@Override
	public int updateEngBom(Map<String, Object> map, HttpSession session) {
		JSONObject bomJSONObject = JSONObject.fromObject(map.get("bom"));
		JSONArray bomSubsidiaryJSONArray = JSONArray.fromObject(map.get("bomSubsidiary"));
		
		EngBom bom = (EngBom) JSONObject.toBean(bomJSONObject, EngBom.class);
		String id = bom.getId();
		bom.setState("closed");
		
		String processInstanceId = bom.getProcessInstanceId();

		if (StringUtils.isNotBlank(processInstanceId)){//开启审核流程，则需要知道修改人是否是当前审核人
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(processInstanceId);//设置查询条件，流程实例id
			Task task = taskQuery.singleResult();
			if (task != null){//流程进行中！
				if (!task.getAssignee().equals(UserUtils.getUserFromSession(session).getAssignee())){//当前审核人才能修改
					throw new RuntimeException("您不是当前审核人，不能修改");
				}
			}else{//流程已结束
				throw new RuntimeException("流程已结束，不能修改");
			}
		}else{
			bom.setProcessInstanceId(null);
		}
		
		int i = bomMapper.updateByPrimaryKeyWithBLOBs(bom);
		
		//先删除
		EngBomSubsidiaryExample example = new EngBomSubsidiaryExample();
		example.createCriteria().andEngBomIdEqualTo(id);
		List<EngBomSubsidiary> bomSubsidiaries = bomSubsidiaryMapper.selectByExample(example);
		for (EngBomSubsidiary bomSubsidiary : bomSubsidiaries) {
			recursionEngBomSubsidiaryForDelete(bomSubsidiary);
			bomSubsidiaryMapper.deleteByPrimaryKey(bomSubsidiary.getId());
		}
		
		//后新增
		for (int j=0;j<bomSubsidiaryJSONArray.size();j++) {//先把children取出来，然后在remove掉，否则会报bean中无children的setting方法
			JSONObject bomSubsidiaryJSONObject = bomSubsidiaryJSONArray.getJSONObject(j);
			JSONArray childrenJSONArray = null;
			if (bomSubsidiaryJSONObject.containsKey("children")){
				if (StringUtils.isNotBlank(bomSubsidiaryJSONObject.getString("children"))){
					childrenJSONArray = bomSubsidiaryJSONObject.getJSONArray("children");
				}
				bomSubsidiaryJSONObject.remove("children");
			}
			
			
			EngBomSubsidiary bomSubsidiary = (EngBomSubsidiary) JSONObject.toBean(bomSubsidiaryJSONObject, EngBomSubsidiary.class);

			if (StringUtils.isBlank(bomSubsidiary.getWarMaterialId())){//如果为空，说明是不关联物料，则传过来的所有数据就要
				bomSubsidiary.setWarMaterialId(null);
			}else{//如果不为空，说明是物料，则传过来的数据，只有materialId、version、singletonConsumption、remark、engBomId/engBomSubsidiaryId、id、serialNumber,如果需要存
				String materialId = bomSubsidiary.getWarMaterialId();
				BigDecimal singletonConsumption = bomSubsidiary.getSingletonConsumption();
				String remark = bomSubsidiary.getRemark();
				
				bomSubsidiary = new EngBomSubsidiary();
				bomSubsidiary.setWarMaterialId(materialId);
				bomSubsidiary.setSingletonConsumption(singletonConsumption);
				bomSubsidiary.setRemark(remark);
			}
			
			bomSubsidiary.setId(UUIDBuild.getUUID());
			bomSubsidiary.setEngBomId(id);
			bomSubsidiary.setEngBomSubsidiaryId(null);
			bomSubsidiary.setOrderNumber(j+1);
			
			if (childrenJSONArray != null && childrenJSONArray.size() > 0){
				bomSubsidiary.setState("closed");
			}else{
				bomSubsidiary.setState("");
			}
			bomSubsidiaryMapper.insert(bomSubsidiary);
			
			if (childrenJSONArray != null && childrenJSONArray.size() > 0){
				recursionEngBomSubsidiaryForSave(childrenJSONArray, bomSubsidiary.getId());
			}
		}
		
		return i;
	}
	

	@Override
	public int deleteEngBomById(String id) {
		EngBom bom = bomMapper.selectByPrimaryKey(id);
		
		if (StringUtils.isNotBlank(bom.getProcessInstanceId())){
			throw new RuntimeException("已开启审核，不能删除");
		}

		EngBomSubsidiaryExample example = new EngBomSubsidiaryExample();
		example.createCriteria().andEngBomIdEqualTo(id);
		List<EngBomSubsidiary> bomSubsidiaries = bomSubsidiaryMapper.selectByExample(example);
		for (EngBomSubsidiary bomSubsidiary : bomSubsidiaries) {
			recursionEngBomSubsidiaryForDelete(bomSubsidiary);
		}
		
		return bomMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 用于删除bom的所有bomSubsidiary的递归方法
	 * @param engBomSubsidiary
	 */
	private void recursionEngBomSubsidiaryForDelete(EngBomSubsidiary engBomSubsidiary) {
		EngBomSubsidiaryExample example = new EngBomSubsidiaryExample();
		example.createCriteria().andEngBomSubsidiaryIdEqualTo(engBomSubsidiary.getId());
		List<EngBomSubsidiary> bomSubsidiaries = bomSubsidiaryMapper.selectByExample(example);
		if (bomSubsidiaries != null && bomSubsidiaries.size() > 0){
			for (EngBomSubsidiary bomSubsidiary : bomSubsidiaries) {
				recursionEngBomSubsidiaryForDelete(bomSubsidiary);
			}
		}
		bomSubsidiaryMapper.deleteByPrimaryKey(engBomSubsidiary.getId());
	}

	@Override
	public int getMaxNumberOfTimes(String salWorkCardSubsidiaryId) {
		EngBomExample example = new EngBomExample();
		example.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(salWorkCardSubsidiaryId);
		example.setOrderByClause("number_of_times");
		List<EngBom> boms = bomMapper.selectByExample(example);
		return boms != null && boms.size() > 0 ? boms.get(boms.size()-1).getNumberOfTimes() : 0;
	}

	@Override
	public List<EngBom> findAllBomForMerge(EngBomQueryVo bomQueryVo) {
		return bomMapper.findAllBomForMerge(bomQueryVo);
	}

	@Override
	public Map<String, Object> mergeCopyBom(EngBomQueryVo bomQueryVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<EngBom> boms =  bomMapper.findAllBomForMerge(bomQueryVo);
		
		//String id = boms.get(0).getId();//获取第一次下bom的id
		
		
		List<EngBomSubsidiary> list = new ArrayList<EngBomSubsidiary>();
		
		int k = 0;
		
		//从第二个开始，把BomSubsidiary的bomId，全部改成第一次bom的id，
		for (int i=0;i<boms.size();i++) {
			EngBomSubsidiaryExample bomSubsidiaryExample = new EngBomSubsidiaryExample();
			bomSubsidiaryExample.createCriteria().andEngBomIdEqualTo(boms.get(i).getId()).andWarMaterialIdIsNull();
			
			List<EngBomSubsidiary> bomSubsidiaries = bomSubsidiaryMapper.selectByExample(bomSubsidiaryExample);
			
			EngBomSubsidiary bomSubsidiaryQueryVo = new EngBomSubsidiary();
			bomSubsidiaryQueryVo.setEngBomId(boms.get(i).getId());
			
			bomSubsidiaries.addAll(bomSubsidiaryMapper.findAllEngBomSubsidiaryList(bomSubsidiaryQueryVo));
			
			for (EngBomSubsidiary bomSubsidiary : bomSubsidiaries) {
				bomSubsidiary.setOrderNumber(bomSubsidiary.getOrderNumber() + k);
			}
			
			list.addAll(bomSubsidiaries);
			
			k = list.size();
			
			for (EngBomSubsidiary bomSubsidiary : bomSubsidiaries) {
				if (bomSubsidiary.getIsMaterial().equals("false")){
					recursionEngBomSubsidiaryForEdit(bomSubsidiary);
				}
			}
		}
		
		
		Map<String, EngBomSubsidiary> bomSubsidiaryMap = new HashMap<String, EngBomSubsidiary>();
		for (EngBomSubsidiary bomSubsidiary : list) {//合并重复
			if (StringUtils.isNotBlank(bomSubsidiary.getWarMaterialId())){//标准bom才需要合并，否则不需要合并
				if (bomSubsidiaryMap.containsKey(bomSubsidiary.getWarMaterialId())){
					EngBomSubsidiary engBomSubsidiary = bomSubsidiaryMap.get(bomSubsidiary.getWarMaterialId());
					engBomSubsidiary.setSingletonConsumption(engBomSubsidiary.getSingletonConsumption().add(bomSubsidiary.getSingletonConsumption()));
				}else{
					bomSubsidiaryMap.put(bomSubsidiary.getWarMaterialId(), bomSubsidiary);
				}
			}else{
				bomSubsidiaryMap.put(bomSubsidiary.getId(), bomSubsidiary);
			}
		}
		
		list.clear();
		for (Entry<String, EngBomSubsidiary> entry : bomSubsidiaryMap.entrySet()){
			list.add(entry.getValue());
		}
		
		Collections.sort(list);
		
		map.put("bomSubsidiaries", list);
		
		return map;
	}

	@Override
	public List<EngBomSubsidiary> calculationMaterialTotalSumById(String id) {
		EngBomSubsidiaryExample example = new EngBomSubsidiaryExample();
		example.createCriteria().andEngBomIdEqualTo(id).andWarMaterialIdIsNull();
		List<EngBomSubsidiary> list = bomSubsidiaryMapper.selectByExample(example);
		
		EngBomSubsidiary bomSubsidiary = new EngBomSubsidiary();
		bomSubsidiary.setEngBomId(id);
		
		list.addAll(bomSubsidiaryMapper.findAllEngBomSubsidiaryList(bomSubsidiary));
		Collections.sort(list);
		for (EngBomSubsidiary engBomSubsidiary : list) {
			engBomSubsidiary.setChildren(findAllBomSubsidiaryListByEngBomSubsidiaryId(engBomSubsidiary.getId()));
		}
		
		List<EngBomSubsidiary> bomSubsidiaries = new ArrayList<EngBomSubsidiary>();
		for (EngBomSubsidiary engBomSubsidiary : list) {
			findEngBomSubsidiaryForMaterial(bomSubsidiaries, engBomSubsidiary);
		}
		
		Map<String, EngBomSubsidiary> map = new HashMap<String, EngBomSubsidiary>();
		for (EngBomSubsidiary engBomSubsidiary : bomSubsidiaries) {
			if (map.containsKey(engBomSubsidiary.getWarMaterialId())){
				map.get(engBomSubsidiary.getWarMaterialId()).setSingletonConsumption(map.get(engBomSubsidiary.getWarMaterialId()).getSingletonConsumption().add(engBomSubsidiary.getSingletonConsumption()));
			}else{
				map.put(engBomSubsidiary.getWarMaterialId(), engBomSubsidiary);
			}
		}
		
		bomSubsidiaries = new ArrayList<EngBomSubsidiary>();
		for (Entry<String, EngBomSubsidiary> entry : map.entrySet()){
			bomSubsidiaries.add(entry.getValue());
		}
		
		return bomSubsidiaries;
	}
	
	/**
	 * bomSubsidiary和bomSubsidiary的children中找到物料，并add到list中，递归方法
	 * @param list
	 * @param bomSubsidiary
	 */
	private void findEngBomSubsidiaryForMaterial(List<EngBomSubsidiary> list, EngBomSubsidiary bomSubsidiary){
		if (bomSubsidiary.getChildren() != null && bomSubsidiary.getChildren().size() > 0){
			for (EngBomSubsidiary engBomSubsidiary : bomSubsidiary.getChildren()) {
				findEngBomSubsidiaryForMaterial(list, engBomSubsidiary);
			}
		}
		
		if (bomSubsidiary.getWarMaterialId() != null){
			bomSubsidiary.setChildren(null);
			list.add(bomSubsidiary);
		}
	}

	@Override
	public List<SysUser> queryAuditorById(String id, String processInstanceId, HttpSession session) {
		if (StringUtils.isBlank(processInstanceId)){
			EngBom bom = bomMapper.selectByPrimaryKey(id);
			processInstanceId = bom.getProcessInstanceId();
		}
		List<String> loginNames = new ArrayList<String>();
		
		List<SysUser> users = new ArrayList<SysUser>();
		
		if (StringUtils.isNotBlank(processInstanceId)){//已经开始了任务
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(processInstanceId);
			Task task = taskQuery.singleResult();
			if (task != null){
				if (task.getAssignee().equals(UserUtils.getUserFromSession(session).getAssignee())){//表示是当前任务的办理人
					String activityImplId = null;
					List<TaskDefinition> taskDefinitions = null;
					 
			        //获取流程实例Id信息   
			          
			        //获取流程发布Id信息   
			        String definitionId = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getProcessDefinitionId();  
			          
			        ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)  
			                .getDeployedProcessDefinition(definitionId);  
			          
			        ExecutionEntity execution = (ExecutionEntity) runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
			          
			        //当前流程节点Id信息   
			        String activitiId = execution.getActivityId();    
			          
			        //获取流程所有节点信息   
			        List<ActivityImpl> activitiList = processDefinitionEntity.getActivities();   
			        
			        //遍历所有节点信息   
			        for(ActivityImpl activityImpl : activitiList){      
			        	activityImplId = activityImpl.getId();     
			              
			            // 找到当前节点信息  
			            if (activitiId.equals(activityImplId)) {
			        		taskDefinitions = ActivitiUtils.nextTaskDefinition(activityImpl, activityImpl.getId(), null, processInstanceId, runtimeService);  
			                break;  
			            }  
			        }
			        loginNames = new ArrayList<String>();
			        
			        if (taskDefinitions != null && taskDefinitions.size() > 0){
			        	for (TaskDefinition taskDefinition : taskDefinitions) {
			        		Set<Expression> expressions = taskDefinition.getCandidateUserIdExpressions();
					       
					        for (Expression expression : expressions) {
					        	String loginName = expression.getExpressionText();
					        	loginNames.add(loginName);
							}
						}
			        }
				}else{
					throw new RuntimeException("对不起，您不是当前任务的办理人！");
				}
			}else{
				throw new RuntimeException("当前流程已经结束，不能审核");
			}
		}else{//未开启任务
			String processDefinitionKey =  ResourcesUtil.getValue("activiti", "bomProcessDefinitionKey");
			
			loginNames = ActivitiUtils.getCandidateUsers(repositoryService, processDefinitionKey);
		}
		
		if (loginNames.size() > 0){
	        SysUserQueryVo userQueryVo = new SysUserQueryVo();
	        userQueryVo.setInLoginNames(loginNames);
	        users = userMapper.findAllSysUserList(userQueryVo);
	        if (users.size() != loginNames.size()){//这里是表示流程里查询到下一节点的用户，在系统的用户表里查询的时候，无法查询到该用户
	        	for (SysUser user : users) {
					if (loginNames.contains(user.getLoginName())){
						loginNames.remove(user.getLoginName());
					}
				}
	        	if (loginNames.size()>0){
	        		for (String string : loginNames) {
	        			SysUser sysUser = new SysUser();
	        			sysUser.setLoginName(string);
	        			sysUser.setUsername("流程定义的用户不存在");
						users.add(sysUser);
					}
	        	}
	        }
        }
		return users;
	}

	@Override
	public void auditEngBom(String id, String assigneeId,HttpSession session) {
		EngBomCustom bom = bomMapper.findBomCustomById(id);
		String processInstanceId = bom.getProcessInstanceId();
		
		List<SysUser> users = queryAuditorById(id, processInstanceId, session);
		
		//发送消息
		SysMessage message = new SysMessage();
		message.setId(UUIDBuild.getUUID());
		message.setIsRead(false);
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("<b>");
		buffer.append(bom.getWorkCardNo());
		buffer.append("-项");
		buffer.append(bom.getSequence());
		buffer.append("</b>的第");
		buffer.append(bom.getNumberOfTimes());
		buffer.append("次下的Bom");
		
		
		if (StringUtils.isNotBlank(processInstanceId)){//已经开始了任务
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(processInstanceId);
			Task task = taskQuery.singleResult();
			if (task != null){
				if (task.getAssignee().equals(UserUtils.getUserFromSession(session).getAssignee())){
					if (StringUtils.isNotBlank(assigneeId)){//
						SysUser assigneeUser = null;
						for (SysUser sysUser : users) {
							if (assigneeId.equals(sysUser.getId())){//说明要发送给下一节点的人包含在下一节点的候选人中
								assigneeUser = sysUser;
								break;
							}
						}
						if (assigneeUser != null){
							taskService.complete(task.getId());
							task = taskQuery.singleResult();
							taskService.claim(task.getId(), assigneeUser.getAssignee());
							buffer.append("需要您审核，请及时处理！");
							
							message.setSender(UserUtils.getUserFromSession(session).getLoginName());
							message.setReceiver(assigneeUser.getLoginName());
						}else{
							throw new RuntimeException("节点候选人员中不包含您选择接收任务的人员");
						}
					}else{//如果是最后一个节点
						if (users != null && users.size() > 0){
							throw new RuntimeException("没有选择接收任务的人员");
						}else{
							taskService.complete(task.getId());
							
							buffer.append("的审核已完成！");
							
							message.setSender("admin");
							HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
							//设置发起人为消息接收人
							message.setReceiver(processInstance.getStartUserId().substring(processInstance.getStartUserId().indexOf("(") + 1,processInstance.getStartUserId().indexOf(")")));
						}
					}
				}else{
					throw new RuntimeException("对不起，您不是当前任务的办理人，请刷新数据！");
				}
			}else{
				throw new RuntimeException("当前流程已经结束，不能审核");
			}
			
		}else{//未开启任务
			if (StringUtils.isBlank(assigneeId)){
				throw new RuntimeException("没有选择接收任务的人员");
			}
			
			SysUser assigneeUser = null;
			for (SysUser sysUser : users) {
				if (assigneeId.equals(sysUser.getId())){//说明要发送给下一节点的人包含在下一节点的候选人中
					assigneeUser = sysUser;
					break;
				}
			}
			if (assigneeUser == null){
				throw new RuntimeException("节点候选人员中不包含您选择接收任务的人员");
			}
			
			identityService.setAuthenticatedUserId(UserUtils.getUserFromSession(session).getAssignee());
			String processDefinitionKey =  ResourcesUtil.getValue("activiti", "bomProcessDefinitionKey");
			String businessKey = id;
			ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey);
			processInstanceId = processInstance.getProcessInstanceId();
			bom.setProcessInstanceId(processInstanceId);
			
			bomMapper.updateByPrimaryKey(bom);
			
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(processInstanceId);
			Task task = taskQuery.singleResult();
			
			taskService.complete(task.getId());//发起人立刻完成任务，发送到下一节点
			
			task = taskQuery.singleResult();
			
			taskService.claim(task.getId(), assigneeUser.getAssignee());
			
			buffer.append("需要您审核，请及时处理！");
			
			message.setSender(UserUtils.getUserFromSession(session).getLoginName());
			message.setReceiver(assigneeUser.getLoginName());
		}
		
		message.setMessage(buffer.toString());
		message.setSendTime(new Date());
		messageMapper.insert(message);
	}
	
	@Override
	public void revokeProcess(String id, HttpSession session) {
		EngBomCustom bom = bomMapper.findBomCustomById(id);
		String processInstanceId = bom.getProcessInstanceId();
		
		if (StringUtils.isNotBlank(processInstanceId)){
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(processInstanceId);//设置查询条件，流程实例id
			Task task = taskQuery.singleResult();
			
			if (task == null){//已完成
				throw new RuntimeException("审核已完成，无法撤销");
			}else{
				HistoricTaskInstanceQuery historicTaskInstanceQuery = historyService.createHistoricTaskInstanceQuery();
				historicTaskInstanceQuery.processInstanceId(processInstanceId);
				List<HistoricTaskInstance> historicTaskInstances = historicTaskInstanceQuery.list();
				
				if (historicTaskInstances.get(0).getAssignee().equals(UserUtils.getUserFromSession(session).getAssignee())){
					//发送消息
					List<SysMessage> messages = new ArrayList<SysMessage>();
					
					for (HistoricTaskInstance historicTaskInstance : historicTaskInstances) {
						String assignee = historicTaskInstance.getAssignee();
						if (!historicTaskInstances.get(0).getAssignee().equals(assignee)){//不给自己发
							SysMessage message = new SysMessage();
							message.setId(UUIDBuild.getUUID());
							message.setIsRead(false);
							
							StringBuffer buffer = new StringBuffer();
							
							buffer.append("<b>");
							buffer.append(bom.getWorkCardNo());
							buffer.append("-项");
							buffer.append(bom.getSequence());
							buffer.append("</b>的第");
							buffer.append(bom.getNumberOfTimes());
							buffer.append("次下的Bom");
							buffer.append("的审核流程，被<b>");
							buffer.append(UserUtils.getUserFromSession(session).getAssignee());
							buffer.append("</b>撤销");
							message.setMessage(buffer.toString());
							
							message.setSender(UserUtils.getUserFromSession(session).getLoginName());
							
							message.setReceiver(assignee.substring(assignee.indexOf("(") + 1, assignee.indexOf(")")));
							
							message.setSendTime(new Date());
							
							if (!messages.contains(message)){
								messages.add(message);
							}
						}
					}
					if (messages != null && messages.size() > 0){
						messageMapper.insertList(messages);
					}
					
					//删除正在运行的流程
					runtimeService.deleteProcessInstance(processInstanceId,""); 
					//删除已经结束流程，也就是历史流程
					historyService.deleteHistoricProcessInstance(processInstanceId);//(顺序不能换) 
	
					bom.setProcessInstanceId(null);
					bomMapper.updateByPrimaryKey(bom);
					
				}else{
					throw new RuntimeException("您不是流程发起人，无法撤销");
				}
			}
		}else{
			throw new RuntimeException("没有开启审核流程");
		}
	}

	@Override
	public void takeBackEngBom(String id, String cause, HttpSession session) {
		EngBomCustom bom = bomMapper.findBomCustomById(id);
		String processInstanceId = bom.getProcessInstanceId();
		
		Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
		if (task != null){//流程没有结束
			//查找历史审核记录
			List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId).list();
			if (list.size()>1){//表示存在上一节点，则可以收回
				//list.size()-1是当前节点，list.size()-2是上一节点
				String assignee = list.get(list.size()-2).getAssignee();//获取上一节点的审核人
				String taskDefinitionKey = list.get(list.size()-2).getTaskDefinitionKey();//上去上一节点的标识
				String prevTaskId = list.get(list.size()-2).getId();//上一节点的ID,用于后面删除改历史消息
				if (assignee.equals(UserUtils.getUserFromSession(session).getAssignee())){//表示当前收回的是上一节点的办理人
					// 取得当前任务.当前任务节点
					HistoricTaskInstance currTask = historyService.createHistoricTaskInstanceQuery().taskId(task.getId()).singleResult();
					// 取得流程实例，流程实例
					ProcessInstance instance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
					
					
					//获取当前的流程定义，用于后面根据节点的表示获取ActivityImpl
					ProcessDefinitionEntity definition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService).getDeployedProcessDefinition(currTask.getProcessDefinitionId());
					
					// 获取当前节点
					ActivityImpl currActivity = ((ProcessDefinitionImpl) definition).findActivity(currTask.getTaskDefinitionKey());
		           
		           
					//获取来源节点的关系（也就是节点间的连线）
					List<PvmTransition> nextTransitionList = currActivity.getIncomingTransitions();

					List<PvmTransition> oriPvmTransitionList = new ArrayList<PvmTransition>();
					//新建一个节点连线关系集合
					//获取出口节点的关系（也就是节点间的连线）
					List<PvmTransition> pvmTransitionList = currActivity.getOutgoingTransitions();
		           
					for (PvmTransition pvmTransition : pvmTransitionList) {
						oriPvmTransitionList.add(pvmTransition);
					}
					// 清除当前活动的出口
					pvmTransitionList.clear();
			           
					// 建立新出口
					//List<TransitionImpl> newTransitions = new ArrayList<TransitionImpl>();
		               
					// 获取上一节点
					ActivityImpl nextActivityImpl = ((ProcessDefinitionImpl) definition).findActivity(taskDefinitionKey);
					TransitionImpl newTransition = currActivity.createOutgoingTransition();
					newTransition.setDestination(nextActivityImpl);
					//newTransitions.add(newTransition);
					// 完成任务
					TaskQuery taskQuery = taskService.createTaskQuery();
					taskQuery.processInstanceId(instance.getId());
					
					Task task1 = taskQuery.singleResult();
					taskService.complete(task1.getId());
					historyService.deleteHistoricTaskInstance(task1.getId());//删除当前节点的历史任务
					historyService.deleteHistoricTaskInstance(prevTaskId);//删除上一节点的历史任务
					Task task2 = taskQuery.singleResult();
					taskService.claim(task2.getId(), assignee);//上一节点的人拾取任务
					
					
					
					//发送消息（发给被收回评审的人）
					SysMessage message = new SysMessage();
					message.setId(UUIDBuild.getUUID());
					message.setIsRead(false);
					
					StringBuffer buffer = new StringBuffer();
					buffer.append("<b>");
					buffer.append(bom.getWorkCardNo());
					buffer.append("-项");
					buffer.append(bom.getSequence());
					buffer.append("</b>的第");
					buffer.append(bom.getNumberOfTimes());
					buffer.append("次下的Bom");
					buffer.append("的审核流程，被<b>");
					buffer.append(UserUtils.getUserFromSession(session).getAssignee());
					buffer.append("</b>收回，原因：<font color='red'>");
					buffer.append(cause);
					buffer.append("</font>");
					message.setMessage(buffer.toString());
					
					message.setSender(UserUtils.getUserFromSession(session).getLoginName());
					
					message.setReceiver(task.getAssignee().substring(task.getAssignee().indexOf("(") + 1, task.getAssignee().indexOf(")")));
					
					message.setSendTime(new Date());
					messageMapper.insert(message);
		           
					// 恢复方向
					//for (TransitionImpl transitionImpl : newTransitions) {
						currActivity.getOutgoingTransitions().remove(newTransition);
					//}
					//恢复出口
					for (PvmTransition pvmTransition : oriPvmTransitionList) {
						pvmTransitionList.add(pvmTransition);
					}
				}else{//不是上一节点的办理人
					throw new RuntimeException("你不是上一节点任务的办理人，不能收回");
				}
			}else{//不存在上一节点，不能收回
				throw new RuntimeException("你当前是第一节点，不能收回");
			}
		}else{//流程结束
			throw new RuntimeException("当前流程已经结束，不能收回");
		}
	}

	@Override
	public void rollBackEngBom(String id, String cause, HttpSession session) {
		EngBomCustom bom = bomMapper.findBomCustomById(id);
		String processInstanceId = bom.getProcessInstanceId();
		
		Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
		if (task != null){//流程没有结束
			if (task.getAssignee().equals(UserUtils.getUserFromSession(session).getAssignee())){
				// 取得当前任务.当前任务节点
				HistoricTaskInstance currTask = historyService.createHistoricTaskInstanceQuery().taskId(task.getId()).singleResult();
				// 取得流程实例，流程实例
				ProcessInstance instance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
			
				//查找历史审核记录
				List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId).list();
				if (list.size()>1){//表示存在上一节点，则可以退回
					//list.size()-1是当前节点，list.size()-2是上一节点
					String assignee = list.get(list.size()-2).getAssignee();//获取上一节点的审核人
					String taskDefinitionKey = list.get(list.size()-2).getTaskDefinitionKey();//上去上一节点的标识
					String prevTaskId = list.get(list.size()-2).getId();//上一节点的ID,用于后面删除改历史消息
					
					//获取当前的流程定义，用于后面根据节点的表示获取ActivityImpl
					ProcessDefinitionEntity definition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService).getDeployedProcessDefinition(currTask.getProcessDefinitionId());
					
					// 获取当前节点
					ActivityImpl currActivity = ((ProcessDefinitionImpl) definition).findActivity(currTask.getTaskDefinitionKey());
					
		           
					//获取来源节点的关系（也就是节点间的连线）
					List<PvmTransition> nextTransitionList = currActivity.getIncomingTransitions();
		
					List<PvmTransition> oriPvmTransitionList = new ArrayList<PvmTransition>();
					//新建一个节点连线关系集合
					//获取出口节点的关系（也就是节点间的连线）
					List<PvmTransition> pvmTransitionList = currActivity.getOutgoingTransitions();
					//
					for (PvmTransition pvmTransition : pvmTransitionList) {
						oriPvmTransitionList.add(pvmTransition);
					}
					// 清除当前活动的出口
					pvmTransitionList.clear();
					
					
					// 建立新出口
					//List<TransitionImpl> newTransitions = new ArrayList<TransitionImpl>();
		               
					// 获取上一节点
					ActivityImpl nextActivityImpl = ((ProcessDefinitionImpl) definition).findActivity(taskDefinitionKey);
					TransitionImpl newTransition = currActivity.createOutgoingTransition();
					newTransition.setDestination(nextActivityImpl);
					//newTransitions.add(newTransition);
					// 完成任务
					TaskQuery taskQuery = taskService.createTaskQuery();
					taskQuery.processInstanceId(instance.getId());
					
					Task task1 = taskQuery.singleResult();
					taskService.complete(task1.getId());
					historyService.deleteHistoricTaskInstance(task1.getId());//删除当前节点的历史任务
					historyService.deleteHistoricTaskInstance(prevTaskId);//删除上一节点的历史任务
					Task task2 = taskQuery.singleResult();
					taskService.claim(task2.getId(), assignee);//上一节点的人拾取任务
					
					//发送消息（发给被收回评审的人）
					SysMessage message = new SysMessage();
					message.setId(UUIDBuild.getUUID());
					message.setIsRead(false);
					
					StringBuffer buffer = new StringBuffer();
					buffer.append("<b>");
					buffer.append(bom.getWorkCardNo());
					buffer.append("-项");
					buffer.append(bom.getSequence());
					buffer.append("</b>的第");
					buffer.append(bom.getNumberOfTimes());
					buffer.append("次下的Bom");
					buffer.append("的审核流程，被<b>");
					buffer.append(UserUtils.getUserFromSession(session).getAssignee());
					buffer.append("</b>退回，原因：<font color='red'>");
					buffer.append(cause);
					buffer.append("</font>");
					message.setMessage(buffer.toString());
					
					message.setSender(UserUtils.getUserFromSession(session).getLoginName());
					
					message.setReceiver(assignee.substring(assignee.indexOf("(") + 1, assignee.indexOf(")")));
					
					message.setSendTime(new Date());
					messageMapper.insert(message);
					
					// 恢复方向
					//for (TransitionImpl transitionImpl : newTransitions) {
					currActivity.getOutgoingTransitions().remove(newTransition);
					//}
					//恢复出口
					for (PvmTransition pvmTransition : oriPvmTransitionList) {
						pvmTransitionList.add(pvmTransition);
					}
				}else{//不存在上一节点，不能退回
					throw new RuntimeException("你当前是第一节点，不能退回");
				}
			}else{//不是当前任务的办理人
				throw new RuntimeException("你不是当前任务的办理人，不能退回");
			}
		}else{//流程结束
			throw new RuntimeException("当前流程已经结束，不能退回");
		}
	}

	@Override
	public void antiAuditEngBom(String id, String cause,HttpSession session) {
		EngBomCustom bom = bomMapper.findBomCustomById(id);
		String processInstanceId = bom.getProcessInstanceId();
		
		
		TaskQuery taskQuery = taskService.createTaskQuery();
		taskQuery.processInstanceId(processInstanceId);//设置查询条件，流程实例id
		Task task = taskQuery.singleResult();
		
		if (task == null){//已完成
		
			HistoricTaskInstanceQuery historicTaskInstanceQuery = historyService.createHistoricTaskInstanceQuery();
			historicTaskInstanceQuery.processInstanceId(processInstanceId);
			historicTaskInstanceQuery.orderByHistoricTaskInstanceStartTime().desc();
			List<HistoricTaskInstance> historicTaskInstances = historicTaskInstanceQuery.list();
			//List<String> assignees = new ArrayList<String>();//这样可能出现重复发消息
			HashSet<String> assignees = new HashSet<String>();//需要发送消息的人（流程进行到当前节点，当前节点的人没有审批，也发送消息通知，因为通知了他要审核）
			for (HistoricTaskInstance historicTaskInstance : historicTaskInstances) {//遍历流程历史记录，获取流程每个节点的审核人员
				assignees.add(historicTaskInstance.getAssignee());
			}
			
			assignees.remove(UserUtils.getUserFromSession(session).getAssignee());//不需要发消息给自己
				
			historyService.deleteHistoricProcessInstance(processInstanceId);//删除历史记录
			
			//发送消息
			List<SysMessage> messages = new ArrayList<SysMessage>();
			for (String receiver : assignees) {
				SysMessage message = new SysMessage();
				message.setId(UUIDBuild.getUUID());
				message.setIsRead(false);
				
				StringBuffer buffer = new StringBuffer();
				buffer.append("<b>");
				buffer.append(bom.getWorkCardNo());
				buffer.append("-项");
				buffer.append(bom.getSequence());
				buffer.append("</b>的第");
				buffer.append(bom.getNumberOfTimes());
				buffer.append("次下的Bom");
				buffer.append("的审核流程，被<b>");
				buffer.append(UserUtils.getUserFromSession(session).getAssignee());
				buffer.append("</b>反审核，原因：<font color='red'>");
				buffer.append(cause);
				buffer.append("</font>");
				message.setMessage(buffer.toString());
				
				message.setSender(UserUtils.getUserFromSession(session).getLoginName());
				
				message.setReceiver(receiver.substring(receiver.indexOf("(") + 1, receiver.indexOf(")")));
				
				message.setSendTime(new Date());
				
				if (!messages.contains(message)){
					messages.add(message);
				}
			}
			
			if (messages != null && messages.size() > 0){
				messageMapper.insertList(messages);
			}
			
			
			//并将所有审核人和审核时间清空，重新设置流程实例id
			bom.setProcessInstanceId(null);
			bomMapper.updateByPrimaryKey(bom);
		}else{
			throw new RuntimeException("审核未完成无法反审核");
		}
	}
}
