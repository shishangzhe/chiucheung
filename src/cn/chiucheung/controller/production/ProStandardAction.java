package cn.chiucheung.controller.production;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.production.standard.ProProcess;
import cn.chiucheung.po.production.standard.ProTechnologyBasicData;
import cn.chiucheung.po.production.standard.ProTechnologyWorkHoursBasicData;
import cn.chiucheung.pojo.production.standard.ProProcessQueryVo;
import cn.chiucheung.pojo.production.standard.ProProcessTechnologyCustom;
import cn.chiucheung.service.production.ProcessService;
import cn.chiucheung.service.production.TechnologyWorkHoursBasicDataService;

@Controller
@RequestMapping("/production/standard")
public class ProStandardAction {
	
	@Autowired 
	ProcessService processService;
	
	@Autowired
	TechnologyWorkHoursBasicDataService technologyWorkHoursBasicDataService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="ab",pid="aa")
	public String index(){
		return "production/standard";
	}
	
	/**
	 * 获取所有的生产工序表
	 * @return 
	 */
	@RequestMapping("findAllProProcessTechnologyList")
	@ResponseBody
	@AnnotationLimit(mid="ab",pid="aa")
	public List<ProProcessTechnologyCustom> findAllProProcessTechnologyList(ProProcessQueryVo processQueryVo){
		return technologyWorkHoursBasicDataService.findAllProProcessTechnologyList(processQueryVo);
	}
	
	/**
	 * 获取所有的生产工序表（用于treegrid的展开）
	 * @return 
	 */
	@RequestMapping("findAllProProcessTechnologySubsidiaryListByProcessIdOrTechnologyBasicDataId")
	@ResponseBody
	@AnnotationLimit(mid="ab",pid="aa")
	public List<ProProcessTechnologyCustom> findAllProProcessTechnologySubsidiaryListByProcessIdOrTechnologyBasicDataId(String proProcessId){
		return technologyWorkHoursBasicDataService.findAllProProcessTechnologySubsidiaryListByProcessIdOrTechnologyBasicDataId(proProcessId);
	}
	
	/**
	 * 获取所有的生产工序表
	 * @return 
	 */
	@RequestMapping("findAllProProcessList")
	@ResponseBody
	@AnnotationLimit(mid="ab",pid="aa")
	public List<ProProcess> findAllProProcessList(ProProcessQueryVo processQueryVo){
		return processService.findAllProProcessList(processQueryVo);
	}

	/**
	 * 新增生产工序
	 * @param ProProcess 新增的生产工序
	 * @return 返回提示信息
	 */
	@RequestMapping(value="saveProProcess")
	@ResponseBody
	@AnnotationLimit(mid="aba",pid="ab")
	public JSONObject saveProProcess(ProProcess process){
		JSONObject jsonObject = new JSONObject();
		try{
			processService.saveProProcess(process);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}	
	
	/**
	 * 根据ID查询生产工序 
	 * @param id 查询的条件，ProProcess的主键
	 * @return 返回查找到的生产工序的json
	 */
	@RequestMapping("findProProcessById")
	@ResponseBody
	@AnnotationLimit(mid="ab",pid="aa")
	public Map<String, Object> findProProcessById(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			ProProcess process = processService.findProProcessById(id);
			map.put("success", true);
			map.put("data", process);
		}catch (Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}	
	
	/**
	 * 修改生产工序
	 * @param process 修改的生产工序
	 * @return 返回提示信息
	 */
	@RequestMapping(value="updateProProcess")
	@ResponseBody
	@AnnotationLimit(mid="abb",pid="ab")
	public JSONObject updateProProcess(ProProcess process){
		JSONObject jsonObject = new JSONObject();
		try{
			processService.updateProProcess(process);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
		
	
	/**
	 * 删除生产工序
	 * @param id 要删除的生产工序
	 * @return 返回提示信息
	 */
	@RequestMapping(value="deleteProProcessById")
	@ResponseBody
	@AnnotationLimit(mid="abc",pid="ab")
	public JSONObject deleteProProcessById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			processService.deleteProProcessById(id);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 新增工序工艺
	 * @param technologyBasicData
	 * @return
	 */
	@RequestMapping("saveTechnology")
	@ResponseBody
	@AnnotationLimit(mid="aba",pid="ab")
	public JSONObject saveTechnology(ProTechnologyBasicData technologyBasicData){
		JSONObject jsonObject = new JSONObject();
		try{
			technologyWorkHoursBasicDataService.saveTechnology(technologyBasicData);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 根据ID查询工艺 
	 * @param id
	 * @return 返回查找到的工艺的json
	 */
	@RequestMapping("findTechnologyById")
	@ResponseBody
	@AnnotationLimit(mid="ab",pid="aa")
	public Map<String, Object> findTechnologyById(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			ProProcessTechnologyCustom processTechnologyCustom = technologyWorkHoursBasicDataService.findTechnologyById(id);
			map.put("success", true);
			map.put("data", processTechnologyCustom);
		}catch (Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}
	
	
	/**
	 * 修改工艺
	 * @param technologyBasicData 修改的工艺
	 * @return 返回提示信息
	 */
	@RequestMapping(value="updateTechnology")
	@ResponseBody
	@AnnotationLimit(mid="abb",pid="ab")
	public JSONObject updateTechnology(ProTechnologyBasicData technologyBasicData){
		JSONObject jsonObject = new JSONObject();
		try{
			technologyWorkHoursBasicDataService.updateTechnology(technologyBasicData);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	
	/**
	 * 删除工艺
	 * @param id
	 * @return 
	 */
	@RequestMapping(value="deleteTechnologyById")
	@ResponseBody
	@AnnotationLimit(mid="abc",pid="ab")
	public JSONObject deleteTechnologyById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			technologyWorkHoursBasicDataService.deleteTechnologyById(id);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	
	
	
	
	
	/**
	 * 根据工序id查找工艺 
	 * @param id
	 * @return 返回查找到的工艺的json
	 */
	@RequestMapping("findTechnologyListByProProcessId")
	@ResponseBody
	@AnnotationLimit(mid="ab",pid="aa")
	public List<ProTechnologyBasicData> findTechnologyListByProProcessId(String id){
		return technologyWorkHoursBasicDataService.findTechnologyListByProProcessId(id);
	}
	
	/**
	 * 新增工序工艺工时
	 * @param technologyWorkHoursBasicData
	 * @return
	 */
	@RequestMapping("saveTechnologyWorkHours")
	@ResponseBody
	@AnnotationLimit(mid="aba",pid="ab")
	public JSONObject saveTechnologyWorkHours(ProTechnologyWorkHoursBasicData technologyWorkHoursBasicData){
		JSONObject jsonObject = new JSONObject();
		try{
			technologyWorkHoursBasicDataService.saveTechnologyWorkHours(technologyWorkHoursBasicData);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 根据ID查询工艺 工时
	 * @param id
	 * @return 返回查找到的工艺的json
	 */
	@RequestMapping("findTechnologyWorkHoursById")
	@ResponseBody
	@AnnotationLimit(mid="ab",pid="aa")
	public Map<String, Object> findTechnologyWorkHoursById(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			ProProcessTechnologyCustom processTechnologyCustom = technologyWorkHoursBasicDataService.findTechnologyWorkHoursById(id);
			map.put("success", true);
			map.put("data", processTechnologyCustom);
		}catch (Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}
	
	
	/**
	 * 修改工艺
	 * @param technologyBasicData 修改的工艺
	 * @return 返回提示信息
	 */
	@RequestMapping(value="updateTechnologyWorkHours")
	@ResponseBody
	@AnnotationLimit(mid="abb",pid="ab")
	public JSONObject updateTechnologyWorkHours(ProTechnologyWorkHoursBasicData technologyWorkHoursBasicData){
		JSONObject jsonObject = new JSONObject();
		try{
			technologyWorkHoursBasicDataService.updateTechnologyWorkHours(technologyWorkHoursBasicData);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	
	/**
	 * 删除工艺
	 * @param id
	 * @return 
	 */
	@RequestMapping(value="deleteTechnologyWorkHoursById")
	@ResponseBody
	@AnnotationLimit(mid="abc",pid="ab")
	public JSONObject deleteTechnologyWorkHoursById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			technologyWorkHoursBasicDataService.deleteTechnologyWorkHoursById(id);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
}
