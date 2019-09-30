package cn.chiucheung.service.warehouse.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import cn.chiucheung.dao.mapper.system.message.SysMessageMapper;
import cn.chiucheung.dao.mapper.system.user.SysUserMapper;
import cn.chiucheung.dao.mapper.warehouse.standardaccessoriesinventory.WarStandardAccessoriesInventoryMapper;
import cn.chiucheung.dao.mapper.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutMapper;
import cn.chiucheung.dao.mapper.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutSubsidiaryMapper;
import cn.chiucheung.po.system.message.SysMessage;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.po.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOut;
import cn.chiucheung.po.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutSubsidiary;
import cn.chiucheung.po.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutSubsidiaryExample;
import cn.chiucheung.pojo.system.user.SysUserQueryVo;
import cn.chiucheung.pojo.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutCustom;
import cn.chiucheung.pojo.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutQueryVo;
import cn.chiucheung.pojo.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutSubsidiaryCustom;
import cn.chiucheung.service.warehouse.StandardAccessoriesStockOutService;
import cn.chiucheung.utils.ActivitiUtils;
import cn.chiucheung.utils.ResourcesUtil;
import cn.chiucheung.utils.UUIDBuild;
import cn.chiucheung.utils.UserUtils;

@Service
public class StandardAccessoriesStockOutServiceImpl implements StandardAccessoriesStockOutService {
	
	@Autowired
	private WarStandardAccessoriesStockOutMapper standardAccessoriesStockOutMapper;
	
	@Autowired
	private WarStandardAccessoriesStockOutSubsidiaryMapper standardAccessoriesStockOutSubsidiaryMapper;
	
	@Autowired
	private WarStandardAccessoriesInventoryMapper standardAccessoriesInventoryMapper;
	
	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private SysMessageMapper messageMapper;

	@Override
	public List<WarStandardAccessoriesStockOut> findAllWarStandardAccessoriesStockOutList(WarStandardAccessoriesStockOutQueryVo standardAccessoriesStockOutQueryVo) {
		return standardAccessoriesStockOutMapper.findAllWarStandardAccessoriesStockOutList(standardAccessoriesStockOutQueryVo);
	}

	@Override
	public String findAllWarStandardAccessoriesStockOutTotal(WarStandardAccessoriesStockOutQueryVo standardAccessoriesStockOutQueryVo) {
		return standardAccessoriesStockOutMapper.findAllWarStandardAccessoriesStockOutTotal(standardAccessoriesStockOutQueryVo);
	}

	@Override
	public List<WarStandardAccessoriesStockOutSubsidiaryCustom> findAllWarStandardAccessoriesStockOutSubsidiaryListByWarStandardAccessoriesStockOutId(String warStandardAccessoriesStockOutId) {
		return standardAccessoriesStockOutSubsidiaryMapper.findAllWarStandardAccessoriesStockOutSubsidiaryListByWarStandardAccessoriesStockOutId(warStandardAccessoriesStockOutId);
	}

	@Override
	public int saveWarStandardAccessoriesStockOut(WarStandardAccessoriesStockOutCustom standardAccessoriesStockOutCustom,HttpSession session) throws Exception{
		WarStandardAccessoriesStockOut standardAccessoriesStockOut = new WarStandardAccessoriesStockOut();
		
		String id = UUIDBuild.getUUID();
		standardAccessoriesStockOutCustom.setId(id);
		standardAccessoriesStockOutCustom.setState("closed");
		
		SimpleDateFormat format = new SimpleDateFormat("yyMM");
		String stockOutNo = format.format(new Date());
		
		int maxStockOutNo = standardAccessoriesStockOutMapper.findMaxStockOutNo(stockOutNo);
		
		standardAccessoriesStockOutCustom.setStockOutNo("SC" + (Integer.parseInt(stockOutNo)*1000 + maxStockOutNo + 1));
		
		//开启工作流
		identityService.setAuthenticatedUserId(UserUtils.getUserFromSession(session).getLoginName());
		String processDefinitionKey =  ResourcesUtil.getValue("activiti", "standardAccessoriesStockOutProcessDefinitionKey");
		String businessKey = id;
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey);
		standardAccessoriesStockOutCustom.setProcessInstanceId(processInstance.getProcessInstanceId());
		
