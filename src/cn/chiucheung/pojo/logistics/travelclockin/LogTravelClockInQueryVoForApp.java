package cn.chiucheung.pojo.logistics.travelclockin;

import java.util.Date;

public class LogTravelClockInQueryVoForApp{
	private String logTravelUserid;
	
	private Date lastClockOn;
	
	private String colckOn;
	
	private int pageSize;

	public String getLogTravelUserid() {
		return logTravelUserid;
	}

	public void setLogTravelUserid(String logTravelUserid) {
		this.logTravelUserid = logTravelUserid;
	}

	public Date getLastClockOn() {
		return lastClockOn;
	}

	public void setLastClockOn(Date lastClockOn) {
		this.lastClockOn = lastClockOn;
	}

	public String getColckOn() {
		return colckOn;
	}

	public void setColckOn(String colckOn) {
		this.colckOn = colckOn;
	}

	public int getPageSize() {
		return pageSize > 20 ? pageSize : 20;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
