package cn.chiucheung.controller.system;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.dao.mapper.system.user.SysUserMapper;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.pojo.sales.reviewer.TaskCustom;
import cn.chiucheung.pojo.system.flow.ProcessDefinitionCustom;
import cn.chiucheung.pojo.system.flow.ProcessDefinitionVo;
import cn.chiucheung.service.system.UserService;

@Controller
@RequestMapping("/system/flow")
public class SysFlowAction {
	
	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SysUserMapper userMapper;
	
	/**
	 * 主页的跳转
	 * @return 跳转的页面
	 */
	@RequestMapping("index")
	@AnnotationLimit(mid="bf",pid="bb")
	public String index(){
		return "system/flow";
	}
	
	
	/**
	 * 新增流程定义部署
	 * @return
	 */
	@RequestMapping(value="saveDeployment",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="bfa",pid="bf")
	public String saveDeployment(MultipartFile resource_bpmn, MultipartFile resource_png){
		try {
			String resourceName_bpmn = resource_bpmn.getOriginalFilename();
			InputStream inputStream_bpmn = resource_bpmn.getInputStream();
			
			String resourceName_png = resource_png.getOriginalFilename();
			InputStream inputStream_png = resource_png.getInputStream();
			
			repositoryService.createDeployment()
			.addInputStream(resourceName_bpmn, inputStream_bpmn)
			.addInputStream(resourceName_png, inputStream_png)
			.deploy();
			
			return "保存成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"保存失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
		}
	}
	
	
	/**
	 * 查找所有的流程定义部署
	 * @return
	 */
	@RequestMapping(value="findAllProcessDefinition")
	@ResponseBody
	@AnnotationLimit(mid="bf",pid="bb")
	public Map<String, Object> findAllProcessDefinition(ProcessDefinitionVo processDefinitionVo){
		List<ProcessDefinition> list = new ArrayList<ProcessDefinition>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProcessDefinitionCustom> processDefinitionCustoms = new ArrayList<ProcessDefinitionCustom>();
		ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
		if (StringUtils.isNotBlank(processDefinitionVo.getName())){
			processDefinitionQuery.processDefinitionNameLike("%"+processDefinitionVo.getName()+"%");
		}
		if (StringUtils.isNotBlank(processDefinitionVo.getSort())&&StringUtils.isNotBlank(processDefinitionVo.getOrder())){
			if (processDefinitionVo.getSort().equals("name")){
				processDefinitionQuery.orderByProcessDefinitionName();
			}else if (processDefinitionVo.getSort().equals("deploymentId")){
				processDefinitionQuery.orderByDeploymentId();
			}else if (processDefinitionVo.getSort().equals("id")){
				processDefinitionQuery.orderByProcessDefinitionId();
			}else if (processDefinitionVo.getSort().equals("key")){
				processDefinitionQuery.orderByProcessDefinitionKey();
			}else if (processDefinitionVo.getSort().equals("version")){
				processDefinitionQuery.orderByProcessDefinitionVersion();
			}
			
			if (processDefinitionVo.getOrder().equals("asc")){
				processDefinitionQuery.asc();
			}else if (processDefinitionVo.getOrder().equals("desc")){
				processDefinitionQuery.desc();
			}
		}
		long total = processDefinitionQuery.count();//分页之前查出总记录数
		if (processDefinitionVo.getPage() != 0 && processDefinitionVo.getRows() != 0){
			list = processDefinitionQuery.listPage(processDefinitionVo.getStartPage(), processDefinitionVo.getRows());
		}else{
			list = processDefinitionQuery.list();
		}
		for (ProcessDefinition processDefinition : list) {
			ProcessDefinitionCustom processDefinitionCustom = new ProcessDefinitionCustom();
			processDefinitionCustom.setDeploymentId(processDefinition.getDeploymentId());
			processDefinitionCustom.setId(processDefinition.getId());
			processDefinitionCustom.setKey(processDefinition.getKey());
			processDefinitionCustom.setName(processDefinition.getName());
			processDefinitionCustom.setVersion(processDefinition.getVersion());
			processDefinitionCustom.setBpmn("processDefinitionId="+processDefinition.getId()+"&resourceType=bpmn");
			processDefinitionCustom.setPng("processDefinitionId="+processDefinition.getId()+"&resourceType=png");
			processDefinitionCustoms.add(processDefinitionCustom);
		}
		map.put("total", total);
		map.put("rows", processDefinitionCustoms);
		return map;
	}
	
	/**
	 * 查找所有的流程定义部署文件
	 * @return
	 */
	@RequestMapping(value="queryProcessDefinitionResource")
	@ResponseBody
	public String queryProcessDefinitionResource(HttpServletResponse response, String processDefinitionId, String resourceType){
		try{
			ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
			processDefinitionQuery.processDefinitionId(processDefinitionId);
			ProcessDefinition processDefinition = processDefinitionQuery.singleResult();
			// 部署id
					String deploymentId = processDefinition.getDeploymentId();
	
					// 资源 文件名称
					String resourceName = null;
	
					if (resourceType.equals("bpmn")) {
						// bpmn资源文件名称
						resourceName = processDefinition.getResourceName();
	
					} else if (resourceType.equals("png")) {
						// png资源文件名称
						resourceName = processDefinition.getDiagramResourceName();
	
					}
					// 资源 文件输入流
					InputStream inputStream = repositoryService.getResourceAsStream(
							deploymentId, resourceName);
	
					// 流复制
	
					byte[] b = new byte[1024];
	
					int len = -1;
					while ((len = inputStream.read(b, 0, 1024)) != -1) {
						response.getOutputStream().write(b, 0, len);
					}
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 删除流程定义部署
	 * @param user 要删除的用户
	 * @return
	 */
	@RequestMapping(value="deleteDeploymentByProcessDefinitionId",produces="text/html;charset=UTF-8")
	@ResponseBody
	@AnnotationLimit(mid="bfb",pid="bf")
	public String deleteDeploymentByProcessDefinitionId(String ProcessDefinitionId){
		try{
			ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
			processDefinitionQuery.processDefinitionId(ProcessDefinitionId);
			ProcessDefinition processDefinition = processDefinitionQuery.singleResult();
			repositoryService.deleteDeployment(processDefinition.getDeploymentId(), true);
			return "删除成功";
		}catch (Exception e){
			e.printStackTrace();
			return "<div style='text-align:center;'>"+"删除失败</br>" + "<font color='red'>error:" +e.getMessage() + "<font/><div/>";
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
	
}
