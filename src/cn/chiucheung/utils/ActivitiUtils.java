package cn.chiucheung.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.activiti.engine.impl.javax.el.ExpressionFactory;
import org.activiti.engine.impl.javax.el.ValueExpression;
import org.activiti.engine.impl.juel.ExpressionFactoryImpl;
import org.activiti.engine.impl.juel.SimpleContext;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.apache.commons.lang.StringUtils;

import cn.chiucheung.po.system.user.SysUser;

public class ActivitiUtils {
	/**  
     * 下一个任务节点信息,  
     *  
     * 如果下一个节点为用户任务则直接返回,  
     *  
     * 如果下一个节点为排他网关, 获取排他网关Id信息, 根据排他网关Id信息和execution获取流程实例排他网关Id为key的变量值,  
     * 根据变量值分别执行排他网关后线路中的el表达式, 并找到el表达式通过的线路后的用户任务信息  
     * @param ActivityImpl activityImpl     流程节点信息  
     * @param String activityId             当前流程节点Id信息  
     * @param Map<String, Object> variables  排他网关顺序流线段判断条件, 且只取第一条记录
     * 											例如排他网关顺序留线段判断条件为${money>1000}, 若满足流程启动时设置variables中的money>1000, 则流程流向该顺序流信息  ,map中的key为money，value为1000
     * @param String processInstanceId      流程实例Id信息  （应该可以不用）
     * @return  
     */    
    public static List<TaskDefinition> nextTaskDefinition(ActivityImpl activityImpl, String activityId, Map<String, Object> variables, String processInstanceId, RuntimeService runtimeService){   
              
        PvmActivity ac = null;  
          
        Object s = null;
        
        List<TaskDefinition> taskDefinitions = new ArrayList<TaskDefinition>();
          
        //如果遍历节点为用户任务并且节点不是当前节点信息   
        if("userTask".equals(activityImpl.getProperty("type")) && !activityId.equals(activityImpl.getId())){    
            //获取该节点下一个节点信息   
            TaskDefinition taskDefinition = ((UserTaskActivityBehavior)activityImpl.getActivityBehavior()).getTaskDefinition();
            taskDefinitions.add(taskDefinition);
        }else{    
            //获取节点所有流向线路信息   
            List<PvmTransition> outTransitions = activityImpl.getOutgoingTransitions();    
            List<PvmTransition> outTransitionsTemp = null;    
            for(PvmTransition tr : outTransitions){      
                ac = tr.getDestination(); //获取线路的终点节点      
                //如果流向线路为排他网关   
                if("exclusiveGateway".equals(ac.getProperty("type"))){    
                    outTransitionsTemp = ac.getOutgoingTransitions();  
                      
                   /* //如果网关路线判断条件为空信息   
                    if(StringUtils.isEmpty(elString)) {  
                        //获取流程启动时设置的网关判断条件信息   
                        elString = getGatewayCondition(ac.getId(), processInstanceId, runtimeService);  
                    } */ 
                      
                    //如果排他网关只有一条线路信息   
                    if(outTransitionsTemp.size() == 1){    
                        return nextTaskDefinition((ActivityImpl)outTransitionsTemp.get(0).getDestination(), activityId, variables, processInstanceId, runtimeService);    
                    }else if(outTransitionsTemp.size() > 1){  //如果排他网关有多条线路信息   
                        for(PvmTransition tr1 : outTransitionsTemp){    
                            s = tr1.getProperty("conditionText");  //获取排他网关线路判断条件信息   
                            //判断el表达式是否成立   
                            String key = variables.keySet().toArray()[0].toString();
                            if(isCondition(key, StringUtils.trim(s.toString()), variables.get(key).toString())){//只会有一个满足的条件 
                            	taskDefinitions = nextTaskDefinition((ActivityImpl)tr1.getDestination(), activityId, variables, processInstanceId, runtimeService);    
                            }    
                        }    
                    }    
                }else if ("inclusiveGateway".equals(ac.getProperty("type"))){//如果是包含网关
                	outTransitionsTemp = ac.getOutgoingTransitions();
                	if(outTransitionsTemp.size() == 1){    
                        return nextTaskDefinition((ActivityImpl)outTransitionsTemp.get(0).getDestination(), activityId, variables, processInstanceId, runtimeService);    
                    }else if(outTransitionsTemp.size() > 1){  //如果排他网关有多条线路信息  
                    	for(PvmTransition tr1 : outTransitionsTemp){    
                            s = tr1.getProperty("conditionText");  //获取排他网关线路判断条件信息   
                            //判断el表达式是否成立   
                            String key = variables.keySet().toArray()[0].toString();
                            if(isCondition(key, StringUtils.trim(s.toString()), variables.get(key).toString())){    
                            	taskDefinitions.addAll(nextTaskDefinition((ActivityImpl)tr1.getDestination(), activityId, variables, processInstanceId, runtimeService));    
                            }    
                        }
                    }
                }else if("userTask".equals(ac.getProperty("type"))){    
                    TaskDefinition taskDefinition = ((UserTaskActivityBehavior)((ActivityImpl)ac).getActivityBehavior()).getTaskDefinition();
                    taskDefinitions.add(taskDefinition);
                }else{ 
                	
                }    
            }    
        }
        return taskDefinitions;
    }  
      
