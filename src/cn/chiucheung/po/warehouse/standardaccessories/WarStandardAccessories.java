package cn.chiucheung.po.warehouse.standardaccessories;

public class WarStandardAccessories {
    private String id;

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

    private Integer lowestWarehousingQuantity;

    private Integer onceProduceQuantity;

    private Integer minProduceQuantity;

    private Integer eachNumber;

    private String warehouseInventory;

    private String warehousePositions;

    private String drawingNumber;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccessoriesCode() {
        return accessoriesCode;
    }

    public void setAccessoriesCode(String accessoriesCode) {
        this.accessoriesCode = accessoriesCode == null ? null : accessoriesCode.trim();
    }

    public String getAccessoriesType() {
        return accessoriesType;
    }

    public void setAccessoriesType(String accessoriesType) {
        this.accessoriesType = accessoriesType == null ? null : accessoriesType.trim();
    }

    public String getAccessoriesName() {
        return accessoriesName;
    }

    public void setAccessoriesName(String accessoriesName) {
        this.accessoriesName = accessoriesName == null ? null : accessoriesName.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification == null ? null : classification.trim();
    }

    public String getMaterialProperties() {
        return materialProperties;
    }

    public void setMaterialProperties(String materialProperties) {
        this.materialProperties = materialProperties == null ? null : materialProperties.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width == null ? null : width.trim();
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth == null ? null : depth.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Integer getLowestWarehousingQuantity() {
        return lowestWarehousingQuantity;
    }

    public void setLowestWarehousingQuantity(Integer lowestWarehousingQuantity) {
        this.lowestWarehousingQuantity = lowestWarehousingQuantity;
    }

    public Integer getOnceProduceQuantity() {
        return onceProduceQuantity;
    }

    public void setOnceProduceQuantity(Integer onceProduceQuantity) {
        this.onceProduceQuantity = onceProduceQuantity;
    }

    public Integer getMinProduceQuantity() {
        return minProduceQuantity;
    }

    public void setMinProduceQuantity(Integer minProduceQuantity) {
        this.minProduceQuantity = minProduceQuantity;
    }

    public Integer getEachNumber() {
        return eachNumber;
    }

    public void setEachNumber(Integer eachNumber) {
        this.eachNumber = eachNumber;
    }

    public String getWarehouseInventory() {
        return warehouseInventory;
    }

    public void setWarehouseInventory(String warehouseInventory) {
        this.warehouseInventory = warehouseInventory == null ? null : warehouseInventory.trim();
    }

    public String getWarehousePositions() {
        return warehousePositions;
    }

    public void setWarehousePositions(String warehousePositions) {
        this.warehousePositions = warehousePositions == null ? null : warehousePositions.trim();
    }

    public String getDrawingNumber() {
        return drawingNumber;
    }

    public void setDrawingNumber(String drawingNumber) {
        this.drawingNumber = drawingNumber == null ? null : drawingNumber.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}