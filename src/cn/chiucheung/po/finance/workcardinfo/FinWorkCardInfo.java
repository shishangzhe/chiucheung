package cn.chiucheung.po.finance.workcardinfo;

import java.math.BigDecimal;
import java.util.Date;

public class FinWorkCardInfo {
    private String id;

    private String workCardNo;

    private String projectLeader;

    private BigDecimal contractAmount;

    private BigDecimal expectedInstallationCost;

    private Float expectedInstallationTime;

    private Float actualAuxiliaryTime;

    private Date completionDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getWorkCardNo() {
        return workCardNo;
    }

    public void setWorkCardNo(String workCardNo) {
        this.workCardNo = workCardNo == null ? null : workCardNo.trim();
    }

    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader == null ? null : projectLeader.trim();
    }

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    public BigDecimal getExpectedInstallationCost() {
        return expectedInstallationCost;
    }

    public void setExpectedInstallationCost(BigDecimal expectedInstallationCost) {
        this.expectedInstallationCost = expectedInstallationCost;
    }

    public Float getExpectedInstallationTime() {
        return expectedInstallationTime;
    }

    public void setExpectedInstallationTime(Float expectedInstallationTime) {
        this.expectedInstallationTime = expectedInstallationTime;
    }

    public Float getActualAuxiliaryTime() {
        return actualAuxiliaryTime;
    }

    public void setActualAuxiliaryTime(Float actualAuxiliaryTime) {
        this.actualAuxiliaryTime = actualAuxiliaryTime;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }
}