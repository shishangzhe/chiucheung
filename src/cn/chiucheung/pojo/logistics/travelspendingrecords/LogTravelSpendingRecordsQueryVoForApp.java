package cn.chiucheung.pojo.logistics.travelspendingrecords;

import java.util.Date;

public class LogTravelSpendingRecordsQueryVoForApp {
	
	private String id;
	
	private Date lastCreateTime;
	
	private int pageSize;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getLastCreateTime() {
		return lastCreateTime;
	}

	public void setLastCreateTime(Date lastCreateTime) {
		this.lastCreateTime = lastCreateTime;
	}

	public int getPageSize() {
		return pageSize > 20 ? pageSize : 20;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
