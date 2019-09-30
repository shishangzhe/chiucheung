package cn.chiucheung.controller.production;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.production.producttechnologyflowchart.ProProductTechnologyFlowChartLinkDataArray;
import cn.chiucheung.po.production.standard.ProProcess;
import cn.chiucheung.po.warehouse.standardaccessories.WarStandardAccessoriesFile;
import cn.chiucheung.pojo.production.producttechnologyflowchart.ProProductTechnologyFlowChartCustom;
import cn.chiucheung.pojo.production.producttechnologyflowchart.ProProductTechnologyFlowChartNodeDataArrayCustom;
import cn.chiucheung.pojo.production.producttechnologyworkhours.ProCalculateProcessTimesCustom;
import cn.chiucheung.pojo.production.producttechnologyworkhours.ProProductTechnologyWorkHoursCustom;
import cn.chiucheung.pojo.production.standard.ProProcessQueryVo;
import cn.chiucheung.pojo.production.standard.ProProcessTreegridCustom;
import cn.chiucheung.pojo.production.standard.ProTechnologyBasicDataCustom;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesQueryVo;
import cn.chiucheung.service.production.ProcessService;
import cn.chiucheung.service.production.ProductTechnologyWorkHoursService;
import cn.chiucheung.service.production.TechnologyWorkHoursBasicDataService;
import cn.chiucheung.service.warehouse.StandardAccessoriesService;
import cn.chiucheung.utils.ResourcesUtil;

@Controller
@RequestMapping("/production/productTechnologyWorkHours")
public class ProductTechnologyWorkHoursAction {
	
	@Autowired
	TechnologyWorkHoursBasicDataService technologyWorkHoursBasicDataService;
	
	@Autowired
	StandardAccessoriesService standardAccessoriesService;
	
	@Autowired
	ProcessService processService;
	
