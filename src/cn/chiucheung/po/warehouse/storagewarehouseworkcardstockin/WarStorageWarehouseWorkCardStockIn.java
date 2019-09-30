package cn.chiucheung.po.warehouse.storagewarehouseworkcardstockin;

import java.util.Date;

public class WarStorageWarehouseWorkCardStockIn {
    private String id;

    private String stockInNo;

    private Date createTime;

    private String preparer;

    private String qcAcceptance;

    private String stockInPeople;

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

    public String getStockInNo() {
        return stockInNo;
    }

    public void setStockInNo(String stockInNo) {
        this.stockInNo = stockInNo == null ? null : stockInNo.trim();
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

    public String getQcAcceptance() {
        return qcAcceptance;
    }

    public void setQcAcceptance(String qcAcceptance) {
        this.qcAcceptance = qcAcceptance == null ? null : qcAcceptance.trim();
    }

    public String getStockInPeople() {
        return stockInPeople;
    }

    public void setStockInPeople(String stockInPeople) {
        this.stockInPeople = stockInPeople == null ? null : stockInPeople.trim();
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