package cn.chiucheung.pojo.sales.workcard;


public class SalWorkCardQueryVo {
	private String quotationNo;
	
	private String quotationYear;
	
	private String workCardNo;
	
	private String workCardYear;
	
	private String workCardLeader;
	
	private String startWorkCardDate;
	
	private String endWorkCardDate;
	
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

	public String getWorkCardNo() {
		return workCardNo;
	}

	public void setWorkCardNo(String workCardNo) {
		this.workCardNo = workCardNo;
	}

	public String getWorkCardYear() {
		return workCardYear;
	}

	public void setWorkCardYear(String workCardYear) {
		this.workCardYear = workCardYear;
	}

	public String getWorkCardLeader() {
		return workCardLeader;
	}

	public void setWorkCardLeader(String workCardLeader) {
		this.workCardLeader = workCardLeader;
	}

	public String getStartWorkCardDate() {
		return startWorkCardDate;
	}

	public void setStartWorkCardDate(String startWorkCardDate) {
		this.startWorkCardDate = startWorkCardDate;
	}

	public String getEndWorkCardDate() {
		return endWorkCardDate;
	}

	public void setEndWorkCardDate(String endWorkCardDate) {
		this.endWorkCardDate = endWorkCardDate;
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