	@Autowired
	ProductTechnologyWorkHoursService productTechnologyWorkHoursService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="ac",pid="aa")
	public String index(){
		return "production/productTechnologyWorkHours";
	}
	
	
	/**
	 * 查询所有的产品工艺工时
	 * @param standardAccessoriesQueryVo
	 * @return
	 */
	@RequestMapping(value="findAllProductTechnologyWorkHoursList")
	@ResponseBody
	@AnnotationLimit(mid="ac",pid="aa")
	public Map<String, Object> findAllProductTechnologyWorkHoursList(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProProductTechnologyWorkHoursCustom> rows = productTechnologyWorkHoursService.findAllProductTechnologyWorkHoursList(standardAccessoriesQueryVo);
		String total = productTechnologyWorkHoursService.findAllProductTechnologyWorkHoursTotal(standardAccessoriesQueryVo);
		map.put("rows", rows);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 根据产品工艺工时的id查询子节点加载的数据
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findAllProductTechnologyWorkHoursSubsidiaryListById")
	@ResponseBody
	@AnnotationLimit(mid="ac",pid="aa")
	public List<ProProductTechnologyWorkHoursCustom> findAllProductTechnologyWorkHoursSubsidiaryListById(String id){
		return productTechnologyWorkHoursService.findAllProductTechnologyWorkHoursSubsidiaryListById(id);
	}
	
	
	/**
	 * 根据产品工艺工时的关联的配件工艺工时查询子节点下加载的数据（子节点下的子节点加载的数据）
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findAllProductTechnologyWorkHoursSubsidiaryListByProProductTechnologyAccessoriesWorkHoursId")
	@ResponseBody
	@AnnotationLimit(mid="ac",pid="aa")
	public List<ProProductTechnologyWorkHoursCustom> findAllProductTechnologyWorkHoursSubsidiaryListByProProductTechnologyAccessoriesWorkHoursId(String proProductTechnologyWorkHoursId){
		return productTechnologyWorkHoursService.findAllProductTechnologyWorkHoursSubsidiaryListByProProductTechnologyAccessoriesWorkHoursId(proProductTechnologyWorkHoursId);
	}
	
	
	/**
	 * 根据条件查找关联或未关联工艺工时的标准配件
	 * @param standardAccessoriesQueryVo 查询条件
	 * @return
	 */
	@RequestMapping("findIsAssociatedWarStandardAccessoriesList")
	@ResponseBody
	@AnnotationLimit(mid="ac",pid="aa")
	public Map<String, Object> findIsAssociatedWarStandardAccessoriesList(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProProductTechnologyWorkHoursCustom> list = productTechnologyWorkHoursService.findAllWarStandardAccessoriesForIsAssociatedList(standardAccessoriesQueryVo);
		String total = productTechnologyWorkHoursService.findAllWarStandardAccessoriesForIsAssociatedTotal(standardAccessoriesQueryVo);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	
	/**
	 * 获取所有的生产工序表
	 * @return 
	 */
	@RequestMapping("findAllProProcessListForCombotreegrid")
	@ResponseBody
	@AnnotationLimit(mid="ac",pid="aa")
	public List<ProProcessTreegridCustom> findAllProProcessListForCombotreegrid(ProProcessQueryVo processQueryVo){
		return processService.findAllProProcessListForCombotreegrid(processQueryVo);
	}
	
	
	/**
	 * 根据工序id查找该工序的工序工艺，用于页面的计算
	 * @return 
	 */
	@RequestMapping("findProcessTechnologyByProcessId")
	@ResponseBody
	@AnnotationLimit(mid="ac",pid="aa")
	public Map<String, Object> findProcessTechnologyByProcessId(String processId, String calculationMethod){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			ProProcess process = processService.findProProcessById(processId);
			List<ProTechnologyBasicDataCustom> datas = technologyWorkHoursBasicDataService.findProcessTechnologyByProcessId(processId, calculationMethod);
			map.put("success", true);
			map.put("datas", datas);
			map.put("process", process);
			if (StringUtils.isNotBlank(calculationMethod)){//计算的修改回显
				map.put("calculationFormulaIsChange", !calculationMethod.split("&#10;")[1].equals(process.getCalculationFormula()));//存储公式是否有变更,变更存true，没有变更存false
				map.put("oldCalculationFormu", calculationMethod.split("&#10;")[1]);
			}else{//第一次计算
				map.put("calculationFormulaIsChange", false);//存储公式是否有变更,变更存true，没有变更存false
				map.put("oldCalculationFormu", "");
			}
		}catch (Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}
	
	
	/**
	 * 查看物料的附件
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("readFileById")
	@ResponseBody
	@AnnotationLimit(mid="ac",pid="aa")
	public String readFileById(String id, HttpServletRequest request, HttpServletResponse response){
		WarStandardAccessoriesFile standardAccessoriesFile = standardAccessoriesService.findfindWarStandardAccessoriesFileById(id);
		File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/warStandardAccessories",standardAccessoriesFile.getFilePath());
		
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = inputStream.read(b)) != -1) {
				response.getOutputStream().write(b, 0, i);
			}
		} catch (FileNotFoundException e) {
			try {
				response.getWriter().write("file not found");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if (inputStream != null){
					inputStream.close();
				}
			}catch (IOException e){
				e.printStackTrace();
			}finally{
				inputStream = null;
			}
		}
		return null;
	}
	
	
	/**
	 * 保存产品工艺工时
	 * @param productTechnologyWorkHoursCustom
	 * @return
	 */
	@RequestMapping(value="saveProductTechnologyWorkHours")
	@ResponseBody
	@AnnotationLimit(mid="aca",pid="ac")
	public JSONObject saveProductTechnologyWorkHours(@RequestBody HashMap<String, Object> map){
		JSONObject jsonObject = new JSONObject();
		
		try{
			productTechnologyWorkHoursService.saveProductTechnologyWorkHours(map);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	
	/**
	 * 根据产品工艺工时id 查找产品工艺工时，用于页面修改
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findProductTechnologyWorkHoursById")
	@ResponseBody
	@AnnotationLimit(mid="acb",pid="ac")
	public Map<String, Object> findProductTechnologyWorkHoursById(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			Map<String, Object> datas = productTechnologyWorkHoursService.findProductTechnologyWorkHoursById(id);
			map.put("success", true);
			map.put("datas", datas);
		}catch (Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}
	
	/**
	 * 更新产品工艺工时
	 * @param map
	 * @return
	 */
	@RequestMapping(value="updateProductTechnologyWorkHours")
	@ResponseBody
	@AnnotationLimit(mid="acb",pid="ac")
	public JSONObject updateProductTechnologyWorkHours(@RequestBody HashMap<String, Object> map){
		JSONObject jsonObject = new JSONObject();
		
		try{
			productTechnologyWorkHoursService.updateProductTechnologyWorkHours(map);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	
	/**
	 * 根据id删除产品工艺工时
	 * @param id
	 * @return
	 */
	@RequestMapping(value="deleteProductTechnologyWorkHoursById")
	@ResponseBody
	@AnnotationLimit(mid="acc",pid="ac")
	public JSONObject deleteProductTechnologyWorkHoursById(String id){
		JSONObject jsonObject = new JSONObject();
		int i = 0;
		
		try{
			i = productTechnologyWorkHoursService.deleteProductTechnologyWorkHoursById(id);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e);
		}
		if (i>0) {
			jsonObject.accumulate("success", true);
		}else {
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", "该数据存在关联关系,请先删除关联项");
		}
		
		return jsonObject;
	}
	
	/**
	 * 设置工艺图形
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("technologyProcessFlowChart")
	@AnnotationLimit(mid="acd",pid="ac")
	public String technologyProcessFlowChart(String id, HttpServletRequest request){
		request.setAttribute("id", id);
		return "production/technologicalProcess";
	}
	
	/**
	 * 设置工艺图形的工序工时查询
	 * @param id
	 * @return
	 */
	@RequestMapping(value="getAllProcessToalTimes")
	@ResponseBody
	@AnnotationLimit(mid="acd",pid="ac")
	public JSONObject getAllProcessToalTimes(String id){
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		boolean start = true;//是否需要开始节点，默认需要
		boolean end = true;//是否需要结束几点，默认需要
		JSONArray nodeDataArrayJsonArray = new JSONArray();
		JSONArray linkDataArrayJsonArray = new JSONArray();
		JSONArray originalJsonArray = new JSONArray();
		try{
			List<ProCalculateProcessTimesCustom> processDatas = productTechnologyWorkHoursService.getAllProcessToalTimes(id);
			ProProductTechnologyFlowChartCustom flowChartCustom = productTechnologyWorkHoursService.findProductTechnologyProcessFlowChartCustomByProProductTechlogyWorkHoursId(id);
			Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();//把所有的工序工时按工序id统计起来
			if (flowChartCustom.getNodeDataArray() != null && flowChartCustom.getNodeDataArray().size() > 0){
				for (ProProductTechnologyFlowChartNodeDataArrayCustom nodeDataArray : flowChartCustom.getNodeDataArray()) {
					JSONObject object = new JSONObject();
					object.accumulate("category", nodeDataArray.getCategory());
					object.accumulate("key", nodeDataArray.getKey());
					object.accumulate("loc", nodeDataArray.getLoc());
					if (!nodeDataArray.getCategory().equals("Start") && !nodeDataArray.getCategory().equals("End")){
						if (map.containsKey(nodeDataArray.getProProcessId())){
							map.put(nodeDataArray.getProProcessId(), map.get(nodeDataArray.getProProcessId()).add(nodeDataArray.getTotalTime()));
						}else{
							map.put(nodeDataArray.getProProcessId(), nodeDataArray.getTotalTime());
						}
						object.accumulate("processCategory", nodeDataArray.getProcessCategory());
						object.accumulate("proProcessId", nodeDataArray.getProProcessId());
						object.accumulate("processName", nodeDataArray.getProcessName());
						object.accumulate("totalTime", nodeDataArray.getTotalTime());
					}else{
						object.accumulate("text", nodeDataArray.getCategory().equals("Start") ? "开始":"结束");
						if (nodeDataArray.getCategory().equals("Start")){
							start = false;
						}else if (nodeDataArray.getCategory().equals("End")){
							end = false;
						}
					}
					nodeDataArrayJsonArray.add(object);
				}
			}
			if (flowChartCustom.getLinkDataArray() != null && flowChartCustom.getLinkDataArray().size() > 0){
				for (ProProductTechnologyFlowChartLinkDataArray linkDataArray : flowChartCustom.getLinkDataArray()){
					JSONObject object = new JSONObject();
					object.accumulate("from", linkDataArray.getFrom());
					object.accumulate("to", linkDataArray.getTo());
					object.accumulate("fromPort", linkDataArray.getFromPort());
					object.accumulate("toPort", linkDataArray.getToPort());
					object.accumulate("points", linkDataArray.getPoints());
					linkDataArrayJsonArray.add(object);
				}
			}
			if (start){
				JSONObject obejct = new JSONObject();
				obejct.accumulate("category", "Start");
				obejct.accumulate("text", "开始");
				jsonArray.add(obejct);
			}
			for (ProCalculateProcessTimesCustom calculateProcessTimesCustom : processDatas) {
				JSONObject obejct = new JSONObject();
				if (map.containsKey(calculateProcessTimesCustom.getId())){
					if (calculateProcessTimesCustom.getTotalTime().subtract(map.get(calculateProcessTimesCustom.getId())).compareTo(BigDecimal.ZERO) != 0){
						obejct.accumulate("category", "process");
						obejct.accumulate("processName", calculateProcessTimesCustom.getProcessName());
						obejct.accumulate("processCategory", calculateProcessTimesCustom.getProcessCategory());
						obejct.accumulate("proProcessId", calculateProcessTimesCustom.getId());
						obejct.accumulate("totalTime", calculateProcessTimesCustom.getTotalTime().subtract(map.get(calculateProcessTimesCustom.getId())));
						jsonArray.add(obejct);
					}
					map.remove(calculateProcessTimesCustom.getId());
				}else{
					obejct.accumulate("category", "process");
					obejct.accumulate("processName", calculateProcessTimesCustom.getProcessName());
					obejct.accumulate("processCategory", calculateProcessTimesCustom.getProcessCategory());
					obejct.accumulate("proProcessId", calculateProcessTimesCustom.getId());
					obejct.accumulate("totalTime", calculateProcessTimesCustom.getTotalTime());
					jsonArray.add(obejct);
				}
			}
			for (ProCalculateProcessTimesCustom calculateProcessTimesCustom : processDatas) {
				JSONObject obejct = new JSONObject();
				obejct.accumulate("category", "process");
				obejct.accumulate("processName", calculateProcessTimesCustom.getProcessName());
				obejct.accumulate("processCategory", calculateProcessTimesCustom.getProcessCategory());
				obejct.accumulate("proProcessId", calculateProcessTimesCustom.getId());
				obejct.accumulate("totalTime", calculateProcessTimesCustom.getTotalTime());
				originalJsonArray.add(obejct);
			}
			if (map.size() > 0){
				for (Entry<String, BigDecimal> entry : map.entrySet()){
					for (ProProductTechnologyFlowChartNodeDataArrayCustom nodeDataArray : flowChartCustom.getNodeDataArray()) {
						if (!nodeDataArray.getCategory().equals("Start") && !nodeDataArray.getCategory().equals("End")){
							if (nodeDataArray.getProProcessId().equals(entry.getKey())){
								JSONObject obejct = new JSONObject();
								obejct.accumulate("category", "process");
								obejct.accumulate("processName", nodeDataArray.getProcessName());
								obejct.accumulate("processCategory", nodeDataArray.getProcessCategory());
								obejct.accumulate("proProcessId", nodeDataArray.getProProcessId());
								obejct.accumulate("totalTime", new BigDecimal("-" + entry.getValue().toString()));
								jsonArray.add(obejct);
								break;
							}
						}
					}
				}
			}
			if (end){
				JSONObject obejct = new JSONObject();
				obejct.accumulate("category", "End");
				obejct.accumulate("text", "结束");
				jsonArray.add(obejct);
			}
			jsonObject.accumulate("success", true);
			jsonObject.accumulate("original", originalJsonArray);
			jsonObject.accumulate("data", jsonArray);
			jsonObject.accumulate("nodeDataArray", nodeDataArrayJsonArray);
			jsonObject.accumulate("linkDataArray", linkDataArrayJsonArray);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 保存工艺图形
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("saveTechnologyProcessFlowChart")
	@ResponseBody
	@AnnotationLimit(mid="acd",pid="ac")
	public JSONObject saveTechnologyProcessFlowChart(@RequestBody HashMap<String, Object> map, HttpServletRequest request){
		JSONObject jsonObject = new JSONObject();
		try{
			productTechnologyWorkHoursService.saveTechnologyProcessFlowChart(map);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 查看工艺图形
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("readProductTechnologyProcessFlowChartImageById")
	@ResponseBody
	@AnnotationLimit(mid="ac",pid="aa")
	public String readProductTechnologyProcessFlowChartImageById(HttpServletRequest request, HttpServletResponse response, String id){
		File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/proProductTechnologyFlowChart", id+".png");
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = inputStream.read(b)) != -1) {
				response.getOutputStream().write(b, 0, i);
			}
		} catch (Exception e) {
			if (!e.toString().split(":")[0].equals("ClientAbortException")){//当用户取消时候，e.toString()= "ClientAbortException:  java.io.IOException"
				//e.printStackTrace();
			}
		}finally{
			try{
				if (inputStream != null){
					inputStream.close();
				}
			}catch (IOException e){
				e.printStackTrace();
			}finally{
				inputStream = null;
			}
		}
		return null;
	}
	
	
	
	
	/**
	 * 更新所有的产品工艺工时
	 * @param 
	 * @return
	 */
	@RequestMapping(value="updateAllProductTechnologyWorkHours")
	@ResponseBody
	@AnnotationLimit(mid="acb",pid="ac")
	public JSONObject updateAllProductTechnologyWorkHours(){
		JSONObject jsonObject = new JSONObject();
		
		try{
			int i = productTechnologyWorkHoursService.updateAllProductTechnologyWorkHours();
			jsonObject.accumulate("success", true);
			jsonObject.accumulate("message", "共更新了" + i + "条数据");
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	
	
	/**
	 * 按工序计算该产品的所有工时
	 * @param 
	 * @return
	 */
	@RequestMapping(value="calculateProcessTimes")
	@ResponseBody
	@AnnotationLimit(mid="ace",pid="ac")
	public JSONObject calculateProcessTimes(String id){
		JSONObject jsonObject = new JSONObject();
		
		try{
			List<ProCalculateProcessTimesCustom> list = productTechnologyWorkHoursService.calculateProcessTimes(id);
			jsonObject.accumulate("success", true);
			jsonObject.accumulate("datas", list);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	
	@RequestMapping(value="exportExcelById")
	@AnnotationLimit(mid="acf",pid="ac")
	public String exportExcelById(HttpServletRequest request, HttpServletResponse response, String id, BigDecimal divisor){
		try {
			File file = new File(request.getSession().getServletContext().getRealPath("WEB-INF"),"template/产品工艺工时.xls");
			List<List<String>> lists = productTechnologyWorkHoursService.exportExcelById(id, divisor);
			
			
			String filename = lists.get(0).get(2)+"工艺工时" + new Date().toLocaleString()+".xls";
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
			
			POIFSFileSystem pfs = new POIFSFileSystem(new FileInputStream(file));
			//得到文档对象
			HSSFWorkbook wb = new HSSFWorkbook(pfs);
			//得到第一个表单
			HSSFSheet sheet = wb.getSheetAt(0);
			
			sheet.getRow(0).getCell(4).setCellValue(lists.get(0).get(2));
			
			HSSFRow sourceRow = sheet.getRow(7);
			if (lists != null && lists.size() > 0){
				for (int i = 0; i<lists.size(); i++) {
					if (i == 0){
						for (int j = 0; j < lists.get(i).size(); j++) {
							if (j<7){
								sourceRow.getCell(j).setCellValue(lists.get(i).get(j));
							}else{
								sourceRow.getCell(j+4).setCellValue(Double.parseDouble(lists.get(i).get(j)));
							}
						}
					}else{
						//HSSFRow targetRow = sheet.createRow(7+i+1);
						/*sheet.shiftRows(7+i, sheet.getLastRowNum(), 1,true,false);*/
						HSSFRow targetRow = sheet.createRow(7+i);
						for (int j=0;j<sourceRow.getPhysicalNumberOfCells();j++){
							HSSFCell sourceCell = sourceRow.getCell(j);
							HSSFCell cell = targetRow.createCell(j);
							cell.setCellStyle(sourceCell.getCellStyle());
						}
						for (int j = 0; j < lists.get(i).size(); j++) {
							if (j<7){
								targetRow.getCell(j).setCellValue(lists.get(i).get(j));
							}else{
								targetRow.getCell(j+4).setCellValue(Double.parseDouble(lists.get(i).get(j)));
							}
						}
					}
				}
			}
			
			
		
			wb.write(response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
			try {
				//response.setContentType("text/xml; charset=UTF-8");
				//response.setCharacterEncoding("UTF-8");
				StringBuffer sb = new StringBuffer();
		        sb.append("<script language='javascript'>alert('");
		        sb.append(e.getMessage());
		        sb.append("！');window.opener.reload();window.opener='';window.open('','_self');window.close();</script>");//该方法刷新父页面的数据,并关闭当前窗口,后面return null;
				response.getOutputStream().write(sb.toString().getBytes());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}
}
