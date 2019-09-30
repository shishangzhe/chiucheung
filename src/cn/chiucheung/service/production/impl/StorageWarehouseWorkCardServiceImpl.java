package cn.chiucheung.service.production.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chiucheung.dao.mapper.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardMapper;
import cn.chiucheung.dao.mapper.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardSubsidiaryMapper;
import cn.chiucheung.dao.mapper.system.message.SysMessageMapper;
import cn.chiucheung.dao.mapper.system.user.SysUserMapper;
import cn.chiucheung.po.production.storagewarehouseworkcard.ProStorageWarehouseWorkCard;
import cn.chiucheung.po.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardSubsidiary;
import cn.chiucheung.po.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardSubsidiaryExample;
import cn.chiucheung.po.system.message.SysMessage;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.po.warehouse.storagewarehouseworkcardstockin.WarStorageWarehouseWorkCardStockInSubsidiary;
import cn.chiucheung.pojo.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardCustom;
import cn.chiucheung.pojo.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardQueryVo;
import cn.chiucheung.pojo.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardShowDataCustom;
import cn.chiucheung.pojo.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardSubsidiaryShowDataCustom;
import cn.chiucheung.pojo.system.user.SysUserQueryVo;
import cn.chiucheung.service.production.StorageWarehouseWorkCardService;
import cn.chiucheung.utils.ActivitiUtils;
import cn.chiucheung.utils.ResourcesUtil;
import cn.chiucheung.utils.UUIDBuild;
import cn.chiucheung.utils.UserUtils;

@Service
public class StorageWarehouseWorkCardServiceImpl implements StorageWarehouseWorkCardService{
	
	@Autowired
	private ProStorageWarehouseWorkCardMapper storageWarehouseWorkCardMapper;
	
	@Autowired
	private ProStorageWarehouseWorkCardSubsidiaryMapper storageWarehouseWorkCardSubsidiaryMapper;
	
	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private SysMessageMapper messageMapper;

	@Override
	public int saveProStorageWarehouseWorkCard(ProStorageWarehouseWorkCardCustom storageWarehouseWorkCardCustom, HttpSession session) throws Exception{
		List<ProStorageWarehouseWorkCardSubsidiary> storageWarehouseWorkCardSubsidiaries = storageWarehouseWorkCardCustom.getStorageWarehouseWorkCardSubsidiaries();
		if (storageWarehouseWorkCardSubsidiaries != null && storageWarehouseWorkCardSubsidiaries.size() > 0){
			String id = UUIDBuild.getUUID();
			storageWarehouseWorkCardCustom.setId(id);
			storageWarehouseWorkCardCustom.setPreparer(UserUtils.getUserFromSession(session).getUsername());
			storageWarehouseWorkCardCustom.setState("closed");
			storageWarehouseWorkCardCustom.setProcessInstanceId(null);
			
			ProStorageWarehouseWorkCard storageWarehouseWorkCard = new ProStorageWarehouseWorkCard();
			
			BeanUtils.copyProperties(storageWarehouseWorkCard, storageWarehouseWorkCardCustom);
			
			int i = 0;
			
			i = i + storageWarehouseWorkCardMapper.insert(storageWarehouseWorkCard);
			
			
			for (ProStorageWarehouseWorkCardSubsidiary storageWarehouseWorkCardSubsidiary : storageWarehouseWorkCardSubsidiaries) {
				storageWarehouseWorkCardSubsidiary.setId(UUIDBuild.getUUID());
				storageWarehouseWorkCardSubsidiary.setProStorageWarehouseWorkCardId(id);
			}
			i = i + storageWarehouseWorkCardSubsidiaryMapper.insertList(storageWarehouseWorkCardSubsidiaries);
			
			return i;
		}else{
			throw new RuntimeException("请至少添加一个物料");
		}
	}

	@Override
	public List<ProStorageWarehouseWorkCardShowDataCustom> findAllProStorageWarehouseWorkCardList(ProStorageWarehouseWorkCardQueryVo storageWarehouseWorkCardQueryVo) {
		return storageWarehouseWorkCardMapper.findAllProStorageWarehouseWorkCardList(storageWarehouseWorkCardQueryVo);
	}

