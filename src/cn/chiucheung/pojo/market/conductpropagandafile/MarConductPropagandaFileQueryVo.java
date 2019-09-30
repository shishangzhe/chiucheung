package cn.chiucheung.pojo.market.conductpropagandafile;

import cn.chiucheung.po.market.conductpropagandafile.MarConductPropagandaFile;

public class MarConductPropagandaFileQueryVo extends MarConductPropagandaFile{
	private int page;//第几页
	
	private int rows;//每页多少条记录
	
	private int startPage;
	
	private String sort;
	
	private String order;
	
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
