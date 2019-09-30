package cn.chiucheung.service.sales.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.dao.mapper.sales.workcard.SalWorkCardDsqMapper;
import cn.chiucheung.dao.mapper.sales.workcard.SalWorkCardDsqOtherMapper;
import cn.chiucheung.dao.mapper.sales.workcard.SalWorkCardEiaMapper;
import cn.chiucheung.dao.mapper.sales.workcard.SalWorkCardEiaOtherMapper;
import cn.chiucheung.dao.mapper.sales.workcard.SalWorkCardFileMapper;
import cn.chiucheung.dao.mapper.sales.workcard.SalWorkCardJg3Mapper;
import cn.chiucheung.dao.mapper.sales.workcard.SalWorkCardJg5Mapper;
import cn.chiucheung.dao.mapper.sales.workcard.SalWorkCardJg6Mapper;
import cn.chiucheung.dao.mapper.sales.workcard.SalWorkCardKztMapper;
import cn.chiucheung.dao.mapper.sales.workcard.SalWorkCardKztOtherMapper;
import cn.chiucheung.dao.mapper.sales.workcard.SalWorkCardMapper;
import cn.chiucheung.dao.mapper.sales.workcard.SalWorkCardSubsidiaryMapper;
import cn.chiucheung.dao.mapper.system.message.SysMessageMapper;
import cn.chiucheung.dao.mapper.system.user.SysUserMapper;
import cn.chiucheung.po.sales.workcard.SalWorkCard;
import cn.chiucheung.po.sales.workcard.SalWorkCardDsq;
import cn.chiucheung.po.sales.workcard.SalWorkCardDsqExample;
import cn.chiucheung.po.sales.workcard.SalWorkCardDsqOther;
import cn.chiucheung.po.sales.workcard.SalWorkCardDsqOtherExample;
import cn.chiucheung.po.sales.workcard.SalWorkCardDsqWithBLOBs;
import cn.chiucheung.po.sales.workcard.SalWorkCardEia;
import cn.chiucheung.po.sales.workcard.SalWorkCardEiaExample;
import cn.chiucheung.po.sales.workcard.SalWorkCardEiaOther;
import cn.chiucheung.po.sales.workcard.SalWorkCardEiaOtherExample;
import cn.chiucheung.po.sales.workcard.SalWorkCardExample;
import cn.chiucheung.po.sales.workcard.SalWorkCardFile;
import cn.chiucheung.po.sales.workcard.SalWorkCardFileExample;
import cn.chiucheung.po.sales.workcard.SalWorkCardJg3;
import cn.chiucheung.po.sales.workcard.SalWorkCardJg3Example;
import cn.chiucheung.po.sales.workcard.SalWorkCardJg5;
import cn.chiucheung.po.sales.workcard.SalWorkCardJg5Example;
import cn.chiucheung.po.sales.workcard.SalWorkCardJg6;
import cn.chiucheung.po.sales.workcard.SalWorkCardJg6Example;
import cn.chiucheung.po.sales.workcard.SalWorkCardKzt;
import cn.chiucheung.po.sales.workcard.SalWorkCardKztExample;
import cn.chiucheung.po.sales.workcard.SalWorkCardKztOther;
import cn.chiucheung.po.sales.workcard.SalWorkCardKztOtherExample;
import cn.chiucheung.po.sales.workcard.SalWorkCardKztWithBLOBs;
import cn.chiucheung.po.sales.workcard.SalWorkCardSubsidiary;
import cn.chiucheung.po.sales.workcard.SalWorkCardSubsidiaryExample;
import cn.chiucheung.po.system.message.SysMessage;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardConfirmation;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardCustom;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardDsqCustom;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardEiaCustom;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardJg3Custom;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardJg5Custom;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardJg6Custom;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardKztCustom;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardQueryVo;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardShowDataCustom;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardSubsidiaryCustom;
import cn.chiucheung.pojo.system.user.SysUserQueryVo;
import cn.chiucheung.service.sales.WorkCardService;
import cn.chiucheung.utils.ActivitiUtils;
import cn.chiucheung.utils.ResourcesUtil;
import cn.chiucheung.utils.UUIDBuild;
import cn.chiucheung.utils.UserUtils;

@Service
public class WorkCardServiceImpl implements WorkCardService{
	
	@Autowired
	private SalWorkCardMapper workCardMapper;
	
	@Autowired
	private SalWorkCardSubsidiaryMapper workCardSubsidiaryMapper;
	
	@Autowired
	private SalWorkCardFileMapper workCardFileMapper;
	
	@Autowired
	private SalWorkCardKztMapper workCardKztMapper;
	
	@Autowired
	private SalWorkCardKztOtherMapper workCardKztOtherMapper;
	
	@Autowired
	private SalWorkCardDsqMapper workCardDsqMapper;
	
	@Autowired
	private SalWorkCardDsqOtherMapper workCardDsqOtherMapper;
	
	@Autowired
	private SalWorkCardJg3Mapper workCardJg3Mapper;
	
	@Autowired
	private SalWorkCardJg5Mapper workCardJg5Mapper;
	
	@Autowired
	private SalWorkCardJg6Mapper workCardJg6Mapper;
	
	@Autowired
	private SalWorkCardEiaMapper workCardEiaMapper;
	
	@Autowired
	private SalWorkCardEiaOtherMapper workCardEiaOtherMapper;
	
	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private SysMessageMapper messageMapper;

	@Override
	public SalWorkCardConfirmation findSalWorkCardSubsidiaryById(String id) {
		return workCardSubsidiaryMapper.findSalWorkCardSubsidiaryById(id);
	}
	
	@Override
	public int saveWorkCard(SalWorkCardCustom workCardCustom, MultipartFile drawings, HttpSession session) throws Exception{
		SalWorkCard workCard = new SalWorkCard();
		String id = UUIDBuild.getUUID();
		workCardCustom.setId(id);
		workCardCustom.setProcessInstanceId(null);
		if (StringUtils.isBlank(workCardCustom.getSalReviewerId())){
			workCardCustom.setSalReviewerId(null);
		}
		workCardCustom.setState("closed");
		
		BeanUtils.copyProperties(workCard, workCardCustom);
		
		int i = 0;
		i = i + workCardMapper.insert(workCard);
		
		if (drawings.getSize() > 0){
		
			File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/workCard/", workCardCustom.getWorkCardNo()+"/drawings");
			if (!file.exists()){
				file.mkdirs();
			}
			
			
			SalWorkCardFile workCardFile = new SalWorkCardFile();
			workCardFile.setId(UUIDBuild.getUUID());
			workCardFile.setFileName(drawings.getOriginalFilename());
			String suffix = drawings.getOriginalFilename().substring(drawings.getOriginalFilename().lastIndexOf("."), drawings.getOriginalFilename().length());
			workCardFile.setFilePath(workCardCustom.getWorkCardNo()+"/drawings/"+UUIDBuild.getUUID()+suffix);
			workCardFile.setDrawingsFile(true);
			workCardFile.setSalWorkCardId(id);
			List<SalWorkCardFile> workCardFiles = new ArrayList<SalWorkCardFile>();
			workCardFiles.add(workCardFile);
			workCardCustom.setWorkCardFiles(workCardFiles);//为了返回给用户界面
			try{
				drawings.transferTo(new File(ResourcesUtil.getValue("fileRootPath", "path") + "/workCard/", workCardFile.getFilePath()));
			}catch (Exception e){
				throw new RuntimeException(e);
			}
			
			i = i + workCardFileMapper.insert(workCardFile);
		}
		
		List<SalWorkCardSubsidiary> workCardSubsidiaries = workCardCustom.getWorkCardSubsidiaries();
		for (SalWorkCardSubsidiary workCardSubsidiary : workCardSubsidiaries) {
			workCardSubsidiary.setId(UUIDBuild.getUUID());
			workCardSubsidiary.setSalWorkCardId(id);
			if (StringUtils.isBlank(workCardSubsidiary.getSalReviewerSubsidiaryId())){
				workCardSubsidiary.setSalReviewerSubsidiaryId(null);
			}
		}
		
		i = i + workCardSubsidiaryMapper.insertList(workCardSubsidiaries);
		
		return i;
	}
	
