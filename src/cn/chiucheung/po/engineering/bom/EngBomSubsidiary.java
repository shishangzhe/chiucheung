package cn.chiucheung.po.engineering.bom;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class EngBomSubsidiary implements Serializable,Comparable<EngBomSubsidiary>{
    private String id;

    private String serialNumber;

    private Integer orderNumber;

    private String materialCode;

    private String materialName;

    private String specifications;

    private String drawingNumber;

    private String materialProperties;

    private String productionWorkshop;

    private String surfaceTreatment;

    private BigDecimal singletonConsumption;

    private String useUnit;

    private String remark;

    private String engBomId;

    private String engBomSubsidiaryId;

    private String warMaterialId;

    private String state;
    
    private List<EngBomSubsidiary> children;
    
    private String workCardNo;
    
    private String isMaterial;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode == null ? null : materialCode.trim();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getDrawingNumber() {
        return drawingNumber;
    }

    public void setDrawingNumber(String drawingNumber) {
        this.drawingNumber = drawingNumber == null ? null : drawingNumber.trim();
    }

    public String getMaterialProperties() {
        return materialProperties;
    }

    public void setMaterialProperties(String materialProperties) {
        this.materialProperties = materialProperties == null ? null : materialProperties.trim();
    }

    public String getProductionWorkshop() {
        return productionWorkshop;
    }

    public void setProductionWorkshop(String productionWorkshop) {
        this.productionWorkshop = productionWorkshop == null ? null : productionWorkshop.trim();
    }

    public String getSurfaceTreatment() {
        return surfaceTreatment;
    }

    public void setSurfaceTreatment(String surfaceTreatment) {
        this.surfaceTreatment = surfaceTreatment == null ? null : surfaceTreatment.trim();
    }

    public BigDecimal getSingletonConsumption() {
        return singletonConsumption;
    }

    public void setSingletonConsumption(BigDecimal singletonConsumption) {
        this.singletonConsumption = singletonConsumption;
    }

    public String getUseUnit() {
        return useUnit;
    }

    public void setUseUnit(String useUnit) {
        this.useUnit = useUnit == null ? null : useUnit.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getEngBomId() {
        return engBomId;
    }

    public void setEngBomId(String engBomId) {
        this.engBomId = engBomId == null ? null : engBomId.trim();
    }

    public String getEngBomSubsidiaryId() {
        return engBomSubsidiaryId;
    }

    public void setEngBomSubsidiaryId(String engBomSubsidiaryId) {
        this.engBomSubsidiaryId = engBomSubsidiaryId == null ? null : engBomSubsidiaryId.trim();
    }

    public String getWarMaterialId() {
        return warMaterialId;
    }

    public void setWarMaterialId(String warMaterialId) {
        this.warMaterialId = warMaterialId == null ? null : warMaterialId.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
    
	public List<EngBomSubsidiary> getChildren() {
		return children;
	}

	public void setChildren(List<EngBomSubsidiary> children) {
		this.children = children;
	}

	public String getWorkCardNo() {
		return "";
	}

	public String getIsMaterial() {
		return warMaterialId == null ? "false" : "true";
	}

	@Override
	public int compareTo(EngBomSubsidiary bomSubsidiary) {
		return this.getOrderNumber() - bomSubsidiary.getOrderNumber();// 根据年龄升序排列，降序修改相减顺序即可
	}
}