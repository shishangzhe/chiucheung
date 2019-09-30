package cn.chiucheung.po.finance.checksheet;

import java.util.Date;

public class FinCheckSheet {
    private String id;

    private String checkSheetNo;

    private String applicant;

    private String installWorkCardNo;

    private String projectManager;

    private Date businessTripDate;

    private Date departureDate;

    private String travelPlace;

    private String accompanyingPersonnel;

    private Boolean isLock;

    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCheckSheetNo() {
        return checkSheetNo;
    }

    public void setCheckSheetNo(String checkSheetNo) {
        this.checkSheetNo = checkSheetNo == null ? null : checkSheetNo.trim();
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant == null ? null : applicant.trim();
    }

    public String getInstallWorkCardNo() {
        return installWorkCardNo;
    }

    public void setInstallWorkCardNo(String installWorkCardNo) {
        this.installWorkCardNo = installWorkCardNo == null ? null : installWorkCardNo.trim();
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager == null ? null : projectManager.trim();
    }

    public Date getBusinessTripDate() {
        return businessTripDate;
    }

    public void setBusinessTripDate(Date businessTripDate) {
        this.businessTripDate = businessTripDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getTravelPlace() {
        return travelPlace;
    }

    public void setTravelPlace(String travelPlace) {
        this.travelPlace = travelPlace == null ? null : travelPlace.trim();
    }

    public String getAccompanyingPersonnel() {
        return accompanyingPersonnel;
    }

    public void setAccompanyingPersonnel(String accompanyingPersonnel) {
        this.accompanyingPersonnel = accompanyingPersonnel == null ? null : accompanyingPersonnel.trim();
    }

    public Boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(Boolean isLock) {
        this.isLock = isLock;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}