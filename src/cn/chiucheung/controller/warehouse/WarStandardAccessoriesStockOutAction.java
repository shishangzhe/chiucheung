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
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
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
import cn.chiucheung.po.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOut;
import cn.chiucheung.pojo.sales.reviewer.TaskCustom;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesInventoryCustom;
import cn.chiucheung.pojo.warehouse.standardaccessories.WarStandardAccessoriesQueryVo;
import cn.chiucheung.pojo.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutCustom;
import cn.chiucheung.pojo.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutQueryVo;
import cn.chiucheung.pojo.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutSubsidiaryCustom;
import cn.chiucheung.service.system.UserService;
import cn.chiucheung.service.warehouse.StandardAccessoriesInventoryService;
import cn.chiucheung.service.warehouse.StandardAccessoriesStockOutService;
import cn.chiucheung.utils.ResourcesUtil;
import cn.chiucheung.utils.UserUtils;

@Controller
@RequestMapping("/warehouse/standardAccessoriesStockOut")
public class WarStandardAccessoriesStockOutAction {
	
	@Autowired
	private StandardAccessoriesInventoryService standardAccessoriesInventoryService;
	
	@Autowired
	private StandardAccessoriesStockOutService standardAccessoriesStockOutService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	/**
	 * 页面的跳转
	 * @return
	 */
	@RequestMapping("index")
	@AnnotationLimit(mid="in",pid="ii")
	public String index(){
		return "warehouse/standardAccessoriesStockOut";
	}
	
	/**
	 * 查找所有的入库单
	 * @return
	 */
	@RequestMapping("findAllWarStandardAccessoriesStockOutList")
	@ResponseBody
	@AnnotationLimit(mid="in",pid="ii")
	public Map<String, Object> findAllWarStandardAccessoriesStockOutList(WarStandardAccessoriesStockOutQueryVo standardAccessoriesStockOutQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<WarStandardAccessoriesStockOut> list = standardAccessoriesStockOutService.findAllWarStandardAccessoriesStockOutList(standardAccessoriesStockOutQueryVo);
		map.put("rows", list);
		
		String total = standardAccessoriesStockOutService.findAllWarStandardAccessoriesStockOutTotal(standardAccessoriesStockOutQueryVo);
		map.put("total", total);
		
		return map;
	}
	
	/**
	 * 页面tree的数据展开
	 * @param warStandardAccessoriesStockInId
	 * @return
	 */
	@RequestMapping("findAllWarStandardAccessoriesStockOutSubsidiaryListByWarStandardAccessoriesStockOutId")
	@ResponseBody
	@AnnotationLimit(mid="in",pid="ii")
	public List<WarStandardAccessoriesStockOutSubsidiaryCustom> findAllWarStandardAccessoriesStockOutSubsidiaryListByWarStandardAccessoriesStockOutId(String warStandardAccessoriesStockOutId){
		return standardAccessoriesStockOutService.findAllWarStandardAccessoriesStockOutSubsidiaryListByWarStandardAccessoriesStockOutId(warStandardAccessoriesStockOutId);
		
	}
	
