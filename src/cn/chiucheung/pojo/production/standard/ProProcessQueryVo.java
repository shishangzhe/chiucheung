package cn.chiucheung.pojo.production.standard;

import java.util.List;

public class ProProcessQueryVo {
	
	private String processNumber;
	
	private String parentProcessNumber;
	
	private String processName;
	
	private String processCategory;
	
	private List<String> notInId;
	
	private String sort;
	
	private String order;

	public String getProcessNumber() {
		return processNumber;
	}

	public void setProcessNumber(String processNumber) {
		this.processNumber = processNumber;
	}

	public String getParentProcessNumber() {
		return parentProcessNumber;
	}

	public void setParentProcessNumber(String parentProcessNumber) {
		this.parentProcessNumber = parentProcessNumber;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getProcessCategory() {
		return processCategory;
	}

	public void setProcessCategory(String processCategory) {
		this.processCategory = processCategory;
	}

	public List<String> getNotInId() {
		return notInId;
	}

	public void setNotInId(List<String> notInId) {
		this.notInId = notInId;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}
