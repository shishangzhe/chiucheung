package cn.chiucheung.controller.warehouse;

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
import cn.chiucheung.po.warehouse.storagewarehouseworkcardstockin.WarStorageWarehouseWorkCardStockIn;
import cn.chiucheung.pojo.sales.reviewer.TaskCustom;
import cn.chiucheung.pojo.warehouse.material.WarMaterialQueryVo;
import cn.chiucheung.pojo.warehouse.storagewarehouseworkcardstockin.ProStorageWarehouseWorkCardSubsidiaryCustom;
import cn.chiucheung.pojo.warehouse.storagewarehouseworkcardstockin.WarStorageWarehouseWorkCardStockInCustom;
import cn.chiucheung.pojo.warehouse.storagewarehouseworkcardstockin.WarStorageWarehouseWorkCardStockInQueryVo;
import cn.chiucheung.pojo.warehouse.storagewarehouseworkcardstockin.WarStorageWarehouseWorkCardStockInSubsidiaryCustom;
import cn.chiucheung.service.system.UserService;
import cn.chiucheung.service.warehouse.StorageWarehouseWorkCardStockInService;

@Controller
@RequestMapping("/warehouse/storageWarehouseWorkCardStockIn")
public class WarStorageWarehouseWorkCardStockInAction {
	
	@Autowired
	private StorageWarehouseWorkCardStockInService storageWarehouseWorkCardStockInService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	/**
	 * 页面的跳转
	 * @return
	 */
	@RequestMapping("index")
	@AnnotationLimit(mid="im",pid="ii")
	public String index(){
		return "warehouse/storageWarehouseWorkCardStockIn";
	}
	
	
	/**
	 * 查找所有的入库单
	 * @return
	 */
	@RequestMapping("findAllWarStorageWarehouseWorkCardStockInList")
	@ResponseBody
	@AnnotationLimit(mid="im",pid="ii")
	public Map<String, Object> findAllWarStorageWarehouseWorkCardStockInList(WarStorageWarehouseWorkCardStockInQueryVo storageWarehouseWorkCardStockInQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<WarStorageWarehouseWorkCardStockIn> list = storageWarehouseWorkCardStockInService.findAllWarStorageWarehouseWorkCardStockInList(storageWarehouseWorkCardStockInQueryVo);
		map.put("rows", list);
		
		String total = storageWarehouseWorkCardStockInService.findAllWarStorageWarehouseWorkCardStockInTotal(storageWarehouseWorkCardStockInQueryVo);
		map.put("total", total);
		
		return map;
	}
	
	/**
	 * 页面的数据展开
	 * @param warStandardAccessoriesStockInId
	 * @return
	 */
	@RequestMapping("findAllWarStorageWarehouseWorkCardStockInSubsidiaryListByWarStorageWarehouseWorkCardStockInId")
	@ResponseBody
	@AnnotationLimit(mid="im",pid="ii")
	public List<WarStorageWarehouseWorkCardStockInSubsidiaryCustom> findAllWarStorageWarehouseWorkCardStockInSubsidiaryListByWarStorageWarehouseWorkCardStockInId(String warStorageWarehouseWorkCardStockInId){
		return storageWarehouseWorkCardStockInService.findAllWarStorageWarehouseWorkCardStockInSubsidiaryListByWarStorageWarehouseWorkCardStockInId(warStorageWarehouseWorkCardStockInId);
		
	}
	
