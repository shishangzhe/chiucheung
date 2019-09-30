package cn.chiucheung.po.warehouse.storagewarehouseworkcardstockin;

public class WarStorageWarehouseWorkCardStockInSubsidiary {
    private String id;

    private Integer sequence;

    private Integer quantity;

    private String remark;

    private String proStorageWarehouseWorkCardSubsidiaryId;

    private String warStorageWarehouseWorkCardStockInId;

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

    public String getProStorageWarehouseWorkCardSubsidiaryId() {
        return proStorageWarehouseWorkCardSubsidiaryId;
    }

    public void setProStorageWarehouseWorkCardSubsidiaryId(String proStorageWarehouseWorkCardSubsidiaryId) {
        this.proStorageWarehouseWorkCardSubsidiaryId = proStorageWarehouseWorkCardSubsidiaryId == null ? null : proStorageWarehouseWorkCardSubsidiaryId.trim();
    }

    public String getWarStorageWarehouseWorkCardStockInId() {
        return warStorageWarehouseWorkCardStockInId;
    }

    public void setWarStorageWarehouseWorkCardStockInId(String warStorageWarehouseWorkCardStockInId) {
        this.warStorageWarehouseWorkCardStockInId = warStorageWarehouseWorkCardStockInId == null ? null : warStorageWarehouseWorkCardStockInId.trim();
    }
}