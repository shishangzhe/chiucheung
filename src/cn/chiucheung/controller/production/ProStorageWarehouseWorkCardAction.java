package cn.chiucheung.controller.production;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.po.warehouse.material.WarMaterial;
import cn.chiucheung.pojo.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardCustom;
import cn.chiucheung.pojo.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardQueryVo;
import cn.chiucheung.pojo.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardShowDataCustom;
import cn.chiucheung.pojo.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardSubsidiaryShowDataCustom;
import cn.chiucheung.pojo.sales.reviewer.TaskCustom;
import cn.chiucheung.pojo.warehouse.material.WarMaterialInventoryCustom;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesInventoryCustom;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesQueryVo;
import cn.chiucheung.service.production.StorageWarehouseWorkCardService;
import cn.chiucheung.service.system.UserService;
import cn.chiucheung.service.warehouse.MaterialInventoryService;
import cn.chiucheung.service.warehouse.MaterialService;
import cn.chiucheung.service.warehouse.StandardAccessoriesInventoryService;
import cn.chiucheung.utils.ResourcesUtil;
import cn.chiucheung.utils.UserUtils;

@Controller
@RequestMapping("/production/storageWarehouseWorkCard")
public class ProStorageWarehouseWorkCardAction {
	
	@Autowired
	private StandardAccessoriesInventoryService standardAccessoriesInventoryService;
	
	@Autowired
	private MaterialInventoryService materialInventoryService;
	
	@Autowired
	private StorageWarehouseWorkCardService storageWarehouseWorkCardService;
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@RequestMapping("index")
	@AnnotationLimit(mid="af",pid="aa")
	public String index(){
		return "production/storageWarehouseWorkCard";
	}
	
