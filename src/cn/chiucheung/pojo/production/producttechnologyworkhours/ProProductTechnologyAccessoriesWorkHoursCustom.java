package cn.chiucheung.pojo.production.producttechnologyworkhours;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import cn.chiucheung.po.production.producttechnologyworkhours.ProProductTechnologyAccessoriesWorkHours;

public class ProProductTechnologyAccessoriesWorkHoursCustom extends ProProductTechnologyAccessoriesWorkHours implements Serializable{
	
	private BigDecimal totalTime;

    private BigDecimal totalArtificialTime;
    
    private String accessoriesCode;

    private String accessoriesType;

    private String accessoriesName;

    private String unit;

    private String product;

    private String classification;

    private String materialProperties;

    private String specifications;

    private String height;

    private String width;

    private String depth;

    private String color;

    private String fileId;

	public BigDecimal getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(BigDecimal totalTime) {
		this.totalTime = totalTime;
	}

	public BigDecimal getTotalArtificialTime() {
		return totalArtificialTime;
	}

	public void setTotalArtificialTime(BigDecimal totalArtificialTime) {
		this.totalArtificialTime = totalArtificialTime;
	}

	public String getAccessoriesCode() {
		return accessoriesCode;
	}

	public void setAccessoriesCode(String accessoriesCode) {
		this.accessoriesCode = accessoriesCode;
	}

	public String getAccessoriesType() {
		return accessoriesType;
	}

	public void setAccessoriesType(String accessoriesType) {
		this.accessoriesType = accessoriesType;
	}

	public String getAccessoriesName() {
		return accessoriesName;
	}

	public void setAccessoriesName(String accessoriesName) {
		this.accessoriesName = accessoriesName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
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

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
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