    /** 
     * 查询流程启动时设置排他网关判断条件信息  
     * @param String gatewayId          排他网关Id信息, 流程启动时设置网关路线判断条件key为网关Id信息  
     * @param String processInstanceId  流程实例Id信息  
     * @return 
     */  
    public static String getGatewayCondition(String gatewayId, String processInstanceId, RuntimeService runtimeService) {  
        Execution execution = runtimeService.createExecutionQuery().processInstanceId(processInstanceId).singleResult();  
        return runtimeService.getVariable(execution.getId(), gatewayId).toString();  
    }  
      
    /** 
     * 根据key和value判断el表达式是否通过信息  
     * @param String key    el表达式key信息  
     * @param String el     el表达式信息  
     * @param String value  el表达式传入值信息  
     * @return 
     */  
    public static boolean isCondition(String key, String el, String value) {  
        ExpressionFactory factory = new ExpressionFactoryImpl();    
        SimpleContext context = new SimpleContext();    
        context.setVariable(key, factory.createValueExpression(value, String.class)); 
        ValueExpression e = factory.createValueExpression(context, el, boolean.class);
        Object object = e.getValue(context);
        return (Boolean) e.getValue(context);  
    }
    
    /**
     * 根据流程定义的key查询流程定义指定的id和name的节点候选人
     * @param repositoryService
     * @param processDefinitionKey 流程定义的key
     * @return
     */
    public static List<String> getCandidateUsers(RepositoryService repositoryService, String processDefinitionKey){
    	List<String> list = new ArrayList<String>();
    	//先查到流程定义
    	ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().processDefinitionKey(processDefinitionKey).latestVersion().singleResult();  
		
		BpmnModel model = repositoryService.getBpmnModel(pd.getId());
		if(model != null) {
			//查到每个节点的信息
		    Collection<FlowElement> flowElements = model.getMainProcess().getFlowElements();
		    List<String> keyList = ResourcesUtil.gekeyList("activitiStartNode");//找出所有的key
		    boolean id = true;
        	boolean name = true;
        	if (keyList.contains(processDefinitionKey+"_id")){
        		id = false;
        	}
        	if (keyList.contains(processDefinitionKey+"_name")){
        		name = false;
        	}
        	if(id && name){
        		throw new RuntimeException("没有定义开始节点");
        	}
		    for(FlowElement e : flowElements) {
		    	//判断是否是UserTask节点，是的话强转
		        if (e instanceof UserTask){
		        	UserTask userTask = (UserTask) e;
		        	
		        	if ((id || userTask.getId().equals(ResourcesUtil.getValue("activitiStartNode", processDefinitionKey+"_id"))) && (name || userTask.getName().equals(ResourcesUtil.getValue("activitiStartNode", processDefinitionKey+"_name")))){
		        		list.addAll(userTask.getCandidateUsers());
		        	}
		        }
		    }
		}
		return list;
    }
}