	/**
	 * 获取所有未完全入库的存仓工咭
	 * @param standardAccessoriesQueryVo
	 * @return
	 */
	@RequestMapping("findAllCompleteStorageWarehouseWorkCardSubsidiaryList")
	@ResponseBody
	@AnnotationLimit(mid="ima",pid="im")
	public Map<String, Object> findAllCompleteStorageWarehouseWorkCardSubsidiaryList(WarMaterialQueryVo materialQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProStorageWarehouseWorkCardSubsidiaryCustom> list = storageWarehouseWorkCardStockInService.findAllCompleteStorageWarehouseWorkCardSubsidiaryList(materialQueryVo);
		String total = storageWarehouseWorkCardStockInService.findAllCompleteStorageWarehouseWorkCardSubsidiaryTotal(materialQueryVo);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 新增入仓单
	 * @param storageWarehouseWorkCardStockInCustom
	 * @return
	 */
	@RequestMapping("saveWarStorageWarehouseWorkCardStockIn")
	@ResponseBody
	@AnnotationLimit(mid="ima",pid="im")
	public JSONObject saveWarStorageWarehouseWorkCardStockIn(WarStorageWarehouseWorkCardStockInCustom storageWarehouseWorkCardStockInCustom){
		JSONObject jsonObject = new JSONObject();
		try{
			storageWarehouseWorkCardStockInService.saveWarStorageWarehouseWorkCardStockIn(storageWarehouseWorkCardStockInCustom);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 根据id查找入库单，用于页面的查看
	 * @param id
	 * @return
	 */
	@RequestMapping("findWarStorageWarehouseWorkCardStockInByIdForView")
	@ResponseBody
	@AnnotationLimit(mid="im",pid="ii")
	public Map<String, Object> findWarStorageWarehouseWorkCardStockInByIdForView(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			Map<String, Object> datas = storageWarehouseWorkCardStockInService.findWarStorageWarehouseWorkCardStockInByIdForView(id);
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
	 * 根据id查找入库单，用于页面的编辑
	 * @param id
	 * @return
	 */
	@RequestMapping("findWarStorageWarehouseWorkCardStockInByIdForEdit")
	@ResponseBody
	@AnnotationLimit(mid="imb",pid="im")
	public Map<String, Object> findWarStorageWarehouseWorkCardStockInByIdForEdit(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			Map<String, Object> datas = storageWarehouseWorkCardStockInService.findWarStorageWarehouseWorkCardStockInByIdForEdit(id, session);
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
	 * 更新入库单
	 * @param standardAccessoriesStockInCustom
	 * @return
	 */
	@RequestMapping("updateWarStorageWarehouseWorkCardStockIn")
	@ResponseBody
	@AnnotationLimit(mid="imb",pid="im")
	public JSONObject updateWarStorageWarehouseWorkCardStockIn(WarStorageWarehouseWorkCardStockInCustom storageWarehouseWorkCardStockInCustom, HttpSession session){
		JSONObject jsonObject = new JSONObject();
		try{
			storageWarehouseWorkCardStockInService.updateWarStorageWarehouseWorkCardStockIn(storageWarehouseWorkCardStockInCustom, session);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	
	@RequestMapping("deleteWarStorageWarehouseWorkCardStockInById")
	@ResponseBody
	@AnnotationLimit(mid="imc",pid="im")
	public JSONObject deleteWarStorageWarehouseWorkCardStockInById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			storageWarehouseWorkCardStockInService.deleteWarStorageWarehouseWorkCardStockInById(id);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
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
	@AnnotationLimit(mid="imd",pid="im")
	public Map<String, Object> queryAuditorById(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			List<SysUser> list = storageWarehouseWorkCardStockInService.queryAuditorById(id, null, session);
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
	 * 审核入库单
	 * @param id
	 * @param assignee 下一节点的接收人（为null代表当前节点是最后一个人）
	 * @param session
	 * @return
	 */
	@RequestMapping("auditWarStorageWarehouseWorkCardStockIn")
	@ResponseBody
	@AnnotationLimit(mid="imd",pid="im")
	public Map<String, Object> auditWarStorageWarehouseWorkCardStockIn(String id, String assigneeId, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			storageWarehouseWorkCardStockInService.auditWarStorageWarehouseWorkCardStockIn(id, assigneeId, session);
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
	@AnnotationLimit(mid="imd",pid="im")
	public Map<String, Object> revokeProcess(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			storageWarehouseWorkCardStockInService.revokeProcess(id, session);
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
	@RequestMapping("takeBackWarStorageWarehouseWorkCardStockIn")
	@ResponseBody
	@AnnotationLimit(mid="imd",pid="im")
	public Map<String, Object> takeBackWarStorageWarehouseWorkCardStockIn(String id, String cause, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			storageWarehouseWorkCardStockInService.takeBackWarStorageWarehouseWorkCardStockIn(id, cause, session);
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
	@RequestMapping("rollBackWarStorageWarehouseWorkCardStockIn")
	@ResponseBody
	@AnnotationLimit(mid="imd",pid="im")
	public Map<String, Object> rollBackWarStorageWarehouseWorkCardStockIn(String id, String cause, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			storageWarehouseWorkCardStockInService.rollBackWarStorageWarehouseWorkCardStockIn(id, cause, session);
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
	@RequestMapping(value="antiAuditWarStorageWarehouseWorkCardStockIn")
	@ResponseBody
	@AnnotationLimit(mid="ime",pid="im")
	public Map<String, Object> antiAuditWarStorageWarehouseWorkCardStockIn(String id, String cause, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			storageWarehouseWorkCardStockInService.antiAuditWarStorageWarehouseWorkCardStockIn(id, cause, session);
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
	@AnnotationLimit(mid="im",pid="ii")
	public String queryActivityMap(Model model, String processInstanceId, HttpServletResponse response){
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
	@AnnotationLimit(mid="im",pid="ii")
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
