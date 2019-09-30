package cn.chiucheung.pojo.logistics.travelspendingrecords;

import java.util.List;

import cn.chiucheung.po.logistics.travelspendingrecords.LogTravelOtherSpending;
import cn.chiucheung.po.logistics.travelspendingrecords.LogTravelTrafficSpending;

public class LogTravelSpendingRecordsCustom{
	
	private List<LogTravelTrafficSpending> traffics;
	
	private List<LogTravelOtherSpending> others;
	
	private List<LogTravelOtherSpending> subsidies;
	
	private String id;
	
	private String workNo;
	
	private String username;

    private String password;
    
    private String deviceSerialNumber;

    private String workCardNo;

    private String isAirpoint;
    
    private String travelDate;

    private Integer liveNumber;

    private Integer livePrice;

    private String provinces;

    private String city;

    private String startTime1;

    private String endTime1;

    private Integer lunch;
    
    private String lunchType;

    private String startTime2;

    private String endTime2;

    private Integer dinner;
    
    private String dinnerType;

    private String startTime3;

    private String endTime3;

    private Integer midnightSnack;

    private String finCheckSheetId;
    
    private String logTravelUserId;
    
    private String state;

	public List<LogTravelTrafficSpending> getTraffics() {
		return traffics;
	}

	public void setTraffics(List<LogTravelTrafficSpending> traffics) {
		this.traffics = traffics;
	}

	public List<LogTravelOtherSpending> getOthers() {
		return others;
	}

	public void setOthers(List<LogTravelOtherSpending> others) {
		this.others = others;
	}

	public List<LogTravelOtherSpending> getSubsidies() {
		return subsidies;
	}

	public void setSubsidies(List<LogTravelOtherSpending> subsidies) {
		this.subsidies = subsidies;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWorkNo() {
		return workNo;
	}

	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeviceSerialNumber() {
		return deviceSerialNumber;
	}

	public void setDeviceSerialNumber(String deviceSerialNumber) {
		this.deviceSerialNumber = deviceSerialNumber;
	}

	public String getWorkCardNo() {
		return workCardNo;
	}

	public void setWorkCardNo(String workCardNo) {
		this.workCardNo = workCardNo;
	}

	public String getIsAirpoint() {
		return isAirpoint;
	}

	public void setIsAirpoint(String isAirpoint) {
		this.isAirpoint = isAirpoint;
	}

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public Integer getLiveNumber() {
		return liveNumber!=null && liveNumber > 0 ? liveNumber : null;
	}

	public void setLiveNumber(Integer liveNumber) {
		this.liveNumber = liveNumber;
	}

	public Integer getLivePrice() {
		return livePrice != null && livePrice > 0 ? livePrice : null;
	}

	public void setLivePrice(Integer livePrice) {
		this.livePrice = livePrice;
	}

	public String getProvinces() {
		return provinces;
	}

	public void setProvinces(String provinces) {
		this.provinces = provinces;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStartTime1() {
		return startTime1;
	}

	public void setStartTime1(String startTime1) {
		this.startTime1 = startTime1;
	}

	public String getEndTime1() {
		return endTime1;
	}

	public void setEndTime1(String endTime1) {
		this.endTime1 = endTime1;
	}

	public Integer getLunch() {
		return lunch != null && lunch > 0 ? lunch : null;
	}

	public void setLunch(Integer lunch) {
		this.lunch = lunch;
	}

	public String getLunchType() {
		return lunchType;
	}

	public void setLunchType(String lunchType) {
		this.lunchType = lunchType;
	}

	public String getStartTime2() {
		return startTime2;
	}

	public void setStartTime2(String startTime2) {
		this.startTime2 = startTime2;
	}

	public String getEndTime2() {
		return endTime2;
	}

	public void setEndTime2(String endTime2) {
		this.endTime2 = endTime2;
	}

	public Integer getDinner() {
		return dinner != null && dinner > 0 ? dinner : null;
	}

	public void setDinner(Integer dinner) {
		this.dinner = dinner;
	}

	public String getDinnerType() {
		return dinnerType;
	}

	public void setDinnerType(String dinnerType) {
		this.dinnerType = dinnerType;
	}

	public String getStartTime3() {
		return startTime3;
	}

	public void setStartTime3(String startTime3) {
		this.startTime3 = startTime3;
	}

	public String getEndTime3() {
		return endTime3;
	}

	public void setEndTime3(String endTime3) {
		this.endTime3 = endTime3;
	}

	public Integer getMidnightSnack() {
		return midnightSnack != null && midnightSnack > 0 ? midnightSnack : null;
	}

	public void setMidnightSnack(Integer midnightSnack) {
		this.midnightSnack = midnightSnack;
	}

	public String getFinCheckSheetId() {
		return finCheckSheetId;
	}

	public void setFinCheckSheetId(String finCheckSheetId) {
		this.finCheckSheetId = finCheckSheetId;
	}

	public String getLogTravelUserId() {
		return logTravelUserId;
	}

	public void setLogTravelUserId(String logTravelUserId) {
		this.logTravelUserId = logTravelUserId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
