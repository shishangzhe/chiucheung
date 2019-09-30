package cn.chiucheung.pojo.purchase.supplier;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;

public class SupplierMaterialCustomer {

    private String id;

    private String materialCode;

    private String materialType;

    private String materialName;

    private String applicableProduct;

    private String classification;

    private String materialProperties;

    private String specifications;

    private String length;

    private String width;

    private String height;

    private String depth;

    private String color;

    private String purchaseUnit;

    private Integer purchaseQuantityAccuracy;

    private String useUnit;

    private Integer useQuantityAccuracy;

    private String unitConversionFormula;

    private Integer batch;

    private Integer procurementCycle;

    private Integer division;

    private String productionWorkshop;

    private Integer lowestWarehousingQuantity;

    private Integer highestWarehousingQuantity;

    private Integer onceProduceQuantity;

    private Integer minProduceQuantity;

    private String drawingNumber;

    private String inspectionStandard;

    private String inspectionWay;

    private String warehouse;

    private String warehousePositions;

    private String remark;

    private String state;

    private String supplierId;

    private Date createTime;

    private String fileId;

    private BigDecimal originalPrice;//物料原价

    private BigDecimal newPrice;//物料新价

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
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

    public String getPurchaseUnit() {
        return purchaseUnit;
    }

    public void setPurchaseUnit(String purchaseUnit) {
        this.purchaseUnit = purchaseUnit;
    }

    public Integer getPurchaseQuantityAccuracy() {
        return purchaseQuantityAccuracy;
    }

    public void setPurchaseQuantityAccuracy(Integer purchaseQuantityAccuracy) {
        this.purchaseQuantityAccuracy = purchaseQuantityAccuracy;
    }

    public String getUseUnit() {
        return useUnit;
    }

    public void setUseUnit(String useUnit) {
        this.useUnit = useUnit;
    }

    public Integer getUseQuantityAccuracy() {
        return useQuantityAccuracy;
    }

    public void setUseQuantityAccuracy(Integer useQuantityAccuracy) {
        this.useQuantityAccuracy = useQuantityAccuracy;
    }

    public String getUnitConversionFormula() {
        return unitConversionFormula;
    }

    public void setUnitConversionFormula(String unitConversionFormula) {
        this.unitConversionFormula = unitConversionFormula;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public Integer getProcurementCycle() {
        return procurementCycle;
    }

    public void setProcurementCycle(Integer procurementCycle) {
        this.procurementCycle = procurementCycle;
    }

    public Integer getDivision() {
        return division;
    }

    public void setDivision(Integer division) {
        this.division = division;
    }

    public String getProductionWorkshop() {
        return productionWorkshop;
    }

    public void setProductionWorkshop(String productionWorkshop) {
        this.productionWorkshop = productionWorkshop;
    }

    public Integer getLowestWarehousingQuantity() {
        return lowestWarehousingQuantity;
    }

    public void setLowestWarehousingQuantity(Integer lowestWarehousingQuantity) {
        this.lowestWarehousingQuantity = lowestWarehousingQuantity;
    }

    public Integer getHighestWarehousingQuantity() {
        return highestWarehousingQuantity;
    }

    public void setHighestWarehousingQuantity(Integer highestWarehousingQuantity) {
        this.highestWarehousingQuantity = highestWarehousingQuantity;
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

    public String getDrawingNumber() {
        return drawingNumber;
    }

    public void setDrawingNumber(String drawingNumber) {
        this.drawingNumber = drawingNumber;
    }

    public String getInspectionStandard() {
        return inspectionStandard;
    }

    public void setInspectionStandard(String inspectionStandard) {
        this.inspectionStandard = inspectionStandard;
    }

    public String getInspectionWay() {
        return inspectionWay;
    }

    public void setInspectionWay(String inspectionWay) {
        this.inspectionWay = inspectionWay;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getWarehousePositions() {
        return warehousePositions;
    }

    public void setWarehousePositions(String warehousePositions) {
        this.warehousePositions = warehousePositions;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal price) {
        this.originalPrice = price;
    }

    public BigDecimal getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(BigDecimal newPrice) {
        this.newPrice = newPrice;
    }
}
