package cn.chiucheung.po.logistics.travelspendingrecords;

import java.util.Date;

public class LogTravelSpendingRecords {
    private String id;

    private String workCardNo;

    private String isAirpoint;

    private Date travelDate;

    private Integer liveNumber;

    private Integer livePrice;

    private String provinces;

    private String city;

    private Date startTime1;

    private Date endTime1;

    private Integer lunch;

    private String lunchType;

    private Date startTime2;

    private Date endTime2;

    private Integer dinner;

    private String dinnerType;

    private Date startTime3;

    private Date endTime3;

    private Integer midnightSnack;

    private Date createTime;

    private String state;

    private String finCheckSheetId;

    private String logTravelUserId;

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

    public String getIsAirpoint() {
        return isAirpoint;
    }

    public void setIsAirpoint(String isAirpoint) {
        this.isAirpoint = isAirpoint == null ? null : isAirpoint.trim();
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public Integer getLiveNumber() {
        return liveNumber;
    }

    public void setLiveNumber(Integer liveNumber) {
        this.liveNumber = liveNumber;
    }

    public Integer getLivePrice() {
        return livePrice;
    }

    public void setLivePrice(Integer livePrice) {
        this.livePrice = livePrice;
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces == null ? null : provinces.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Date getStartTime1() {
        return startTime1;
    }

    public void setStartTime1(Date startTime1) {
        this.startTime1 = startTime1;
    }

    public Date getEndTime1() {
        return endTime1;
    }

    public void setEndTime1(Date endTime1) {
        this.endTime1 = endTime1;
    }

    public Integer getLunch() {
        return lunch;
    }

    public void setLunch(Integer lunch) {
        this.lunch = lunch;
    }

    public String getLunchType() {
        return lunchType;
    }

    public void setLunchType(String lunchType) {
        this.lunchType = lunchType == null ? null : lunchType.trim();
    }

    public Date getStartTime2() {
        return startTime2;
    }

    public void setStartTime2(Date startTime2) {
        this.startTime2 = startTime2;
    }

    public Date getEndTime2() {
        return endTime2;
    }

    public void setEndTime2(Date endTime2) {
        this.endTime2 = endTime2;
    }

    public Integer getDinner() {
        return dinner;
    }

    public void setDinner(Integer dinner) {
        this.dinner = dinner;
    }

    public String getDinnerType() {
        return dinnerType;
    }

    public void setDinnerType(String dinnerType) {
        this.dinnerType = dinnerType == null ? null : dinnerType.trim();
    }

    public Date getStartTime3() {
        return startTime3;
    }

    public void setStartTime3(Date startTime3) {
        this.startTime3 = startTime3;
    }

    public Date getEndTime3() {
        return endTime3;
    }

    public void setEndTime3(Date endTime3) {
        this.endTime3 = endTime3;
    }

    public Integer getMidnightSnack() {
        return midnightSnack;
    }

    public void setMidnightSnack(Integer midnightSnack) {
        this.midnightSnack = midnightSnack;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getFinCheckSheetId() {
        return finCheckSheetId;
    }

    public void setFinCheckSheetId(String finCheckSheetId) {
        this.finCheckSheetId = finCheckSheetId == null ? null : finCheckSheetId.trim();
    }

    public String getLogTravelUserId() {
        return logTravelUserId;
    }

    public void setLogTravelUserId(String logTravelUserId) {
        this.logTravelUserId = logTravelUserId == null ? null : logTravelUserId.trim();
    }
}