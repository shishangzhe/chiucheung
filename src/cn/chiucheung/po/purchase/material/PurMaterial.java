package cn.chiucheung.po.purchase.material;

import java.io.Serializable;

public class PurMaterial implements Serializable{
    private String id;

    private String materialType;

    private String materialCategory;

    private String materialName;

    private String specification;

    private String model;

    private String area;

    private String thick;

    private String length;

    private String width;

    private String density;

    private String weight;

    private String kgPrice;

    private String unitPrice;

    private String unit;

    private String supplier;

    private String usingRange;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType == null ? null : materialType.trim();
    }

    public String getMaterialCategory() {
        return materialCategory;
    }

    public void setMaterialCategory(String materialCategory) {
        this.materialCategory = materialCategory == null ? null : materialCategory.trim();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getThick() {
        return thick;
    }

    public void setThick(String thick) {
        this.thick = thick == null ? null : thick.trim();
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length == null ? null : length.trim();
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width == null ? null : width.trim();
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density == null ? null : density.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getKgPrice() {
        return kgPrice;
    }

    public void setKgPrice(String kgPrice) {
        this.kgPrice = kgPrice == null ? null : kgPrice.trim();
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice == null ? null : unitPrice.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getUsingRange() {
        return usingRange;
    }

    public void setUsingRange(String usingRange) {
        this.usingRange = usingRange == null ? null : usingRange.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}