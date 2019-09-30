package cn.chiucheung.service.market.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.market.costbudget.MarCostBudgetMapper;
import cn.chiucheung.dao.mapper.market.costbudget.MarCostBudgetMaterialMapper;
import cn.chiucheung.dao.mapper.purchase.material.PurMaterialMapper;
import cn.chiucheung.po.market.costbudget.MarCostBudget;
import cn.chiucheung.po.market.costbudget.MarCostBudgetExample;
import cn.chiucheung.po.market.costbudget.MarCostBudgetExample.Criteria;
import cn.chiucheung.po.market.costbudget.MarCostBudgetMaterial;
import cn.chiucheung.po.market.costbudget.MarCostBudgetMaterialExample;
import cn.chiucheung.po.purchase.material.PurMaterial;
import cn.chiucheung.po.system.user.Privilege;
import cn.chiucheung.pojo.market.costbudget.MarCostBudgetCustom;
import cn.chiucheung.pojo.market.costbudget.MarCostBudgetVo;
import cn.chiucheung.service.market.CostBudgetService;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class CostBudgetServiceImpl implements CostBudgetService{
	
	@Autowired
	private MarCostBudgetMapper costBudgetMapper;
	
	@Autowired
	private MarCostBudgetMaterialMapper costBudgetMaterialMapper;
	
	@Autowired
	private PurMaterialMapper materialMapper;
	
	@Override
	public int saveCostBudget(Map<String, Object> map) {
		JSONObject costBudgetJsonObject = JSONObject.fromObject(map.get("costBudget"));
		//如何提交的时间为空时，需要将submitTime移动，否则空的转换成javaBean时，会自动设置成当前的时间
		if (StringUtils.isBlank(costBudgetJsonObject.getString("submitTime"))){
			costBudgetJsonObject.remove("submitTime");
		}
		MarCostBudget costBudget = (MarCostBudget) JSONObject.toBean(costBudgetJsonObject, MarCostBudget.class);
		String id = UUIDBuild.getUUID();
		costBudget.setId(id);
		
		//如果是新建的成本核算表，是没有外键到项目评审表的成本核算，所以如果为""时，设置成null
		if (StringUtils.isBlank(costBudget.getSalReviewerId())){
			costBudget.setSalReviewerId(null);
		}
		
		JSONArray materialsArray = JSONArray.fromObject(map.get("materials"));
		List<MarCostBudgetMaterial> marCostBudgetMaterials = JSONArray.toList(materialsArray, MarCostBudgetMaterial.class);
		for (MarCostBudgetMaterial marCostBudgetMaterial : marCostBudgetMaterials) {
			marCostBudgetMaterial.setPurMaterialId(marCostBudgetMaterial.getId());
			marCostBudgetMaterial.setId(UUIDBuild.getUUID());
			marCostBudgetMaterial.setMarCostBudgetId(id);
		}
		
		int i = 0;
		
		i = i + costBudgetMapper.insert(costBudget);
		
		i = i + costBudgetMaterialMapper.insertList(marCostBudgetMaterials);
		return i;
	}

	@Override
	public List<MarCostBudget> findCostBudgetListBySalReviewerId(String salReviewerId, List<Privilege> privileges) {
		MarCostBudgetExample costBudgetExample = new MarCostBudgetExample();
		Criteria criteria = costBudgetExample.createCriteria();
		criteria.andSalReviewerIdEqualTo(salReviewerId);
		Privilege privilege = new Privilege();
		privilege.setMid("dfm");
		privilege.setPid("df");
		
		Privilege privilege1 = new Privilege();
		privilege1.setMid("dfl");
		privilege1.setPid("df");
		if (privileges!=null && !privileges.contains(privilege) && !privileges.contains(privilege1)){//没有生成和修改权限的都不能看没有提交时间的
			criteria.andSubmitTimeIsNotNull();
		}
		return costBudgetMapper.selectByExample(costBudgetExample);
	}

	@Override
	public Map<String, Object> findCostBudgetByIdForView(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		MarCostBudget costBudget = costBudgetMapper.selectByPrimaryKey(id);
		String remark = costBudget.getRemark();
		if (remark != null){
			remark=remark.replaceAll("<","&It;").replaceAll(">","&gt").replaceAll("\r\n","<br><br>").replaceAll(" ","&nbsp;");
			costBudget.setRemark(remark);
		}
		map.put("costBudget", costBudget);
		
		MarCostBudgetMaterialExample costBudgetMaterialExample = new MarCostBudgetMaterialExample();
		costBudgetMaterialExample.setOrderByClause("number");
		costBudgetMaterialExample.createCriteria().andMarCostBudgetIdEqualTo(id);
		List<MarCostBudgetMaterial> costBudgetMaterials = costBudgetMaterialMapper.selectByExample(costBudgetMaterialExample);
		map.put("materials", costBudgetMaterials);
		
		return map;
	}
	
	@Override
	public Map<String, Object> findCostBudgetById(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		MarCostBudget costBudget = costBudgetMapper.selectByPrimaryKey(id);
		map.put("costBudget", costBudget);
		
		MarCostBudgetMaterialExample costBudgetMaterialExample = new MarCostBudgetMaterialExample();
		costBudgetMaterialExample.setOrderByClause("number");
		costBudgetMaterialExample.createCriteria().andMarCostBudgetIdEqualTo(id);
		List<MarCostBudgetMaterial> costBudgetMaterials = costBudgetMaterialMapper.selectByExample(costBudgetMaterialExample);
		map.put("materials", costBudgetMaterials);
		
		return map;
	}

	@Override
	public int updateCostBudget(Map<String, Object> map) {
		JSONObject costBudgetJsonObject = JSONObject.fromObject(map.get("costBudget"));
		//如何提交的时间为空时，需要将submitTime移动，否则空的转换成javaBean时，会自动设置成当前的时间
		if (StringUtils.isBlank(costBudgetJsonObject.getString("submitTime"))){
			costBudgetJsonObject.remove("submitTime");
		}
		MarCostBudget costBudget = (MarCostBudget) JSONObject.toBean(costBudgetJsonObject, MarCostBudget.class);
		
		//如果修改的成本核算表，是没有外键到项目评审表的成本核算，所以如果为""时，设置成null
		if (StringUtils.isBlank(costBudget.getSalReviewerId())){
			costBudget.setSalReviewerId(null);
		}
		
		//先删除MarCostBudgetId等于id的所有marCostBudgetMaterial
		MarCostBudgetMaterialExample costBudgetMaterialExample = new MarCostBudgetMaterialExample();
		costBudgetMaterialExample.createCriteria().andMarCostBudgetIdEqualTo(costBudget.getId());
		costBudgetMaterialMapper.deleteByExample(costBudgetMaterialExample);
		
		//在添加
		JSONArray materialsArray = JSONArray.fromObject(map.get("materials"));
		List<MarCostBudgetMaterial> marCostBudgetMaterials = JSONArray.toList(materialsArray, MarCostBudgetMaterial.class);
		for (MarCostBudgetMaterial marCostBudgetMaterial : marCostBudgetMaterials) {
			if (StringUtils.isBlank(marCostBudgetMaterial.getPurMaterialId())){
				marCostBudgetMaterial.setPurMaterialId(marCostBudgetMaterial.getId());
				marCostBudgetMaterial.setId(UUIDBuild.getUUID());
			}
			marCostBudgetMaterial.setMarCostBudgetId(costBudget.getId());
		}
		
		int i = 0;
		
		i = i + costBudgetMapper.updateByPrimaryKeyWithBLOBs(costBudget);
		
		i = i + costBudgetMaterialMapper.insertList(marCostBudgetMaterials);
		return i;
	}

	@Override
	public int deleteCostBudgetById(String id) {
		int i = 0;
		//先删除MarCostBudgetId等于id的所有marCostBudgetMaterial
		MarCostBudgetMaterialExample costBudgetMaterialExample = new MarCostBudgetMaterialExample();
		costBudgetMaterialExample.createCriteria().andMarCostBudgetIdEqualTo(id);
		i = i + costBudgetMaterialMapper.deleteByExample(costBudgetMaterialExample);
		
		i = i + costBudgetMapper.deleteByPrimaryKey(id);
		return i;
	}


	@Override
	public int updateCostBudgetByIdForAssociated(String id, String salReviewerId) {
		MarCostBudget costBudget = new MarCostBudget();
		costBudget.setId(id);
		costBudget.setSalReviewerId(salReviewerId);
		return costBudgetMapper.updateByPrimaryKeySelective(costBudget);
	}
	
	@Override
	public int updateCostBudgetByIdForCancelAssociated(String id) {
		//取消关联，也就是将sal_reviewer_id设置为null
		return costBudgetMapper.updateCostBudgetByIdForCancelAssociated(id);
	}

	@Override
	public Map<String, Object> findAllCostBudgetList(MarCostBudgetVo costBudgetVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MarCostBudget> costBudgets = costBudgetMapper.findAllCostBudgetList(costBudgetVo);
		map.put("rows", costBudgets);
		String total = costBudgetMapper.findAllCostBudgetTotal(costBudgetVo);
		map.put("total", total);
		return map;
	}

	@Override
	public MarCostBudget findCostBudgetByIdForAssociated(String id) {
		return costBudgetMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<MarCostBudgetCustom> findCxportingReportDatas(MarCostBudgetVo costBudgetVo) {
		return costBudgetMapper.findCxportingReportDatas(costBudgetVo);
	}

	@Override
	public Map<String, Object> findCostBudgetByIdForCopyData(String id, Boolean flag) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		MarCostBudget costBudget = costBudgetMapper.selectByPrimaryKey(id);
		costBudget.setId("");
		costBudget.setReviewer("");
		costBudget.setPreparer(null);
		map.put("costBudget", costBudget);
		
		MarCostBudgetMaterialExample costBudgetMaterialExample = new MarCostBudgetMaterialExample();
		costBudgetMaterialExample.setOrderByClause("number");
		costBudgetMaterialExample.createCriteria().andMarCostBudgetIdEqualTo(id);
		List<MarCostBudgetMaterial> costBudgetMaterials = costBudgetMaterialMapper.selectByExample(costBudgetMaterialExample);
		for (MarCostBudgetMaterial costBudgetMaterial : costBudgetMaterials) {
			String purMaterialId = costBudgetMaterial.getPurMaterialId();
			//开始计算
			costBudgetMaterial.setId(purMaterialId);
			if (flag){//更新物料
				PurMaterial material = materialMapper.selectByPrimaryKey(purMaterialId);
				costBudgetMaterial.setMaterialType(material.getMaterialType());
				costBudgetMaterial.setMaterialName(material.getMaterialName());
				costBudgetMaterial.setModel(material.getModel());
				costBudgetMaterial.setThick(material.getThick());
				costBudgetMaterial.setLength(material.getLength());
				costBudgetMaterial.setWidth(material.getWidth());
				costBudgetMaterial.setWeight(material.getWeight());
				costBudgetMaterial.setUnit(material.getUnit());
				costBudgetMaterial.setUnitPrice(material.getUnitPrice());
			}
		}
		map.put("materials", costBudgetMaterials);
		return map;
	}

}
