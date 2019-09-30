package cn.chiucheung.pojo.sales.reviewer;

import java.util.Date;
import java.util.List;

public class SalReviewerQueryVo {
	private String quotationNo;
	
	private String quotationYear;
	
	private String projectLeader;
	
	private Date startCreateTime;
	
	private Date endCreateTime;
	
	private Boolean isCost;//false交期评审,true成本核算
	
	private String assignee;//该字段是用来查询当前代办任务的(如果为为空，则查询所有，否则查询个人代办任务)
	
	private int page;//第几页
	
	private int rows;//每页多少条记录
	
	private int startPage;
	
	private String sort;
	
	private String order;

	public String getQuotationNo() {
		return quotationNo;
	}

	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}

	public String getQuotationYear() {
		return quotationYear;
	}

	public void setQuotationYear(String quotationYear) {
		this.quotationYear = quotationYear;
	}

	public String getProjectLeader() {
		return projectLeader;
	}

	public void setProjectLeader(String projectLeader) {
		this.projectLeader = projectLeader;
	}

	public Date getStartCreateTime() {
		return startCreateTime;
	}

	public void setStartCreateTime(Date startCreateTime) {
		this.startCreateTime = startCreateTime;
	}

	public Date getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(Date endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

	public Boolean getIsCost() {
		return isCost;
	}

	public void setIsCost(Boolean isCost) {
		this.isCost = isCost;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
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

	public int getStartPage() {
		return (page-1)*rows;
	}
	
}
