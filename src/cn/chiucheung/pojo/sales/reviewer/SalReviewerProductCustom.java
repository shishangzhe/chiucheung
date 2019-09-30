package cn.chiucheung.pojo.sales.reviewer;

import java.io.Serializable;

/**
 * 用于项目评审展示计算工时的产品id、产品名称、产品型号、产品数量、产品工序工时的计算系数
 * @author adm-03
 *
 */
public class SalReviewerProductCustom implements Serializable{
	private String id;//产品id
	
	private String productName;//产品名称
	
	private String productModel;//产品型号
	
	private String quantity;//产品数量
	
	private String coefficient;//产品工序工时的计算系数

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(String coefficient) {
		this.coefficient = coefficient;
	}
	
}
