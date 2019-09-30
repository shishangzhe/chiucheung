package cn.chiucheung.po.warehouse.standardaccessoriesstockout;

public class WarStandardAccessoriesStockOutSubsidiary {
    private String id;

    private Integer sequence;

    private Integer quantity;

    private String remark;

    private String warStandardAccessoriesId;

    private String warStandardAccessoriesStockOutId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getWarStandardAccessoriesId() {
        return warStandardAccessoriesId;
    }

    public void setWarStandardAccessoriesId(String warStandardAccessoriesId) {
        this.warStandardAccessoriesId = warStandardAccessoriesId == null ? null : warStandardAccessoriesId.trim();
    }

    public String getWarStandardAccessoriesStockOutId() {
        return warStandardAccessoriesStockOutId;
    }

    public void setWarStandardAccessoriesStockOutId(String warStandardAccessoriesStockOutId) {
        this.warStandardAccessoriesStockOutId = warStandardAccessoriesStockOutId == null ? null : warStandardAccessoriesStockOutId.trim();
    }
}