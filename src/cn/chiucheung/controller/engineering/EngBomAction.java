package cn.chiucheung.controller.engineering;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.engineering.bom.EngBom;
import cn.chiucheung.po.engineering.bom.EngBomSubsidiary;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.po.warehouse.material.WarMaterial;
import cn.chiucheung.po.warehouse.material.WarMaterialFile;
import cn.chiucheung.pojo.engineering.bom.EngBomQueryVo;
import cn.chiucheung.pojo.engineering.bom.SalWorkCardItemCustomForEngBom;
import cn.chiucheung.pojo.engineering.standardBom.EngStandardBomCustom;
import cn.chiucheung.pojo.sales.reviewer.TaskCustom;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import cn.chiucheung.service.engineering.BomService;
import cn.chiucheung.service.engineering.StandardBomService;
import cn.chiucheung.service.warehouse.MaterialService;
import cn.chiucheung.utils.ResourcesUtil;


@Controller
@RequestMapping("/engineering/bom")
public class EngBomAction {
	
	@Autowired
	BomService bomService;
	
	@Autowired
	StandardBomService standardBomService;
	
	@Autowired
	MaterialService  materialService;
	
	@Autowired
	RepositoryService repositoryService;
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	HistoryService historyService;
	
	@RequestMapping("index")
	@AnnotationLimit(pid="cc",mid="cg")
	public String index(){
		return "engineering/bom";
	}
	
