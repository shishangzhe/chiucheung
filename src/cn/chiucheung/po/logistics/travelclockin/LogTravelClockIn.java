package cn.chiucheung.po.logistics.travelclockin;

import java.util.Date;

public class LogTravelClockIn {
    private String id;

    private Date clockOn;

    private String address;

    private String logTravelUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getClockOn() {
        return clockOn;
    }

    public void setClockOn(Date clockOn) {
        this.clockOn = clockOn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getLogTravelUserId() {
        return logTravelUserId;
    }

    public void setLogTravelUserId(String logTravelUserId) {
        this.logTravelUserId = logTravelUserId == null ? null : logTravelUserId.trim();
    }
}