package cn.chiucheung.pojo.warehouse.standardaccessoriesstockout;

import java.util.Date;

public class WarStandardAccessoriesStockOutQueryVo {
	private String stockOutNo;
	
	private String preparer;
	
	private Date startCreateTime;
	
	private Date endCreateTime;
	
	private String accessoriesCode;
	
	private int page;//第几页
	
	private int rows;//每页多少条记录
	
	private int startPage;
	
	private String sort;
	
	private String order;

	public String getStockOutNo() {
		return stockOutNo;
	}

	public void setStockOutNo(String stockOutNo) {
		this.stockOutNo = stockOutNo;
	}

	public String getPreparer() {
		return preparer;
	}

	public void setPreparer(String preparer) {
		this.preparer = preparer;
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

	public String getAccessoriesCode() {
		return accessoriesCode;
	}

	public void setAccessoriesCode(String accessoriesCode) {
		this.accessoriesCode = accessoriesCode;
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
