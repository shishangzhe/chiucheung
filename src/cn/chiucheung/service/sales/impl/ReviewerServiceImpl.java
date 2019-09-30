package cn.chiucheung.service.sales.impl;

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

import cn.chiucheung.dao.mapper.market.costbudget.MarCostBudgetMapper;
import cn.chiucheung.dao.mapper.sales.reviewer.SalReviewerFileMapper;
import cn.chiucheung.dao.mapper.sales.reviewer.SalReviewerMapper;
import cn.chiucheung.dao.mapper.sales.reviewer.SalReviewerSubsidiaryMapper;
import cn.chiucheung.dao.mapper.sales.workcard.SalWorkCardMapper;
import cn.chiucheung.dao.mapper.system.message.SysMessageMapper;
import cn.chiucheung.dao.mapper.system.user.SysUserMapper;
import cn.chiucheung.po.market.costbudget.MarCostBudget;
import cn.chiucheung.po.market.costbudget.MarCostBudgetExample;
import cn.chiucheung.po.sales.reviewer.SalReviewer;
import cn.chiucheung.po.sales.reviewer.SalReviewerFile;
import cn.chiucheung.po.sales.reviewer.SalReviewerFileExample;
import cn.chiucheung.po.sales.reviewer.SalReviewerSubsidiary;
import cn.chiucheung.po.sales.reviewer.SalReviewerSubsidiaryExample;
import cn.chiucheung.po.sales.reviewer.SalReviewerWithBLOBs;
import cn.chiucheung.po.sales.workcard.SalWorkCard;
import cn.chiucheung.po.sales.workcard.SalWorkCardExample;
import cn.chiucheung.po.system.message.SysMessage;
import cn.chiucheung.po.system.user.SysUser;
import cn.chiucheung.pojo.sales.reviewer.SalReviewerCustom;
import cn.chiucheung.pojo.sales.reviewer.SalReviewerQueryVo;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardQueryVo;
import cn.chiucheung.pojo.sales.workcard.SalWorkCardShowDataCustom;
import cn.chiucheung.pojo.system.user.SysUserQueryVo;
import cn.chiucheung.service.sales.ReviewerService;
import cn.chiucheung.utils.ActivitiUtils;
import cn.chiucheung.utils.ResourcesUtil;
import cn.chiucheung.utils.UUIDBuild;
import cn.chiucheung.utils.UserUtils;

@Service
public class ReviewerServiceImpl implements ReviewerService{
	
	@Autowired
	private SalReviewerMapper reviewerMapper;
	
	@Autowired
	private SalReviewerSubsidiaryMapper reviewerSubsidiaryMapper;
	
	@Autowired
	private SalReviewerFileMapper reviewerFileMapper;
	
	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private SysUserMapper userMapper;
	
	@Autowired
	private SysMessageMapper messageMapper;
	
	@Autowired
	private SalWorkCardMapper workCardMapper;
	
	@Autowired
	private MarCostBudgetMapper costBudgetMapper;

	@Override
	public int saveReviewer(SalReviewerCustom reviewerCustom, HttpSession session) throws Exception {
		SalReviewerWithBLOBs reviewerWithBLOBs = new SalReviewerWithBLOBs();
		//将页面传入的参数copy到SalReviewerWithBLOBs，并且设置state（treegrid的展开折叠状态），和isAttached为false(是否有附件的)
		BeanUtils.copyProperties(reviewerWithBLOBs, reviewerCustom);
		String id = UUIDBuild.getUUID();
		reviewerWithBLOBs.setState("closed");
		reviewerWithBLOBs.setIsAttached(false);
		reviewerWithBLOBs.setId(id);
		reviewerWithBLOBs.setProcessInstanceId(null);
		
		//对附件进行遍历，如果有附件，则设置isAttached为true
		List<SalReviewerFile> reviewerFiles = reviewerCustom.getReviewerFiles();
		if (reviewerFiles!=null && reviewerFiles.size()>0){
			reviewerWithBLOBs.setIsAttached(true);
			for (SalReviewerFile salReviewerFile : reviewerFiles) {
				salReviewerFile.setId(UUIDBuild.getUUID());
				salReviewerFile.setSalReviewerId(id);
			}
		}
		
		int i = 0;
		i = reviewerMapper.insertSelective(reviewerWithBLOBs);

		if (reviewerFiles != null && reviewerFiles.size()>0){
			i = i + reviewerFileMapper.insertList(reviewerFiles);
		}
		
		List<SalReviewerSubsidiary> reviewerSubsidiaries = reviewerCustom.getReviewerSubsidiaries();
		for (SalReviewerSubsidiary reviewerSubsidiary : reviewerSubsidiaries) {
			reviewerSubsidiary.setId(UUIDBuild.getUUID());
			reviewerSubsidiary.setSalReviewerId(id);
			i = i + reviewerSubsidiaryMapper.insertSelective(reviewerSubsidiary);
		}
		return i;
	}

