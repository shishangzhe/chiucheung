package cn.chiucheung.pojo.engineering.standardBom;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import cn.chiucheung.po.engineering.standardbom.EngStandardBom;

public class EngStandardBomCustom extends EngStandardBom implements Serializable{
    private String materialCode;

    private String materialType;

    private String materialName;
    
    private BigDecimal singletonConsumption;

    private String useUnit;

    private String applicableProduct;

    private String classification;

    private String materialProperties;
    
    private String productionWorkshop;

    private String specifications;
    
    private String length;

    private String height;

    private String width;

    private String depth;

    private String color;

    private String drawingNumber;

    private String remark;//标准Bom的备注
    
    private String materialRemark;//物料的备注
    
    private String fileId;
    
	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
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
		this.useUnit = useUnit;
	}

	public String getApplicableProduct() {
		return applicableProduct;
	}

	public void setApplicableProduct(String applicableProduct) {
		this.applicableProduct = applicableProduct;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getMaterialProperties() {
		return materialProperties;
	}

	public void setMaterialProperties(String materialProperties) {
		this.materialProperties = materialProperties;
	}

	public String getProductionWorkshop() {
		return productionWorkshop;
	}

	public void setProductionWorkshop(String productionWorkshop) {
		this.productionWorkshop = productionWorkshop;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDrawingNumber() {
		return drawingNumber;
	}

	public void setDrawingNumber(String drawingNumber) {
		this.drawingNumber = drawingNumber;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMaterialRemark() {
		return materialRemark;
	}

	public void setMaterialRemark(String materialRemark) {
		this.materialRemark = materialRemark;
	}

	public String getFileId() {
		if (StringUtils.isNotBlank(fileId)){
			fileId = "<a href='readFileById.action?id="+fileId+"' target='target_'>查看</a>";
		}
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
}
