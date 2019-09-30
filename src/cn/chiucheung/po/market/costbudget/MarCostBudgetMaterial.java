package cn.chiucheung.po.market.costbudget;

import java.io.Serializable;

public class MarCostBudgetMaterial implements Serializable{
    private String id;

    private Integer number;

    private String componentName;

    private String materialType;

    private String materialName;

    private String model;

    private String thick;

    private String length;

    private String width;

    private String weight;

    private String quantity;

    private String unit;

    private String unitPrice;

    private String remark;

    private String marCostBudgetId;

    private String purMaterialId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName == null ? null : componentName.trim();
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType == null ? null : materialType.trim();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity == null ? null : quantity.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice == null ? null : unitPrice.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getMarCostBudgetId() {
        return marCostBudgetId;
    }

    public void setMarCostBudgetId(String marCostBudgetId) {
        this.marCostBudgetId = marCostBudgetId == null ? null : marCostBudgetId.trim();
    }

    public String getPurMaterialId() {
        return purMaterialId;
    }

    public void setPurMaterialId(String purMaterialId) {
        this.purMaterialId = purMaterialId == null ? null : purMaterialId.trim();
    }
}