	@Override
	public SalWorkCardFile findFileById(String id) {
		return workCardFileMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteFileById(String id, HttpServletRequest request) {
		SalWorkCardFile workCardFile = workCardFileMapper.selectByPrimaryKey(id);
		
		int i = workCardFileMapper.deleteByPrimaryKey(id);
		
		File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/workCard/", workCardFile.getFilePath());
		if (file.exists()){//如果存在
			if (!file.delete()){
				throw new RuntimeException("文件删除失败");
			}
		}
		return i;
	}

	@Override
	public List<SalWorkCardShowDataCustom> findAllWorkCardList(SalWorkCardQueryVo workCardQueryVo) {
		return workCardMapper.findAllWorkCardList(workCardQueryVo);
	}
	
	@Override
	public String findAllWorkCardListCount(SalWorkCardQueryVo workCardQueryVo) {
		return workCardMapper.findAllWorkCardListTotal(workCardQueryVo);
	}
	
	@Override
	public List<SalWorkCardSubsidiaryCustom> findAllSalWorkCardSubsidiaryListBySalWorkCardId(String id) {
		return workCardSubsidiaryMapper.findAllSalWorkCardSubsidiaryListBySalWorkCardId(id);
	}
	
	@Override
	public Map<String, Object> findSalWorkCardByIdForEdit(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		SalWorkCard workCard = workCardMapper.selectByPrimaryKey(id);
		map.put("workCard", workCard);
		
		if(workCard.getProcessInstanceId() != null){
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(workCard.getProcessInstanceId());//设置查询条件，流程实例id
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
		
		SalWorkCardSubsidiaryExample workCardSubsidiaryExample = new SalWorkCardSubsidiaryExample();
		workCardSubsidiaryExample.setOrderByClause("sequence");
		workCardSubsidiaryExample.createCriteria().andSalWorkCardIdEqualTo(id);
		List<SalWorkCardSubsidiary> workCardSubsidiaries = workCardSubsidiaryMapper.selectByExample(workCardSubsidiaryExample);
		map.put("workCardSubsidiaries", workCardSubsidiaries);
		
		SalWorkCardFileExample workCardFileExample = new SalWorkCardFileExample();
		workCardFileExample.createCriteria().andSalWorkCardIdEqualTo(id).andDrawingsFileEqualTo(true);
		List<SalWorkCardFile> workCardFiles = workCardFileMapper.selectByExample(workCardFileExample);
		map.put("workCardFiles", workCardFiles);
		
		return map;
	}
	
	@Override
	public Map<String, Object> findSalWorkCardByIdForView(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		SalWorkCard workCard = workCardMapper.selectByPrimaryKey(id);
		map.put("workCard", workCard);
		
		SalWorkCardSubsidiaryExample workCardSubsidiaryExample = new SalWorkCardSubsidiaryExample();
		workCardSubsidiaryExample.setOrderByClause("sequence");
		workCardSubsidiaryExample.createCriteria().andSalWorkCardIdEqualTo(id);
		List<SalWorkCardSubsidiary> workCardSubsidiaries = workCardSubsidiaryMapper.selectByExample(workCardSubsidiaryExample);
		map.put("workCardSubsidiaries", workCardSubsidiaries);
		
		SalWorkCardFileExample workCardFileExample = new SalWorkCardFileExample();
		workCardFileExample.createCriteria().andSalWorkCardIdEqualTo(id).andDrawingsFileEqualTo(true);
		List<SalWorkCardFile> workCardFiles = workCardFileMapper.selectByExample(workCardFileExample);
		map.put("workCardFiles", workCardFiles);
		
		return map;
	}
	
	@Override
	public int updateWorkCard(SalWorkCardCustom workCardCustom, MultipartFile drawings, HttpSession session) throws Exception{
		String processInstanceId = workCardCustom.getProcessInstanceId();
		
		if (StringUtils.isNotBlank(processInstanceId)){//开启审核流程，则需要知道修改人是否是当前审核人
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(workCardCustom.getProcessInstanceId());//设置查询条件，流程实例id
			Task task = taskQuery.singleResult();
			if (task != null){//已完成
				if (!task.getAssignee().equals(UserUtils.getUserFromSession(session).getAssignee())){//当前审核人才能修改
					throw new RuntimeException("您不是当前审核人，不能修改");
				}
			}else{
				throw new RuntimeException("流程已结束，不能修改");
			}
		}else{
			workCardCustom.setProcessInstanceId(null);
		}
		
		if (StringUtils.isBlank(workCardCustom.getSalReviewerId())){
			workCardCustom.setSalReviewerId(null);
		}
		SalWorkCard workCard = new SalWorkCard();
		workCardCustom.setState("closed");
		
		BeanUtils.copyProperties(workCard, workCardCustom);
		
		int i = 0;
		i = i + workCardMapper.updateByPrimaryKeyWithBLOBs(workCard);
		
		if (drawings.getSize() > 0){
			
			File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/workCard/", workCardCustom.getWorkCardNo()+"/drawings");
			if (!file.exists()){
				file.mkdirs();
			}
			
			
			SalWorkCardFile workCardFile = new SalWorkCardFile();
			workCardFile.setId(UUIDBuild.getUUID());
			workCardFile.setFileName(drawings.getOriginalFilename());
			String suffix = drawings.getOriginalFilename().substring(drawings.getOriginalFilename().lastIndexOf("."), drawings.getOriginalFilename().length());
			workCardFile.setFilePath(workCardCustom.getWorkCardNo()+"/drawings/"+UUIDBuild.getUUID()+suffix);
			workCardFile.setDrawingsFile(true);
			workCardFile.setSalWorkCardId(workCardCustom.getId());
			List<SalWorkCardFile> workCardFiles = new ArrayList<SalWorkCardFile>();
			workCardFiles.add(workCardFile);
			workCardCustom.setWorkCardFiles(workCardFiles);//为了返回给用户界面
			try{
				drawings.transferTo(new File(ResourcesUtil.getValue("fileRootPath", "path") + "/workCard/", workCardFile.getFilePath()));
			}catch (Exception e){
				throw new RuntimeException(e);
			}
			
			i = i + workCardFileMapper.insert(workCardFile);
		}
		
		List<SalWorkCardSubsidiary> insertWorkCardSubsidiaries = new ArrayList<SalWorkCardSubsidiary>();//新增的集合
		List<SalWorkCardSubsidiary> updateWorkCardSubsidiaries = new ArrayList<SalWorkCardSubsidiary>();//更新的集合
		List<SalWorkCardSubsidiary> notDelWorkCardSubsidiaries = new ArrayList<SalWorkCardSubsidiary>();//不删除的集合
		
		List<SalWorkCardSubsidiary> workCardSubsidiaries = workCardCustom.getWorkCardSubsidiaries();//更新传过来的集合
		
		
		for (SalWorkCardSubsidiary workCardSubsidiary : workCardSubsidiaries) {
			if (StringUtils.isBlank(workCardSubsidiary.getSalReviewerSubsidiaryId())){
				workCardSubsidiary.setSalReviewerSubsidiaryId(null);
			}
			if (StringUtils.isBlank(workCardSubsidiary.getId())){
				workCardSubsidiary.setId(UUIDBuild.getUUID());
				workCardSubsidiary.setSalWorkCardId(workCardCustom.getId());
				insertWorkCardSubsidiaries.add(workCardSubsidiary);
			}
		}
		workCardSubsidiaries.removeAll(insertWorkCardSubsidiaries);
		
		
		SalWorkCardSubsidiaryExample workCardSubsidiaryExample = new SalWorkCardSubsidiaryExample();
		workCardSubsidiaryExample.createCriteria().andSalWorkCardIdEqualTo(workCardCustom.getId());
		List<SalWorkCardSubsidiary> existingWorkCardSubsidiaries = workCardSubsidiaryMapper.selectByExample(workCardSubsidiaryExample);//现有的集合
		
		for (SalWorkCardSubsidiary existingWorkCardSubsidiary : existingWorkCardSubsidiaries) {
			for (SalWorkCardSubsidiary workCardSubsidiary : workCardSubsidiaries) {
				if (existingWorkCardSubsidiary.getId().equals(workCardSubsidiary.getId())){
					updateWorkCardSubsidiaries.add(workCardSubsidiary);
					notDelWorkCardSubsidiaries.add(existingWorkCardSubsidiary);
					break;
				}
			}
		}
		existingWorkCardSubsidiaries.removeAll(notDelWorkCardSubsidiaries);
		
		if (insertWorkCardSubsidiaries.size() > 0){
			i = i + workCardSubsidiaryMapper.insertList(insertWorkCardSubsidiaries);
		}
		
		if (updateWorkCardSubsidiaries.size() > 0){
			for (SalWorkCardSubsidiary updateWorkCardSubsidiary : updateWorkCardSubsidiaries) {
				i = i + workCardSubsidiaryMapper.updateByPrimaryKeySelective(updateWorkCardSubsidiary);
			}
		}
		
		if (existingWorkCardSubsidiaries.size() > 0){
			List<String> values = new ArrayList<String>();
			for (SalWorkCardSubsidiary existingWorkCardSubsidiary : existingWorkCardSubsidiaries) {
				values.add(existingWorkCardSubsidiary.getId());
				if (StringUtils.isNotBlank(existingWorkCardSubsidiary.getConfirmation())){
					if ("workCardKzt".equals(existingWorkCardSubsidiary.getConfirmation())){
						SalWorkCardKztExample workCardKztExample = new SalWorkCardKztExample();
						workCardKztExample.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(existingWorkCardSubsidiary.getId());
						
						List<SalWorkCardKzt> workCardKzts = workCardKztMapper.selectByExample(workCardKztExample);
						
						SalWorkCardKztOtherExample workCardKztOtherExample = new SalWorkCardKztOtherExample();
						workCardKztOtherExample.createCriteria().andSalWorkCardKztIdEqualTo(workCardKzts.get(0).getId());
						i = i + workCardKztOtherMapper.deleteByExample(workCardKztOtherExample);
						
						i = i + workCardKztMapper.deleteByPrimaryKey(workCardKzts.get(0).getId());
						
					}else if ("workCardDsq".equals(existingWorkCardSubsidiary.getConfirmation())){
						SalWorkCardDsqExample workCardDsqExample = new SalWorkCardDsqExample();
						workCardDsqExample.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(existingWorkCardSubsidiary.getId());
						
						List<SalWorkCardDsq> workCardDsqs = workCardDsqMapper.selectByExample(workCardDsqExample);
						
						SalWorkCardDsqOtherExample workCardDsqOtherExample = new SalWorkCardDsqOtherExample();
						workCardDsqOtherExample.createCriteria().andSalWorkCardDsqIdEqualTo(workCardDsqs.get(0).getId());
						i = i + workCardDsqOtherMapper.deleteByExample(workCardDsqOtherExample);
						
						i = i + workCardDsqMapper.deleteByPrimaryKey(workCardDsqs.get(0).getId());
					}else if ("workCardJg3".equals(existingWorkCardSubsidiary.getConfirmation())){
						SalWorkCardJg3Example workCardJg3Example = new SalWorkCardJg3Example();
						workCardJg3Example.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(existingWorkCardSubsidiary.getId());
						
						i = i + workCardJg3Mapper.deleteByExample(workCardJg3Example);
					}else if ("workCardJg5".equals(existingWorkCardSubsidiary.getConfirmation())){
						SalWorkCardJg5Example workCardJg5Example = new SalWorkCardJg5Example();
						workCardJg5Example.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(existingWorkCardSubsidiary.getId());
						
						i = i + workCardJg5Mapper.deleteByExample(workCardJg5Example);
					}else if ("workCardJg6".equals(existingWorkCardSubsidiary.getConfirmation())){
						SalWorkCardJg6Example workCardJg6Example = new SalWorkCardJg6Example();
						workCardJg6Example.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(existingWorkCardSubsidiary.getId());
						
						i = i + workCardJg6Mapper.deleteByExample(workCardJg6Example);
					}else if ("workCardEia".equals(existingWorkCardSubsidiary.getConfirmation())){
						SalWorkCardEiaExample workCardEiaExample = new SalWorkCardEiaExample();
						workCardEiaExample.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(existingWorkCardSubsidiary.getId());
						
						List<SalWorkCardEia> workCardEias = workCardEiaMapper.selectByExample(workCardEiaExample);
						
						SalWorkCardEiaOtherExample workCardEiaOtherExample = new SalWorkCardEiaOtherExample();
						workCardEiaOtherExample.createCriteria().andSalWorkCardEiaIdEqualTo(workCardEias.get(0).getId());
						i = i + workCardEiaOtherMapper.deleteByExample(workCardEiaOtherExample);
						
						i = i + workCardEiaMapper.deleteByPrimaryKey(workCardEias.get(0).getId());
					}
				}
			}
			
			SalWorkCardSubsidiaryExample workCardSubsidiaryExample2 = new SalWorkCardSubsidiaryExample();
			workCardSubsidiaryExample2.createCriteria().andIdIn(values);
			i = i + workCardSubsidiaryMapper.deleteByExample(workCardSubsidiaryExample2);
		}
		
		//在将新增的项次添加回custom，返回给页面
		workCardSubsidiaries.addAll(insertWorkCardSubsidiaries);
		
		return i;
	}
	
	@Override
	public int deleteSalWorkCardById(String id) throws Exception{	
		SalWorkCard workCard = workCardMapper.selectByPrimaryKey(id);
		
		if (StringUtils.isNotBlank(workCard.getProcessInstanceId())){
			throw new RuntimeException("已开启审核，不能删除");
		}
		
		int i = 0;

		//删除文件和文件的表数据（工咭内的图纸文件）
		SalWorkCardFileExample workCardFileExample1 = new SalWorkCardFileExample();
		workCardFileExample1.createCriteria().andSalWorkCardIdEqualTo(id).andDrawingsFileEqualTo(true);
		List<SalWorkCardFile> workCardFiles1 = workCardFileMapper.selectByExample(workCardFileExample1);
		
		if (workCardFiles1.size() > 0){
			throw new RuntimeException("请先删除工咭的批核图图纸后，在删除工咭");
		}
		
		SalWorkCardSubsidiaryExample workCardSubsidiaryExample = new SalWorkCardSubsidiaryExample();
		workCardSubsidiaryExample.createCriteria().andSalWorkCardIdEqualTo(id);
		List<SalWorkCardSubsidiary> salWorkCardSubsidiaries = workCardSubsidiaryMapper.selectByExample(workCardSubsidiaryExample);
		
		for (SalWorkCardSubsidiary workCardSubsidiary : salWorkCardSubsidiaries) {
			if (StringUtils.isNotBlank(workCardSubsidiary.getConfirmation())){
				if ("workCardKzt".equals(workCardSubsidiary.getConfirmation())){
					SalWorkCardKztExample workCardKztExample = new SalWorkCardKztExample();
					workCardKztExample.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(workCardSubsidiary.getId());
					
					List<SalWorkCardKzt> workCardKzts = workCardKztMapper.selectByExample(workCardKztExample);
					
					SalWorkCardKztOtherExample workCardKztOtherExample = new SalWorkCardKztOtherExample();
					workCardKztOtherExample.createCriteria().andSalWorkCardKztIdEqualTo(workCardKzts.get(0).getId());
					i = i + workCardKztOtherMapper.deleteByExample(workCardKztOtherExample);
					
					i = i + workCardKztMapper.deleteByPrimaryKey(workCardKzts.get(0).getId());
					
				}else if ("workCardDsq".equals(workCardSubsidiary.getConfirmation())){
					SalWorkCardDsqExample workCardDsqExample = new SalWorkCardDsqExample();
					workCardDsqExample.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(workCardSubsidiary.getId());
					
					List<SalWorkCardDsq> workCardDsqs = workCardDsqMapper.selectByExample(workCardDsqExample);
					
					SalWorkCardDsqOtherExample workCardDsqOtherExample = new SalWorkCardDsqOtherExample();
					workCardDsqOtherExample.createCriteria().andSalWorkCardDsqIdEqualTo(workCardDsqs.get(0).getId());
					i = i + workCardDsqOtherMapper.deleteByExample(workCardDsqOtherExample);
					
					i = i + workCardDsqMapper.deleteByPrimaryKey(workCardDsqs.get(0).getId());
				}else if ("workCardJg3".equals(workCardSubsidiary.getConfirmation())){
					SalWorkCardJg3Example workCardJg3Example = new SalWorkCardJg3Example();
					workCardJg3Example.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(workCardSubsidiary.getId());
					
					i = i + workCardJg3Mapper.deleteByExample(workCardJg3Example);
				}else if ("workCardJg5".equals(workCardSubsidiary.getConfirmation())){
					SalWorkCardJg5Example workCardJg5Example = new SalWorkCardJg5Example();
					workCardJg5Example.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(workCardSubsidiary.getId());
					
					i = i + workCardJg5Mapper.deleteByExample(workCardJg5Example);
				}else if ("workCardJg6".equals(workCardSubsidiary.getConfirmation())){
					SalWorkCardJg6Example workCardJg6Example = new SalWorkCardJg6Example();
					workCardJg6Example.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(workCardSubsidiary.getId());
					
					i = i + workCardJg6Mapper.deleteByExample(workCardJg6Example);
				}else if ("workCardEia".equals(workCardSubsidiary.getConfirmation())){
					SalWorkCardEiaExample workCardEiaExample = new SalWorkCardEiaExample();
					workCardEiaExample.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(workCardSubsidiary.getId());
					
					List<SalWorkCardEia> workCardEias = workCardEiaMapper.selectByExample(workCardEiaExample);
					
					SalWorkCardEiaOtherExample workCardEiaOtherExample = new SalWorkCardEiaOtherExample();
					workCardEiaOtherExample.createCriteria().andSalWorkCardEiaIdEqualTo(workCardEias.get(0).getId());
					i = i + workCardEiaOtherMapper.deleteByExample(workCardEiaOtherExample);
					
					i = i + workCardEiaMapper.deleteByPrimaryKey(workCardEias.get(0).getId());
				}
			}
		}
		
		i = i + workCardSubsidiaryMapper.deleteByExample(workCardSubsidiaryExample);
		
		
		i = i + workCardMapper.deleteByPrimaryKey(id);
		
		return i;
	}

	@Override
	public int saveWorkCardKzt(SalWorkCardKztCustom workCardKztCustom) throws Exception{
		SalWorkCardKztWithBLOBs workCardKztWithBLOBs = new SalWorkCardKztWithBLOBs();
		String id = UUIDBuild.getUUID();
		workCardKztCustom.setId(id);
		
		BeanUtils.copyProperties(workCardKztWithBLOBs, workCardKztCustom);
		
		int i = 0;
		i = i + workCardKztMapper.insert(workCardKztWithBLOBs);
		
		//更新项次的confirmation字段，为了后面查询的时候，好知道查询那个表
		SalWorkCardSubsidiary workCardSubsidiary = new SalWorkCardSubsidiary();
		workCardSubsidiary.setId(workCardKztCustom.getSalWorkCardSubsidiaryId());
		workCardSubsidiary.setConfirmation(workCardKztCustom.getConfirmation());
		i = i + workCardSubsidiaryMapper.updateByPrimaryKeySelective(workCardSubsidiary);
		
		List<SalWorkCardKztOther> workCardKztOthers = workCardKztCustom.getWorkCardConfirmationOthers();
		if (workCardKztOthers != null && workCardKztOthers.size() > 0){
			for (SalWorkCardKztOther salWorkCardKztOther : workCardKztOthers) {
				salWorkCardKztOther.setId(UUIDBuild.getUUID());
				salWorkCardKztOther.setSalWorkCardKztId(id);
			}
			i = i + workCardKztOtherMapper.insertList(workCardKztOthers);
		}
		
		return i;
	}

	@Override
	public SalWorkCardKztCustom findWorkCardKztByWorkCardSubsidiaryId(String workCardSubsidiaryId) throws Exception{
		SalWorkCardKztCustom workCardKztCustom = new SalWorkCardKztCustom();
		
		SalWorkCardKztExample workCardKztExample = new SalWorkCardKztExample();
		workCardKztExample.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(workCardSubsidiaryId);
		List<SalWorkCardKztWithBLOBs> workCardKztWithBLOBs  = workCardKztMapper.selectByExampleWithBLOBs(workCardKztExample);
		
		BeanUtils.copyProperties(workCardKztCustom, workCardKztWithBLOBs.get(0));
		
		
		SalWorkCardKztOtherExample workCardKztOtherExample = new SalWorkCardKztOtherExample();
		workCardKztOtherExample.setOrderByClause("sequence");
		workCardKztOtherExample.createCriteria().andSalWorkCardKztIdEqualTo(workCardKztCustom.getId());
		List<SalWorkCardKztOther> workCardKztOthers = workCardKztOtherMapper.selectByExample(workCardKztOtherExample);
		
		workCardKztCustom.setWorkCardConfirmationOthers(workCardKztOthers);
		return workCardKztCustom;
	}
	
	@Override
	public int updateWorkCardKzt(SalWorkCardKztCustom workCardKztCustom) throws Exception{
		SalWorkCardKztWithBLOBs workCardKztWithBLOBs = new SalWorkCardKztWithBLOBs();
		
		BeanUtils.copyProperties(workCardKztWithBLOBs, workCardKztCustom);
		
		int i = 0;
		i = i + workCardKztMapper.updateByPrimaryKeyWithBLOBs(workCardKztWithBLOBs);
		
		//删除所有的其他
		SalWorkCardKztOtherExample workCardKztOtherExample = new SalWorkCardKztOtherExample();
		workCardKztOtherExample.createCriteria().andSalWorkCardKztIdEqualTo(workCardKztWithBLOBs.getId());
		i = i + workCardKztOtherMapper.deleteByExample(workCardKztOtherExample);
		
		//在添加
		List<SalWorkCardKztOther> workCardKztOthers = workCardKztCustom.getWorkCardConfirmationOthers();
		if (workCardKztOthers != null && workCardKztOthers.size() > 0){
			for (SalWorkCardKztOther salWorkCardKztOther : workCardKztOthers) {
				salWorkCardKztOther.setId(UUIDBuild.getUUID());
				salWorkCardKztOther.setSalWorkCardKztId(workCardKztWithBLOBs.getId());
			}
			i = i + workCardKztOtherMapper.insertList(workCardKztOthers);
		}
		
		return i;
	}

	@Override
	public int deleteWorkCardKztByWorkCardSubsidiaryId(String workCardSubsidiaryId) {
		SalWorkCardKztExample workCardKztExample = new SalWorkCardKztExample();
		workCardKztExample.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(workCardSubsidiaryId);
		List<SalWorkCardKzt> list = workCardKztMapper.selectByExample(workCardKztExample);
		String id = list.get(0).getId();
		
		SalWorkCardSubsidiary workCardSubsidiary = workCardSubsidiaryMapper.selectByPrimaryKey(workCardSubsidiaryId);
		workCardSubsidiary.setConfirmation(null);
		workCardSubsidiaryMapper.updateByPrimaryKey(workCardSubsidiary);
		
		SalWorkCardKztOtherExample workCardKztOtherExample = new SalWorkCardKztOtherExample();
		workCardKztOtherExample.createCriteria().andSalWorkCardKztIdEqualTo(id);
		
		int i = workCardKztOtherMapper.deleteByExample(workCardKztOtherExample);
		
		i = i + workCardKztMapper.deleteByPrimaryKey(id);
		
		return i;
	}

	@Override
	public int saveWorkCardDsq(SalWorkCardDsqCustom workCardDsqCustom) throws Exception{
		SalWorkCardDsqWithBLOBs workCardDsqWithBLOBs = new SalWorkCardDsqWithBLOBs();
		String id = UUIDBuild.getUUID();
		workCardDsqCustom.setId(id);
		
		BeanUtils.copyProperties(workCardDsqWithBLOBs, workCardDsqCustom);
		
		int i = 0;
		i = i + workCardDsqMapper.insert(workCardDsqWithBLOBs);
		
		//更新项次的confirmation字段，为了后面查询的时候，好知道查询那个表
		SalWorkCardSubsidiary workCardSubsidiary = new SalWorkCardSubsidiary();
		workCardSubsidiary.setId(workCardDsqCustom.getSalWorkCardSubsidiaryId());
		workCardSubsidiary.setConfirmation(workCardDsqCustom.getConfirmation());
		i = i + workCardSubsidiaryMapper.updateByPrimaryKeySelective(workCardSubsidiary);
		
		List<SalWorkCardDsqOther> workCardDsqOthers = workCardDsqCustom.getWorkCardConfirmationOthers();
		if (workCardDsqOthers != null && workCardDsqOthers.size() > 0){
			for (SalWorkCardDsqOther workCardDsqOther : workCardDsqOthers) {
				workCardDsqOther.setId(UUIDBuild.getUUID());
				workCardDsqOther.setSalWorkCardDsqId(id);
			}
			i = i + workCardDsqOtherMapper.insertList(workCardDsqOthers);
		}
		
		return i;
	}

	@Override
	public SalWorkCardDsqCustom findWorkCardDsqByWorkCardSubsidiaryId(String workCardSubsidiaryId) throws Exception{
		SalWorkCardDsqCustom workCardDsqCustom = new SalWorkCardDsqCustom();
		
		SalWorkCardDsqExample workCardDsqExample = new SalWorkCardDsqExample();
		workCardDsqExample.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(workCardSubsidiaryId);
		List<SalWorkCardDsqWithBLOBs> workCardDsqWithBLOBs  = workCardDsqMapper.selectByExampleWithBLOBs(workCardDsqExample);
		
		BeanUtils.copyProperties(workCardDsqCustom, workCardDsqWithBLOBs.get(0));
		
		
		SalWorkCardDsqOtherExample workCardDsqOtherExample = new SalWorkCardDsqOtherExample();
		workCardDsqOtherExample.setOrderByClause("sequence");
		workCardDsqOtherExample.createCriteria().andSalWorkCardDsqIdEqualTo(workCardDsqCustom.getId());
		List<SalWorkCardDsqOther> workCardDsqOthers = workCardDsqOtherMapper.selectByExample(workCardDsqOtherExample);
		
		workCardDsqCustom.setWorkCardConfirmationOthers(workCardDsqOthers);
		return workCardDsqCustom;
	}
	
	@Override
	public int updateWorkCardDsq(SalWorkCardDsqCustom workCardDsqCustom) throws Exception{
		SalWorkCardDsqWithBLOBs workCardDsqWithBLOBs = new SalWorkCardDsqWithBLOBs();
		
		BeanUtils.copyProperties(workCardDsqWithBLOBs, workCardDsqCustom);
		
		int i = 0;
		i = i + workCardDsqMapper.updateByPrimaryKeyWithBLOBs(workCardDsqWithBLOBs);
		
		//删除所有的其他
		SalWorkCardDsqOtherExample workCardDsqOtherExample = new SalWorkCardDsqOtherExample();
		workCardDsqOtherExample.createCriteria().andSalWorkCardDsqIdEqualTo(workCardDsqWithBLOBs.getId());
		i = i + workCardDsqOtherMapper.deleteByExample(workCardDsqOtherExample);
		
		//在添加
		List<SalWorkCardDsqOther> workCardDsqOthers = workCardDsqCustom.getWorkCardConfirmationOthers();
		if (workCardDsqOthers != null && workCardDsqOthers.size() > 0){
			for (SalWorkCardDsqOther salWorkCardDsqOther : workCardDsqOthers) {
				salWorkCardDsqOther.setId(UUIDBuild.getUUID());
				salWorkCardDsqOther.setSalWorkCardDsqId(workCardDsqWithBLOBs.getId());
			}
			i = i + workCardDsqOtherMapper.insertList(workCardDsqOthers);
		}
		
		return i;
	}


	@Override
	public int deleteWorkCardDsqByWorkCardSubsidiaryId(String workCardSubsidiaryId) {
		SalWorkCardDsqExample workCardDsqExample = new SalWorkCardDsqExample();
		workCardDsqExample.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(workCardSubsidiaryId);
		List<SalWorkCardDsq> list = workCardDsqMapper.selectByExample(workCardDsqExample);
		String id = list.get(0).getId();
		
		SalWorkCardSubsidiary workCardSubsidiary = workCardSubsidiaryMapper.selectByPrimaryKey(workCardSubsidiaryId);
		workCardSubsidiary.setConfirmation(null);
		workCardSubsidiaryMapper.updateByPrimaryKey(workCardSubsidiary);
		
		SalWorkCardDsqOtherExample workCardDsqOtherExample = new SalWorkCardDsqOtherExample();
		workCardDsqOtherExample.createCriteria().andSalWorkCardDsqIdEqualTo(id);
		
		int i = workCardDsqOtherMapper.deleteByExample(workCardDsqOtherExample);
		
		i = i + workCardDsqMapper.deleteByPrimaryKey(id);
		
		return i;
	}
	@Override
	public int saveWorkCardJg3(SalWorkCardJg3Custom workCardJg3Custom) throws Exception{
		SalWorkCardJg3 workCardJg3 = new SalWorkCardJg3();
		String id = UUIDBuild.getUUID();
		workCardJg3Custom.setId(id);
		
		BeanUtils.copyProperties(workCardJg3, workCardJg3Custom);
		
		int i = 0;
		i = i + workCardJg3Mapper.insert(workCardJg3);
		
		//更新项次的confirmation字段，为了后面查询的时候，好知道查询那个表
		SalWorkCardSubsidiary workCardSubsidiary = new SalWorkCardSubsidiary();
		workCardSubsidiary.setId(workCardJg3Custom.getSalWorkCardSubsidiaryId());
		workCardSubsidiary.setConfirmation(workCardJg3Custom.getConfirmation());
		i = i + workCardSubsidiaryMapper.updateByPrimaryKeySelective(workCardSubsidiary);
		
		return i;
	}

	@Override
	public SalWorkCardJg3Custom findWorkCardJg3ByWorkCardSubsidiaryId(String workCardSubsidiaryId) throws Exception{
		SalWorkCardJg3Custom workCardJg3Custom = new SalWorkCardJg3Custom();
		
		SalWorkCardJg3Example workCardJg3Example = new SalWorkCardJg3Example();
		workCardJg3Example.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(workCardSubsidiaryId);
		List<SalWorkCardJg3> workCardJg3s  = workCardJg3Mapper.selectByExample(workCardJg3Example);
		
		BeanUtils.copyProperties(workCardJg3Custom, workCardJg3s.get(0));
		
		return workCardJg3Custom;
	}
	
	@Override
	public int updateWorkCardJg3(SalWorkCardJg3Custom workCardJg3Custom) throws Exception{
		SalWorkCardJg3 workCardJg3 = new SalWorkCardJg3();
		
		BeanUtils.copyProperties(workCardJg3, workCardJg3Custom);
		
		int i = 0;
		i = i + workCardJg3Mapper.updateByPrimaryKey(workCardJg3);
		
		return i;
	}

	@Override
	public int deleteWorkCardJg3ByWorkCardSubsidiaryId(String workCardSubsidiaryId) {
		SalWorkCardJg3Example workCardJg3Example = new SalWorkCardJg3Example();
		workCardJg3Example.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(workCardSubsidiaryId);
		int i = workCardJg3Mapper.deleteByExample(workCardJg3Example);
		
		SalWorkCardSubsidiary workCardSubsidiary = workCardSubsidiaryMapper.selectByPrimaryKey(workCardSubsidiaryId);
		workCardSubsidiary.setConfirmation(null);
		workCardSubsidiaryMapper.updateByPrimaryKey(workCardSubsidiary);
		
		return i;
	}

	@Override
	public int saveWorkCardJg5(SalWorkCardJg5Custom workCardJg5Custom) throws Exception{
		SalWorkCardJg5 workCardJg5 = new SalWorkCardJg5();
		String id = UUIDBuild.getUUID();
		workCardJg5Custom.setId(id);
		
		BeanUtils.copyProperties(workCardJg5, workCardJg5Custom);
		
		int i = 0;
		i = i + workCardJg5Mapper.insert(workCardJg5);
		
		//更新项次的confirmation字段，为了后面查询的时候，好知道查询那个表
		SalWorkCardSubsidiary workCardSubsidiary = new SalWorkCardSubsidiary();
		workCardSubsidiary.setId(workCardJg5Custom.getSalWorkCardSubsidiaryId());
		workCardSubsidiary.setConfirmation(workCardJg5Custom.getConfirmation());
		i = i + workCardSubsidiaryMapper.updateByPrimaryKeySelective(workCardSubsidiary);
		
		return i;
	}

	@Override
	public SalWorkCardJg5Custom findWorkCardJg5ByWorkCardSubsidiaryId(String workCardSubsidiaryId) throws Exception{
		SalWorkCardJg5Custom workCardJg5Custom = new SalWorkCardJg5Custom();
		
		SalWorkCardJg5Example workCardJg5Example = new SalWorkCardJg5Example();
		workCardJg5Example.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(workCardSubsidiaryId);
		List<SalWorkCardJg5> workCardJg5s  = workCardJg5Mapper.selectByExample(workCardJg5Example);
		
		BeanUtils.copyProperties(workCardJg5Custom, workCardJg5s.get(0));
		
		return workCardJg5Custom;
	}
	
	@Override
	public int updateWorkCardJg5(SalWorkCardJg5Custom workCardJg5Custom) throws Exception{
		SalWorkCardJg5 workCardJg5 = new SalWorkCardJg5();
		
		BeanUtils.copyProperties(workCardJg5, workCardJg5Custom);
		
		int i = 0;
		i = i + workCardJg5Mapper.updateByPrimaryKey(workCardJg5);
		
		return i;
	}

	@Override
	public int deleteWorkCardJg5ByWorkCardSubsidiaryId(String workCardSubsidiaryId) {
		SalWorkCardJg5Example workCardJg5Example = new SalWorkCardJg5Example();
		workCardJg5Example.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(workCardSubsidiaryId);
		int i = workCardJg5Mapper.deleteByExample(workCardJg5Example);
		
		SalWorkCardSubsidiary workCardSubsidiary = workCardSubsidiaryMapper.selectByPrimaryKey(workCardSubsidiaryId);
		workCardSubsidiary.setConfirmation(null);
		workCardSubsidiaryMapper.updateByPrimaryKey(workCardSubsidiary);
		
		return i;
	}
	
	@Override
	public int saveWorkCardJg6(SalWorkCardJg6Custom workCardJg6Custom) throws Exception{
		SalWorkCardJg6 workCardJg6 = new SalWorkCardJg6();
		String id = UUIDBuild.getUUID();
		workCardJg6Custom.setId(id);
		
		BeanUtils.copyProperties(workCardJg6, workCardJg6Custom);
		
		int i = 0;
		i = i + workCardJg6Mapper.insert(workCardJg6);
		
		//更新项次的confirmation字段，为了后面查询的时候，好知道查询那个表
		SalWorkCardSubsidiary workCardSubsidiary = new SalWorkCardSubsidiary();
		workCardSubsidiary.setId(workCardJg6Custom.getSalWorkCardSubsidiaryId());
		workCardSubsidiary.setConfirmation(workCardJg6Custom.getConfirmation());
		i = i + workCardSubsidiaryMapper.updateByPrimaryKeySelective(workCardSubsidiary);
		
		return i;
	}

	@Override
	public SalWorkCardJg6Custom findWorkCardJg6ByWorkCardSubsidiaryId(String workCardSubsidiaryId) throws Exception{
		SalWorkCardJg6Custom workCardJg6Custom = new SalWorkCardJg6Custom();
		
		SalWorkCardJg6Example workCardJg6Example = new SalWorkCardJg6Example();
		workCardJg6Example.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(workCardSubsidiaryId);
		List<SalWorkCardJg6> workCardJg6s  = workCardJg6Mapper.selectByExampleWithBLOBs(workCardJg6Example);
		
		BeanUtils.copyProperties(workCardJg6Custom, workCardJg6s.get(0));
		
		return workCardJg6Custom;
	}
	
	@Override
	public int updateWorkCardJg6(SalWorkCardJg6Custom workCardJg6Custom) throws Exception{
		SalWorkCardJg6 workCardJg6 = new SalWorkCardJg6();
		
		BeanUtils.copyProperties(workCardJg6, workCardJg6Custom);
		
		int i = 0;
		i = i + workCardJg6Mapper.updateByPrimaryKeyWithBLOBs(workCardJg6);
		
		return i;
	}


	@Override
	public int deleteWorkCardJg6ByWorkCardSubsidiaryId(String workCardSubsidiaryId) {
		SalWorkCardJg6Example workCardJg6Example = new SalWorkCardJg6Example();
		workCardJg6Example.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(workCardSubsidiaryId);
		int i = workCardJg6Mapper.deleteByExample(workCardJg6Example);
		
		SalWorkCardSubsidiary workCardSubsidiary = workCardSubsidiaryMapper.selectByPrimaryKey(workCardSubsidiaryId);
		workCardSubsidiary.setConfirmation(null);
		workCardSubsidiaryMapper.updateByPrimaryKey(workCardSubsidiary);
		
		return i;
	}
	
	@Override
	public int saveWorkCardEia(SalWorkCardEiaCustom workCardEiaCustom) throws Exception{
		SalWorkCardEia workCardEia = new SalWorkCardEia();
		String id = UUIDBuild.getUUID();
		workCardEiaCustom.setId(id);
		
		BeanUtils.copyProperties(workCardEia, workCardEiaCustom);
		
		int i = 0;
		i = i + workCardEiaMapper.insert(workCardEiaCustom);
		
		//更新项次的confirmation字段，为了后面查询的时候，好知道查询那个表
		SalWorkCardSubsidiary workCardSubsidiary = new SalWorkCardSubsidiary();
		workCardSubsidiary.setId(workCardEiaCustom.getSalWorkCardSubsidiaryId());
		workCardSubsidiary.setConfirmation(workCardEiaCustom.getConfirmation());
		i = i + workCardSubsidiaryMapper.updateByPrimaryKeySelective(workCardSubsidiary);
		
		List<SalWorkCardEiaOther> workCardEiaOthers = workCardEiaCustom.getWorkCardConfirmationOthers();
		if (workCardEiaOthers != null && workCardEiaOthers.size() > 0){
			for (SalWorkCardEiaOther workCardEiaOther : workCardEiaOthers) {
				workCardEiaOther.setId(UUIDBuild.getUUID());
				workCardEiaOther.setSalWorkCardEiaId(id);
			}
			i = i + workCardEiaOtherMapper.insertList(workCardEiaOthers);
		}
		
		return i;
	}

	@Override
	public SalWorkCardEiaCustom findWorkCardEiaByWorkCardSubsidiaryId(String workCardSubsidiaryId) throws Exception{
		SalWorkCardEiaCustom workCardEiaCustom = new SalWorkCardEiaCustom();
		
		SalWorkCardEiaExample workCardEiaExample = new SalWorkCardEiaExample();
		workCardEiaExample.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(workCardSubsidiaryId);
		List<SalWorkCardEia> workCardEias = workCardEiaMapper.selectByExampleWithBLOBs(workCardEiaExample);
		
		BeanUtils.copyProperties(workCardEiaCustom, workCardEias.get(0));
		
		
		SalWorkCardEiaOtherExample workCardEiaOtherExample = new SalWorkCardEiaOtherExample();
		workCardEiaOtherExample.setOrderByClause("sequence");
		workCardEiaOtherExample.createCriteria().andSalWorkCardEiaIdEqualTo(workCardEiaCustom.getId());
		List<SalWorkCardEiaOther> workCardEiaOthers = workCardEiaOtherMapper.selectByExample(workCardEiaOtherExample);
		
		workCardEiaCustom.setWorkCardConfirmationOthers(workCardEiaOthers);
		return workCardEiaCustom;
	}
	
	@Override
	public int updateWorkCardEia(SalWorkCardEiaCustom workCardEiaCustom) throws Exception{
		SalWorkCardEia workCardEia = new SalWorkCardEia();
		
		BeanUtils.copyProperties(workCardEia, workCardEiaCustom);
		
		int i = 0;
		i = i + workCardEiaMapper.updateByPrimaryKeyWithBLOBs(workCardEiaCustom);
		
		//删除所有的其他
		SalWorkCardEiaOtherExample workCardEiaOtherExample = new SalWorkCardEiaOtherExample();
		workCardEiaOtherExample.createCriteria().andSalWorkCardEiaIdEqualTo(workCardEia.getId());
		i = i + workCardEiaOtherMapper.deleteByExample(workCardEiaOtherExample);
		
		//在添加
		List<SalWorkCardEiaOther> workCardEiaOthers = workCardEiaCustom.getWorkCardConfirmationOthers();
		if (workCardEiaOthers != null && workCardEiaOthers.size() > 0){
			for (SalWorkCardEiaOther workCardEiaOther : workCardEiaOthers) {
				workCardEiaOther.setId(UUIDBuild.getUUID());
				workCardEiaOther.setSalWorkCardEiaId(workCardEia.getId());
			}
			i = i + workCardEiaOtherMapper.insertList(workCardEiaOthers);
		}
		
		return i;
	}

	@Override
	public int deleteWorkCardEiaByWorkCardSubsidiaryId(String workCardSubsidiaryId) {
		SalWorkCardEiaExample workCardEiaExample = new SalWorkCardEiaExample();
		workCardEiaExample.createCriteria().andSalWorkCardSubsidiaryIdEqualTo(workCardSubsidiaryId);
		List<SalWorkCardEia> list = workCardEiaMapper.selectByExample(workCardEiaExample);
		String id = list.get(0).getId();
		
		SalWorkCardEiaOtherExample workCardEiaOtherExample = new SalWorkCardEiaOtherExample();
		workCardEiaOtherExample.createCriteria().andSalWorkCardEiaIdEqualTo(id);
		
		SalWorkCardSubsidiary workCardSubsidiary = workCardSubsidiaryMapper.selectByPrimaryKey(workCardSubsidiaryId);
		workCardSubsidiary.setConfirmation(null);
		workCardSubsidiaryMapper.updateByPrimaryKey(workCardSubsidiary);
		
		int i = workCardEiaOtherMapper.deleteByExample(workCardEiaOtherExample);
		
		i = i + workCardEiaMapper.deleteByPrimaryKey(id);
		
		return i;
	}
	
	@Override
	public List<SysUser> queryAuditorById(String id, String processInstanceId, HttpSession session) {
		SalWorkCard workCard = workCardMapper.selectByPrimaryKey(id);
		if (StringUtils.isBlank(processInstanceId)){
			processInstanceId = workCard.getProcessInstanceId();
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
			String processDefinitionKey = ResourcesUtil.getValue("activiti", "WorkCardProcessDefinitionKey");
			
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
	public void auditWorkCard(String id, String assigneeId,HttpSession session) {
		SalWorkCard workCard = workCardMapper.selectByPrimaryKey(id);
		String processInstanceId = workCard.getProcessInstanceId();
		
		List<SysUser> users = queryAuditorById(id, processInstanceId, session);
		
		//发送消息
		SysMessage message = new SysMessage();
		message.setId(UUIDBuild.getUUID());
		message.setIsRead(false);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("工咭");
		
		buffer.append("<b>");
		buffer.append(workCard.getWorkCardNo());
		buffer.append("</b>");
		
		
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
							 ExecutionEntity execution = (ExecutionEntity) runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();  
							 
							 //当前流程节点Id信息   
							 String activitiId = execution.getActivityId();    
							 if (activitiId.equals("startAudit")){
								 workCard.setWorkCardLeader(workCard.getWorkCardLeader() + "/" + UserUtils.getUserFromSession(session).getUsername());
								 workCardMapper.updateByPrimaryKeyWithBLOBs(workCard);
							 }else if (activitiId.equals("saleReviewer")){
								 workCard.setSigner(UserUtils.getUserFromSession(session).getUsername());
								 workCardMapper.updateByPrimaryKeyWithBLOBs(workCard);
							 }
							
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
			
			String processDefinitionKey = ResourcesUtil.getValue("activiti", "WorkCardProcessDefinitionKey");
			
			identityService.setAuthenticatedUserId(UserUtils.getUserFromSession(session).getAssignee());
			String businessKey = id;
			ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey);
			processInstanceId = processInstance.getProcessInstanceId();
			workCard.setProcessInstanceId(processInstanceId);
			workCard.setWorkCardLeader(workCard.getWorkCardLeader() + "/" + UserUtils.getUserFromSession(session).getUsername());//开启直接经过了开始审核的节点，所以要填上
			
			workCardMapper.updateByPrimaryKeyWithBLOBs(workCard);
			
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
		SalWorkCard workCard = workCardMapper.selectByPrimaryKey(id);
		String processInstanceId = workCard.getProcessInstanceId();
		
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
							
							buffer.append("工咭");
							
							buffer.append("<b>");
							buffer.append(workCard.getWorkCardNo());
							buffer.append("</b>");
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
					
					workCard.setWorkCardLeader(workCard.getWorkCardLeader().split("/")[0]);
					workCard.setSigner(null);
			    	
					workCard.setProcessInstanceId(null);
					workCardMapper.updateByPrimaryKeyWithBLOBs(workCard);
					
				}else{
					throw new RuntimeException("您不是流程发起人，无法撤销");
				}
			}
		}else{
			throw new RuntimeException("没有开启审核流程");
		}
	}
	