		BeanUtils.copyProperties(standardAccessoriesStockOut, standardAccessoriesStockOutCustom);
		
		int i = 0;
		
		i = i + standardAccessoriesStockOutMapper.insert(standardAccessoriesStockOut);
		
		List<WarStandardAccessoriesStockOutSubsidiaryCustom> standardAccessoriesStockOutSubsidiaryCustoms = standardAccessoriesStockOutCustom.getStandardAccessoriesStockOutSubsidiaryCustoms();
		List<WarStandardAccessoriesStockOutSubsidiary> standardAccessoriesStockOutSubsidiaries = new ArrayList<WarStandardAccessoriesStockOutSubsidiary>();
		
		if (standardAccessoriesStockOutSubsidiaryCustoms != null && standardAccessoriesStockOutSubsidiaryCustoms.size() > 0){
			for (WarStandardAccessoriesStockOutSubsidiaryCustom standardAccessoriesStockOutSubsidiaryCustom : standardAccessoriesStockOutSubsidiaryCustoms) {
				
				//根据物料Id查询库存与未审核完成的出库单的差值（也就是：库存量-占有量（未审核完成的出库单））
				int quantity = standardAccessoriesStockOutSubsidiaryMapper.calculateDifferencesQuantityForInventoryAndAllNotAuditCompletedByWarStandardAccessoriesId(standardAccessoriesStockOutSubsidiaryCustom.getWarStandardAccessoriesId(),null);
				
				if (quantity < standardAccessoriesStockOutSubsidiaryCustom.getQuantity()){
					throw new RuntimeException("库存不足！");
				}
				
				WarStandardAccessoriesStockOutSubsidiary standardAccessoriesStockOutSubsidiary = new WarStandardAccessoriesStockOutSubsidiary();
				
				standardAccessoriesStockOutSubsidiaryCustom.setId(UUIDBuild.getUUID());
				standardAccessoriesStockOutSubsidiaryCustom.setWarStandardAccessoriesStockOutId(id);
				
				BeanUtils.copyProperties(standardAccessoriesStockOutSubsidiary, standardAccessoriesStockOutSubsidiaryCustom);
				
				standardAccessoriesStockOutSubsidiaries.add(standardAccessoriesStockOutSubsidiary);
			}
		}else{
			throw new RuntimeException("没有添加任何出库物料");
		}
		
		i = i + standardAccessoriesStockOutSubsidiaryMapper.insertList(standardAccessoriesStockOutSubsidiaries);
		
