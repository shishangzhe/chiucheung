package cn.chiucheung.po.warehouse.standardaccessoriesstockout;

import java.util.Date;

public class WarStandardAccessoriesStockOut {
    private String id;

    private String stockOutNo;

    private Date createTime;

    private String preparer;

    private String receiveMaterial;

    private String reviewer;

    private Date auditTime;

    private String remark;

    private String processInstanceId;

    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStockOutNo() {
        return stockOutNo;
    }

    public void setStockOutNo(String stockOutNo) {
        this.stockOutNo = stockOutNo == null ? null : stockOutNo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPreparer() {
        return preparer;
    }

    public void setPreparer(String preparer) {
        this.preparer = preparer == null ? null : preparer.trim();
    }

    public String getReceiveMaterial() {
        return receiveMaterial;
    }

    public void setReceiveMaterial(String receiveMaterial) {
        this.receiveMaterial = receiveMaterial == null ? null : receiveMaterial.trim();
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer == null ? null : reviewer.trim();
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}