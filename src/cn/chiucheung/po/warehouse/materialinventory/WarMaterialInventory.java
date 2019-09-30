package cn.chiucheung.po.warehouse.materialinventory;

import java.math.BigDecimal;

public class WarMaterialInventory {
    private String id;

    private BigDecimal existingQuantity;

    private String warMaterialId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public BigDecimal getExistingQuantity() {
        return existingQuantity;
    }

    public void setExistingQuantity(BigDecimal existingQuantity) {
        this.existingQuantity = existingQuantity;
    }

    public String getWarMaterialId() {
        return warMaterialId;
    }

    public void setWarMaterialId(String warMaterialId) {
        this.warMaterialId = warMaterialId == null ? null : warMaterialId.trim();
    }
}