	/**
	 * 查找所有库存
	 * @param standardAccessoriesQueryVo
	 * @return
	 */
	@RequestMapping("findAllWarStandardAccessoriesInventoryList")
	@ResponseBody
	@AnnotationLimit(mid="ina",pid="in")
	public Map<String, Object> findAllWarStandardAccessoriesInventoryList(WarStandardAccessoriesQueryVo standardAccessoriesQueryVo){
		Map<String, Object> map = new HashMap<String, Object>();
		List<WarStandardAccessoriesInventoryCustom> list = standardAccessoriesInventoryService.findAllWarStandardAccessoriesInventoryList(standardAccessoriesQueryVo);
		String total = standardAccessoriesInventoryService.findAllWarStandardAccessoriesInventoryTotal(standardAccessoriesQueryVo);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	/**
	 * 新增出库单
	 * @param standardAccessoriesStockOutCustom
	 * @return
	 */
	@RequestMapping("saveWarStandardAccessoriesStockOut")
	@ResponseBody
	@AnnotationLimit(mid="ina",pid="in")
	public JSONObject saveWarStandardAccessoriesStockOut(WarStandardAccessoriesStockOutCustom standardAccessoriesStockOutCustom, HttpSession session){
		JSONObject jsonObject = new JSONObject();
		try{
			standardAccessoriesStockOutService.saveWarStandardAccessoriesStockOut(standardAccessoriesStockOutCustom, session);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 根据id查找出库单，用于页面的查看
	 * @param id
	 * @return
	 */
	@RequestMapping("findWarStandardAccessoriesStockOutByIdForView")
	@ResponseBody
	@AnnotationLimit(mid="in",pid="ii")
	public Map<String, Object> findWarStandardAccessoriesStockOutByIdForView(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			WarStandardAccessoriesStockOutCustom standardAccessoriesStockOutCustom = standardAccessoriesStockOutService.findWarStandardAccessoriesStockOutByIdForEdit(id);
			map.put("success", true);
			map.put("standardAccessoriesStockOutCustom", standardAccessoriesStockOutCustom);
		}catch (Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}
	
	
	/**
	 * 根据id查找出库单，用于页面的编辑
	 * @param id
	 * @return
	 */
	@RequestMapping("findWarStandardAccessoriesStockOutByIdForEdit")
	@ResponseBody
	@AnnotationLimit(mid="inb",pid="in")
	public Map<String, Object> findWarStandardAccessoriesStockOutByIdForEdit(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			WarStandardAccessoriesStockOutCustom standardAccessoriesStockOutCustom = standardAccessoriesStockOutService.findWarStandardAccessoriesStockOutByIdForEdit(id);
			
			String processInstanceId = standardAccessoriesStockOutCustom.getProcessInstanceId();
			String processDefinitionKey = ResourcesUtil.getValue("activiti", "standardAccessoriesStockOutProcessDefinitionKey");
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processDefinitionKey(processDefinitionKey);//设置查询条件，当前模块的任务
			taskQuery.processInstanceId(processInstanceId);//设置查询条件，流程实例id
			Task task = taskQuery.singleResult();
			if (task != null){//流程进行中！
				if (task.getTaskDefinitionKey().equals("createStockOut") && task.getAssignee().equals(UserUtils.getUserFromSession(session).getLoginName())){//第一节点
					map.put("flag", true);
				}else{
					map.put("flag", false);
				}
			}else{//流程已结束
				map.put("flag", false);
			}
			
			map.put("success", true);
			map.put("standardAccessoriesStockOutCustom", standardAccessoriesStockOutCustom);
		}catch (Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("message", e.getMessage());
		}
		return map;
	}
	
	/**
	 * 更新出库单
	 * @param standardAccessoriesStockOutCustom
	 * @return
	 */
	@RequestMapping("updateWarStandardAccessoriesStockOut")
	@ResponseBody
	@AnnotationLimit(mid="inb",pid="in")
	public JSONObject updateWarStandardAccessoriesStockOut(WarStandardAccessoriesStockOutCustom standardAccessoriesStockOutCustom){
		JSONObject jsonObject = new JSONObject();
		try{
			standardAccessoriesStockOutService.updateWarStandardAccessoriesStockOut(standardAccessoriesStockOutCustom);
			jsonObject.accumulate("success", true);
		}catch (Exception e){
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("message", e.getMessage());
		}
		return jsonObject;
	}
	
	/**
	 * 根据id删除出库单
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteWarStandardAccessoriesStockOutById")
	@ResponseBody
	@AnnotationLimit(mid="inc",pid="in")
	public JSONObject deleteWarStandardAccessoriesStockOutById(String id){
		JSONObject jsonObject = new JSONObject();
		try{
			standardAccessoriesStockOutService.deleteWarStandardAccessoriesStockOutById(id);
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
	@RequestMapping(value="queryAuditorByProcessInstanceId")
	@ResponseBody
	@AnnotationLimit(mid="ind",pid="in")
	public Map<String, Object> queryAuditorByProcessInstanceId(String id, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			List<SysUser> list = standardAccessoriesStockOutService.queryAuditorByProcessInstanceId(id, session);
			map.put("success", true);
			map.put("rows",list);
			return map;
		}catch(Exception e){
			map.put("success", false);
			map.put("message","<div style='text-align:center;'>"+"获取下一节点失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>");
			return map;
		}
	}
	
	/**
	 * 审核出库单
	 * @param id
	 * @param assignee 下一节点的接收人（为null代表当前节点是最后一个人）
	 * @param session
	 * @return
	 */
	@RequestMapping(value="auditWarStandardAccessoriesStockOut",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="ind",pid="in")
	public String auditWarStandardAccessoriesStockOut(String id, String assignee, HttpSession session){
		try{
			standardAccessoriesStockOutService.auditWarStandardAccessoriesStockOut(id, assignee, session);
			return "审核成功";
		} catch (Exception e) {
			if("com.mysql.jdbc.MysqlDataTruncation: Data truncation: Out of range value adjusted for column 'existing_quantity' at row 1".equals(e.getCause() == null ? "" : e.getCause().toString())){
				return "<div style='text-align:center;'>"+"重新审核失败</br>" + "<font color='red'>error:库存数量小于入库单的数量<font/><div/>";
			}else{
				e.printStackTrace();
				return "<div style='text-align:center;'>"+"审核失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
			}
		}
	}

	/**
	 * 收回评审
	 * @param id
	 * @return
	 */
	@RequestMapping(value="takeBackWarStandardAccessoriesStockOut",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="ine",pid="in")
	public String takeBackWarStandardAccessoriesStockOut(String id, String cause, HttpSession session){
		try {
			standardAccessoriesStockOutService.takeBackWarStandardAccessoriesStockOut(id, cause, session);
			return "收回审核成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"收回审核失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	/**
	 * 退回到上一节点
	 * @param id
	 * @return
	 */
	@RequestMapping(value="rollBackWarStandardAccessoriesStockOut",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="inf",pid="in")
	public String rollBackWarStandardAccessoriesStockOut(String id, String cause, HttpSession session){
		try {
			standardAccessoriesStockOutService.rollBackWarStandardAccessoriesStockOut(id, cause, session);
			return "退回成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"退回失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	
	/**
	 * 重新开始评审
	 * @param id
	 * @return
	 */
	@RequestMapping(value="reAuditWarStandardAccessoriesStockOut",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="ing",pid="in")
	public String reAuditWarStandardAccessoriesStockOut(String id, String cause, HttpSession session){
		try {
			standardAccessoriesStockOutService.reAuditWarStandardAccessoriesStockOut(id, cause, session);
			return "重新审核成功";
		} catch (Exception e) {
			if("com.mysql.jdbc.MysqlDataTruncation: Data truncation: Out of range value adjusted for column 'existing_quantity' at row 1".equals(e.getCause() == null ? "" : e.getCause().toString())){
				return "<div style='text-align:center;'>"+"重新审核失败</br>" + "<font color='red'>error:库存数量小于入库单的数量<font/><div/>";
			}else{
				e.printStackTrace();
				return "<div style='text-align:center;'>"+"重新审核失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
			}
		}
	}
	
	
	/**
	 * 查询当前任务进行到哪
	 * @param model
	 * @param processInstanceId
	 * @param response
	 * @return
	 */
	@RequestMapping("/queryActivityMap")
	@AnnotationLimit(mid="in",pid="ii")
	public String queryActivityMap(Model model, String processInstanceId, HttpServletResponse response){
		ProcessInstanceQuery processInstanceQuery = runtimeService.createProcessInstanceQuery();
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
				String assignee = task.getAssignee();
				List<SysUser> userList = userService.findAllSysUserByLoginName(assignee);
				JSONObject jsonObject = new JSONObject();
				jsonObject.accumulate("activity_width", activity_width);
				jsonObject.accumulate("activity_height", activity_height);
				jsonObject.accumulate("activity_y", activity_y);
				jsonObject.accumulate("activity_x", activity_x);
				jsonObject.accumulate("assignee", userList.get(0).getUsername()+"("+userList.get(0).getLoginName()+")");
				jsonArray.add(jsonObject);
			}
			model.addAttribute("list", jsonArray);
			
			return "system/queryActivityMap";
		}else{
			StringBuffer sb = new StringBuffer();
	        sb.append("<script language='javascript'>alert('");
	        sb.append("已审核完成或重新开始审核，并已为您刷新了数据，请重新点击查看");
	        sb.append("！');window.opener.reload();window.opener='';window.open('','_self');window.close();</script>");//该方法刷新父页面的数据,并关闭当前窗口,后面return null;
	        try {
	            response.setContentType("text/html; charset=utf-8");  
	            response.getWriter().println(sb.toString());
	            response.getWriter().flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return null;
		}
	}
	
	/**
	 * 查询已完成的任务
	 * @param processInstanceId
	 * @return
	 */
	@RequestMapping("queryTaskByProcessInstanceId")
	@AnnotationLimit(mid="in",pid="ii")
	public String queryTaskByProcessInstanceId(String processInstanceId, Model model, HttpServletResponse response){
		HistoricTaskInstanceQuery historicTaskInstanceQuery = historyService.createHistoricTaskInstanceQuery();
		historicTaskInstanceQuery.processInstanceId(processInstanceId);
		historicTaskInstanceQuery.orderByHistoricTaskInstanceStartTime().desc();
		List<HistoricTaskInstance> historicTaskInstances = historicTaskInstanceQuery.list();
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
	        sb.append("数据在评审中，已为您刷新了数据，请重新点击查看");
	        sb.append("！');window.opener.reload();window.opener='';window.open('','_self');window.close();</script>");//该方法刷新父页面的数据,并关闭当前窗口,后面return null;
	        try {
	            System.out.println(sb.toString());
	            response.setContentType("text/html; charset=utf-8");  
	            response.getWriter().println(sb.toString());
	            response.getWriter().flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return null;
		}
	}
	
	
	//时间类型转换器
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
