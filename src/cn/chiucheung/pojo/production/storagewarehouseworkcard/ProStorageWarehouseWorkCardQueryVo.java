package cn.chiucheung.pojo.production.storagewarehouseworkcard;

import java.util.Date;

public class ProStorageWarehouseWorkCardQueryVo {
	private String workCardNo;
	
	private String workCardLeader;
	
	private String preparer;
	
	private Date startWorkCardDate;
	
	private Date endWorkCardDate;
	
	private int page;//第几页
	
	private int rows;//每页多少条记录
	
	private int startPage;
	
	private String sort;
	
	private String order;
	
	public String getWorkCardNo() {
		return workCardNo;
	}
	
	public void setWorkCardNo(String workCardNo) {
		this.workCardNo = workCardNo;
	}
	
	public String getWorkCardLeader() {
		return workCardLeader;
	}
	
	public void setWorkCardLeader(String workCardLeader) {
		this.workCardLeader = workCardLeader;
	}
	
	public String getPreparer() {
		return preparer;
	}
	
	public void setPreparer(String preparer) {
		this.preparer = preparer;
	}
	
	public Date getStartWorkCardDate() {
		return startWorkCardDate;
	}
	
	public void setStartWorkCardDate(Date startWorkCardDate) {
		this.startWorkCardDate = startWorkCardDate;
	}
	
	public Date getEndWorkCardDate() {
		return endWorkCardDate;
	}
	
	public void setEndWorkCardDate(Date endWorkCardDate) {
		this.endWorkCardDate = endWorkCardDate;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getRows() {
		return rows;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public int getStartPage() {
		return (page-1)*rows;
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