		return i;
	}

	@Override
	public WarStandardAccessoriesStockOutCustom findWarStandardAccessoriesStockOutByIdForEdit(String id) throws Exception{
		WarStandardAccessoriesStockOutCustom standardAccessoriesStockOutCustom = new WarStandardAccessoriesStockOutCustom();
		
		WarStandardAccessoriesStockOut standardAccessoriesStockOut = standardAccessoriesStockOutMapper.selectByPrimaryKey(id);
		
		List<WarStandardAccessoriesStockOutSubsidiaryCustom> standardAccessoriesStockOutSubsidiaryCustoms = standardAccessoriesStockOutSubsidiaryMapper.findAllWarStandardAccessoriesStockOutSubsidiaryListByWarStandardAccessoriesStockOutId(id);
		
		BeanUtils.copyProperties(standardAccessoriesStockOutCustom, standardAccessoriesStockOut);
		standardAccessoriesStockOutCustom.setStandardAccessoriesStockOutSubsidiaryCustoms(standardAccessoriesStockOutSubsidiaryCustoms);
		
		return standardAccessoriesStockOutCustom;
	}

	@Override
	public int updateWarStandardAccessoriesStockOut(WarStandardAccessoriesStockOutCustom standardAccessoriesStockOutCustom)throws Exception {
		WarStandardAccessoriesStockOut standardAccessoriesStockOut = new WarStandardAccessoriesStockOut();
		
		standardAccessoriesStockOutCustom.setState("closed");
		
		BeanUtils.copyProperties(standardAccessoriesStockOut, standardAccessoriesStockOutCustom);
		
		int i = 0;
		
		i = i + standardAccessoriesStockOutMapper.updateByPrimaryKey(standardAccessoriesStockOut);

		List<WarStandardAccessoriesStockOutSubsidiaryCustom> standardAccessoriesStockOutSubsidiaryCustoms = standardAccessoriesStockOutCustom.getStandardAccessoriesStockOutSubsidiaryCustoms();
		List<WarStandardAccessoriesStockOutSubsidiary> standardAccessoriesStockOutSubsidiaries = new ArrayList<WarStandardAccessoriesStockOutSubsidiary>();
		
		if (standardAccessoriesStockOutSubsidiaryCustoms != null && standardAccessoriesStockOutSubsidiaryCustoms.size() > 0){
			for (WarStandardAccessoriesStockOutSubsidiaryCustom standardAccessoriesStockOutSubsidiaryCustom : standardAccessoriesStockOutSubsidiaryCustoms) {
				
				//根据物料Id查询库存与未审核完成的出库单的差值（也就是：库存量-占有量（未审核完成的出库单））
				int quantity = standardAccessoriesStockOutSubsidiaryMapper.calculateDifferencesQuantityForInventoryAndAllNotAuditCompletedByWarStandardAccessoriesId(standardAccessoriesStockOutSubsidiaryCustom.getWarStandardAccessoriesId(),standardAccessoriesStockOutCustom.getId());
				
				if (quantity < standardAccessoriesStockOutSubsidiaryCustom.getQuantity()){
					throw new RuntimeException("库存不足！");
				}
						
				WarStandardAccessoriesStockOutSubsidiary standardAccessoriesStockOutSubsidiary = new WarStandardAccessoriesStockOutSubsidiary();
				
				standardAccessoriesStockOutSubsidiaryCustom.setId(UUIDBuild.getUUID());
				standardAccessoriesStockOutSubsidiaryCustom.setWarStandardAccessoriesStockOutId(standardAccessoriesStockOut.getId());
				
				BeanUtils.copyProperties(standardAccessoriesStockOutSubsidiary, standardAccessoriesStockOutSubsidiaryCustom);
				
				standardAccessoriesStockOutSubsidiaries.add(standardAccessoriesStockOutSubsidiary);
			}
		}else{
			throw new RuntimeException("没有添加任何出库物料");
		}
		
		WarStandardAccessoriesStockOutSubsidiaryExample standardAccessoriesStockOutSubsidiaryExample = new WarStandardAccessoriesStockOutSubsidiaryExample();
		standardAccessoriesStockOutSubsidiaryExample.createCriteria().andWarStandardAccessoriesStockOutIdEqualTo(standardAccessoriesStockOut.getId());
		i = i + standardAccessoriesStockOutSubsidiaryMapper.deleteByExample(standardAccessoriesStockOutSubsidiaryExample);
		
		i = i + standardAccessoriesStockOutSubsidiaryMapper.insertList(standardAccessoriesStockOutSubsidiaries);
		
		return i;
	}

	@Override
	public int deleteWarStandardAccessoriesStockOutById(String id) {
		int i = 0;
		
		WarStandardAccessoriesStockOut standardAccessoriesStockOut = standardAccessoriesStockOutMapper.selectByPrimaryKey(id);
		String processInstanceId = standardAccessoriesStockOut.getProcessInstanceId();
		String processDefinitionKey = ResourcesUtil.getValue("activiti", "standardAccessoriesStockOutProcessDefinitionKey");
		TaskQuery taskQuery = taskService.createTaskQuery();
		taskQuery.processDefinitionKey(processDefinitionKey);//设置查询条件，当前模块的任务
		taskQuery.processInstanceId(processInstanceId);//设置查询条件，流程实例id
		Task task = taskQuery.singleResult();
		if (task != null){
			if (task.getTaskDefinitionKey().equals("createStockOut")){
				//删除正在运行的流程
				runtimeService.deleteProcessInstance(processInstanceId,""); 
				historyService.deleteHistoricProcessInstance(processInstanceId);//(顺序不能换) 
				//删除已经结束流程
				//historyService.deleteHistoricProcessInstance(procesInstanceId);
				
				WarStandardAccessoriesStockOutSubsidiaryExample standardAccessoriesStockOutSubsidiaryExample = new WarStandardAccessoriesStockOutSubsidiaryExample();
				standardAccessoriesStockOutSubsidiaryExample.createCriteria().andWarStandardAccessoriesStockOutIdEqualTo(id);
				i = i + standardAccessoriesStockOutSubsidiaryMapper.deleteByExample(standardAccessoriesStockOutSubsidiaryExample);
				
				i = i + standardAccessoriesStockOutMapper.deleteByPrimaryKey(id);
				
				return i;
			}else{
				throw new RuntimeException("流程在第一节点，才能进行删除");
			}
		}else{
			throw new RuntimeException("审核已经完成，无法进行删除");
		}
	}
	
	@Override
	public List<SysUser> queryAuditorByProcessInstanceId(String id, HttpSession session) {
		WarStandardAccessoriesStockOut standardAccessoriesStockOut = standardAccessoriesStockOutMapper.selectByPrimaryKey(id);
		String processInstanceId = standardAccessoriesStockOut.getProcessInstanceId();
		
		TaskQuery taskQuery = taskService.createTaskQuery();
		taskQuery.processInstanceId(processInstanceId);
		Task task = taskQuery.singleResult();
		if (task != null){
			if (task.getAssignee().equals(UserUtils.getUserFromSession(session).getLoginName())){//表示是当前任务的办理人
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
		        List<String> loginNames = new ArrayList<String>();
		        
		        if (taskDefinitions != null && taskDefinitions.size() > 0){
		        	for (TaskDefinition taskDefinition : taskDefinitions) {
		        		Set<Expression> expressions = taskDefinition.getCandidateUserIdExpressions();
				       
				        for (Expression expression : expressions) {
				        	String loginName = expression.getExpressionText();
				        	loginNames.add(loginName);
						}
					}
		        }
		        List<SysUser> users = new ArrayList<SysUser>();
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
			}else{
				throw new RuntimeException("对不起，您不是当前任务的办理人！");
			}
		}else{
			throw new RuntimeException("当前流程已经结束，不能审核");
		}
	}
	
	@Override
	public void auditWarStandardAccessoriesStockOut(String id, String assignee, HttpSession session) {
		WarStandardAccessoriesStockOut standardAccessoriesStockOut = standardAccessoriesStockOutMapper.selectByPrimaryKey(id);
		String processInstanceId = standardAccessoriesStockOut.getProcessInstanceId();
		
		TaskQuery taskQuery = taskService.createTaskQuery();
		taskQuery.processInstanceId(processInstanceId);
		Task task = taskQuery.singleResult();
		if (task != null){
			if (task.getAssignee().equals(UserUtils.getUserFromSession(session).getLoginName())){
		        /*//获取流程发布Id信息   
		        String definitionId = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getProcessDefinitionId();  
		          
		        ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)  
		                .getDeployedProcessDefinition(definitionId);  */
		          
		        ExecutionEntity execution = (ExecutionEntity) runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();  
		          
		        //当前流程节点Id信息   
		        String activitiId = execution.getActivityId();    
		        if (activitiId.equals("stockOut")){//相当于审批完成
		        	standardAccessoriesStockOut.setReviewer(UserUtils.getUserFromSession(session).getUsername());
		        	standardAccessoriesStockOut.setAuditTime(new Date());
		        	//把数量出库出去
		        	standardAccessoriesStockOutMapper.updateWarStandardAccessoriesInventoryByWarStandardAccessoriesStockOutIdForSubtract(id);
		        	
		        }
		        standardAccessoriesStockOutMapper.updateByPrimaryKey(standardAccessoriesStockOut);
				
				taskService.complete(task.getId());
				
				//发送消息
				SysMessage message = new SysMessage();
				message.setId(UUIDBuild.getUUID());
				message.setIsRead(false);
				
				StringBuffer buffer = new StringBuffer();
				buffer.append("出库单");
				buffer.append("<b>"+standardAccessoriesStockOut.getStockOutNo()+"</b>");
				
				if (StringUtils.isNotBlank(assignee)){
					List<Task> tasks = taskQuery.list();
					for (Task task2 : tasks) {
						List<IdentityLink> identityLinks =  taskService.getIdentityLinksForTask(task2.getId());
						List<String> userIds = new ArrayList<String>();
						for (IdentityLink identityLink : identityLinks) {
							userIds.add(identityLink.getUserId());
						}
						if (userIds.contains(assignee)){
							taskService.claim(task2.getId(), assignee);
						}else{
							throw new RuntimeException("评审候选人中没有您选择的评审人");
						}
						buffer.append("需要您审批，请及时处理！");
						message.setSender(UserUtils.getUserFromSession(session).getLoginName());
						message.setReceiver(assignee);
					}
				}else{//相当于审批完成
					buffer.append("审批已完成！");
					message.setSender("admin");
					HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
					//设置发起人为消息接收人
					message.setReceiver(processInstance.getStartUserId());
				}
	
				message.setMessage(buffer.toString());
				message.setSendTime(new Date());
				messageMapper.insert(message);
			}else{
				throw new RuntimeException("对不起，您不是当前任务的办理人，请刷新数据！");
			}
		}else{
			throw new RuntimeException("当前流程已经结束，不能审核");
		}
	}
	
	
	@Override
	public void rollBackWarStandardAccessoriesStockOut(String id, String cause, HttpSession session) {
		WarStandardAccessoriesStockOut standardAccessoriesStockOut = standardAccessoriesStockOutMapper.selectByPrimaryKey(id);
		String processInstanceId = standardAccessoriesStockOut.getProcessInstanceId();
		
		Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
		if (task != null){//流程没有结束
			if (task.getAssignee().equals(UserUtils.getUserFromSession(session).getLoginName())){
				// 取得当前任务.当前任务节点
				HistoricTaskInstance currTask = historyService.createHistoricTaskInstanceQuery().taskId(task.getId()).singleResult();
				// 取得流程实例，流程实例
				ProcessInstance instance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
			
				//查找历史审核记录
				List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery().
						processInstanceId(processInstanceId).orderByHistoricActivityInstanceStartTime().desc().list();
				if (list.size()>1){//表示存在上一节点，则可以退回
					//0是当前节点，1是上一节点
					String assignee = list.get(1).getAssignee();//获取上一节点的审核人
					String taskDefinitionKey = list.get(1).getTaskDefinitionKey();//上去上一节点的标识
					String prevTaskId = list.get(1).getId();//上一节点的ID,用于后面删除改历史消息
					
					//获取当前的流程变量
					Map<String, Object> variables = instance.getProcessVariables();
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
		           taskService.complete(task1.getId(), variables);
		           historyService.deleteHistoricTaskInstance(task1.getId());//删除当前节点的历史任务
		           historyService.deleteHistoricTaskInstance(prevTaskId);//删除上一节点的历史任务
		           Task task2 = taskQuery.singleResult();
		           taskService.claim(task2.getId(), assignee);//上一节点的人拾取任务
		           
		           
		           //发送消息
		           SysMessage message = new SysMessage();
		           message.setId(UUIDBuild.getUUID());
		           message.setIsRead(false);
		           
		           StringBuffer buffer = new StringBuffer();
		           buffer.append("出库单");
		           buffer.append("<b>"+standardAccessoriesStockOut.getStockOutNo()+"</b>");
		           buffer.append("的办理已被<b>"+UserUtils.getUserFromSession(session).getUsername()+"</b>退回，原因：<font color='red'>"+cause+"</font>，请重新办理！");
		           message.setMessage(buffer.toString());
		           message.setReceiver(assignee);
		           message.setSender("admin");
		           message.setSendTime(new Date());
		           messageMapper.insert(message);
		           if (taskDefinitionKey.equals("stockOut")){
		        	   standardAccessoriesStockOut.setReviewer(null);
		        	   standardAccessoriesStockOut.setAuditTime(null);
		           }
		          
		           standardAccessoriesStockOutMapper.updateByPrimaryKey(standardAccessoriesStockOut);
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
	public void takeBackWarStandardAccessoriesStockOut(String id, String cause, HttpSession session) {
		WarStandardAccessoriesStockOut standardAccessoriesStockOut = standardAccessoriesStockOutMapper.selectByPrimaryKey(id);
		String processInstanceId = standardAccessoriesStockOut.getProcessInstanceId();
		
		Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
		if (task != null){//流程没有结束
			//查找历史审核记录
			List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery().
					processInstanceId(processInstanceId).orderByHistoricActivityInstanceStartTime().desc().list();
			if (list.size()>1){//表示存在上一节点，则可以收回
				//0是当前节点，1是上一节点
				String assignee = list.get(1).getAssignee();//获取上一节点的审核人
				String taskDefinitionKey = list.get(1).getTaskDefinitionKey();//上去上一节点的标识
				String prevTaskId = list.get(1).getId();//上一节点的ID,用于后面删除改历史消息
				if (assignee.equals(UserUtils.getUserFromSession(session).getLoginName())){//表示当前收回的是上一节点的办理人
					// 取得当前任务.当前任务节点
					HistoricTaskInstance currTask = historyService.createHistoricTaskInstanceQuery().taskId(task.getId()).singleResult();
					// 取得流程实例，流程实例
					ProcessInstance instance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
					
					
					//获取当前的流程变量
					Map<String, Object> variables = instance.getProcessVariables();
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
		           taskService.complete(task1.getId(), variables);
		           historyService.deleteHistoricTaskInstance(task1.getId());//删除当前节点的历史任务
		           historyService.deleteHistoricTaskInstance(prevTaskId);//删除上一节点的历史任务
		           Task task2 = taskQuery.singleResult();
		           taskService.claim(task2.getId(), assignee);//上一节点的人拾取任务
		           

		           	//发送消息（发给被收回评审的人）
					SysMessage message = new SysMessage();
					message.setId(UUIDBuild.getUUID());
					message.setIsRead(false);
					
					StringBuffer buffer = new StringBuffer();
					buffer.append("出库单");
					buffer.append("<b>"+standardAccessoriesStockOut.getStockOutNo()+"</b>");
					buffer.append("的审核任务被<b>"+UserUtils.getUserFromSession(session).getUsername()+"</b>收回，原因：<font color='red'>"+cause+"</font>");
					message.setMessage(buffer.toString());
					message.setReceiver(task.getAssignee());
					message.setSender(assignee);
					message.setSendTime(new Date());
					messageMapper.insert(message);
		           
					if (taskDefinitionKey.equals("stockOut")){
						standardAccessoriesStockOut.setReviewer(null);
						standardAccessoriesStockOut.setAuditTime(null);
					}
					standardAccessoriesStockOutMapper.updateByPrimaryKey(standardAccessoriesStockOut);
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
	public void reAuditWarStandardAccessoriesStockOut(String id, String cause, HttpSession session) {
		WarStandardAccessoriesStockOut standardAccessoriesStockOut = standardAccessoriesStockOutMapper.selectByPrimaryKey(id);
		String processInstanceId = standardAccessoriesStockOut.getProcessInstanceId();
		
		String processDefinitionKey = ResourcesUtil.getValue("activiti", "standardAccessoriesStockOutProcessDefinitionKey");
		
		TaskQuery taskQuery = taskService.createTaskQuery();
		taskQuery.processDefinitionKey(processDefinitionKey);//设置查询条件，当前模块的任务
		taskQuery.processInstanceId(processInstanceId);//设置查询条件，流程实例id
		Task task = taskQuery.singleResult();
		if (task == null){//已完成
		
			HistoricTaskInstanceQuery historicTaskInstanceQuery = historyService.createHistoricTaskInstanceQuery();
			historicTaskInstanceQuery.processDefinitionKey(processDefinitionKey);
			historicTaskInstanceQuery.processInstanceId(processInstanceId);
			historicTaskInstanceQuery.orderByHistoricTaskInstanceStartTime().desc();
			List<HistoricTaskInstance> historicTaskInstances = historicTaskInstanceQuery.list();
			String assignee = "";//记录能反审的人
			String startAssignee = "";//记录发起审核的人（因为这里是最终审核人才能反审，所以assignee记录的是最终审核人）
			//List<String> assignees = new ArrayList<String>();//这样可能出现重复发消息
			HashSet<String> assignees = new HashSet<String>();//需要发送消息的人（流程进行到当前节点，当前节点的人没有审批，也发送消息通知，因为通知了他要审核）
			for (HistoricTaskInstance historicTaskInstance : historicTaskInstances) {//遍历流程历史记录
				if (historicTaskInstance.getTaskDefinitionKey().equals("stockOut")){//如果是最终的出库审核人
					assignee = historicTaskInstance.getAssignee();
				}else if (historicTaskInstance.getTaskDefinitionKey().equals("createStockOut")){
					startAssignee = historicTaskInstance.getAssignee();
					assignees.add(historicTaskInstance.getAssignee());//只需要通知他，但是还这么做，如果后期还要添加审核节点，可能就是通知多人，所以要添加到集合
				}
			}
			if (assignee.equals(UserUtils.getUserFromSession(session).getLoginName())){
			
				historyService.deleteHistoricProcessInstance(processInstanceId);//删除历史记录
				identityService.setAuthenticatedUserId(startAssignee);
				String businessKey = id;
				
				//从库中增加数量
				standardAccessoriesStockOutMapper.updateWarStandardAccessoriesInventoryByWarStandardAccessoriesStockOutIdForAdd(id);
				
				//发送消息
				List<SysMessage> messages = new ArrayList<SysMessage>();
				for (String receiver : assignees) {
					SysMessage message = new SysMessage();
					message.setId(UUIDBuild.getUUID());
					message.setIsRead(false);
					
					StringBuffer buffer = new StringBuffer();
					buffer.append("出库单");
					buffer.append("<b>"+standardAccessoriesStockOut.getStockOutNo()+"</b>");
					buffer.append("已被<b>"+UserUtils.getUserFromSession(session).getUsername()+"</b>重新开启审核，原因：<font color='red'>"+cause+"</font>");
					message.setMessage(buffer.toString());
					message.setReceiver(receiver);
					message.setSender("admin");
					message.setSendTime(new Date());
					messages.add(message);
				}
				messageMapper.insertList(messages);
				
				
				//并将所有审核人和审核时间清空，重新设置流程实例id
				ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey);
				standardAccessoriesStockOut.setProcessInstanceId(processInstance.getProcessInstanceId());
				standardAccessoriesStockOut.setReviewer(null);
				standardAccessoriesStockOut.setAuditTime(null);
				standardAccessoriesStockOutMapper.updateByPrimaryKey(standardAccessoriesStockOut);
			}else{
				//流程发起人不能重新开启审核，否则仓库管理有问题
				throw new RuntimeException("您不是流程的最终审核人，不能重新开启审核！");
			}
		}else{//未完成，则要删除正在运行的任务
			throw new RuntimeException("审核未完成无法重新开始审核");
		}
	}
}
