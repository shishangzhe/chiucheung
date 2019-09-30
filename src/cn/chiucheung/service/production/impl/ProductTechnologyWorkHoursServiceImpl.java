package cn.chiucheung.service.production.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.production.producttechnologyflowchart.ProProductTechnologyFlowChartLinkDataArrayMapper;
import cn.chiucheung.dao.mapper.production.producttechnologyflowchart.ProProductTechnologyFlowChartNodeDataArrayMapper;
import cn.chiucheung.dao.mapper.production.producttechnologyworkhours.ProProductTechnologyAccessoriesWorkHoursMapper;
import cn.chiucheung.dao.mapper.production.producttechnologyworkhours.ProProductTechnologyProcessWorkHoursMapper;
import cn.chiucheung.dao.mapper.production.producttechnologyworkhours.ProProductTechnologyWorkHoursMapper;
import cn.chiucheung.dao.mapper.production.standard.ProProcessMapper;
import cn.chiucheung.dao.mapper.warehouse.basedata.WarBaseDataMapper;
import cn.chiucheung.po.production.producttechnologyflowchart.ProProductTechnologyFlowChartLinkDataArray;
import cn.chiucheung.po.production.producttechnologyflowchart.ProProductTechnologyFlowChartLinkDataArrayExample;
import cn.chiucheung.po.production.producttechnologyflowchart.ProProductTechnologyFlowChartNodeDataArray;
import cn.chiucheung.po.production.producttechnologyflowchart.ProProductTechnologyFlowChartNodeDataArrayExample;
import cn.chiucheung.po.production.producttechnologyworkhours.ProProductTechnologyAccessoriesWorkHours;
import cn.chiucheung.po.production.producttechnologyworkhours.ProProductTechnologyAccessoriesWorkHoursExample;
import cn.chiucheung.po.production.producttechnologyworkhours.ProProductTechnologyProcessWorkHours;
import cn.chiucheung.po.production.producttechnologyworkhours.ProProductTechnologyProcessWorkHoursExample;
import cn.chiucheung.po.production.producttechnologyworkhours.ProProductTechnologyWorkHours;
import cn.chiucheung.po.warehouse.basedata.WarBaseData;
import cn.chiucheung.po.warehouse.basedata.WarBaseDataExample;
import cn.chiucheung.pojo.production.producttechnologyflowchart.ProProductTechnologyFlowChartCustom;
import cn.chiucheung.pojo.production.producttechnologyflowchart.ProProductTechnologyFlowChartNodeDataArrayCustom;
import cn.chiucheung.pojo.production.producttechnologyworkhours.ProCalculateProcessTimesCustom;
import cn.chiucheung.pojo.production.producttechnologyworkhours.ProCalculateProcessTimesForExportExcelCustom;
import cn.chiucheung.pojo.production.producttechnologyworkhours.ProProductTechnologyAccessoriesWorkHoursCustom;
import cn.chiucheung.pojo.production.producttechnologyworkhours.ProProductTechnologyProcessWorkHoursCustom;
import cn.chiucheung.pojo.production.producttechnologyworkhours.ProProductTechnologyWorkHoursCustom;
import cn.chiucheung.pojo.production.producttechnologyworkhours.ProProductTechnologyWorkHoursForExportExcelCustom;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesQueryVo;
import cn.chiucheung.service.production.ProductTechnologyWorkHoursService;
import cn.chiucheung.utils.Base64Util;
import cn.chiucheung.utils.ResourcesUtil;
import cn.chiucheung.utils.UUIDBuild;

@Service
public class ProductTechnologyWorkHoursServiceImpl implements ProductTechnologyWorkHoursService{
	
	@Autowired
	ProProductTechnologyWorkHoursMapper productTechnologyWorkHoursMapper;
	
	@Autowired
	ProProductTechnologyProcessWorkHoursMapper productTechnologyProcessWorkHoursMapper;
	
	@Autowired
	ProProductTechnologyAccessoriesWorkHoursMapper productTechnologyAccessoriesWorkHoursMapper;
	
	@Autowired
	WarBaseDataMapper baseDataMapper;
	
	@Autowired
	ProProcessMapper processMapper;
	
	@Autowired
	ProProductTechnologyFlowChartLinkDataArrayMapper productTechnologyFlowChartLinkDataArrayMapper;
	
	@Autowired
	ProProductTechnologyFlowChartNodeDataArrayMapper productTechnologyFlowChartNodeDataArrayMapper;
	
	@Override
	public List<ProProductTechnologyWorkHoursCustom> findAllProductTechnologyWorkHoursList(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo) {
		return productTechnologyWorkHoursMapper.findAllProductTechnologyWorkHoursList(standardAccessoriesQueryVo);
	}
	
	@Override
	public String findAllProductTechnologyWorkHoursTotal(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo) {
		return productTechnologyWorkHoursMapper.findAllProductTechnologyWorkHoursTotal(standardAccessoriesQueryVo);
	}
	
	
	@Override
	public List<ProProductTechnologyWorkHoursCustom> findAllProductTechnologyWorkHoursSubsidiaryListById(String id) {
		List<ProProductTechnologyWorkHoursCustom> productTechnologyWorkHoursCustoms = new ArrayList<ProProductTechnologyWorkHoursCustom>();
		
		List<ProProductTechnologyWorkHoursCustom> productTechnologyProcessWorkHours = productTechnologyWorkHoursMapper.findAllProductTechnologyProcessWorkHoursListByProProductTechnologyWorkHoursId(id);
		if (productTechnologyProcessWorkHours != null && productTechnologyProcessWorkHours.size() > 0){
			for (ProProductTechnologyWorkHoursCustom productTechnologyWorkHoursCustom : productTechnologyProcessWorkHours) {//重新设置id，防止冲突，本身的id不需要，因为是最后一个节点
				productTechnologyWorkHoursCustom.setId(UUIDBuild.getUUID());
			}
		}
		
		List<ProProductTechnologyWorkHoursCustom> productTechnologyAccessoriesWorkHours = productTechnologyWorkHoursMapper.findAllProductTechnologyAccessoriesWorkHoursListByProProductTechnologyWorkHoursId(id);
		if (productTechnologyAccessoriesWorkHours != null && productTechnologyAccessoriesWorkHours.size() > 0){
			for (ProProductTechnologyWorkHoursCustom proProductTechnologyWorkHoursCustom : productTechnologyAccessoriesWorkHours) {//重新设置id，防止冲突，本身的id放在proProductTechnologyWorkHoursId
				proProductTechnologyWorkHoursCustom.setId(UUIDBuild.getUUID());
			}
		}
		
		productTechnologyWorkHoursCustoms.addAll(productTechnologyAccessoriesWorkHours);
		productTechnologyWorkHoursCustoms.addAll(productTechnologyProcessWorkHours);
		
		
		return productTechnologyWorkHoursCustoms;
	}
	