	@Override
	public void takeBackWorkCard(String id, String cause, HttpSession session) {
		SalWorkCard workCard = workCardMapper.selectByPrimaryKey(id);
		String processInstanceId = workCard.getProcessInstanceId();
		
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
					buffer.append("工咭");
					
					buffer.append("<b>");
					buffer.append(workCard.getWorkCardNo());
					buffer.append("</b>");
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
					
					if (taskDefinitionKey.equals("startAudit")){
						workCard.setWorkCardLeader(workCard.getWorkCardLeader().split("/")[0]);
						workCardMapper.updateByPrimaryKeyWithBLOBs(workCard);
					}else if (taskDefinitionKey.equals("saleReviewer")){
						workCard.setSigner(null);
					}
					workCardMapper.updateByPrimaryKeyWithBLOBs(workCard);
		           
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
	public void rollBackWorkCard(String id, String cause, HttpSession session) {
		SalWorkCard workCard = workCardMapper.selectByPrimaryKey(id);
		String processInstanceId = workCard.getProcessInstanceId();
		
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
					
					buffer.append("工咭");
					
					buffer.append("<b>");
					buffer.append(workCard.getWorkCardNo());
					buffer.append("</b>");
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
					
					
					
					if (taskDefinitionKey.equals("startAudit")){
						workCard.setWorkCardLeader(workCard.getWorkCardLeader().split("/")[0]);
						workCardMapper.updateByPrimaryKeyWithBLOBs(workCard);
					}else if (taskDefinitionKey.equals("saleReviewer")){
						workCard.setSigner(null);
					}
					workCardMapper.updateByPrimaryKeyWithBLOBs(workCard);
					
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
	public void antiAuditWorkCard(String id, String cause, HttpSession session) {
		SalWorkCard workCard = workCardMapper.selectByPrimaryKey(id);
		String processInstanceId = workCard.getProcessInstanceId();
		
		//查询是否有关联工咭相关文件
		SalWorkCardFileExample workCardFileExample = new SalWorkCardFileExample();
		workCardFileExample.createCriteria().andSalWorkCardIdEqualTo(id).andDrawingsFileEqualTo(false);
		List<SalWorkCardFile> workCardFiles = workCardFileMapper.selectByExample(workCardFileExample);
		
		
		if (workCardFiles != null && workCardFiles.size() > 0){
			throw new RuntimeException("请先删除工咭相关资料后，在反审工咭");
		}
		
		//查询是否有关联bom
		List<SalWorkCardSubsidiary> workCardSubsidiaries = workCardSubsidiaryMapper.findRelationBomBySalWorkCardId(id);
		if (workCardSubsidiaries != null && workCardSubsidiaries.size() > 0){
			throw new RuntimeException("请先删除bom，在反审工咭");
		}
		
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
				buffer.append("工咭");
				
				buffer.append("<b>");
				buffer.append(workCard.getWorkCardNo());
				buffer.append("</b>");
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
			
			workCard.setWorkCardLeader(workCard.getWorkCardLeader().split("/")[0]);
			workCard.setSigner(null);
			//并将所有审核人和审核时间清空，重新设置流程实例id
			workCard.setProcessInstanceId(null);
			workCardMapper.updateByPrimaryKeyWithBLOBs(workCard);
		}else{
			throw new RuntimeException("审核未完成无法反审核");
		}
	}

	@Override
	public List<SalWorkCardFile> findWorkCardFileListBySalWorkCardId(String salReviewerId, HttpServletRequest request) {
		return workCardFileMapper.findWorkCardFileListBySalWorkCardId(salReviewerId);
	}

	@Override
	public int saveWorkCardFile(String id, String workCardNo, MultipartFile workCardFile, HttpSession session) throws Exception{
		if (workCardFile.getSize() > 0){
			File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/workCard/", workCardNo);
			if (!file.exists()){
				file.mkdirs();
			}
			
			SalWorkCardFile workCardFile2 = new SalWorkCardFile();
			workCardFile2.setId(UUIDBuild.getUUID());
			workCardFile2.setFileName(workCardFile.getOriginalFilename());
			String suffix = workCardFile.getOriginalFilename().substring(workCardFile.getOriginalFilename().lastIndexOf("."), workCardFile.getOriginalFilename().length());
			workCardFile2.setFilePath(workCardNo+"/"+UUIDBuild.getUUID()+suffix);
			workCardFile2.setDrawingsFile(false);
			workCardFile2.setSalWorkCardId(id);
			workCardFile.transferTo(new File(ResourcesUtil.getValue("fileRootPath", "path") + "/workCard/", workCardFile2.getFilePath()));
			
			int i = workCardFileMapper.insert(workCardFile2);
			return i;
		}else{
			throw new RuntimeException("没有上传文件，或者上传0KB的文件");
		}
	}

	@Override
	public int deleteWorkCardFile(String id) {
		SalWorkCardFile workCardFile = workCardFileMapper.selectByPrimaryKey(id);
		
		if (StringUtils.isNotBlank(workCardFile.getProcessInstanceId())){
			throw new RuntimeException("已开启审核，不能删除");
		}
			
		int i = workCardFileMapper.deleteByPrimaryKey(id);
		File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/workCard/", workCardFile.getFilePath());
		if (file.exists()){//如果文件存在
			if (!file.delete()){
				throw new RuntimeException("文件删除失败");
			}
		}
		return i;
	}

	@Override
	public List<SysUser> queryAuditorForWorkCardFileById(String id, String processInstanceId, HttpSession session) {
		SalWorkCardFile workCardFile = workCardFileMapper.selectByPrimaryKey(id);
		if (StringUtils.isBlank(processInstanceId)){
			processInstanceId = workCardFile.getProcessInstanceId();
		}
		List<String> loginNames = new ArrayList<String>();
		
		List<SysUser> users = new ArrayList<SysUser>();
		
		if (StringUtils.isNotBlank(processInstanceId)){//已经开始了任务
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(processInstanceId);
			List<Task> tasks = taskQuery.list();
			if (tasks != null && tasks.size() > 0){
				Task task = null;
				for (Task task2 : tasks) {
					if (task2.getAssignee().equals(UserUtils.getUserFromSession(session).getAssignee())){
						task = task2;
					}
				}
				if (task != null){//表示是当前任务的办理人
					String activityImplId = null;
					List<TaskDefinition> taskDefinitions = null;
					String activitiId = task.getTaskDefinitionKey(); 
					 
			        //获取流程实例Id信息   
			          
			        //获取流程发布Id信息   
			        String definitionId = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getProcessDefinitionId();  
			          
			        ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)  
			                .getDeployedProcessDefinition(definitionId);  
			          
			        ExecutionEntity execution = (ExecutionEntity) runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
			          
			          
			        //获取流程所有节点信息   
			        List<ActivityImpl> activitiList = processDefinitionEntity.getActivities();   
			        
			        //遍历所有节点信息   
			        for(ActivityImpl activityImpl : activitiList){      
			        	activityImplId = activityImpl.getId();     
			              
			            // 找到当前节点信息  
			            if (activitiId.equals(activityImplId)) {
			            	Map<String, Object> variables = new HashMap<String, Object>();
			            	String assignees = "queryAuditor";
			            	variables.put("assignees", assignees);
			        		taskDefinitions = ActivitiUtils.nextTaskDefinition(activityImpl, activityImpl.getId(), variables, processInstanceId, runtimeService);  
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
			String processDefinitionKey = ResourcesUtil.getValue("activiti", "WorkCardFileProcessDefinitionKey");
			
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
	public void auditWorkCardFile(String id, String assigneeIds, HttpSession session) {
		SalWorkCardFile workCardFile = workCardFileMapper.selectByPrimaryKey(id);
		String processInstanceId = workCardFile.getProcessInstanceId();
		
		SalWorkCard workCard = workCardMapper.selectByPrimaryKey(workCardFile.getSalWorkCardId());
		
		List<SysUser> users = queryAuditorForWorkCardFileById(id, processInstanceId, session);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("工咭");
		buffer.append("<b>");
		buffer.append(workCard.getWorkCardNo());
		buffer.append("</b>");
		buffer.append("的工咭相关资料");
		buffer.append("<b>");
		buffer.append(workCardFile.getFileName());
		buffer.append("</b>");
		
		
		if (StringUtils.isNotBlank(processInstanceId)){//已经开始了任务
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(processInstanceId);
			List<Task> tasks = taskQuery.list();
			if (tasks != null && tasks.size() > 0){
				Task task = null;
				for (Task task2 : tasks) {
					if (task2.getAssignee().equals(UserUtils.getUserFromSession(session).getAssignee())){
						task = task2;
					}
				}
				if (task != null){
					if (StringUtils.isNotBlank(assigneeIds)){//不是最后一个节点
						List<String> assigneeIdList = Arrays.asList(assigneeIds.split(","));
						
						List<SysUser> assigneeUsers = new ArrayList<SysUser>();
						
						String assignees = "";
						
						for (String assigneeId : assigneeIdList) {
							for (SysUser sysUser : users) {
								if (assigneeId.equals(sysUser.getId())){//说明要发送给下一节点的人包含在下一节点的候选人中
									assigneeUsers.add(sysUser);
									assignees = assignees + sysUser.getLoginName() + ",";
									users.remove(sysUser);
									break;
								}
							}
						}
						assignees = assignees.substring(0, assignees.length()-1);
						
						
						if (assigneeUsers.size() > 0 && assigneeUsers.size() == assigneeIdList.size()){
							Map<String, Object> variables = new HashMap<String, Object>();
							variables.put("assignees", assignees);
							taskService.complete(task.getId(), variables);
							
							List<Task> tasks2 = taskQuery.list();
							if (assigneeUsers.size() == tasks2.size()){
								List<SysMessage> messages = new ArrayList<SysMessage>();
								buffer.append("需要您审核，请及时处理！");
								for (Task task2 : tasks2) {
									List<IdentityLink> identityLinks = taskService.getIdentityLinksForTask(task2.getId());
									List<String> userIds = new ArrayList<String>();
									for (IdentityLink identityLink : identityLinks) {
										userIds.add(identityLink.getUserId());
									}
									
									boolean b = false;//标识该任务的候选人是否有选择的审核人
									for (SysUser user : assigneeUsers) {
										if (userIds.contains(user.getLoginName())){
											taskService.claim(task2.getId(), user.getAssignee());
											
											//发送消息
											SysMessage message = new SysMessage();
											message.setId(UUIDBuild.getUUID());
											message.setIsRead(false);
											message.setMessage(buffer.toString());
											message.setSender(UserUtils.getUserFromSession(session).getLoginName());
											message.setReceiver(user.getLoginName());
											message.setSendTime(new Date());
											
											messages.add(message);
											
											break;
										}
									}
									if (!b){//如果没有，则抛出异常
										throw new RuntimeException("评审候选人中没有您选择的评审人");
									}
								}
								messageMapper.insertList(messages);
							}else{
								throw new RuntimeException("选择的人数跟实际分配的人数不相等");
							}
							
						}else{
							throw new RuntimeException("评审候选人中没有您选择的评审人");
						}
					}else{//如果是最后一个节点
						if (users != null && users.size() > 0){
							throw new RuntimeException("没有选择接收任务的人员");
						}else{
							taskService.complete(task.getId());
							
							SysMessage message = new SysMessage();
							message.setId(UUIDBuild.getUUID());
							message.setIsRead(false);
							
							buffer.append("的审核已完成！");
							message.setMessage(buffer.toString());
							message.setSendTime(new Date());
							
							
							message.setSender("admin");
							HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
							//设置发起人为消息接收人
							message.setReceiver(processInstance.getStartUserId().substring(processInstance.getStartUserId().indexOf("(") + 1,processInstance.getStartUserId().indexOf(")")));
							messageMapper.insert(message);
						}
					}
				}else{
					throw new RuntimeException("对不起，您不是当前任务的办理人，请刷新数据！");
				}
			}else{
				throw new RuntimeException("当前流程已经结束，不能审核");
			}
			
		}else{//未开启任务
			
			if (StringUtils.isNotBlank(assigneeIds)){//
				List<String> assigneeIdList = Arrays.asList(assigneeIds.split(","));
				
				List<SysUser> assigneeUsers = new ArrayList<SysUser>();
				
				String assignees = "";
				
				for (String assigneeId : assigneeIdList) {
					for (SysUser sysUser : users) {
						if (assigneeId.equals(sysUser.getId())){//说明要发送给下一节点的人包含在下一节点的候选人中
							assigneeUsers.add(sysUser);
							assignees = assignees + sysUser.getLoginName() + ",";
							users.remove(sysUser);
							break;
						}
					}
				}
				assignees = assignees.substring(0, assignees.length()-1);
				
				
				if (assigneeUsers.size() > 0 && assigneeUsers.size() == assigneeIdList.size()){
					String processDefinitionKey = ResourcesUtil.getValue("activiti", "WorkCardFileProcessDefinitionKey");
					
					identityService.setAuthenticatedUserId(UserUtils.getUserFromSession(session).getAssignee());
					String businessKey = id;
					ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey);
					processInstanceId = processInstance.getProcessInstanceId();
					workCardFile.setProcessInstanceId(processInstanceId);
					
					workCardFileMapper.updateByPrimaryKey(workCardFile);
					
					TaskQuery taskQuery = taskService.createTaskQuery();
					taskQuery.processInstanceId(processInstanceId);
					Task task = taskQuery.singleResult();
					
					
					Map<String, Object> variables = new HashMap<String, Object>();
					variables.put("assignees", assignees);
					taskService.complete(task.getId(), variables);
					
					List<Task> tasks = taskQuery.list();
					if (assigneeUsers.size() == tasks.size()){
						List<SysMessage> messages = new ArrayList<SysMessage>();
						buffer.append("需要您审核，请及时处理！");
						for (Task task2 : tasks) {
							List<IdentityLink> identityLinks = taskService.getIdentityLinksForTask(task2.getId());
							List<String> userIds = new ArrayList<String>();
							for (IdentityLink identityLink : identityLinks) {
								userIds.add(identityLink.getUserId());
							}
							
							boolean b = false;//标识该任务的候选人是否有选择的审核人
							for (SysUser user : assigneeUsers) {
								if (userIds.contains(user.getLoginName())){
									taskService.claim(task2.getId(), user.getAssignee());
									
									//发送消息
									SysMessage message = new SysMessage();
									message.setId(UUIDBuild.getUUID());
									message.setIsRead(false);
									message.setMessage(buffer.toString());
									message.setSender(UserUtils.getUserFromSession(session).getLoginName());
									message.setReceiver(user.getLoginName());
									message.setSendTime(new Date());
									
									messages.add(message);
									b = true;
									break;
								}
							}
							if (!b){//如果没有，则抛出异常
								throw new RuntimeException("评审候选人中没有您选择的评审人");
							}
						}
						messageMapper.insertList(messages);
					}else{
						throw new RuntimeException("选择的人数跟实际分配的人数不相等");
					}
					
				}else{
					throw new RuntimeException("评审候选人中没有您选择的评审人");
				}
			}else{
				throw new RuntimeException("没有选择接收任务的人员");
			}
		}
	}

	@Override
	public void revokeProcessWorkCardFile(String id, HttpSession session) {
		SalWorkCardFile workCardFile = workCardFileMapper.selectByPrimaryKey(id);
		String processInstanceId = workCardFile.getProcessInstanceId();
		
		SalWorkCard workCard = workCardMapper.selectByPrimaryKey(workCardFile.getSalWorkCardId());
		
		if (StringUtils.isNotBlank(processInstanceId)){
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(processInstanceId);//设置查询条件，流程实例id
			List<Task> tasks = taskQuery.list();
			
			if (tasks == null || tasks.size() <= 0){//已完成
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
							
							buffer.append("工咭");
							buffer.append("<b>");
							buffer.append(workCard.getWorkCardNo());
							buffer.append("</b>");
							buffer.append("的工咭相关资料");
							buffer.append("<b>");
							buffer.append(workCardFile.getFileName());
							buffer.append("</b>");
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
					
			    	
					workCardFile.setProcessInstanceId(null);
					workCardFileMapper.updateByPrimaryKey(workCardFile);
					
				}else{
					throw new RuntimeException("您不是流程发起人，无法撤销");
				}
			}
		}else{
			throw new RuntimeException("没有开启审核流程");
		}
	}

	@Override
	public void antiAuditWorkCardFile(String id, String cause, HttpSession session) {
		SalWorkCardFile workCardFile = workCardFileMapper.selectByPrimaryKey(id);
		String processInstanceId = workCardFile.getProcessInstanceId();
		
		SalWorkCard workCard = workCardMapper.selectByPrimaryKey(workCardFile.getSalWorkCardId());
		
		
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
				buffer.append("工咭");
				buffer.append("<b>");
				buffer.append(workCard.getWorkCardNo());
				buffer.append("</b>");
				buffer.append("的工咭相关资料");
				buffer.append("<b>");
				buffer.append(workCardFile.getFileName());
				buffer.append("</b>");
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
			workCardFile.setProcessInstanceId(null);
			workCardFileMapper.updateByPrimaryKey(workCardFile);
		}else{
			throw new RuntimeException("审核未完成无法反审核");
		}
	}
}
