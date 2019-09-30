package cn.chiucheung.po.engineering.standardbom;

import java.math.BigDecimal;

public class EngStandardBomSubsidiary {
    private String id;

    private Integer serialNumber;

    private BigDecimal singletonConsumption;

    private String remark;

    private String engStandardBomId;

    private String warMaterialId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getSingletonConsumption() {
        return singletonConsumption;
    }

    public void setSingletonConsumption(BigDecimal singletonConsumption) {
        this.singletonConsumption = singletonConsumption;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getEngStandardBomId() {
        return engStandardBomId;
    }

    public void setEngStandardBomId(String engStandardBomId) {
        this.engStandardBomId = engStandardBomId == null ? null : engStandardBomId.trim();
    }

    public String getWarMaterialId() {
        return warMaterialId;
    }

    public void setWarMaterialId(String warMaterialId) {
        this.warMaterialId = warMaterialId == null ? null : warMaterialId.trim();
    }
}