	/**
	 * 查询所有的存仓工咭
	 * @param storageWarehouseWorkCardQueryVo 查询条件
	 * @return
	 */
	@RequestMapping("findAllProStorageWarehouseWorkCardList")
	@ResponseBody
	public Map<String, Object> findAllProStorageWarehouseWorkCardList(ProStorageWarehouseWorkCardQueryVo storageWarehouseWorkCardQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProStorageWarehouseWorkCardShowDataCustom> list = storageWarehouseWorkCardService.findAllProStorageWarehouseWorkCardList(storageWarehouseWorkCardQueryVo);
		map.put("rows", list);
		String total = storageWarehouseWorkCardService.findAllProStorageWarehouseWorkCardTotal(storageWarehouseWorkCardQueryVo);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 查询所有的物料库存
	 * @param materialQueryVo 查询条件
	 * @return
	 */
	@RequestMapping("findAllWarMaterialInventoryList")
	@ResponseBody
	@AnnotationLimit(mid="af",pid="aa")
	public Map<String, Object> findAllWarMaterialInventoryList(WarMaterialQueryVo materialQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<WarMaterialInventoryCustom> list = materialInventoryService.findAllWarMaterialInventoryList(materialQueryVo);
		String total = materialInventoryService.findAllWarMaterialInventoryTotal(materialQueryVo);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 新增存仓工咭
	 * @param storageWarehouseWorkCardCustom
	 * @param session
	 * @return
	 */
	@RequestMapping("saveProStorageWarehouseWorkCard")
	@ResponseBody
	@AnnotationLimit(mid="afa",pid="af")
	public JSONObject saveProStorageWarehouseWorkCard(ProStorageWarehouseWorkCardCustom storageWarehouseWorkCardCustom, HttpSession session){
		JSONObject jsonObject = new JSONObject();
		try{
			storageWarehouseWorkCardService.saveProStorageWarehouseWorkCard(storageWarehouseWorkCardCustom, session);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 用于tree的数据展开
	 * @param proStorageWarehouseWorkCardQueryId
	 * @return
	 */
	@RequestMapping("findAllProStorageWarehouseWorkCardSubsidiaryListByProStorageWarehouseWorkCardId")
	@ResponseBody
	@AnnotationLimit(mid="af",pid="aa")
	public List<ProStorageWarehouseWorkCardSubsidiaryShowDataCustom> findAllProStorageWarehouseWorkCardSubsidiaryListByProStorageWarehouseWorkCardId(String proStorageWarehouseWorkCardQueryId){
		return storageWarehouseWorkCardService.findAllProStorageWarehouseWorkCardSubsidiaryListByProStorageWarehouseWorkCardId(proStorageWarehouseWorkCardQueryId);
	}
	
	/**
	 * 根据id查找存仓工咭，用于页面的数据查看
	 * @param id
	 * @return
	 */
	@RequestMapping("findProStorageWarehouseWorkCardByIdForView")
	@ResponseBody
	@AnnotationLimit(mid="af",pid="aa")
	public Map<String, Object> findProStorageWarehouseWorkCardByIdForView(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> datas = storageWarehouseWorkCardService.findProStorageWarehouseWorkCardByIdForView(id);
			map.put("success", true);
			map.put("datas", datas);
		} catch (Exception e) {
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}
	
	/**
	 * 根据id查找存仓工咭，用于页面的数据修改
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("findProStorageWarehouseWorkCardByIdForEdit")
	@ResponseBody
	@AnnotationLimit(mid="afb",pid="af")
	public Map<String, Object> findProStorageWarehouseWorkCardByIdForEdit(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> datas = storageWarehouseWorkCardService.findProStorageWarehouseWorkCardByIdForEdit(id, session);
			map.put("success", true);
			map.put("datas", datas);
		} catch (Exception e) {
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}
	
	/**
	 * 更新存仓工咭
	 * @param storageWarehouseWorkCardCustom
	 * @return
	 */
	@RequestMapping("updateProStorageWarehouseWorkCard")
	@ResponseBody
	@AnnotationLimit(mid="afb",pid="af")
	public JSONObject updateProStorageWarehouseWorkCard(ProStorageWarehouseWorkCardCustom storageWarehouseWorkCardCustom, HttpSession session){
		JSONObject jsonObject = new JSONObject();
		try{
			storageWarehouseWorkCardService.updateProStorageWarehouseWorkCard(storageWarehouseWorkCardCustom, session);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 根据id删除存仓工咭
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteProStorageWarehouseWorkCardById")
	@ResponseBody
	@AnnotationLimit(mid="afc",pid="af")
	public JSONObject deleteProStorageWarehouseWorkCardById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			storageWarehouseWorkCardService.deleteProStorageWarehouseWorkCardById(id);
			jsonObject.accumulate("success", true);
		}catch(Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	
	/**
	 * 根据流程定义id查询下一节点接收任务的人
	 * @param id
	 * @return
	 */
	@RequestMapping(value="queryAuditorById")
	@ResponseBody
	@AnnotationLimit(mid="afd",pid="af")
	public Map<String, Object> queryAuditorById(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			List<SysUser> list = storageWarehouseWorkCardService.queryAuditorById(id, null, session);
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
	 * 审核存仓工咭
	 * @param id
	 * @param assignee 下一节点的接收人（为null代表当前节点是最后一个人）
	 * @param session
	 * @return
	 */
	@RequestMapping("auditProStorageWarehouseWorkCard")
	@ResponseBody
	@AnnotationLimit(mid="afd",pid="af")
	public Map<String, Object> auditProStorageWarehouseWorkCard(String id, String assigneeId, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			storageWarehouseWorkCardService.auditProStorageWarehouseWorkCard(id, assigneeId, session);
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
	@AnnotationLimit(mid="afd",pid="af")
	public Map<String, Object> revokeProcess(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			storageWarehouseWorkCardService.revokeProcess(id, session);
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
	@RequestMapping("takeBackProStorageWarehouseWorkCard")
	@ResponseBody
	@AnnotationLimit(mid="afd",pid="af")
	public Map<String, Object> takeBackProStorageWarehouseWorkCard(String id, String cause, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			storageWarehouseWorkCardService.takeBackProStorageWarehouseWorkCard(id, cause, session);
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
	 * @return
	 */
	@RequestMapping("rollBackProStorageWarehouseWorkCard")
	@ResponseBody
	@AnnotationLimit(mid="afd",pid="af")
	public Map<String, Object> rollBackProStorageWarehouseWorkCard(String id, String cause, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			storageWarehouseWorkCardService.rollBackProStorageWarehouseWorkCard(id, cause, session);
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
	@RequestMapping(value="antiAuditProStorageWarehouseWorkCard")
	@ResponseBody
	@AnnotationLimit(mid="afe",pid="af")
	public Map<String, Object> antiAuditProStorageWarehouseWorkCard(String id, String cause, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			storageWarehouseWorkCardService.antiAuditProStorageWarehouseWorkCard(id, cause, session);
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
	@AnnotationLimit(mid="af",pid="aa")
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
	@AnnotationLimit(mid="af",pid="aa")
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
