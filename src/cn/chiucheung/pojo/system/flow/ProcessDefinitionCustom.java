package cn.chiucheung.pojo.system.flow;

import java.io.Serializable;

/**
 * 流程定义的自定义bean
 * @author adm-03
 *
 */
public class ProcessDefinitionCustom implements Serializable{
	
	private String id;
	
	private String deploymentId;
	
	private String name;
	
	private String key;
	
	private int version;
	
	private String bpmn;
	
	private String png;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeploymentId() {
		return deploymentId;
	}

	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getBpmn() {
		return bpmn;
	}

	public void setBpmn(String bpmn) {
		this.bpmn = bpmn;
	}

	public String getPng() {
		return png;
	}

	public void setPng(String png) {
		this.png = png;
	}
	
}
