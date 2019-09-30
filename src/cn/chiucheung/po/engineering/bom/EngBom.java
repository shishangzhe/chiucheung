package cn.chiucheung.po.engineering.bom;

import java.util.Date;

public class EngBom {
    private String id;

    private Date bomDate;

    private Integer numberOfTimes;

    private String preparer;

    private String salWorkCardSubsidiaryId;

    private String processInstanceId;

    private String state;

    private String explain;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getBomDate() {
        return bomDate;
    }

    public void setBomDate(Date bomDate) {
        this.bomDate = bomDate;
    }

    public Integer getNumberOfTimes() {
        return numberOfTimes;
    }

    public void setNumberOfTimes(Integer numberOfTimes) {
        this.numberOfTimes = numberOfTimes;
    }

    public String getPreparer() {
        return preparer;
    }

    public void setPreparer(String preparer) {
        this.preparer = preparer == null ? null : preparer.trim();
    }

    public String getSalWorkCardSubsidiaryId() {
        return salWorkCardSubsidiaryId;
    }

    public void setSalWorkCardSubsidiaryId(String salWorkCardSubsidiaryId) {
        this.salWorkCardSubsidiaryId = salWorkCardSubsidiaryId == null ? null : salWorkCardSubsidiaryId.trim();
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

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
    }
}