	@Override
	public List<ProProductTechnologyWorkHoursCustom> findAllProductTechnologyWorkHoursSubsidiaryListByProProductTechnologyAccessoriesWorkHoursId(String id) {
		List<ProProductTechnologyWorkHoursCustom> productTechnologyWorkHoursCustoms = new ArrayList<ProProductTechnologyWorkHoursCustom>();
		
		List<ProProductTechnologyWorkHoursCustom> productTechnologyProcessWorkHours = productTechnologyWorkHoursMapper.findAllProductTechnologyProcessWorkHoursListByProProductTechnologyAccessoriesWorkHoursId(id);
		if (productTechnologyProcessWorkHours != null && productTechnologyProcessWorkHours.size() > 0){
			for (ProProductTechnologyWorkHoursCustom productTechnologyWorkHoursCustom : productTechnologyProcessWorkHours) {//重新设置id，防止冲突，本身的id不需要，因为是最后一个节点
				productTechnologyWorkHoursCustom.setId(UUIDBuild.getUUID());
			}
		}
		
		List<ProProductTechnologyWorkHoursCustom> productTechnologyAccessoriesWorkHours = productTechnologyWorkHoursMapper.findAllProductTechnologyAccessoriesWorkHoursListByProProductTechnologyAccessoriesWorkHoursId(id);
		if (productTechnologyAccessoriesWorkHours != null && productTechnologyAccessoriesWorkHours.size() > 0){
			for (ProProductTechnologyWorkHoursCustom proProductTechnologyWorkHoursCustom : productTechnologyAccessoriesWorkHours) {//重新设置id，防止冲突，本身的id放在proProductTechnologyWorkHoursId
				proProductTechnologyWorkHoursCustom.setId(UUIDBuild.getUUID());
			}
		}
		
		productTechnologyWorkHoursCustoms.addAll(productTechnologyAccessoriesWorkHours);
		productTechnologyWorkHoursCustoms.addAll(productTechnologyProcessWorkHours);
		
		
		return productTechnologyWorkHoursCustoms;
	}
	
	@Override
	public List<ProProductTechnologyWorkHoursCustom> findAllWarStandardAccessoriesForIsAssociatedList(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo) {
		return productTechnologyWorkHoursMapper.findAllWarStandardAccessoriesForIsAssociatedList(standardAccessoriesQueryVo);
	}

	@Override
	public String findAllWarStandardAccessoriesForIsAssociatedTotal(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo) {
		return productTechnologyWorkHoursMapper.findAllWarStandardAccessoriesForIsAssociatedTotal(standardAccessoriesQueryVo);
	}
	
	@Override
	public int saveProductTechnologyWorkHours(HashMap<String, Object> map) throws Exception{
        JSONArray jsonArray =JSONArray.fromObject(map.get("processDatas"));
		ProProductTechnologyWorkHours productTechnologyWorkHours = (ProProductTechnologyWorkHours) JSONObject.toBean(JSONObject.fromObject(map.get("productTechnologyWorkHours")), ProProductTechnologyWorkHours.class);
		
		List<ProProductTechnologyProcessWorkHours> processDatas = JSONArray.toList(jsonArray, ProProductTechnologyProcessWorkHours.class);
		
		List<ProProductTechnologyAccessoriesWorkHoursCustom> standardAccessoriesDatas = JSONArray.toList(JSONArray.fromObject(map.get("standardAccessoriesDatas")), ProProductTechnologyAccessoriesWorkHoursCustom.class);
		
		String id = UUIDBuild.getUUID();
		
		productTechnologyWorkHours.setId(id);
		
		BigDecimal processTotalTime = new BigDecimal(0);
		BigDecimal processTotalArtificialTime = new BigDecimal(0);
		
		if (processDatas != null && processDatas.size() > 0){
			for (ProProductTechnologyProcessWorkHours productTechnologyProcessWorkHours : processDatas) {
				productTechnologyProcessWorkHours.setProProcessId(productTechnologyProcessWorkHours.getId());
				productTechnologyProcessWorkHours.setId(UUIDBuild.getUUID());
				productTechnologyProcessWorkHours.setProProductTechnologyWorkHoursId(id);
				processTotalTime = processTotalTime.add(productTechnologyProcessWorkHours.getTotalTime());
				processTotalArtificialTime = processTotalArtificialTime.add(productTechnologyProcessWorkHours.getTotalArtificialTime());
			}
		}
		
		BigDecimal standardAccessoriesTotalTime = new BigDecimal(0);
		BigDecimal standardAccessoriesTotalArtificialTime = new BigDecimal(0);
		
		if (standardAccessoriesDatas != null && standardAccessoriesDatas.size() > 0){
			for (ProProductTechnologyAccessoriesWorkHoursCustom productTechnologyAccessoriesWorkHoursCustom : standardAccessoriesDatas) {
				productTechnologyAccessoriesWorkHoursCustom.setProProductTechnologyAccessoriesWorkHoursId(productTechnologyAccessoriesWorkHoursCustom.getProProductTechnologyWorkHoursId());
				productTechnologyAccessoriesWorkHoursCustom.setProProductTechnologyWorkHoursId(id);
				productTechnologyAccessoriesWorkHoursCustom.setId(UUIDBuild.getUUID());
				standardAccessoriesTotalTime = standardAccessoriesTotalTime.add(productTechnologyAccessoriesWorkHoursCustom.getTotalTime().multiply(new BigDecimal(productTechnologyAccessoriesWorkHoursCustom.getEachNumber())));
				standardAccessoriesTotalArtificialTime = standardAccessoriesTotalArtificialTime.add(productTechnologyAccessoriesWorkHoursCustom.getTotalArtificialTime().multiply(new BigDecimal(productTechnologyAccessoriesWorkHoursCustom.getEachNumber())));
			}
		}
		
		BigDecimal totalTime = processTotalTime.multiply(productTechnologyWorkHours.getProcessCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP).add(standardAccessoriesTotalTime.multiply(productTechnologyWorkHours.getAccessoriesCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP));
		BigDecimal totalArtificialTime = processTotalArtificialTime.multiply(productTechnologyWorkHours.getProcessCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP).add(standardAccessoriesTotalArtificialTime.multiply(productTechnologyWorkHours.getAccessoriesCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP));
		
		productTechnologyWorkHours.setTotalTime(totalTime);
		productTechnologyWorkHours.setTotalArtificialTime(totalArtificialTime);
		productTechnologyWorkHours.setState("closed");
		
		int i = productTechnologyWorkHoursMapper.insert(productTechnologyWorkHours);
		
		if (processDatas != null && processDatas.size() > 0){
			productTechnologyProcessWorkHoursMapper.insertList(processDatas);
		}
		
		if (standardAccessoriesDatas != null && standardAccessoriesDatas.size() > 0){
			productTechnologyAccessoriesWorkHoursMapper.insertList(standardAccessoriesDatas);
		}
		
		return i;
	}

