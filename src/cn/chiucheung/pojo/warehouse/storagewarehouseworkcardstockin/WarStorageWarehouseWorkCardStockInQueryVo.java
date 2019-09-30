package cn.chiucheung.pojo.warehouse.storagewarehouseworkcardstockin;

import java.util.Date;

public class WarStorageWarehouseWorkCardStockInQueryVo {
	private String stockInNo;
	
	private String preparer;
	
	private Date startCreateTime;
	
	private Date endCreateTime;
	
	private String materialCode;
	
	private int page;//第几页
	
	private int rows;//每页多少条记录
	
	private int startPage;
	
	private String sort;
	
	private String order;

	public String getStockInNo() {
		return stockInNo;
	}

	public void setStockInNo(String stockInNo) {
		this.stockInNo = stockInNo;
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

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
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
