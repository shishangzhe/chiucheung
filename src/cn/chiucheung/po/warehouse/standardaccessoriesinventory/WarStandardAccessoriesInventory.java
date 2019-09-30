package cn.chiucheung.po.warehouse.standardaccessoriesinventory;

public class WarStandardAccessoriesInventory {
    private String id;

    private Integer existingQuantity;

    private String warStandardAccessoriesId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getExistingQuantity() {
        return existingQuantity;
    }

    public void setExistingQuantity(Integer existingQuantity) {
        this.existingQuantity = existingQuantity;
    }

    public String getWarStandardAccessoriesId() {
        return warStandardAccessoriesId;
    }

    public void setWarStandardAccessoriesId(String warStandardAccessoriesId) {
        this.warStandardAccessoriesId = warStandardAccessoriesId == null ? null : warStandardAccessoriesId.trim();
    }
}