	@Override
	public List<SalReviewerCustom> findAllSalReviewerList(SalReviewerQueryVo reviewerQueryVo) {
		return reviewerMapper.findAllSalReviewerList(reviewerQueryVo);
	}
	

	@Override
	public String findAllSalReviewerListTotal(SalReviewerQueryVo reviewerQueryVo) {
		return reviewerMapper.findAllSalReviewerListTotal(reviewerQueryVo);
	}

	@Override
	public List<SalReviewerCustom> findAllSalReviewerSubsidiaryListBySalReviewerId(String id) {
		return reviewerSubsidiaryMapper.findAllSalReviewerSubsidiaryListBySalReviewerId(id);
	}

	@Override
	public Map<String, Object> findSalReviewerByIdForEdit(String id, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		SalReviewerWithBLOBs reviewerWithBLOBs = reviewerMapper.selectByPrimaryKey(id);
		map.put("reviewer", reviewerWithBLOBs);
		
		if(reviewerWithBLOBs.getProcessInstanceId() != null){
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(reviewerWithBLOBs.getProcessInstanceId());//设置查询条件，流程实例id
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
		
		//根据id查询SalReviewerSubsidiary的所有数据
		SalReviewerSubsidiaryExample reviewerSubsidiaryExample = new SalReviewerSubsidiaryExample();
		reviewerSubsidiaryExample.setOrderByClause("sequence");
		reviewerSubsidiaryExample.createCriteria().andSalReviewerIdEqualTo(id);
		List<SalReviewerSubsidiary> reviewerSubsidiaries = reviewerSubsidiaryMapper.selectByExample(reviewerSubsidiaryExample);
		
		map.put("reviewerSubsidiaries", reviewerSubsidiaries);
		
		//如果有附件根据id查询sal
		if(reviewerWithBLOBs.getIsAttached()){
			SalReviewerFileExample reviewerFileExample = new SalReviewerFileExample();
			reviewerFileExample.createCriteria().andSalReviewerIdEqualTo(id);
			List<SalReviewerFile> reviewerFiles = reviewerFileMapper.selectByExample(reviewerFileExample);
			map.put("reviewerFiles", reviewerFiles);
		}
		
		return map;
	}

	@Override
	public Map<String, Object> findSalReviewerByIdForView(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		SalReviewerWithBLOBs reviewerWithBLOBs = reviewerMapper.selectByPrimaryKey(id);
		map.put("reviewer", reviewerWithBLOBs);
		
		//根据id查询SalReviewerSubsidiary的所有数据
		SalReviewerSubsidiaryExample reviewerSubsidiaryExample = new SalReviewerSubsidiaryExample();
		reviewerSubsidiaryExample.setOrderByClause("sequence");
		reviewerSubsidiaryExample.createCriteria().andSalReviewerIdEqualTo(id);
		List<SalReviewerSubsidiary> reviewerSubsidiaries = reviewerSubsidiaryMapper.selectByExample(reviewerSubsidiaryExample);
		
		map.put("reviewerSubsidiaries", reviewerSubsidiaries);
		
		//如果有附件根据id查询sal
		if(reviewerWithBLOBs.getIsAttached()){
			SalReviewerFileExample reviewerFileExample = new SalReviewerFileExample();
			reviewerFileExample.createCriteria().andSalReviewerIdEqualTo(id);
			List<SalReviewerFile> reviewerFiles = reviewerFileMapper.selectByExample(reviewerFileExample);
			map.put("reviewerFiles", reviewerFiles);
		}
		
		return map;
	}

	@Override
	public SalReviewerFile findSalReviewerFileById(String id) {
		return reviewerFileMapper.selectByPrimaryKey(id);
	}


	@Override
	public int updateReviewer(SalReviewerCustom reviewerCustom, HttpSession session) throws Exception{
		String processInstanceId = reviewerCustom.getProcessInstanceId();
		
		if (StringUtils.isNotBlank(processInstanceId)){//开启审核流程，则需要知道修改人是否是当前审核人
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(reviewerCustom.getProcessInstanceId());//设置查询条件，流程实例id
			Task task = taskQuery.singleResult();
			if (task != null){//已完成
				if (!task.getAssignee().equals(UserUtils.getUserFromSession(session).getAssignee())){//当前审核人才能修改
					throw new RuntimeException("您不是当前审核人，不能修改");
				}
			}else{
				throw new RuntimeException("流程已结束，不能修改");
			}
		}else{
			reviewerCustom.setProcessInstanceId(null);
		}
		SalReviewerWithBLOBs reviewerWithBLOBs = new SalReviewerWithBLOBs();
		BeanUtils.copyProperties(reviewerWithBLOBs, reviewerCustom);
		reviewerWithBLOBs.setState("closed");
		//先删除所有关联的E6文件
		SalReviewerFileExample reviewerFileExample = new SalReviewerFileExample();
		reviewerFileExample.createCriteria().andSalReviewerIdEqualTo(reviewerWithBLOBs.getId());
		reviewerFileMapper.deleteByExample(reviewerFileExample);
		reviewerWithBLOBs.setIsAttached(false);
		
		//对附件进行遍历，如果有附件，则设置isAttached为true
		List<SalReviewerFile> reviewerFiles = reviewerCustom.getReviewerFiles();
		if (reviewerFiles!=null && reviewerFiles.size()>0){
			reviewerWithBLOBs.setIsAttached(true);
			for (SalReviewerFile salReviewerFile : reviewerFiles) {
				salReviewerFile.setId(UUIDBuild.getUUID());
				salReviewerFile.setSalReviewerId(reviewerWithBLOBs.getId());
			}
		}
		
		int i = 0;
		if (reviewerFiles != null && reviewerFiles.size()>0){
			i = i + reviewerFileMapper.insertList(reviewerFiles);
		}
		i = reviewerMapper.updateByPrimaryKeyWithBLOBs(reviewerWithBLOBs);
		
		//下面不直接删，在新增，是因为关联了工咭号，项次会有关联，但是生成了工咭后，又不可以进行修改了，所以，是否考虑不要这样操作？
		List<SalReviewerSubsidiary> insertReviewerSubsidiaries = new ArrayList<SalReviewerSubsidiary>();//新增的集合
		List<SalReviewerSubsidiary> updateReviewerSubsidiaries = new ArrayList<SalReviewerSubsidiary>();//更新的集合
		List<SalReviewerSubsidiary> notDelReviewerSubsidiaries = new ArrayList<SalReviewerSubsidiary>();//不删除的集合
		
		List<SalReviewerSubsidiary> reviewerSubsidiaries = reviewerCustom.getReviewerSubsidiaries();//更新传过来的集合
		
		for (SalReviewerSubsidiary reviewerSubsidiary : reviewerSubsidiaries) {
			if (StringUtils.isBlank(reviewerSubsidiary.getId())){
				reviewerSubsidiary.setId(UUIDBuild.getUUID());
				insertReviewerSubsidiaries.add(reviewerSubsidiary);
			}
		}
		reviewerSubsidiaries.removeAll(insertReviewerSubsidiaries);
		
		SalReviewerSubsidiaryExample reviewerSubsidiaryExample = new SalReviewerSubsidiaryExample();
		reviewerSubsidiaryExample.createCriteria().andSalReviewerIdEqualTo(reviewerCustom.getId());
		List<SalReviewerSubsidiary> existingReviewerSubsidiaries = reviewerSubsidiaryMapper.selectByExample(reviewerSubsidiaryExample);
		
		for (SalReviewerSubsidiary existingReviewerSubsidiary : existingReviewerSubsidiaries) {
			for (SalReviewerSubsidiary reviewerSubsidiary : reviewerSubsidiaries) {
				if (existingReviewerSubsidiary.getId().equals(reviewerSubsidiary.getId())){
					updateReviewerSubsidiaries.add(reviewerSubsidiary);
					notDelReviewerSubsidiaries.add(existingReviewerSubsidiary);
					break;
				}
			}
		}
		
		existingReviewerSubsidiaries.removeAll(notDelReviewerSubsidiaries);
		
		if (insertReviewerSubsidiaries.size() > 0){
			for (SalReviewerSubsidiary reviewerSubsidiary : insertReviewerSubsidiaries) {
				reviewerSubsidiary.setId(UUIDBuild.getUUID());
				reviewerSubsidiary.setSalReviewerId(reviewerCustom.getId());
				i = i + reviewerSubsidiaryMapper.insertSelective(reviewerSubsidiary);
			}
		}
		
		if (updateReviewerSubsidiaries.size() > 0) {
			for (SalReviewerSubsidiary reviewerSubsidiary : updateReviewerSubsidiaries) {
				i = i + reviewerSubsidiaryMapper.updateByPrimaryKeySelective(reviewerSubsidiary);
			}
		}
		
		if (existingReviewerSubsidiaries.size() > 0){
			List<String> values = new ArrayList<String>();
			for (SalReviewerSubsidiary existingReviewerSubsidiary : existingReviewerSubsidiaries) {
				values.add(existingReviewerSubsidiary.getId());
			}
			SalReviewerSubsidiaryExample reviewerSubsidiaryExample2 = new SalReviewerSubsidiaryExample();
			reviewerSubsidiaryExample2.createCriteria().andIdIn(values);
			i = i + reviewerSubsidiaryMapper.deleteByExample(reviewerSubsidiaryExample2);
		}
		
		
		/*//先删除
		SalReviewerSubsidiaryExample reviewerSubsidiaryExample = new SalReviewerSubsidiaryExample();
		reviewerSubsidiaryExample.createCriteria().andSalReviewerIdEqualTo(reviewerWithBLOBs.getId());
		reviewerSubsidiaryMapper.deleteByExample(reviewerSubsidiaryExample);
		//在新增
		List<SalReviewerSubsidiary> reviewerSubsidiaries = reviewerCustom.getReviewerSubsidiaries();
		for (SalReviewerSubsidiary reviewerSubsidiary : reviewerSubsidiaries) {
			reviewerSubsidiary.setId(UUIDBuild.getUUID());
			reviewerSubsidiary.setSalReviewerId(reviewerCustom.getId());
			i = i + reviewerSubsidiaryMapper.insertSelective(reviewerSubsidiary);
		}*/
		
		return i;
	}

	@Override
	public int deleteSalReviewerById(String id) {
		SalReviewerWithBLOBs reviewerWithBLOBs = reviewerMapper.selectByPrimaryKey(id);
		
		if (StringUtils.isNotBlank(reviewerWithBLOBs.getProcessInstanceId())){
			throw new RuntimeException("已开启审核，不能删除");
		}
		
		
		SalReviewerSubsidiaryExample reviewerSubsidiaryExample = new SalReviewerSubsidiaryExample();
		reviewerSubsidiaryExample.createCriteria().andSalReviewerIdEqualTo(id);
		reviewerSubsidiaryMapper.deleteByExample(reviewerSubsidiaryExample);
		
		SalReviewerFileExample reviewerFileExample = new SalReviewerFileExample();
		reviewerFileExample.createCriteria().andSalReviewerIdEqualTo(id);
		reviewerFileMapper.deleteByExample(reviewerFileExample);
		
		return reviewerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Map<String, Object> findSalReviewerByIdForGenerateWorkCard(String id) {
		SalReviewerWithBLOBs reviewerWithBLOBs = reviewerMapper.selectByPrimaryKey(id);
		String processInstanceId = reviewerWithBLOBs.getProcessInstanceId();
		if (StringUtils.isNotBlank(processInstanceId)){
			//根据QN编号查找工咭
			SalWorkCardQueryVo workCardQueryVo = new SalWorkCardQueryVo();
			workCardQueryVo.setQuotationNo(reviewerWithBLOBs.getQuotationNo());
			List<SalWorkCardShowDataCustom> workCards = workCardMapper.findAllWorkCardList(workCardQueryVo);
			if (workCards.size() <= 0){
			
				Map<String, Object> map = new HashMap<String, Object>();
				
				TaskQuery taskQuery = taskService.createTaskQuery();
				taskQuery.processInstanceId(processInstanceId);//设置查询条件，流程实例id
				Task task = taskQuery.singleResult();
				
				if (task == null){//已完成
				
					map.put("reviewer", reviewerWithBLOBs);
					
					//根据id查询SalReviewerSubsidiary的所有数据
					SalReviewerSubsidiaryExample reviewerSubsidiaryExample = new SalReviewerSubsidiaryExample();
					reviewerSubsidiaryExample.setOrderByClause("sequence");
					reviewerSubsidiaryExample.createCriteria().andSalReviewerIdEqualTo(id);
					List<SalReviewerSubsidiary> reviewerSubsidiaries = reviewerSubsidiaryMapper.selectByExample(reviewerSubsidiaryExample);
					
					map.put("reviewerSubsidiaries", reviewerSubsidiaries);
					
					return map;
				}else{
					throw new RuntimeException("审核未完成无法生成工咭");
				}
			}else{
				throw new RuntimeException(reviewerWithBLOBs.getQuotationNo()+"已经生成了工咭");
			}
		}else{
			throw new RuntimeException("没有开启审核，必须审核完成才能生成工咭");
		}
	}
	
	@Override
	public List<SysUser> queryAuditorById(String id, String processInstanceId, HttpSession session) {
		SalReviewerWithBLOBs reviewerWithBLOBs = reviewerMapper.selectByPrimaryKey(id);
		if (StringUtils.isBlank(processInstanceId)){
			processInstanceId = reviewerWithBLOBs.getProcessInstanceId();
		}
		List<String> loginNames = new ArrayList<String>();
		
		List<SysUser> users = new ArrayList<SysUser>();
		
		if (StringUtils.isNotBlank(processInstanceId)){//已经开始了任务
		    //根据流程id查询出当前任务
            Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
			if (task != null){
				if (task.getAssignee().equals(UserUtils.getUserFromSession(session).getAssignee())){//表示是当前任务的办理人
					String activityImplId = null;
					List<TaskDefinition> taskDefinitions = null;
			          
			        //获取流程发布Id信息   
			        String definitionId = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getProcessDefinitionId();  
			          //获取流程定义实体对象
			        ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)  
			                .getDeployedProcessDefinition(definitionId);  
			          //获取流程执行实体对象
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
			            	if (reviewerWithBLOBs.getIsCost()){//成本核算
			            		taskDefinitions = ActivitiUtils.nextTaskDefinition(activityImpl, activityImpl.getId(), null, processInstanceId, runtimeService);
			            	}else{//交期评审
			            		Map<String, Object> variables = new HashMap<String, Object>();
								variables.put("specialMaterial", reviewerWithBLOBs.getSpecialMaterial());
				        		taskDefinitions = ActivitiUtils.nextTaskDefinition(activityImpl, activityImpl.getId(), variables, processInstanceId, runtimeService);
			            	}
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
			String processDefinitionKey = "";
			if (reviewerWithBLOBs.getIsCost()){//成本核算
				processDefinitionKey = ResourcesUtil.getValue("activiti", "ReviewerCostProcessDefinitionKey");
			}else{//交期评审
				processDefinitionKey = ResourcesUtil.getValue("activiti", "ReviewerProcessDefinitionKey");
			}

			//获取当前流程的指定id和name的节点候选人
			loginNames = ActivitiUtils.getCandidateUsers(repositoryService, processDefinitionKey);
		}
		//将获取到的节点候选人跟数据库中的用户对比查询,不存在就清除节点候选人中的相关数据
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
	public void auditReviewer(String id, String assigneeId,HttpSession session) {
		SalReviewerWithBLOBs reviewerWithBLOBs = reviewerMapper.selectByPrimaryKey(id);
		String processInstanceId = reviewerWithBLOBs.getProcessInstanceId();
		
		List<SysUser> users = queryAuditorById(id, processInstanceId, session);
		
		//发送消息
		SysMessage message = new SysMessage();
		message.setId(UUIDBuild.getUUID());
		message.setIsRead(false);
		
		StringBuffer buffer = new StringBuffer();
		
		if (reviewerWithBLOBs.getIsCost()){//成本核算
			buffer.append("项目评审表-成本核算");
		}else{//交期评审
			buffer.append("项目评审表-交期评审");
		}
		
		buffer.append("<b>");
		buffer.append(reviewerWithBLOBs.getQuotationNo());
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
					        
					        if (activitiId.equals("startAudit")){
					        	
					        }else if (activitiId.equals("saleReviewer")){
					        	reviewerWithBLOBs.setSalReviewer(UserUtils.getUserFromSession(session).getUsername());
					        	reviewerMapper.updateByPrimaryKeyWithBLOBs(reviewerWithBLOBs);
					        }else if (activitiId.equals("engDistribution")){
					        	
					        }else if (activitiId.equals("engWrite")){
					        	reviewerWithBLOBs.setArrange(UserUtils.getUserFromSession(session).getUsername());
					        	reviewerMapper.updateByPrimaryKeyWithBLOBs(reviewerWithBLOBs);
					        }else if (activitiId.equals("engReviewer")){
					        	reviewerWithBLOBs.setEngReviewer(UserUtils.getUserFromSession(session).getUsername());
					        	reviewerWithBLOBs.setEngReviewerDate(new Date());
					        	reviewerMapper.updateByPrimaryKeyWithBLOBs(reviewerWithBLOBs);
					        }else if (activitiId.equals("purReviewer")){
					        	reviewerWithBLOBs.setPurReviewer(UserUtils.getUserFromSession(session).getUsername());
					        	reviewerWithBLOBs.setPurReviewerDate(new Date());
					        	reviewerMapper.updateByPrimaryKeyWithBLOBs(reviewerWithBLOBs);
					        }else if (activitiId.equals("proReviewer")){
					        	reviewerWithBLOBs.setProReviewer(UserUtils.getUserFromSession(session).getUsername());
					        	reviewerWithBLOBs.setProReviewerDate(new Date());
					        	reviewerMapper.updateByPrimaryKeyWithBLOBs(reviewerWithBLOBs);
					        }
							
							Map<String, Object> variables = new HashMap<String, Object>();
							variables.put("specialMaterial", reviewerWithBLOBs.getSpecialMaterial());
							
							taskService.complete(task.getId(), variables);
							
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
			
			String processDefinitionKey = "";
			if (reviewerWithBLOBs.getIsCost()){//成本核算
				processDefinitionKey = ResourcesUtil.getValue("activiti", "ReviewerCostProcessDefinitionKey");
			}else{//交期评审
				processDefinitionKey = ResourcesUtil.getValue("activiti", "ReviewerProcessDefinitionKey");
			}
			
			identityService.setAuthenticatedUserId(UserUtils.getUserFromSession(session).getAssignee());
			String businessKey = id;
			ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey);
			processInstanceId = processInstance.getProcessInstanceId();
			reviewerWithBLOBs.setProcessInstanceId(processInstanceId);
			
			reviewerMapper.updateByPrimaryKeyWithBLOBs(reviewerWithBLOBs);
			
			TaskQuery taskQuery = taskService.createTaskQuery();
			taskQuery.processInstanceId(processInstanceId);
			Task task = taskQuery.singleResult();
			
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("specialMaterial", reviewerWithBLOBs.getSpecialMaterial());
			
			taskService.complete(task.getId(), variables);//发起人立刻完成任务，发送到下一节点
			
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
		SalReviewerWithBLOBs reviewerWithBLOBs = reviewerMapper.selectByPrimaryKey(id);
		String processInstanceId = reviewerWithBLOBs.getProcessInstanceId();
		
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
							
							if (reviewerWithBLOBs.getIsCost()){//成本核算
								buffer.append("项目评审表-成本核算");
							}else{//交期评审
								buffer.append("项目评审表-交期评审");
							}
							
							buffer.append("<b>");
							buffer.append(reviewerWithBLOBs.getQuotationNo());
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
					
					reviewerWithBLOBs.setSalReviewer(null);
			    	reviewerWithBLOBs.setArrange(null);
			    	reviewerWithBLOBs.setEngReviewer(null);
			    	reviewerWithBLOBs.setEngReviewerDate(null);
			    	reviewerWithBLOBs.setPurReviewer(null);
			    	reviewerWithBLOBs.setPurReviewerDate(null);
			    	reviewerWithBLOBs.setProReviewer(null);
			    	reviewerWithBLOBs.setProReviewerDate(null);
			    	
					reviewerWithBLOBs.setProcessInstanceId(null);
					reviewerMapper.updateByPrimaryKeyWithBLOBs(reviewerWithBLOBs);
					
				}else{
					throw new RuntimeException("您不是流程发起人，无法撤销");
				}
			}
		}else{
			throw new RuntimeException("没有开启审核流程");
		}
	}