	@Override
	public Map<String, Object> findProductTechnologyWorkHoursById(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		ProProductTechnologyWorkHours productTechnologyWorkHours = productTechnologyWorkHoursMapper.selectByPrimaryKey(id);
		
		map.put("productTechnologyWorkHours", productTechnologyWorkHours);
		
		
		List<ProProductTechnologyProcessWorkHoursCustom> processDatas = productTechnologyProcessWorkHoursMapper.findAllProProductTechnologyProcessWorkHoursListByProProductTechnologyWorkHoursId(id);
		
		map.put("processDatas", processDatas);


		List<ProProductTechnologyAccessoriesWorkHoursCustom> standardAccessoriesDatas = productTechnologyAccessoriesWorkHoursMapper.findAllProProductTechnologyAccessoriesWorkHoursListByProProductTechnologyWorkHoursId(id);

		map.put("standardAccessoriesDatas", standardAccessoriesDatas);
		
		
		//下面是查找该产品的页面编辑combogrid需要加载的要修改的数据
		WarStandardAccessoriesQueryVo standardAccessoriesQueryVo = new WarStandardAccessoriesQueryVo();
		standardAccessoriesQueryVo.setId(productTechnologyWorkHours.getWarStandardAccessoriesId());
		
		List<ProProductTechnologyWorkHoursCustom> list = productTechnologyWorkHoursMapper.findAllWarStandardAccessoriesForIsAssociatedList(standardAccessoriesQueryVo);
		
		HashMap<String, Object> row = new HashMap<String, Object>();
		row.put("total", 1);
		row.put("rows", list);
		
		map.put("row", row);
		
		
		return map;
	}

	@Override
	public int updateProductTechnologyWorkHours(HashMap<String, Object> map) {
		ProProductTechnologyWorkHours productTechnologyWorkHours = (ProProductTechnologyWorkHours) JSONObject.toBean(JSONObject.fromObject(map.get("productTechnologyWorkHours")), ProProductTechnologyWorkHours.class);
		
		List<ProProductTechnologyProcessWorkHours> processDatas = JSONArray.toList(JSONArray.fromObject(map.get("processDatas")), ProProductTechnologyProcessWorkHours.class);
		
		List<ProProductTechnologyAccessoriesWorkHoursCustom> standardAccessoriesDatas = JSONArray.toList(JSONArray.fromObject(map.get("standardAccessoriesDatas")), ProProductTechnologyAccessoriesWorkHoursCustom.class);
		
		String id = productTechnologyWorkHours.getId();
		
		productTechnologyWorkHours.setId(id);
		
		BigDecimal processTotalTime = new BigDecimal(0);
		BigDecimal processTotalArtificialTime = new BigDecimal(0);
		
		if (processDatas != null && processDatas.size() > 0){
			for (ProProductTechnologyProcessWorkHours productTechnologyProcessWorkHours : processDatas) {
				productTechnologyProcessWorkHours.setProProcessId(productTechnologyProcessWorkHours.getId());
				productTechnologyProcessWorkHours.setId(UUIDBuild.getUUID());
				productTechnologyProcessWorkHours.setProProductTechnologyWorkHoursId(id);
				processTotalTime = processTotalTime.add(productTechnologyProcessWorkHours.getTotalTime());
				processTotalArtificialTime = processTotalArtificialTime.add(productTechnologyProcessWorkHours.getTotalArtificialTime());
			}
		}
		
		BigDecimal standardAccessoriesTotalTime = new BigDecimal(0);
		BigDecimal standardAccessoriesTotalArtificialTime = new BigDecimal(0);
		
		if (standardAccessoriesDatas != null && standardAccessoriesDatas.size() > 0){
			for (ProProductTechnologyAccessoriesWorkHoursCustom productTechnologyAccessoriesWorkHoursCustom : standardAccessoriesDatas) {
				productTechnologyAccessoriesWorkHoursCustom.setProProductTechnologyAccessoriesWorkHoursId(productTechnologyAccessoriesWorkHoursCustom.getProProductTechnologyWorkHoursId());
				productTechnologyAccessoriesWorkHoursCustom.setProProductTechnologyWorkHoursId(id);
				productTechnologyAccessoriesWorkHoursCustom.setId(UUIDBuild.getUUID());
				standardAccessoriesTotalTime = standardAccessoriesTotalTime.add(productTechnologyAccessoriesWorkHoursCustom.getTotalTime().multiply(new BigDecimal(productTechnologyAccessoriesWorkHoursCustom.getEachNumber())));
				standardAccessoriesTotalArtificialTime = standardAccessoriesTotalArtificialTime.add(productTechnologyAccessoriesWorkHoursCustom.getTotalArtificialTime().multiply(new BigDecimal(productTechnologyAccessoriesWorkHoursCustom.getEachNumber())));
			}
		}
		
		BigDecimal totalTime = processTotalTime.multiply(productTechnologyWorkHours.getProcessCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP).add(standardAccessoriesTotalTime.multiply(productTechnologyWorkHours.getAccessoriesCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP));
		BigDecimal totalArtificialTime = processTotalArtificialTime.multiply(productTechnologyWorkHours.getProcessCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP).add(standardAccessoriesTotalArtificialTime.multiply(productTechnologyWorkHours.getAccessoriesCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP));
		
		productTechnologyWorkHours.setTotalTime(totalTime);
		productTechnologyWorkHours.setTotalArtificialTime(totalArtificialTime);
		productTechnologyWorkHours.setState("closed");
		
		int i = productTechnologyWorkHoursMapper.updateByPrimaryKey(productTechnologyWorkHours);
		
		
		ProProductTechnologyProcessWorkHoursExample processWorkHoursExample = new ProProductTechnologyProcessWorkHoursExample();
		processWorkHoursExample.createCriteria().andProProductTechnologyWorkHoursIdEqualTo(id);
		productTechnologyProcessWorkHoursMapper.deleteByExample(processWorkHoursExample);
		
		if (processDatas != null && processDatas.size() > 0){
			productTechnologyProcessWorkHoursMapper.insertList(processDatas);
		}
		
		
		ProProductTechnologyAccessoriesWorkHoursExample accessoriesWorkHoursExample = new ProProductTechnologyAccessoriesWorkHoursExample();
		accessoriesWorkHoursExample.createCriteria().andProProductTechnologyWorkHoursIdEqualTo(id);
		productTechnologyAccessoriesWorkHoursMapper.deleteByExample(accessoriesWorkHoursExample);
		
		if (standardAccessoriesDatas != null && standardAccessoriesDatas.size() > 0){
			productTechnologyAccessoriesWorkHoursMapper.insertList(standardAccessoriesDatas);
		}
		
		return i;
	}

