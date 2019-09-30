package cn.chiucheung.pojo.system.message;

public class AuditQueryVo {
	private int auditState;//区分查询，0：待审核、1：已审核:2：已发送审核
	
	private int modularState;//区分查询的模块，0：项目评审表、1：工咭、2：工咭相关资料
	
	private String assignee;//登录名
	
	private int page;//第几页
	
	private int rows;//每页多少条记录
	
	private int startPage;
	
	private String sort;
	
	private String order;

	public int getAuditState() {
		return auditState;
	}

	public void setAuditState(int auditState) {
		this.auditState = auditState;
	}

	public int getModularState() {
		return modularState;
	}

	public void setModularState(int modularState) {
		this.modularState = modularState;
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

	public int getStartPage() {
		return (page-1)*rows;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
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
