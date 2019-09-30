package cn.chiucheung.pojo.engineering.bom;

import cn.chiucheung.po.engineering.bom.EngBom;

public class EngBomCustom extends EngBom{
	private String workCardNo;
	
	private Integer sequence;
	
	private String quantity;
	
	private String productName;

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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
