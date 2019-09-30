package cn.chiucheung.pojo.sales.workcard;

import java.io.Serializable;
import java.util.Date;

import javax.sound.midi.Sequence;

import org.apache.commons.lang.StringUtils;

public class SalWorkCardSubsidiaryCustom implements Serializable{
	private String id;
	
	private String sequence;
	
	private String quotationNo = "";
	
	private String productCode;

    private String productName;

    private String productModel;

    private Integer quantity;

    private String unit;

    private Date expectedDeliveryDate;

    private Date engReleaseDataDate;

    private String proPeriod;
    
    private String confirmation;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getQuotationNo() {
		return quotationNo;
	}

	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public Date getEngReleaseDataDate() {
		return engReleaseDataDate;
	}

	public void setEngReleaseDataDate(Date engReleaseDataDate) {
		this.engReleaseDataDate = engReleaseDataDate;
	}

	public String getProPeriod() {
		return proPeriod;
	}

	public void setProPeriod(String proPeriod) {
		this.proPeriod = proPeriod;
	}

	public String getConfirmation() {
		return StringUtils.isNotBlank(confirmation) ? "<a style='cursor: pointer;' onclick='editConfirmation(\"" + id + "\",\"" + confirmation + "\",\"" + sequence + "\")'>查看</a>" : "";
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}
	
}