	@Override
	public String findAllProStorageWarehouseWorkCardTotal(ProStorageWarehouseWorkCardQueryVo storageWarehouseWorkCardQueryVo) {
		return storageWarehouseWorkCardMapper.findAllProStorageWarehouseWorkCardTotal(storageWarehouseWorkCardQueryVo);
	}

	@Override
	public List<ProStorageWarehouseWorkCardSubsidiaryShowDataCustom> findAllProStorageWarehouseWorkCardSubsidiaryListByProStorageWarehouseWorkCardId(String proStorageWarehouseWorkCardQueryId) {
		return storageWarehouseWorkCardSubsidiaryMapper.findAllProStorageWarehouseWorkCardSubsidiaryListByProStorageWarehouseWorkCardId(proStorageWarehouseWorkCardQueryId);
	}

	@Override
	public Map<String, Object> findProStorageWarehouseWorkCardByIdForView(String id) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		
		ProStorageWarehouseWorkCard storageWarehouseWorkCard = storageWarehouseWorkCardMapper.selectByPrimaryKey(id);
		map.put("storageWarehouseWorkCard", storageWarehouseWorkCard);
		
		List<ProStorageWarehouseWorkCardSubsidiaryShowDataCustom> storageWarehouseWorkCardSubsidiaryShowDataCustoms = findAllProStorageWarehouseWorkCardSubsidiaryListByProStorageWarehouseWorkCardId(id);
		map.put("storageWarehouseWorkCardSubsidiary", storageWarehouseWorkCardSubsidiaryShowDataCustoms);
		
