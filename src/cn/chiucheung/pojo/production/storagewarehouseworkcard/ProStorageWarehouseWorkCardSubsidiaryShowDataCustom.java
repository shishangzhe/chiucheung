package cn.chiucheung.pojo.production.storagewarehouseworkcard;

import java.util.Date;

public class ProStorageWarehouseWorkCardSubsidiaryShowDataCustom {
	private String id;
	
	private String sequence;
	
	private String materialCode;
	
	private String materialName;
	
	private String materialModel;
	
	private Integer quantity;
	
	private String useUnit;
	
	private Integer previousDays;
	
	private Date expectedDeliveryDate;

	private Date engReleaseDataDate;

	private String remark;
	
	private String workCardNo;
	
	private String warMaterialId;

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

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialModel() {
		return materialModel;
	}

	public void setMaterialModel(String materialModel) {
		this.materialModel = materialModel;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getUseUnit() {
		return useUnit;
	}

	public void setUseUnit(String useUnit) {
		this.useUnit = useUnit;
	}

	public Integer getPreviousDays() {
		return previousDays;
	}

	public void setPreviousDays(Integer previousDays) {
		this.previousDays = previousDays;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getWorkCardNo() {
		return workCardNo == null ? "" : workCardNo;
	}

	public void setWorkCardNo(String workCardNo) {
		this.workCardNo = workCardNo;
	}

	public String getWarMaterialId() {
		return warMaterialId;
	}

	public void setWarMaterialId(String warMaterialId) {
		this.warMaterialId = warMaterialId;
	}
	
}
