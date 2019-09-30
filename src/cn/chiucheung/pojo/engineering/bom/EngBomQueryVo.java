package cn.chiucheung.pojo.engineering.bom;

import java.util.Date;

public class EngBomQueryVo {
	private String workCardNo;

    private Integer sequence;

    private Date startBomDate;
	
	private Date endBomDate;

    private String productName;

    private String preparer;
    
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

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Date getStartBomDate() {
		return startBomDate;
	}

	public void setStartBomDate(Date startBomDate) {
		this.startBomDate = startBomDate;
	}

	public Date getEndBomDate() {
		return endBomDate;
	}

	public void setEndBomDate(Date endBomDate) {
		this.endBomDate = endBomDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPreparer() {
		return preparer;
	}

	public void setPreparer(String preparer) {
		this.preparer = preparer;
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