	@Override
	public int deleteProductTechnologyWorkHoursById(String id) {
		//删除前先判断该项是否有关联项,有就直接跳回,没有就继续进行操作
		ProProductTechnologyAccessoriesWorkHoursExample accessoriesWorkHoursExample = new ProProductTechnologyAccessoriesWorkHoursExample();
		accessoriesWorkHoursExample.createCriteria().andProProductTechnologyAccessoriesWorkHoursIdEqualTo(id);
		List<ProProductTechnologyAccessoriesWorkHours> productTechnologyAccessoriesWorkHours = productTechnologyAccessoriesWorkHoursMapper.selectByExample(accessoriesWorkHoursExample);
		if (productTechnologyAccessoriesWorkHours.size()>0) {
			return 0;
		}
		accessoriesWorkHoursExample.clear();

		
		ProProductTechnologyProcessWorkHoursExample processWorkHoursExample = new ProProductTechnologyProcessWorkHoursExample();
		processWorkHoursExample.createCriteria().andProProductTechnologyWorkHoursIdEqualTo(id);
		productTechnologyProcessWorkHoursMapper.deleteByExample(processWorkHoursExample);
				
		accessoriesWorkHoursExample.createCriteria().andProProductTechnologyWorkHoursIdEqualTo(id);
		
		productTechnologyAccessoriesWorkHoursMapper.deleteByExample(accessoriesWorkHoursExample);
		return productTechnologyWorkHoursMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<ProCalculateProcessTimesCustom> getAllProcessToalTimes(String id) {
		List<ProCalculateProcessTimesCustom> processes = productTechnologyWorkHoursMapper.findAllProProcessListForCalculateProcessTimes();//获取所有的工序
		
		List<ProProductTechnologyProcessWorkHoursCustom> processDatas = getProcessDatas(id);
		
		//将相同的工序的时间累加起来
		if (processDatas != null && processDatas.size() > 0){
			for (ProProductTechnologyProcessWorkHoursCustom processData : processDatas) {
				for (ProCalculateProcessTimesCustom process : processes) {
					if (processData.getId().equals(process.getId())){
						process.setTotalTime(process.getTotalTime().add(processData.getTotalTime()));
						process.setTotalArtificialTime(process.getTotalArtificialTime().add(processData.getTotalArtificialTime()));
					}
				}
			}
		}
		
		List<ProCalculateProcessTimesCustom> list = new ArrayList<ProCalculateProcessTimesCustom>();
		for (ProCalculateProcessTimesCustom calculateProcessTimesCustom : processes) {
			if (calculateProcessTimesCustom.getTotalTime().compareTo(BigDecimal.ZERO) != 0){
				list.add(calculateProcessTimesCustom);
			}
		}
		return list;
	}
	


	@Override
	public ProProductTechnologyFlowChartCustom findProductTechnologyProcessFlowChartCustomByProProductTechlogyWorkHoursId(String id) {
		
		ProProductTechnologyFlowChartCustom flowChartCustom = new ProProductTechnologyFlowChartCustom();
		
		
		List<ProProductTechnologyFlowChartLinkDataArray> linkDataArray = productTechnologyFlowChartLinkDataArrayMapper.findProProductTechnologyFlowChartLinkDataArrayCustomByProProductTechlogyWorkHoursId(id);
		
		List<ProProductTechnologyFlowChartNodeDataArrayCustom> nodeDataArray = productTechnologyFlowChartNodeDataArrayMapper.findProProductTechnologyFlowChartNodeDataArrayCustomByProProductTechlogyWorkHoursId(id);
		
		flowChartCustom.setLinkDataArray(linkDataArray);
		flowChartCustom.setNodeDataArray(nodeDataArray);
		
		return flowChartCustom;
	}
	

	@Override
	public int saveTechnologyProcessFlowChart(HashMap<String, Object> map) {
		String proProductTechnologyWorkHoursId = map.get("proProductTechnologyWorkHoursId").toString();
		
		String startKey = "";
		String endKey = "";
		JSONArray nodeDataJsonArray = JSONArray.fromObject(map.get("nodeDataArray"));
		List<ProProductTechnologyFlowChartNodeDataArray> nodeDataArray = JSONArray.toList(nodeDataJsonArray, ProProductTechnologyFlowChartNodeDataArray.class);
		if (nodeDataArray.size() < 3){
			throw new RuntimeException("当前节点数少于三个，至少拥有一个开始节点、一个工序节点、一个结束节点");
		}
		for (ProProductTechnologyFlowChartNodeDataArray productTechnologyFlowChartNodeDataArray : nodeDataArray) {
			if (productTechnologyFlowChartNodeDataArray.getCategory().equals("Start")){
				startKey = productTechnologyFlowChartNodeDataArray.getKey();
			}else if (productTechnologyFlowChartNodeDataArray.getCategory().equals("End")){
				endKey = productTechnologyFlowChartNodeDataArray.getKey();
			}else {
				//如果为空或小于等于0，则要数据错误
				if (productTechnologyFlowChartNodeDataArray.getTotalTime() == null || productTechnologyFlowChartNodeDataArray.getTotalTime().compareTo(BigDecimal.ZERO) != 1){
					throw new RuntimeException("工序工时不能小于或等于0");
				}
			}
			productTechnologyFlowChartNodeDataArray.setId(UUIDBuild.getUUID());
			productTechnologyFlowChartNodeDataArray.setProProductTechnologyWorkHoursId(proProductTechnologyWorkHoursId);
		}
		
		if (!StringUtils.isNotBlank(startKey)){
			throw new RuntimeException("没有开始节点");
		}
		
		if (!StringUtils.isNotBlank(endKey)){
			throw new RuntimeException("没有结束节点");
		}
		
		
		List<ProProductTechnologyFlowChartLinkDataArray> linkDataArray = new ArrayList<ProProductTechnologyFlowChartLinkDataArray>();
		JSONArray linkDataJsonArray = JSONArray.fromObject(map.get("linkDataArray"));
		if (linkDataJsonArray.size() < 2){
			throw new RuntimeException("有节点没有连线");
		}
		
		for (int i = 0; i < linkDataJsonArray.size(); i++) {
			JSONObject jsonObject = linkDataJsonArray.getJSONObject(i);
			Object object = jsonObject.get("points");
			jsonObject.remove("points");
			ProProductTechnologyFlowChartLinkDataArray productTechnologyFlowChartLinkDataArray = (ProProductTechnologyFlowChartLinkDataArray) JSONObject.toBean(jsonObject, ProProductTechnologyFlowChartLinkDataArray.class);
			productTechnologyFlowChartLinkDataArray.setId(UUIDBuild.getUUID());
			productTechnologyFlowChartLinkDataArray.setPoints(object.toString());
			productTechnologyFlowChartLinkDataArray.setProProductTechnologyWorkHoursId(proProductTechnologyWorkHoursId);
			linkDataArray.add(productTechnologyFlowChartLinkDataArray);
		}
		
		Map<String, List<String>> key1 = new LinkedHashMap<String, List<String>>();//map的value是map的key的后面节点的集合
		Map<String, List<String>> key2 = new LinkedHashMap<String, List<String>>();//map的value是map的key的前面节点的集合
		
		//找到每个节点key前面的节点和后面的节点
		for (ProProductTechnologyFlowChartLinkDataArray productTechnologyFlowChartLinkDataArray : linkDataArray) {
			String fromKey = productTechnologyFlowChartLinkDataArray.getFrom();
			String toKey = productTechnologyFlowChartLinkDataArray.getTo();
			if (key1.containsKey(fromKey)){
				if(key1.get(fromKey).contains(toKey)){
					throw new RuntimeException("存在重复的连线");
				}
				if (key1.get(fromKey).contains(endKey) || toKey.equals(endKey)){
					throw new RuntimeException("同一节点后面连了其他节点和结束节点");
				}
				key1.get(fromKey).add(toKey);
			}else{
				List<String> list=  new ArrayList<String>();
				list.add(toKey);
				key1.put(fromKey, list);
			}
			
			
			if (key2.containsKey(toKey)){
				if (key2.get(toKey).contains(fromKey)){
					throw new RuntimeException("存在重复的连线");
				}
				key2.get(toKey).add(fromKey);
			}else{
				List<String> list = new ArrayList<String>();
				list.add(fromKey);
				key2.put(toKey, list);
			}
		}
		
		//校验连线
		for (int i = 0; i < nodeDataJsonArray.size(); i++) {
			String key = nodeDataJsonArray.getJSONObject(i).getString("key");
			
			if (key.equals(startKey)){
				if (!key1.containsKey(key)){
					throw new RuntimeException("开始节点后面没有连线");
				}
			}else if (key.equals(endKey)){
				if (!key2.containsKey(key)){
					throw new RuntimeException("没有节点连线到结束节点");
				}
			}else{
				String processName = nodeDataJsonArray.getJSONObject(i).getString("processName");
				String processCategory = nodeDataJsonArray.getJSONObject(i).getString("processCategory");
				
				if (!key1.containsKey(key)){
					throw new RuntimeException(processName + "->" + processCategory + "节点后面没有连线");
				}
				if (!key2.containsKey(key)){
					throw new RuntimeException("没有节点连线到" + processName + "->" + processCategory + "节点");
				}
			}
		}
		
		List<String> lineKeys = new ArrayList<String>();
		lineKeys.add(startKey);
		
		List<String> list = key1.get(startKey);
		
		checkGoJsData(list, lineKeys, key1, endKey, new ArrayList<List<String>>());
		
		//先删除旧的，新增和更新做到一起
		ProProductTechnologyFlowChartLinkDataArrayExample linkDataArrayExample = new ProProductTechnologyFlowChartLinkDataArrayExample();
		linkDataArrayExample.createCriteria().andProProductTechnologyWorkHoursIdEqualTo(proProductTechnologyWorkHoursId);
		productTechnologyFlowChartLinkDataArrayMapper.deleteByExample(linkDataArrayExample);
		
		ProProductTechnologyFlowChartNodeDataArrayExample nodeDataArrayExample = new ProProductTechnologyFlowChartNodeDataArrayExample();
		nodeDataArrayExample.createCriteria().andProProductTechnologyWorkHoursIdEqualTo(proProductTechnologyWorkHoursId);
		productTechnologyFlowChartNodeDataArrayMapper.deleteByExample(nodeDataArrayExample);
		
		int i = productTechnologyFlowChartLinkDataArrayMapper.insertList(linkDataArray);
		
		i += productTechnologyFlowChartNodeDataArrayMapper.insertList(nodeDataArray);
		
		//最后在生成图片，避免更新时覆盖了图片，但是存入数据库的时候报错，数据没更新，图片更新了问题
		String imgStr = map.get("image").toString();
		File fileDir = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/proProductTechnologyFlowChart");
		if (!fileDir.exists()){
        	fileDir.mkdirs();
        }
		String imagePath = new File(fileDir, proProductTechnologyWorkHoursId+".png").getPath();
		boolean b = Base64Util.GenerateImage(imgStr.split(",")[1], imagePath);
		if (!b){
			throw new RuntimeException("图片转换失败");
		}
		
		return i;
	}
	
	/**
	 * 遍历每条线路，每条线路不可能出现重复的key，出现重复的key会造成死循环，所以就是有回头的连线,
	 * 并且检查是否有重复的线路或者多余的线路
	 * @param list 下一节点的集合
	 * @param lineKeys 当前线路的集合
	 * @param key1 linkDataArray转成的map集合
	 * @param endKey 结束的key
	 * @param lists 存储所有线路的集合
	 */
	public void checkGoJsData(List<String> list, List<String> lineKeys, Map<String, List<String>> key1, String endKey, List<List<String>> lists){
		for (String key : list) {
			if (lineKeys.contains(key)){
				throw new RuntimeException("有回头的连线，请检查");
			}
			List<String> deepCopy = deepCopy(lineKeys);
			deepCopy.add(key);
			if (!key1.get(key).contains(endKey)){
				checkGoJsData(key1.get(key), deepCopy, key1, endKey, lists);
			}else{
				deepCopy.add(endKey);
				System.out.println(deepCopy.toString());//打印出每条线路
				for (List<String> l : lists) {
					if (l.containsAll(deepCopy)){
						throw new RuntimeException("有多余的连线或重复的连线");
					}
				}
				lists.add(deepCopy);
			}
		}
		
	}

	@Override
	public int updateAllProductTechnologyWorkHours() {
		int count = 0;
		//先按产品分类查询
		WarBaseDataExample baseDataExample = new WarBaseDataExample();
		baseDataExample.setOrderByClause("dictionarie_code");
		baseDataExample.createCriteria().andKeywordEqualTo("类型");
		List<WarBaseData> baseDatas = baseDataMapper.selectByExample(baseDataExample);
		//类型第一个是最底层的，不需要更新，从类型的第二个开始
		for (int i = 1; i < baseDatas.size(); i++) {
			//按类型查找配件的工艺工时
			WarStandardAccessoriesQueryVo standardAccessoriesQueryVo = new WarStandardAccessoriesQueryVo();
			standardAccessoriesQueryVo.setAccessoriesType(baseDatas.get(i).getDictionarieCode()+"");
			List<ProProductTechnologyWorkHoursCustom> productTechnologyWorkHoursCustoms = productTechnologyWorkHoursMapper.findAllProductTechnologyWorkHoursList(standardAccessoriesQueryVo);
			
			if (productTechnologyWorkHoursCustoms != null && productTechnologyWorkHoursCustoms.size() > 0){
				for (ProProductTechnologyWorkHoursCustom productTechnologyWorkHours : productTechnologyWorkHoursCustoms) {
					//查找该工艺工时下面的工序，重新计算工时
					BigDecimal processTotalTime = new BigDecimal(0);
					BigDecimal processTotalArtificialTime = new BigDecimal(0);
					List<ProProductTechnologyProcessWorkHoursCustom> processDatas = productTechnologyProcessWorkHoursMapper.findAllProProductTechnologyProcessWorkHoursListByProProductTechnologyWorkHoursId(productTechnologyWorkHours.getId());
					if (processDatas != null && processDatas.size() > 0){
						for (ProProductTechnologyProcessWorkHours productTechnologyProcessWorkHours : processDatas) {
							processTotalTime = processTotalTime.add(productTechnologyProcessWorkHours.getTotalTime());
							processTotalArtificialTime = processTotalArtificialTime.add(productTechnologyProcessWorkHours.getTotalArtificialTime());
						}
					}
					//查找该工艺工时下面的配件，重新计算工时
					BigDecimal standardAccessoriesTotalTime = new BigDecimal(0);
					BigDecimal standardAccessoriesTotalArtificialTime = new BigDecimal(0);
					List<ProProductTechnologyAccessoriesWorkHoursCustom> standardAccessoriesDatas = productTechnologyAccessoriesWorkHoursMapper.findAllProProductTechnologyAccessoriesWorkHoursListByProProductTechnologyWorkHoursId(productTechnologyWorkHours.getId());
					if (standardAccessoriesDatas != null && standardAccessoriesDatas.size() > 0){
						for (ProProductTechnologyAccessoriesWorkHoursCustom productTechnologyAccessoriesWorkHoursCustom : standardAccessoriesDatas) {
							standardAccessoriesTotalTime = standardAccessoriesTotalTime.add(productTechnologyAccessoriesWorkHoursCustom.getTotalTime().multiply(new BigDecimal(productTechnologyAccessoriesWorkHoursCustom.getEachNumber())));
							standardAccessoriesTotalArtificialTime = standardAccessoriesTotalArtificialTime.add(productTechnologyAccessoriesWorkHoursCustom.getTotalArtificialTime().multiply(new BigDecimal(productTechnologyAccessoriesWorkHoursCustom.getEachNumber())));
						}
					}
					
					
					BigDecimal totalTime = processTotalTime.multiply(productTechnologyWorkHours.getProcessCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP).add(standardAccessoriesTotalTime.multiply(productTechnologyWorkHours.getAccessoriesCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP));
					BigDecimal totalArtificialTime = processTotalArtificialTime.multiply(productTechnologyWorkHours.getProcessCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP).add(standardAccessoriesTotalArtificialTime.multiply(productTechnologyWorkHours.getAccessoriesCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP));
					
					productTechnologyWorkHours.setTotalTime(totalTime);
					productTechnologyWorkHours.setTotalArtificialTime(totalArtificialTime);
				}
				
				//批量更新
				count = count +productTechnologyWorkHoursMapper.updateList(productTechnologyWorkHoursCustoms);
			}
		}
		return count;
	}

	@Override
	public List<ProCalculateProcessTimesCustom> calculateProcessTimes(String id) {
		
		List<ProCalculateProcessTimesCustom> processes = productTechnologyWorkHoursMapper.findAllProProcessListForCalculateProcessTimes();//获取所有的工序
		
		List<ProProductTechnologyProcessWorkHoursCustom> processDatas = getProcessDatas(id);
		
		//将相同的工序的时间累加起来
		if (processDatas != null && processDatas.size() > 0){
			for (ProProductTechnologyProcessWorkHoursCustom processData : processDatas) {
				for (ProCalculateProcessTimesCustom process : processes) {
					if (processData.getId().equals(process.getId())){
						process.setTotalTime(process.getTotalTime().add(processData.getTotalTime()));
						process.setTotalArtificialTime(process.getTotalArtificialTime().add(processData.getTotalArtificialTime()));
					}
				}
			}
		}
		
		List<ProCalculateProcessTimesCustom> list = new ArrayList<ProCalculateProcessTimesCustom>();
		for (ProCalculateProcessTimesCustom process : processes) {
			if (process.getParentProcessNumber() == 0){
				getChildrenNode(processes, process);
				list.add(process);
			}
		}
		
		return list;
	}
	
	/**
	 * 获取产品工艺下面所有的工序的工时，递归
	 * @param id
	 * @return
	 */
	public List<ProProductTechnologyProcessWorkHoursCustom> getProcessDatas(String id){
		ProProductTechnologyWorkHours productTechnologyWorkHours = productTechnologyWorkHoursMapper.selectByPrimaryKey(id);
		
		List<ProProductTechnologyProcessWorkHoursCustom> list = productTechnologyProcessWorkHoursMapper.findAllProProductTechnologyProcessWorkHoursListByProProductTechnologyWorkHoursId(id);
		
		List<ProProductTechnologyProcessWorkHoursCustom> processDatas = deepCopy(list);//必须深度克隆，否则上面查询了同一个id的时候，不会重新查询数据库，而是直接从sqlSession中取，取出的也就是改过的数，所以会有问题
		
		for (ProProductTechnologyProcessWorkHoursCustom processData : processDatas) {
			processData.setTotalTime(processData.getTotalTime().multiply(productTechnologyWorkHours.getProcessCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP));
			processData.setTotalArtificialTime(processData.getTotalArtificialTime().multiply(productTechnologyWorkHours.getProcessCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP));
		}
		
		List<ProProductTechnologyAccessoriesWorkHoursCustom> standardAccessoriesDatas = productTechnologyAccessoriesWorkHoursMapper.findAllProProductTechnologyAccessoriesWorkHoursListByProProductTechnologyWorkHoursId(id);
		
		for (ProProductTechnologyAccessoriesWorkHoursCustom standardAccessoriesData : standardAccessoriesDatas) {//循环零部件，下面要开始递归
			
			List<ProProductTechnologyProcessWorkHoursCustom> processDatas2 = getProcessDatas(standardAccessoriesData.getProProductTechnologyWorkHoursId());
			
			for (ProProductTechnologyProcessWorkHoursCustom processData : processDatas2) {
				processData.setTotalTime(processData.getTotalTime().multiply(new BigDecimal(standardAccessoriesData.getEachNumber())));
				processData.setTotalTime(processData.getTotalTime().multiply(productTechnologyWorkHours.getProcessCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP));
				
				processData.setTotalArtificialTime(processData.getTotalArtificialTime().multiply(new BigDecimal(standardAccessoriesData.getEachNumber())));
				processData.setTotalArtificialTime(processData.getTotalArtificialTime().multiply(productTechnologyWorkHours.getProcessCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP));
			}
			processDatas.addAll(processDatas2);
		}
		return processDatas;
	}
	
	/**
	 * 从所有的工序list中，循环找到calculateProcessTimesCustom的子工序，setChildred进去，然后子工序也是如此，一直递归
	 * @param list 原数据
	 * @param calculateProcessTimesCustom 需要setChildren的父节点
	 * @return
	 */
	public void getChildrenNode(List<ProCalculateProcessTimesCustom> list, ProCalculateProcessTimesCustom calculateProcessTimesCustom){
		List<ProCalculateProcessTimesCustom> children = new ArrayList<ProCalculateProcessTimesCustom>();
		if (list != null && list.size() > 0){
			for (ProCalculateProcessTimesCustom custom : list) {
				if (custom.getParentProcessNumber().equals(calculateProcessTimesCustom.getProcessNumber())){//所有工序循环，如果找到工序的父编号跟当前要setChildren的工工序的编号相同，则需要在递归在去找它下面的工序，否则认为下面没有子工序，则不需要递归操作了
					getChildrenNode(list, custom);
					children.add(custom);
				}
			}
			if (children.size() > 0){
				BigDecimal totalTime = new BigDecimal(0);
				BigDecimal totalArtificialTime = new BigDecimal(0);
				for (ProCalculateProcessTimesCustom custom : children) {
					totalTime = totalTime.add(custom.getTotalTime());
					totalArtificialTime = totalArtificialTime.add(custom.getTotalArtificialTime());
				}
				calculateProcessTimesCustom.setChildren(children);
				calculateProcessTimesCustom.setTotalTime(totalTime);
				calculateProcessTimesCustom.setTotalArtificialTime(totalArtificialTime);
			}
		}
	}
	
	/**
	 * List的深度克隆，List的po的时候，addAll、 遍历add等等都是指向同一个地址
	 * @param src
	 * @return
	 */
	public static <T> List<T> deepCopy(List<T> src){  
	     try{
	    	 ByteArrayOutputStream byteOut = new ByteArrayOutputStream();    
	 	    ObjectOutputStream out = new ObjectOutputStream(byteOut);    
	 	    out.writeObject(src);    
	 	    
	 	    ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());    
	 	    ObjectInputStream in = new ObjectInputStream(byteIn);    
	 	    @SuppressWarnings("unchecked")    
	 	    List<T> dest = (List<T>) in.readObject();  
	 	    return dest;  
	     }catch (Exception e){
	    	 e.printStackTrace();
	     }
		return null;
	}

