package cn.chiucheung.po.production.storagewarehouseworkcard;

import java.util.Date;

public class ProStorageWarehouseWorkCardSubsidiary {
    private String id;

    private Integer sequence;

    private Integer quantity;

    private Integer previousDays;

    private Date expectedDeliveryDate;

    private Date engReleaseDataDate;

    private String remark;

    private String warMaterialId;

    private String proStorageWarehouseWorkCardId;

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

    public Integer getPreviousDays() {
        return previousDays;
    }

    public void setPreviousDays(Integer previousDays) {
        this.previousDays = previousDays;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public Date getEngReleaseDataDate() {
        return engReleaseDataDate;
    }

    public void setEngReleaseDataDate(Date engReleaseDataDate) {
        this.engReleaseDataDate = engReleaseDataDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getWarMaterialId() {
        return warMaterialId;
    }

    public void setWarMaterialId(String warMaterialId) {
        this.warMaterialId = warMaterialId == null ? null : warMaterialId.trim();
    }

    public String getProStorageWarehouseWorkCardId() {
        return proStorageWarehouseWorkCardId;
    }

    public void setProStorageWarehouseWorkCardId(String proStorageWarehouseWorkCardId) {
        this.proStorageWarehouseWorkCardId = proStorageWarehouseWorkCardId == null ? null : proStorageWarehouseWorkCardId.trim();
    }
}