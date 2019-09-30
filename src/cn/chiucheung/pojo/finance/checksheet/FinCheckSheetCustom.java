package cn.chiucheung.pojo.finance.checksheet;

import java.util.Date;

import cn.chiucheung.pojo.logistics.travelspendingrecords.LogTravelSpendingRecordsCustom;

public class FinCheckSheetCustom extends LogTravelSpendingRecordsCustom{
	private String checkSheetNo;

    private String applicant;

    private String installWorkCardNo;
    
    private Float totalCost;

    private String projectManager;

    private Date businessTripDate;

    private Date departureDate;

    private String travelPlace;

    private String accompanyingPersonnel;

    private String state;

	public String getCheckSheetNo() {
		return checkSheetNo;
	}

	public void setCheckSheetNo(String checkSheetNo) {
		this.checkSheetNo = checkSheetNo;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getInstallWorkCardNo() {
		return installWorkCardNo;
	}

	public void setInstallWorkCardNo(String installWorkCardNo) {
		this.installWorkCardNo = installWorkCardNo;
	}

	public Float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
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
		this.travelPlace = travelPlace;
	}

	public String getAccompanyingPersonnel() {
		return accompanyingPersonnel;
	}

	public void setAccompanyingPersonnel(String accompanyingPersonnel) {
		this.accompanyingPersonnel = accompanyingPersonnel;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    
}