	@Override
	public List<List<String>> exportExcelById(String id, BigDecimal divisor) {
		ProProductTechnologyWorkHoursForExportExcelCustom productTechnologyWorkHoursForExportExcelCustom = getExcelData(id);//这里是对的
		
		calculateProcessTimes2(productTechnologyWorkHoursForExportExcelCustom);
		
		List<List<String>> calculateProcessTimes2 = getExelData2(productTechnologyWorkHoursForExportExcelCustom, divisor, "");
		return calculateProcessTimes2;
	}
	
	/**
	 * 根据产品工艺的id，导出工时，递归(查询的一级缓存问题，所以需要深度复制)
	 * @param id
	 * @return
	 */
	public ProProductTechnologyWorkHoursForExportExcelCustom getExcelData(String id){
		//获取当前需要导出的产品的相关信息
		ProProductTechnologyWorkHoursForExportExcelCustom productTechnologyWorkHoursForExportExcelCustom = (ProProductTechnologyWorkHoursForExportExcelCustom) productTechnologyWorkHoursMapper.findProductTechnologyWorkHoursByIdForExportExcel(id).deepClone();
		
		//每道工序所需要的工时，没有经过的工序，则为0
		List<ProCalculateProcessTimesForExportExcelCustom> processTimes = deepCopy(productTechnologyWorkHoursMapper.findProcessTimesByProProductTechnologyWorkHoursIdForExportExcel(id));
		
		//将产品下面的工序set进去，这里不包含零部件的工序
		productTechnologyWorkHoursForExportExcelCustom.setProcessTimes(processTimes);
		
		//查询下面的零部件
		ProProductTechnologyAccessoriesWorkHoursExample example = new ProProductTechnologyAccessoriesWorkHoursExample();
		example.createCriteria().andProProductTechnologyWorkHoursIdEqualTo(id);
		example.setOrderByClause("number");
		List<ProProductTechnologyAccessoriesWorkHours> list = productTechnologyAccessoriesWorkHoursMapper.selectByExample(example);//一级缓存问题
		
		List<ProProductTechnologyWorkHoursForExportExcelCustom> list2 = new ArrayList<ProProductTechnologyWorkHoursForExportExcelCustom>();
		
		if (list != null && list.size() > 0){
			for (ProProductTechnologyAccessoriesWorkHours productTechnologyAccessoriesWorkHours : list) {
				ProProductTechnologyWorkHoursForExportExcelCustom excelData = getExcelData(productTechnologyAccessoriesWorkHours.getProProductTechnologyAccessoriesWorkHoursId());
				excelData.setEachNumber(productTechnologyAccessoriesWorkHours.getEachNumber());
				list2.add(excelData);
			}
		}
		productTechnologyWorkHoursForExportExcelCustom.setProductTechnologyWorkHoursForExportExcelCustoms(list2);
		return productTechnologyWorkHoursForExportExcelCustom;
		
	}
	
