package cn.chiucheung.pojo.production.producttechnologyflowchart;

import java.math.BigDecimal;

public class ProProductTechnologyFlowChartNodeDataArrayCustom{
	private String processName;
	
	private String processCategory;
	
	private String category;

    private String key;

    private String loc;

    private BigDecimal totalTime;

    private String proProcessId;

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public BigDecimal getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(BigDecimal totalTime) {
		this.totalTime = totalTime;
	}

	public String getProProcessId() {
		return proProcessId;
	}

	public void setProProcessId(String proProcessId) {
		this.proProcessId = proProcessId;
	}
	
}