		return map;
	}
	
	@Override
	public Map<String,Object> findProStorageWarehouseWorkCardByIdForEdit(String id, HttpSession session) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		ProStorageWarehouseWorkCard storageWarehouseWorkCard = storageWarehouseWorkCardMapper.selectByPrimaryKey(id);
		map.put("storageWarehouseWorkCard", storageWarehouseWorkCard);
		
		if(storageWarehouseWorkCard.getProcessInstanceId() != null){
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(storageWarehouseWorkCard.getProcessInstanceId());//设置查询条件，流程实例id
			Task task = taskQuery.singleResult();
			if (task != null){//流程进行中！
				if (task.getAssignee().equals(UserUtils.getUserFromSession(session).getAssignee())){//当前审核人才能修改
					map.put("isEdit", true);
				}else{
					map.put("isEdit", false);
					map.put("doNotEditMessage", "您不是当前审核人");
				}
			}else{//流程已结束
				map.put("isEdit", false);
				map.put("doNotEditMessage", "流程已结束");
			}
		}else{
			map.put("isEdit", true);
		}
		
		List<ProStorageWarehouseWorkCardSubsidiaryShowDataCustom> storageWarehouseWorkCardSubsidiaryShowDataCustoms = findAllProStorageWarehouseWorkCardSubsidiaryListByProStorageWarehouseWorkCardId(id);
		map.put("storageWarehouseWorkCardSubsidiary", storageWarehouseWorkCardSubsidiaryShowDataCustoms);
		
		return map;
	};

	@Override
	public int updateProStorageWarehouseWorkCard(ProStorageWarehouseWorkCardCustom storageWarehouseWorkCardCustom, HttpSession session) throws Exception{
		String processInstanceId = storageWarehouseWorkCardCustom.getProcessInstanceId();
		
		if (StringUtils.isNotBlank(processInstanceId)){//开启审核流程，则需要知道修改人是否是当前审核人
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(processInstanceId);//设置查询条件，流程实例id
			Task task = taskQuery.singleResult();
			if (task != null){//流程进行中！
				if (!task.getAssignee().equals(UserUtils.getUserFromSession(session).getAssignee())){//当前审核人才能修改
					throw new RuntimeException("您不是当前审核人，不能修改");
				}
			}else{//流程已结束
				throw new RuntimeException("流程已结束，不能修改");
			}
		}else{
			storageWarehouseWorkCardCustom.setProcessInstanceId(null);
		}
		
		List<ProStorageWarehouseWorkCardSubsidiary> storageWarehouseWorkCardSubsidiaries = storageWarehouseWorkCardCustom.getStorageWarehouseWorkCardSubsidiaries();
		
		if (storageWarehouseWorkCardSubsidiaries != null && storageWarehouseWorkCardSubsidiaries.size() > 0){
			storageWarehouseWorkCardCustom.setState("closed");
			
			ProStorageWarehouseWorkCard storageWarehouseWorkCard = new ProStorageWarehouseWorkCard();
			
			BeanUtils.copyProperties(storageWarehouseWorkCard, storageWarehouseWorkCardCustom);
			
			int i = 0;
			
			i = i + storageWarehouseWorkCardMapper.updateByPrimaryKey(storageWarehouseWorkCard);
			
			//先删除
			ProStorageWarehouseWorkCardSubsidiaryExample storageWarehouseWorkCardSubsidiaryExample = new ProStorageWarehouseWorkCardSubsidiaryExample();
			storageWarehouseWorkCardSubsidiaryExample.createCriteria().andProStorageWarehouseWorkCardIdEqualTo(storageWarehouseWorkCard.getId());
			storageWarehouseWorkCardSubsidiaryMapper.deleteByExample(storageWarehouseWorkCardSubsidiaryExample);
			//在添加
			for (ProStorageWarehouseWorkCardSubsidiary storageWarehouseWorkCardSubsidiary : storageWarehouseWorkCardSubsidiaries) {
				storageWarehouseWorkCardSubsidiary.setId(UUIDBuild.getUUID());
				storageWarehouseWorkCardSubsidiary.setProStorageWarehouseWorkCardId(storageWarehouseWorkCard.getId());
			}
			i = i + storageWarehouseWorkCardSubsidiaryMapper.insertList(storageWarehouseWorkCardSubsidiaries);
			
			return i;
		}else{
			throw new RuntimeException("请至少添加一个配件");
		}
		
		/*String processDefinitionKey = ResourcesUtil.getValue("activiti", "storageWarehouseWorkCardProcessDefinitionKey");
		TaskQuery taskQuery = taskService.createTaskQuery();
		taskQuery.processDefinitionKey(processDefinitionKey);//设置查询条件，当前模块的任务
		taskQuery.processInstanceId(storageWarehouseWorkCardCustom.getProcessInstanceId());//设置查询条件，流程实例id
		Task task = taskQuery.singleResult();
		if (task != null){
			List<ProStorageWarehouseWorkCardSubsidiary> storageWarehouseWorkCardSubsidiaries = storageWarehouseWorkCardCustom.getStorageWarehouseWorkCardSubsidiaries();
			
			if (storageWarehouseWorkCardSubsidiaries != null && storageWarehouseWorkCardSubsidiaries.size() > 0){
				storageWarehouseWorkCardCustom.setState("closed");
				
				ProStorageWarehouseWorkCard storageWarehouseWorkCard = new ProStorageWarehouseWorkCard();
				
				BeanUtils.copyProperties(storageWarehouseWorkCard, storageWarehouseWorkCardCustom);
				
				int i = 0;
				
				i = i + storageWarehouseWorkCardMapper.updateByPrimaryKey(storageWarehouseWorkCard);
				
				//先删除
				ProStorageWarehouseWorkCardSubsidiaryExample storageWarehouseWorkCardSubsidiaryExample = new ProStorageWarehouseWorkCardSubsidiaryExample();
				storageWarehouseWorkCardSubsidiaryExample.createCriteria().andProStorageWarehouseWorkCardIdEqualTo(storageWarehouseWorkCard.getId());
				storageWarehouseWorkCardSubsidiaryMapper.deleteByExample(storageWarehouseWorkCardSubsidiaryExample);
				//在添加
				for (ProStorageWarehouseWorkCardSubsidiary storageWarehouseWorkCardSubsidiary : storageWarehouseWorkCardSubsidiaries) {
					storageWarehouseWorkCardSubsidiary.setId(UUIDBuild.getUUID());
					storageWarehouseWorkCardSubsidiary.setProStorageWarehouseWorkCardId(storageWarehouseWorkCard.getId());
				}
				i = i + storageWarehouseWorkCardSubsidiaryMapper.insertList(storageWarehouseWorkCardSubsidiaries);
				
				return i;
			}else{
				throw new RuntimeException("请至少添加一个配件");
			}
		}else{
			throw new RuntimeException("审核已经完成，无法进行修改");
		}*/
	}

	@Override
	public int deleteProStorageWarehouseWorkCardById(String id) {
		ProStorageWarehouseWorkCard storageWarehouseWorkCard = storageWarehouseWorkCardMapper.selectByPrimaryKey(id);
		
		String processInstanceId = storageWarehouseWorkCard.getProcessInstanceId();
		if (StringUtils.isNotBlank(processInstanceId)){
			throw new RuntimeException("已开启审核，不能删除");
		}
		
				
		int i = 0;
		ProStorageWarehouseWorkCardSubsidiaryExample storageWarehouseWorkCardSubsidiaryExample = new ProStorageWarehouseWorkCardSubsidiaryExample();
		storageWarehouseWorkCardSubsidiaryExample.createCriteria().andProStorageWarehouseWorkCardIdEqualTo(id);
		i = i + storageWarehouseWorkCardSubsidiaryMapper.deleteByExample(storageWarehouseWorkCardSubsidiaryExample);
		
		i = i + storageWarehouseWorkCardMapper.deleteByPrimaryKey(id);
		return i;
	}
	
	
	/*@Override
	public List<SysUser> queryAuditorByProcessInstanceId(String id, HttpSession session) {
		ProStorageWarehouseWorkCard storageWarehouseWorkCard = storageWarehouseWorkCardMapper.selectByPrimaryKey(id);
		String processInstanceId = storageWarehouseWorkCard.getProcessInstanceId();
		
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
	}*/
	
	@Override
	public List<SysUser> queryAuditorById(String id, String processInstanceId, HttpSession session) {
		if (StringUtils.isBlank(processInstanceId)){
			ProStorageWarehouseWorkCard storageWarehouseWorkCard = storageWarehouseWorkCardMapper.selectByPrimaryKey(id);
			processInstanceId = storageWarehouseWorkCard.getProcessInstanceId();
		}
		List<String> loginNames = new ArrayList<String>();
		
		List<SysUser> users = new ArrayList<SysUser>();
		
		if (StringUtils.isNotBlank(processInstanceId)){//已经开始了任务
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(processInstanceId);
			Task task = taskQuery.singleResult();
			if (task != null){
				if (task.getAssignee().equals(UserUtils.getUserFromSession(session).getAssignee())){//表示是当前任务的办理人
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
			        loginNames = new ArrayList<String>();
			        
			        if (taskDefinitions != null && taskDefinitions.size() > 0){
			        	for (TaskDefinition taskDefinition : taskDefinitions) {
			        		Set<Expression> expressions = taskDefinition.getCandidateUserIdExpressions();
					       
					        for (Expression expression : expressions) {
					        	String loginName = expression.getExpressionText();
					        	loginNames.add(loginName);
							}
						}
			        }
				}else{
					throw new RuntimeException("对不起，您不是当前任务的办理人！");
				}
			}else{
				throw new RuntimeException("当前流程已经结束，不能审核");
			}
		}else{//未开启任务
			String processDefinitionKey =  ResourcesUtil.getValue("activiti", "storageWarehouseWorkCardProcessDefinitionKey");
			
			loginNames = ActivitiUtils.getCandidateUsers(repositoryService, processDefinitionKey);
		}
		
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
	}
	
	@Override
	public void auditProStorageWarehouseWorkCard(String id, String assigneeId, HttpSession session) {
		ProStorageWarehouseWorkCard storageWarehouseWorkCard = storageWarehouseWorkCardMapper.selectByPrimaryKey(id);
		String processInstanceId = storageWarehouseWorkCard.getProcessInstanceId();
		
		List<SysUser> users = queryAuditorById(id, processInstanceId, session);
		
		//发送消息
		SysMessage message = new SysMessage();
		message.setId(UUIDBuild.getUUID());
		message.setIsRead(false);
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("存仓工咭");
		buffer.append("<b>");
		buffer.append(storageWarehouseWorkCard.getWorkCardNo());
		buffer.append("</b>");
		
		
		if (StringUtils.isNotBlank(processInstanceId)){//已经开始了任务
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(processInstanceId);
			Task task = taskQuery.singleResult();
			if (task != null){
				if (task.getAssignee().equals(UserUtils.getUserFromSession(session).getAssignee())){
					if (StringUtils.isNotBlank(assigneeId)){//
						SysUser assigneeUser = null;
						for (SysUser sysUser : users) {
							if (assigneeId.equals(sysUser.getId())){//说明要发送给下一节点的人包含在下一节点的候选人中
								assigneeUser = sysUser;
								break;
							}
						}
						if (assigneeUser != null){
							ExecutionEntity execution = (ExecutionEntity) runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
							
							//当前流程节点Id信息   
							String activitiId = execution.getActivityId();
							if (activitiId.equals("workCardLeaderReviewer")){
								storageWarehouseWorkCard.setWorkCardLeader(UserUtils.getUserFromSession(session).getUsername());
								storageWarehouseWorkCardMapper.updateByPrimaryKey(storageWarehouseWorkCard);
							}else if (activitiId.equals("generalManagerReviewer")){
								storageWarehouseWorkCard.setSigner(UserUtils.getUserFromSession(session).getUsername());
								storageWarehouseWorkCardMapper.updateByPrimaryKey(storageWarehouseWorkCard);
							}
							
							
							
							taskService.complete(task.getId());
							task = taskQuery.singleResult();
							taskService.claim(task.getId(), assigneeUser.getAssignee());
							buffer.append("需要您审核，请及时处理！");
							
							message.setSender(UserUtils.getUserFromSession(session).getLoginName());
							message.setReceiver(assigneeUser.getLoginName());
						}else{
							throw new RuntimeException("节点候选人员中不包含您选择接收任务的人员");
						}
					}else{//如果是最后一个节点
						if (users != null && users.size() > 0){
							throw new RuntimeException("没有选择接收任务的人员");
						}else{
							storageWarehouseWorkCard.setProLeader(UserUtils.getUserFromSession(session).getUsername());
							storageWarehouseWorkCardMapper.updateByPrimaryKey(storageWarehouseWorkCard);
							
							taskService.complete(task.getId());
							
							buffer.append("的审核已完成！");
							
							message.setSender("admin");
							HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
							//设置发起人为消息接收人
							message.setReceiver(processInstance.getStartUserId().substring(processInstance.getStartUserId().indexOf("(") + 1,processInstance.getStartUserId().indexOf(")")));
						}
					}
				}else{
					throw new RuntimeException("对不起，您不是当前任务的办理人，请刷新数据！");
				}
			}else{
				throw new RuntimeException("当前流程已经结束，不能审核");
			}
			
		}else{//未开启任务
			if (StringUtils.isBlank(assigneeId)){
				throw new RuntimeException("没有选择接收任务的人员");
			}
			
			SysUser assigneeUser = null;
			for (SysUser sysUser : users) {
				if (assigneeId.equals(sysUser.getId())){//说明要发送给下一节点的人包含在下一节点的候选人中
					assigneeUser = sysUser;
					break;
				}
			}
			if (assigneeUser == null){
				throw new RuntimeException("节点候选人员中不包含您选择接收任务的人员");
			}
			
			identityService.setAuthenticatedUserId(UserUtils.getUserFromSession(session).getAssignee());
			String processDefinitionKey =  ResourcesUtil.getValue("activiti", "storageWarehouseWorkCardProcessDefinitionKey");
			String businessKey = id;
			ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey);
			processInstanceId = processInstance.getProcessInstanceId();
			storageWarehouseWorkCard.setProcessInstanceId(processInstanceId);
			
			storageWarehouseWorkCardMapper.updateByPrimaryKey(storageWarehouseWorkCard);
			
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(processInstanceId);
			Task task = taskQuery.singleResult();
			
			taskService.complete(task.getId());//发起人立刻完成任务，发送到下一节点
			
			task = taskQuery.singleResult();
			
			taskService.claim(task.getId(), assigneeUser.getAssignee());
			
			buffer.append("需要您审核，请及时处理！");
			
			message.setSender(UserUtils.getUserFromSession(session).getLoginName());
			message.setReceiver(assigneeUser.getLoginName());
		}
		
		message.setMessage(buffer.toString());
		message.setSendTime(new Date());
		messageMapper.insert(message);
	}
	
	@Override
	public void revokeProcess(String id, HttpSession session) {
		ProStorageWarehouseWorkCard storageWarehouseWorkCard = storageWarehouseWorkCardMapper.selectByPrimaryKey(id);
		String processInstanceId = storageWarehouseWorkCard.getProcessInstanceId();
		
		if (StringUtils.isNotBlank(processInstanceId)){
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(processInstanceId);//设置查询条件，流程实例id
			Task task = taskQuery.singleResult();
			
			if (task == null){//已完成
				throw new RuntimeException("审核已完成，无法撤销");
			}else{
				HistoricTaskInstanceQuery historicTaskInstanceQuery = historyService.createHistoricTaskInstanceQuery();
				historicTaskInstanceQuery.processInstanceId(processInstanceId);
				List<HistoricTaskInstance> historicTaskInstances = historicTaskInstanceQuery.list();
				
				if (historicTaskInstances.get(0).getAssignee().equals(UserUtils.getUserFromSession(session).getAssignee())){
					//发送消息
					List<SysMessage> messages = new ArrayList<SysMessage>();
					
					for (HistoricTaskInstance historicTaskInstance : historicTaskInstances) {
						String assignee = historicTaskInstance.getAssignee();
						if (!historicTaskInstances.get(0).getAssignee().equals(assignee)){//不给自己发
							SysMessage message = new SysMessage();
							message.setId(UUIDBuild.getUUID());
							message.setIsRead(false);
							
							StringBuffer buffer = new StringBuffer();
							
							buffer.append("存仓工咭");
							buffer.append("<b>");
							buffer.append(storageWarehouseWorkCard.getWorkCardNo());
							buffer.append("</b>");
							buffer.append("的审核流程，被<b>");
							buffer.append(UserUtils.getUserFromSession(session).getAssignee());
							buffer.append("</b>撤销");
							message.setMessage(buffer.toString());
							
							message.setSender(UserUtils.getUserFromSession(session).getLoginName());
							
							message.setReceiver(assignee.substring(assignee.indexOf("(") + 1, assignee.indexOf(")")));
							
							message.setSendTime(new Date());
							
							if (!messages.contains(message)){
								messages.add(message);
							}
						}
					}
					if (messages != null && messages.size() > 0){
						messageMapper.insertList(messages);
					}
					
					//删除正在运行的流程
					runtimeService.deleteProcessInstance(processInstanceId,""); 
					//删除已经结束流程，也就是历史流程
					historyService.deleteHistoricProcessInstance(processInstanceId);//(顺序不能换) 
					
					storageWarehouseWorkCard.setWorkCardLeader("");
					storageWarehouseWorkCard.setSigner("");
					storageWarehouseWorkCard.setProLeader("");
					
					storageWarehouseWorkCard.setProcessInstanceId(null);
					storageWarehouseWorkCardMapper.updateByPrimaryKey(storageWarehouseWorkCard);
					
				}else{
					throw new RuntimeException("您不是流程发起人，无法撤销");
				}
			}
		}else{
			throw new RuntimeException("没有开启审核流程");
		}
	}
	
	
	
	
	@Override
	public void takeBackProStorageWarehouseWorkCard(String id, String cause, HttpSession session) {
		ProStorageWarehouseWorkCard storageWarehouseWorkCard = storageWarehouseWorkCardMapper.selectByPrimaryKey(id);
		String processInstanceId = storageWarehouseWorkCard.getProcessInstanceId();
		
		Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
		if (task != null){//流程没有结束
			//查找历史审核记录
			List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId).list();
			if (list.size()>1){//表示存在上一节点，则可以收回
				//list.size()-1是当前节点，list.size()-2是上一节点
				String assignee = list.get(list.size()-2).getAssignee();//获取上一节点的审核人
				String taskDefinitionKey = list.get(list.size()-2).getTaskDefinitionKey();//上去上一节点的标识
				String prevTaskId = list.get(list.size()-2).getId();//上一节点的ID,用于后面删除改历史消息
				if (assignee.equals(UserUtils.getUserFromSession(session).getAssignee())){//表示当前收回的是上一节点的办理人
					// 取得当前任务.当前任务节点
					HistoricTaskInstance currTask = historyService.createHistoricTaskInstanceQuery().taskId(task.getId()).singleResult();
					// 取得流程实例，流程实例
					ProcessInstance instance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
					
					
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
					taskService.complete(task1.getId());
					historyService.deleteHistoricTaskInstance(task1.getId());//删除当前节点的历史任务
					historyService.deleteHistoricTaskInstance(prevTaskId);//删除上一节点的历史任务
					Task task2 = taskQuery.singleResult();
					taskService.claim(task2.getId(), assignee);//上一节点的人拾取任务
					
					
					
					//发送消息（发给被收回评审的人）
					SysMessage message = new SysMessage();
					message.setId(UUIDBuild.getUUID());
					message.setIsRead(false);
					
					StringBuffer buffer = new StringBuffer();
					buffer.append("存仓工咭");
					buffer.append("<b>");
					buffer.append(storageWarehouseWorkCard.getWorkCardNo());
					buffer.append("</b>");
					buffer.append("的审核流程，被<b>");
					buffer.append(UserUtils.getUserFromSession(session).getAssignee());
					buffer.append("</b>收回，原因：<font color='red'>");
					buffer.append(cause);
					buffer.append("</font>");
					message.setMessage(buffer.toString());
					
					message.setSender(UserUtils.getUserFromSession(session).getLoginName());
					
					message.setReceiver(task.getAssignee().substring(task.getAssignee().indexOf("(") + 1, task.getAssignee().indexOf(")")));
					
					message.setSendTime(new Date());
					messageMapper.insert(message);
					
					if (taskDefinitionKey.equals("workCardLeaderReviewer")){
						storageWarehouseWorkCard.setWorkCardLeader("");
						storageWarehouseWorkCardMapper.updateByPrimaryKey(storageWarehouseWorkCard);
					}else if (taskDefinitionKey.equals("generalManagerReviewer")){
						storageWarehouseWorkCard.setSigner("");
						storageWarehouseWorkCardMapper.updateByPrimaryKey(storageWarehouseWorkCard);
					}else if (taskDefinitionKey.equals("notifyPro")){
						storageWarehouseWorkCard.setProLeader("");
						storageWarehouseWorkCardMapper.updateByPrimaryKey(storageWarehouseWorkCard);
					}
		           
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
	public void rollBackProStorageWarehouseWorkCard(String id, String cause, HttpSession session) {
		ProStorageWarehouseWorkCard storageWarehouseWorkCard = storageWarehouseWorkCardMapper.selectByPrimaryKey(id);
		String processInstanceId = storageWarehouseWorkCard.getProcessInstanceId();
		
		Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
		if (task != null){//流程没有结束
			if (task.getAssignee().equals(UserUtils.getUserFromSession(session).getAssignee())){
				// 取得当前任务.当前任务节点
				HistoricTaskInstance currTask = historyService.createHistoricTaskInstanceQuery().taskId(task.getId()).singleResult();
				// 取得流程实例，流程实例
				ProcessInstance instance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
			
				//查找历史审核记录
				List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery().processInstanceId(processInstanceId).list();
				if (list.size()>1){//表示存在上一节点，则可以退回
					//list.size()-1是当前节点，list.size()-2是上一节点
					String assignee = list.get(list.size()-2).getAssignee();//获取上一节点的审核人
					String taskDefinitionKey = list.get(list.size()-2).getTaskDefinitionKey();//上去上一节点的标识
					String prevTaskId = list.get(list.size()-2).getId();//上一节点的ID,用于后面删除改历史消息
					
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
					taskService.complete(task1.getId());
					historyService.deleteHistoricTaskInstance(task1.getId());//删除当前节点的历史任务
					historyService.deleteHistoricTaskInstance(prevTaskId);//删除上一节点的历史任务
					Task task2 = taskQuery.singleResult();
					taskService.claim(task2.getId(), assignee);//上一节点的人拾取任务
					
					//发送消息（发给被收回评审的人）
					SysMessage message = new SysMessage();
					message.setId(UUIDBuild.getUUID());
					message.setIsRead(false);
					
					StringBuffer buffer = new StringBuffer();
					buffer.append("存仓工咭");
					buffer.append("<b>");
					buffer.append(storageWarehouseWorkCard.getWorkCardNo());
					buffer.append("</b>");
					buffer.append("的审核流程，被<b>");
					buffer.append(UserUtils.getUserFromSession(session).getAssignee());
					buffer.append("</b>退回，原因：<font color='red'>");
					buffer.append(cause);
					buffer.append("</font>");
					message.setMessage(buffer.toString());
					
					message.setSender(UserUtils.getUserFromSession(session).getLoginName());
					
					message.setReceiver(assignee.substring(assignee.indexOf("(") + 1, assignee.indexOf(")")));
					
					message.setSendTime(new Date());
					messageMapper.insert(message);
					
					if (taskDefinitionKey.equals("workCardLeaderReviewer")){
						storageWarehouseWorkCard.setWorkCardLeader("");
						storageWarehouseWorkCardMapper.updateByPrimaryKey(storageWarehouseWorkCard);
					}else if (taskDefinitionKey.equals("generalManagerReviewer")){
						storageWarehouseWorkCard.setSigner("");
						storageWarehouseWorkCardMapper.updateByPrimaryKey(storageWarehouseWorkCard);
					}else if (taskDefinitionKey.equals("notifyPro")){
						storageWarehouseWorkCard.setProLeader("");
						storageWarehouseWorkCardMapper.updateByPrimaryKey(storageWarehouseWorkCard);
					}
					
					
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
	public void antiAuditProStorageWarehouseWorkCard(String id, String cause, HttpSession session) {
		ProStorageWarehouseWorkCard storageWarehouseWorkCard = storageWarehouseWorkCardMapper.selectByPrimaryKey(id);
		String processInstanceId = storageWarehouseWorkCard.getProcessInstanceId();
		
		TaskQuery taskQuery = taskService.createTaskQuery();
		taskQuery.processInstanceId(processInstanceId);//设置查询条件，流程实例id
		Task task = taskQuery.singleResult();
		
		if (task == null){//已完成
			
			List<WarStorageWarehouseWorkCardStockInSubsidiary> storageWarehouseWorkCardStockInSubsidiaries = storageWarehouseWorkCardMapper.findWarStorageWarehouseWorkCardStockInSubsidiariesByProStorageWarehouseWorkCardId(id);
			if (storageWarehouseWorkCardStockInSubsidiaries != null && storageWarehouseWorkCardStockInSubsidiaries.size() > 0){
				throw new RuntimeException("已经关联了存仓入库单");
			}
			
			HistoricTaskInstanceQuery historicTaskInstanceQuery = historyService.createHistoricTaskInstanceQuery();
			historicTaskInstanceQuery.processInstanceId(processInstanceId);
			historicTaskInstanceQuery.orderByHistoricTaskInstanceStartTime().desc();
			List<HistoricTaskInstance> historicTaskInstances = historicTaskInstanceQuery.list();
			//List<String> assignees = new ArrayList<String>();//这样可能出现重复发消息
			HashSet<String> assignees = new HashSet<String>();//需要发送消息的人（流程进行到当前节点，当前节点的人没有审批，也发送消息通知，因为通知了他要审核）
			for (HistoricTaskInstance historicTaskInstance : historicTaskInstances) {//遍历流程历史记录，获取流程每个节点的审核人员
				assignees.add(historicTaskInstance.getAssignee());
			}
			
			assignees.remove(UserUtils.getUserFromSession(session).getAssignee());//不需要发消息给自己
				
			historyService.deleteHistoricProcessInstance(processInstanceId);//删除历史记录
			
			//发送消息
			List<SysMessage> messages = new ArrayList<SysMessage>();
			for (String receiver : assignees) {
				SysMessage message = new SysMessage();
				message.setId(UUIDBuild.getUUID());
				message.setIsRead(false);
				
				StringBuffer buffer = new StringBuffer();
				buffer.append("存仓工咭");
				buffer.append("<b>");
				buffer.append(storageWarehouseWorkCard.getWorkCardNo());
				buffer.append("</b>");
				buffer.append("的审核流程，被<b>");
				buffer.append(UserUtils.getUserFromSession(session).getAssignee());
				buffer.append("</b>反审核，原因：<font color='red'>");
				buffer.append(cause);
				buffer.append("</font>");
				message.setMessage(buffer.toString());
				
				message.setSender(UserUtils.getUserFromSession(session).getLoginName());
				
				message.setReceiver(receiver.substring(receiver.indexOf("(") + 1, receiver.indexOf(")")));
				
				message.setSendTime(new Date());
				
				if (!messages.contains(message)){
					messages.add(message);
				}
			}
			
			if (messages != null && messages.size() > 0){
				messageMapper.insertList(messages);
			}
			
			storageWarehouseWorkCard.setWorkCardLeader("");
			storageWarehouseWorkCard.setSigner("");
			storageWarehouseWorkCard.setProLeader("");
			
			//并将所有审核人和审核时间清空，重新设置流程实例id
			storageWarehouseWorkCard.setProcessInstanceId(null);
			storageWarehouseWorkCardMapper.updateByPrimaryKey(storageWarehouseWorkCard);
		}else{
			throw new RuntimeException("审核未完成无法反审核");
		}
	}

}
