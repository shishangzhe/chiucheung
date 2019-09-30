package cn.chiucheung.pojo.system.message;

import java.io.Serializable;

public class AuditCustom implements Serializable{
	private String id;//项目评审表的id
	
	private String taskDefinitionKey;//当前的节点
	
	private String processDefinitionKey;//activiti流程的key
	
	private String processInstanceId;//activiti任务实例的id
	
	private String auditStateUrl;//评审状态的查询url
	
	private String modular;//模块
	
	private String startUsername;//发起人
	
	private String startTime;//流程的开始时间
	
	private String endTime;//流程的结束时间
	
	private String receiveTime;//流程到我这个节点时间
	
	private String name;//对应模块的单据编号或名称

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskDefinitionKey() {
		return taskDefinitionKey;
	}

	public void setTaskDefinitionKey(String taskDefinitionKey) {
		this.taskDefinitionKey = taskDefinitionKey;
	}

	public String getProcessDefinitionKey() {
		return processDefinitionKey;
	}

	public void setProcessDefinitionKey(String processDefinitionKey) {
		this.processDefinitionKey = processDefinitionKey;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getAuditStateUrl() {
		return auditStateUrl;
	}

	public void setAuditStateUrl(String auditStateUrl) {
		this.auditStateUrl = auditStateUrl;
	}

	public String getModular() {
		return modular;
	}

	public void setModular(String modular) {
		this.modular = modular;
	}

	public String getStartUsername() {
		return startUsername;
	}

	public void setStartUsername(String username) {
		this.startUsername = username;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