	@Override
	public void takeBackReviewer(String id, String cause, HttpSession session) {
		SalReviewerWithBLOBs reviewerWithBLOBs = reviewerMapper.selectByPrimaryKey(id);
		String processInstanceId = reviewerWithBLOBs.getProcessInstanceId();
		
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
					/*List<PvmTransition> nextTransitionList = currActivity.getIncomingTransitions();*/

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
					
					Map<String, Object> variables = new HashMap<String, Object>();
					variables.put("specialMaterial", reviewerWithBLOBs.getSpecialMaterial());
					
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
					if (reviewerWithBLOBs.getIsCost()){//成本核算
						buffer.append("项目评审表-成本核算");
					}else{//交期评审
						buffer.append("项目评审表-交期评审");
					}
					
					buffer.append("<b>");
					buffer.append(reviewerWithBLOBs.getQuotationNo());
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
					
					if (taskDefinitionKey.equals("createReviewer")){
			           	
					}else if (taskDefinitionKey.equals("saleReviewer")){
						reviewerWithBLOBs.setSalReviewer(null);
					}else if (taskDefinitionKey.equals("engDistribution")){
	   
					}else if (taskDefinitionKey.equals("engWrite")){
						reviewerWithBLOBs.setArrange(null);
					}else if (taskDefinitionKey.equals("engReviewer")){
						reviewerWithBLOBs.setEngReviewer(null);
						reviewerWithBLOBs.setEngReviewerDate(null);
					}else if (taskDefinitionKey.equals("purReviewer")){
						reviewerWithBLOBs.setPurReviewer(null);
						reviewerWithBLOBs.setPurReviewerDate(null);
					}else if (taskDefinitionKey.equals("proReviewer")){
						reviewerWithBLOBs.setProReviewer(null);
						reviewerWithBLOBs.setProReviewerDate(null);
					}
					reviewerMapper.updateByPrimaryKeyWithBLOBs(reviewerWithBLOBs);
		           
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
	public void rollBackReviewer(String id, String cause, HttpSession session) {
		SalReviewerWithBLOBs reviewerWithBLOBs = reviewerMapper.selectByPrimaryKey(id);
		String processInstanceId = reviewerWithBLOBs.getProcessInstanceId();
		
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
//					List<PvmTransition> nextTransitionList = currActivity.getIncomingTransitions();
		
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
					
					Map<String, Object> variables = new HashMap<String, Object>();
					variables.put("specialMaterial", reviewerWithBLOBs.getSpecialMaterial());
					
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
					
					if (reviewerWithBLOBs.getIsCost()){//成本核算
						buffer.append("项目评审表-成本核算");
					}else{//交期评审
						buffer.append("项目评审表-交期评审");
					}
					
					buffer.append("<b>");
					buffer.append(reviewerWithBLOBs.getQuotationNo());
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
					
					
					
					if (taskDefinitionKey.equals("startAudit")){
			           	
					}else if (taskDefinitionKey.equals("saleReviewer")){
						reviewerWithBLOBs.setSalReviewer(null);
						reviewerMapper.updateByPrimaryKeyWithBLOBs(reviewerWithBLOBs);
					}else if (taskDefinitionKey.equals("engDistribution")){
						
					}else if (taskDefinitionKey.equals("engWrite")){
						reviewerWithBLOBs.setArrange(null);
						reviewerMapper.updateByPrimaryKeyWithBLOBs(reviewerWithBLOBs);
					}else if (taskDefinitionKey.equals("engReviewer")){
						reviewerWithBLOBs.setEngReviewer(null);
						reviewerWithBLOBs.setEngReviewerDate(null);
						reviewerMapper.updateByPrimaryKeyWithBLOBs(reviewerWithBLOBs);
					}else if (taskDefinitionKey.equals("purReviewer")){
						reviewerWithBLOBs.setPurReviewer(null);
						reviewerWithBLOBs.setPurReviewerDate(null);
						reviewerMapper.updateByPrimaryKeyWithBLOBs(reviewerWithBLOBs);
					}else if (taskDefinitionKey.equals("proReviewer")){
						reviewerWithBLOBs.setProReviewer(null);
						reviewerWithBLOBs.setProReviewerDate(null);
						reviewerMapper.updateByPrimaryKeyWithBLOBs(reviewerWithBLOBs);
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
	public void antiAuditReviewer(String id, String cause, HttpSession session) {
		SalReviewerWithBLOBs reviewerWithBLOBs = reviewerMapper.selectByPrimaryKey(id);
		String processInstanceId = reviewerWithBLOBs.getProcessInstanceId();
		
		if (!reviewerWithBLOBs.getIsCost()) {
			SalWorkCardExample workCardExample = new SalWorkCardExample();
			workCardExample.createCriteria().andSalReviewerIdEqualTo(id);
			List<SalWorkCard> workCards = workCardMapper.selectByExample(workCardExample);
			if (workCards != null && workCards.size() > 0){
				throw new RuntimeException("关联了工咭" + workCards.get(0).getWorkCardNo());
			}
		}else{
			MarCostBudgetExample costBudgetExample = new MarCostBudgetExample();
			costBudgetExample.createCriteria().andSalReviewerIdEqualTo(id);
			List<MarCostBudget> costBudgets = costBudgetMapper.selectByExample(costBudgetExample);
			if (costBudgets != null && costBudgets.size() > 0){
				throw new RuntimeException("关联了成本核算");
			}
		}
		
		
		TaskQuery taskQuery = taskService.createTaskQuery();
		taskQuery.processInstanceId(processInstanceId);//设置查询条件，流程实例id
		Task task = taskQuery.singleResult();
		
		if (task == null){//已完成
		
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
				if (reviewerWithBLOBs.getIsCost()){//成本核算
					buffer.append("项目评审表-成本核算");
				}else{//交期评审
					buffer.append("项目评审表-交期评审");
				}
				
				buffer.append("<b>");
				buffer.append(reviewerWithBLOBs.getQuotationNo());
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
			
			reviewerWithBLOBs.setSalReviewer(null);
	    	reviewerWithBLOBs.setArrange(null);
	    	reviewerWithBLOBs.setEngReviewer(null);
	    	reviewerWithBLOBs.setEngReviewerDate(null);
	    	reviewerWithBLOBs.setPurReviewer(null);
	    	reviewerWithBLOBs.setPurReviewerDate(null);
	    	reviewerWithBLOBs.setProReviewer(null);
	    	reviewerWithBLOBs.setProReviewerDate(null);
			
			//并将所有审核人和审核时间清空，重新设置流程实例id
			reviewerWithBLOBs.setProcessInstanceId(null);
			reviewerMapper.updateByPrimaryKeyWithBLOBs(reviewerWithBLOBs);
		}else{
			throw new RuntimeException("审核未完成无法反审核");
		}
	}

	@Override
	public SalReviewer findSalReviewerByIdForGenerateCostBudget(String id) {
		SalReviewerWithBLOBs reviewerWithBLOBs = reviewerMapper.selectByPrimaryKey(id);
		String processInstanceId = reviewerWithBLOBs.getProcessInstanceId();
		if (StringUtils.isNotBlank(processInstanceId)){
				TaskQuery taskQuery = taskService.createTaskQuery();
				taskQuery.processInstanceId(processInstanceId);//设置查询条件，流程实例id
				Task task = taskQuery.singleResult();
				
				if (task == null){//已完成
					return reviewerWithBLOBs;
				}else{
					throw new RuntimeException("审核未完成无法生成成本核算表");
				}
		}else{
			throw new RuntimeException("没有开启审核，必须审核完成才能生成成本核算表");
		}
	}

	@Override
	public List<SalReviewerCustom> findCompleteReviewerCostCollect(SalReviewerQueryVo reviewerQueryVo) {
		return reviewerMapper.findCompleteReviewerCostCollect(reviewerQueryVo);
	}
}
