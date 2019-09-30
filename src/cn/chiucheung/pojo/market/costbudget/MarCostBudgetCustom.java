package cn.chiucheung.pojo.market.costbudget;

import java.io.Serializable;
import java.util.Date;

public class MarCostBudgetCustom implements Serializable{
	
	private String quotationNo;//报价单号
	
	private Date endTime;//接到报价单日期（评审结束日期）
	
	private String projectLeader;//项目负责人
	
	private String customerName;//客户名称
	
	private String productName;//项目名称
	
	private String peripheralSize;//尺寸
	
	private String totalNumber;//总数量
	
	private String unitPrice;//单价
	
	private String totalPrice;//总价
	
	private Date submitTime;//报出日期
	
	private String preparer;//制表人
	
	private String reviewer;

	public String getQuotationNo() {
		return quotationNo;
	}

	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getProjectLeader() {
		return projectLeader;
	}

	public void setProjectLeader(String projectLeader) {
		this.projectLeader = projectLeader;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPeripheralSize() {
		return peripheralSize;
	}

	public void setPeripheralSize(String peripheralSize) {
		this.peripheralSize = peripheralSize;
	}

	public String getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(String totalNumber) {
		this.totalNumber = totalNumber;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public String getPreparer() {
		return preparer;
	}

	public void setPreparer(String preparer) {
		this.preparer = preparer;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	
}