	/**
	 * 查找所有的bom
	 * @param bomQueryVo 查询条件
	 * @return
	 */
	@RequestMapping("findAllBomList")
	@ResponseBody
	@AnnotationLimit(pid="cc",mid="cg")
	public Map<String, Object> findAllBomList(EngBomQueryVo bomQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<EngBom> rows = bomService.findAllBomList(bomQueryVo);
		String total = bomService.findAllBomTotal(bomQueryVo);
		map.put("rows", rows);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 根据bom的id查找子节点加载的数据
	 * @param id
	 * @return
	 */
	@RequestMapping("findAllBomSubsidiaryListByEngBomId")
	@ResponseBody
	@AnnotationLimit(pid="cc",mid="cg")
	public List<EngBomSubsidiary> findAllBomSubsidiaryListByEngBomId(String id){
		return bomService.findAllBomSubsidiaryListByEngBomId(id);
	}
	
	/**
	 * 查询工咭项次，用于页面选择
	 * @return
	 */
	@RequestMapping("findAllWorkCardSubsidiaryList")
	@ResponseBody
	@AnnotationLimit(pid="cc",mid="cg")
	public Map<String, Object> findAllWorkCardSubsidiaryList(EngBomQueryVo bomQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<SalWorkCardItemCustomForEngBom> rows = bomService.findAllWorkCardSubsidiaryList(bomQueryVo);
		String total = bomService.findAllWorkCardSubsidiaryTotal(bomQueryVo);
		map.put("rows", rows);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 保存bom
	 * @param map
	 * @return
	 */
	@RequestMapping("saveEngBom")
	@ResponseBody
	@AnnotationLimit(pid="cg",mid="cga")
	public JSONObject saveEngBom(@RequestBody Map<String, Object> map){
		JSONObject jsonObject = new JSONObject();
		try{
			bomService.saveEngBom(map);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 根据id查找bom，用于页面修改
	 * @param id
	 * @return
	 */
	@RequestMapping("findEngBomByIdForEdit")
	@ResponseBody
	@AnnotationLimit(pid="cg",mid="cgb")
	public Map<String, Object> findEngBomByIdForEdit(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			Map<String, Object> datas = bomService.findEngBomByIdForEdit(id, session);
			
			map.put("datas", datas);
			map.put("success", true);
		}catch (Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	/**
	 * 根据id查找bom，用于页面修改
	 * @param id
	 * @return
	 */
	@RequestMapping("findEngBomByIdForView")
	@ResponseBody
	@AnnotationLimit(pid="cc",mid="cg")
	public Map<String, Object> findEngBomByIdForView(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			Map<String, Object> datas = bomService.findEngBomByIdForView(id);
			
			map.put("datas", datas);
			map.put("success", true);
		}catch (Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	/**
	 * 根据id查找bom，用于页面复制
	 * @param id
	 * @return
	 */
	@RequestMapping("findEngBomByIdForCopy")
	@ResponseBody
	@AnnotationLimit(pid="cg",mid="cga")
	public Map<String, Object> findEngBomByIdForCopy(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			Map<String, Object> datas = bomService.findEngBomByIdForCopy(id);
			map.put("datas", datas);
			map.put("success", true);
		}catch (Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	/**
	 * 更新bom
	 * @param map
	 * @return
	 */
	@RequestMapping("updateEngBom")
	@ResponseBody
	@AnnotationLimit(pid="cg",mid="cgb")
	public JSONObject updateEngBom(@RequestBody Map<String, Object> map, HttpSession session){
		JSONObject jsonObject = new JSONObject();
		try{
			bomService.updateEngBom(map, session);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 删除bom
	 * @param map
	 * @return
	 */
	@RequestMapping("deleteEngBomById")
	@ResponseBody
	@AnnotationLimit(pid="cg",mid="cgc")
	public JSONObject deleteEngBomById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			bomService.deleteEngBomById(id);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 根据工咭号和项次查询最大的次数
	 * @param workCardNo
	 * @param workCardItem
	 * @return
	 */
	@RequestMapping("getMaxNumberOfTimes")
	@ResponseBody
	@AnnotationLimit(pid="cg",mid="cga")
	public JSONObject getMaxNumberOfTimes(String salWorkCardSubsidiaryId){
		JSONObject jsonObject = new JSONObject();
		try{
			int maxNumberOfTimes = bomService.getMaxNumberOfTimes(salWorkCardSubsidiaryId);
			jsonObject.accumulate("success", true);
			jsonObject.accumulate("maxNumberOfTimes", maxNumberOfTimes);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	
	/**
	 * 根据条件查找所有的标准配件
	 * @param standardAccessoriesQueryVo 查询条件
	 * @return
	 */
	@RequestMapping("findWarMaterialByMaterialCode")
	@ResponseBody
	@AnnotationLimit(pid="cc",mid="cg")
	public Map<String, Object> findWarMaterialByMaterialCode(String materialCode){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			if (StringUtils.isNotBlank(materialCode)){
				List<EngStandardBomCustom> list = standardBomService.findWarMaterialByMaterialCode(materialCode);
				if (list != null && list.size() > 0){
					map.put("success", true);
					map.put("bomSubsidiary", list.get(0));
				}else{
					map.put("success", false);
					map.put("message", "没有找到物料");
				}
			}else{
				map.put("success", false);
				map.put("message", "没有找到物料");
			}
		}catch (Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}
	
	
	/**
	 * 查找所有的物料
	 * @param materialQueryVo 查询条件
	 * @return
	 */
	@RequestMapping("findAllWarMaterialList")
	@ResponseBody
	@AnnotationLimit(pid="cc",mid="cg")
	public Map<String, Object> findAllWarMaterialList(WarMaterialQueryVo materialQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(materialQueryVo.getIsQuery());
		String total = materialService.findAllWarMaterialTotal(materialQueryVo);
		List<WarMaterial> list = materialService.findAllWarMaterialList(materialQueryVo);
		map.put("rows", list);
		map.put("total", total);
		map.put("query", materialQueryVo);
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
	@AnnotationLimit(pid="cc",mid="cg")
	public String readFileById(String id, HttpServletRequest request, HttpServletResponse response){
		WarMaterialFile materialFile = materialService.findMaterialFileById(id);
		File file = new File(ResourcesUtil.getValue("fileRootPath", "path") + "/material",materialFile.getFilePath());
		
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
	 * 查找所有的bom,为了合并
	 * @param bomQueryVo 查询条件，不是模糊查找了，是等于查找，只用workCardNo、workCardItem
	 * @return
	 */
	@RequestMapping("findAllBomForMerge")
	@ResponseBody
	@AnnotationLimit(pid="cg",mid="cga")
	public List<EngBom> findAllBomForMerge(EngBomQueryVo bomQueryVo){
		return bomService.findAllBomForMerge(bomQueryVo);
	}
	
	
	/**
	 * 合并bom
	 * @param bomQueryVo 查询条件，不是模糊查找了，是等于查找，只用workCardNo、workCardItem
	 * @return
	 */
	@RequestMapping("mergeCopyBom")
	@ResponseBody
	@AnnotationLimit(pid="cg",mid="cga")
	public Map<String, Object> mergeCopyBom(EngBomQueryVo bomQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			Map<String, Object> datas = bomService.mergeCopyBom(bomQueryVo);
			map.put("datas", datas);
			map.put("success", true);
		}catch (Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	
	
	/**
	 * 计算物料总和
	 * @param id
	 * @return
	 */
	@RequestMapping("calculationMaterialTotalSumById")
	@ResponseBody
	@AnnotationLimit(pid="cc",mid="cg")
	public Map<String, Object> calculationMaterialTotalSumById(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			List<EngBomSubsidiary> list = bomService.calculationMaterialTotalSumById(id);
			map.put("list", list);
			map.put("success", true);
		}catch (Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	
	
	/**
	 * 根据bom的id查询下一节点接收任务的人,如何未开始，则查询第一节点的接收人
	 * @param id
	 * @return
	 */
	@RequestMapping(value="queryAuditorById")
	@ResponseBody
	@AnnotationLimit(pid="cg",mid="cgd")
	public Map<String, Object> queryAuditorById(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			List<SysUser> list = bomService.queryAuditorById(id, null, session);
			map.put("success", true);
			map.put("rows",list);
			return map;
		}catch(Exception e){
			map.put("success", false);
			map.put("message",e.getMessage());
			return map;
		}
	}
	
	/**
	 * 审核bom
	 * @param id
	 * @param assigneeId 下一节点的接收人的id（为空代表当前节点是最后一个人）
	 * @param session
	 * @return
	 */
	@RequestMapping(value="auditEngBom")
	@ResponseBody
	@AnnotationLimit(pid="cg",mid="cgd")
	public Map<String, Object> auditEngBom(String id, String assigneeId, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			bomService.auditEngBom(id, assigneeId, session);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	
	/**
	 * 撤销流程
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="revokeProcess")
	@ResponseBody
	@AnnotationLimit(pid="cg",mid="cgd")
	public Map<String, Object> revokeProcess(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			bomService.revokeProcess(id, session);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	
	
	/**
	 * 收回评审
	 * @param id
	 * @return
	 */
	@RequestMapping(value="takeBackEngBom")
	@ResponseBody
	@AnnotationLimit(pid="cg",mid="cgd")
	public Map<String, Object> takeBackEngBom(String id, String cause, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			bomService.takeBackEngBom(id, cause, session);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	
	/**
	 * 退回到上一节点
	 * @param id
	 * @param cause
	 * @return
	 */
	@RequestMapping(value="rollBackEngBom")
	@ResponseBody
	@AnnotationLimit(pid="cg",mid="cgd")
	public Map<String, Object> rollBackEngBom(String id, String cause, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			bomService.rollBackEngBom(id, cause, session);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	/**
	 * 反审核
	 * @param id
	 * @param cause
	 * @return
	 */
	@RequestMapping(value="antiAuditEngBom")
	@ResponseBody
	@AnnotationLimit(pid="cg",mid="cge")
	public Map<String, Object> antiAuditEngBom(String id, String cause, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			bomService.antiAuditEngBom(id, cause, session);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message",e.getMessage());
		}
		return map;
	}
	
	
	
	
	/**
	 * 查询当前任务进行到哪
	 * @param model
	 * @param processInstanceId
	 * @param response
	 * @return
	 */
	@RequestMapping("/queryActivityMap")
	@AnnotationLimit(pid="cc",mid="cg")
	public String queryActivityMap(Model model, String processInstanceId, HttpServletResponse response){
		/*ProcessInstanceQuery processInstanceQuery = runtimeService.createProcessInstanceQuery();
		processInstanceQuery.processInstanceId(processInstanceId);
		ProcessInstance processInstance = processInstanceQuery.singleResult();
		if (processInstance != null){
			String processDefinitionId = processInstance.getProcessDefinitionId();
			model.addAttribute("processDefinitionId", processDefinitionId);
			
			// 根据 流程定义 id查询流程定义 实体对象
			ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(processDefinitionId);
			
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(processInstanceId);
			List<Task> tasks = taskQuery.list();
			JSONArray jsonArray = new JSONArray();
			for (Task task : tasks) {
				ActivityImpl activityImpl = processDefinitionEntity.findActivity(task.getTaskDefinitionKey());
				int activity_width = activityImpl.getWidth();
				int activity_height = activityImpl.getHeight();
				int activity_y = activityImpl.getY();
				int activity_x = activityImpl.getX();
				JSONObject jsonObject = new JSONObject();
				jsonObject.accumulate("activity_width", activity_width);
				jsonObject.accumulate("activity_height", activity_height);
				jsonObject.accumulate("activity_y", activity_y);
				jsonObject.accumulate("activity_x", activity_x);
				jsonObject.accumulate("assignee", task.getAssignee());
				jsonArray.add(jsonObject);
			}
			model.addAttribute("list", jsonArray);
			
			return "system/queryActivityMap";
		}else{
			StringBuffer sb = new StringBuffer();
	        sb.append("<script language='javascript'>alert('");
	        sb.append("已评审完成，并已为您刷新了数据，请重新点击查看");
	        sb.append("！');window.opener.reload();window.opener='';window.open('','_self');window.close();</script>");//该方法刷新父页面的数据,并关闭当前窗口,后面return null;
	        try {
	            response.setContentType("text/html; charset=utf-8");  
	            response.getWriter().println(sb.toString());
	            response.getWriter().flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return null;
		}*/
		
		if (StringUtils.isNotBlank(processInstanceId)){
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(processInstanceId);
			List<Task> tasks = taskQuery.list();
			if (tasks != null && tasks.size() > 0){//表示有任务，一定在审核中
				
				String processDefinitionId = tasks.get(0).getProcessDefinitionId();
				model.addAttribute("processDefinitionId", processDefinitionId);
				
				// 根据 流程定义 id查询流程定义 实体对象
				ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(processDefinitionId);
				
				JSONArray jsonArray = new JSONArray();
				for (Task task : tasks) {
					ActivityImpl activityImpl = processDefinitionEntity.findActivity(task.getTaskDefinitionKey());
					int activity_width = activityImpl.getWidth();
					int activity_height = activityImpl.getHeight();
					int activity_y = activityImpl.getY();
					int activity_x = activityImpl.getX();
					JSONObject jsonObject = new JSONObject();
					jsonObject.accumulate("activity_width", activity_width);
					jsonObject.accumulate("activity_height", activity_height);
					jsonObject.accumulate("activity_y", activity_y);
					jsonObject.accumulate("activity_x", activity_x);
					jsonObject.accumulate("assignee", task.getAssignee());
					jsonArray.add(jsonObject);
				}
				model.addAttribute("list", jsonArray);
				return "system/queryActivityMap";
			}else{
				HistoricActivityInstanceQuery historicActivityInstanceQuery = historyService.createHistoricActivityInstanceQuery();
				historicActivityInstanceQuery.processInstanceId(processInstanceId);
				List<HistoricActivityInstance> historicActivityInstances = historicActivityInstanceQuery.list();
				if (historicActivityInstances != null && historicActivityInstances.size() > 0){//说明是审核完成了
					StringBuffer sb = new StringBuffer();
			        sb.append("<script language='javascript'>alert('");
			        sb.append("已评审完成，并已为您刷新了数据，请重新点击查看");
			        sb.append("！');window.opener.reload();window.opener='';window.open('','_self');window.close();</script>");//该方法刷新父页面的数据,并关闭当前窗口,后面return null;
			        try {
			            response.setContentType("text/html; charset=utf-8");  
			            response.getWriter().println(sb.toString());
			            response.getWriter().flush();
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
				}else{//没有查找到，说明根本没有这个流程实例
					StringBuffer sb = new StringBuffer();
			        sb.append("<script language='javascript'>alert('");
			        sb.append("没有找到流程实例，并已为您刷新了数据，请重新点击查看");
			        sb.append("！');window.opener.reload();window.opener='';window.open('','_self');window.close();</script>");//该方法刷新父页面的数据,并关闭当前窗口,后面return null;
			        try {
			            response.setContentType("text/html; charset=utf-8");  
			            response.getWriter().println(sb.toString());
			            response.getWriter().flush();
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
				}
			}
		}else{
			StringBuffer sb = new StringBuffer();
	        sb.append("<script language='javascript'>alert('");
	        sb.append("没有传入流程实例id，并已为您刷新了数据，请重新点击查看");
	        sb.append("！');window.opener.reload();window.opener='';window.open('','_self');window.close();</script>");//该方法刷新父页面的数据,并关闭当前窗口,后面return null;
	        try {
	            response.setContentType("text/html; charset=utf-8");  
	            response.getWriter().println(sb.toString());
	            response.getWriter().flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
		
		return null;
	}
	
	/**
	 * 查询已完成的任务
	 * @param processInstanceId
	 * @return
	 */
	@RequestMapping("queryTaskByProcessInstanceId")
	@AnnotationLimit(pid="cc",mid="cg")
	public String queryTaskByProcessInstanceId(String processInstanceId, Model model, HttpServletResponse response){
		HistoricTaskInstanceQuery historicTaskInstanceQuery = historyService.createHistoricTaskInstanceQuery();
		historicTaskInstanceQuery.processInstanceId(processInstanceId);
		List<HistoricTaskInstance> historicTaskInstances = historicTaskInstanceQuery.list();
		
		
		if (historicTaskInstances != null && historicTaskInstances.size() > 0){
			
			List<TaskCustom> list = new ArrayList<TaskCustom>();
			for (HistoricTaskInstance historicTaskInstance : historicTaskInstances) {
				TaskCustom taskCustom = new TaskCustom();
				taskCustom.setTaskId(historicTaskInstance.getId());
				taskCustom.setTaskName(historicTaskInstance.getName());
				taskCustom.setAssignee(historicTaskInstance.getAssignee());
				taskCustom.setTaskDefinitionKey(historicTaskInstance.getTaskDefinitionKey());
				taskCustom.setTask_startTime(historicTaskInstance.getStartTime());
				taskCustom.setTask_endTime(historicTaskInstance.getEndTime());
				list.add(taskCustom);
			}
			if (list.size()>0){
				model.addAttribute("list", list);
				return "system/queryTaskByProcessInstanceId";
			}else{
				StringBuffer sb = new StringBuffer();
		        sb.append("<script language='javascript'>alert('");
		        sb.append("没有找到流程实例，已为您刷新了数据，请重新点击查看");
		        sb.append("！');window.opener.reload();window.opener='';window.open('','_self');window.close();</script>");//该方法刷新父页面的数据,并关闭当前窗口,后面return null;
		        try {
		            System.out.println(sb.toString());
		            response.setContentType("text/html; charset=utf-8");  
		            response.getWriter().println(sb.toString());
		            response.getWriter().flush();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			}
		}else{
			StringBuffer sb = new StringBuffer();
	        sb.append("<script language='javascript'>alert('");
	        sb.append("没有找到流程实例，已为您刷新了数据，请重新点击查看");
	        sb.append("！');window.opener.reload();window.opener='';window.open('','_self');window.close();</script>");//该方法刷新父页面的数据,并关闭当前窗口,后面return null;
	        try {
	            System.out.println(sb.toString());
	            response.setContentType("text/html; charset=utf-8");  
	            response.getWriter().println(sb.toString());
	            response.getWriter().flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		return null;
	}
	
	//时间类型转换器
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