	/**
	 * 将bean转成list集合，方便填充到Excel中
	 * @param custom
	 * @param divisor
	 * @param serialNumber
	 * @return
	 */
	public List<List<String>> getExelData2(ProProductTechnologyWorkHoursForExportExcelCustom custom, BigDecimal divisor, String serialNumber){
		List<List<String>> lists = new ArrayList<List<String>>();

		List<ProCalculateProcessTimesForExportExcelCustom> processTimes = custom.getProcessTimes();

		List<String> list = new ArrayList<String>();
		list.add(serialNumber);
		list.add(custom.getAccessoriesCode());
		list.add(custom.getAccessoriesName());
		list.add(custom.getSpecifications());
		list.add(custom.getDrawingNumber());
		list.add(custom.getEachNumber()+"");
		list.add(custom.getUnit());

		for (ProCalculateProcessTimesForExportExcelCustom calculateProcessTimesForExportExcelCustom : processTimes) {
			list.add(calculateProcessTimesForExportExcelCustom.getTotalTime().divide(divisor, 2, BigDecimal.ROUND_HALF_UP).toString());
		}

		lists.add(list);

		if (custom != null && custom.getProductTechnologyWorkHoursForExportExcelCustoms() != null && custom.getProductTechnologyWorkHoursForExportExcelCustoms().size() > 0){
			for (int i = 0; i < custom.getProductTechnologyWorkHoursForExportExcelCustoms().size(); i++) {
				lists.addAll(getExelData2(custom.getProductTechnologyWorkHoursForExportExcelCustoms().get(i), divisor, serialNumber == "" ? serialNumber + (i+1) : serialNumber + "." + (i+1)));
			}
		}
		return lists;
	}

    /**
     * 计算工时，递归
     */
    public void calculateProcessTimes2(ProProductTechnologyWorkHoursForExportExcelCustom custom){

        List<ProCalculateProcessTimesForExportExcelCustom> processTimes = custom.getProcessTimes();
        for (ProCalculateProcessTimesForExportExcelCustom calculateProcessTimesForExportExcelCustom : processTimes) {
            calculateProcessTimesForExportExcelCustom.setTotalTime(calculateProcessTimesForExportExcelCustom.getTotalTime().multiply(custom.getProcessCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP));
            calculateProcessTimesForExportExcelCustom.setTotalArtificialTime(calculateProcessTimesForExportExcelCustom.getTotalArtificialTime().multiply(custom.getProcessCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP));
        }

        //直接遍历零部件
        if (custom != null && custom.getProductTechnologyWorkHoursForExportExcelCustoms() != null && custom.getProductTechnologyWorkHoursForExportExcelCustoms().size() > 0){//说明有零部件，则遍历，当前的
            for (ProProductTechnologyWorkHoursForExportExcelCustom exportExcelCustom : custom.getProductTechnologyWorkHoursForExportExcelCustoms()) {//这里的肯定是产品下面的零部件，所以要乘以系数（数量在里面的bean直接计算了）
                calculateProcessTimes2(exportExcelCustom);
                for (int i = 0; i < processTimes.size(); i++) {
                    //累加
                    processTimes.get(i).setTotalTime(processTimes.get(i).getTotalTime().add(exportExcelCustom.getProcessTimes().get(i).getTotalTime().multiply(new BigDecimal(exportExcelCustom.getEachNumber())).multiply(custom.getAccessoriesCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP)));
                    processTimes.get(i).setTotalArtificialTime(processTimes.get(i).getTotalArtificialTime().add(exportExcelCustom.getProcessTimes().get(i).getTotalArtificialTime().multiply(new BigDecimal(exportExcelCustom.getEachNumber())).multiply(custom.getAccessoriesCoefficient()).setScale(2, BigDecimal.ROUND_HALF_UP)));
                }
            }

        }
    }


}
