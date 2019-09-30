package cn.chiucheung.po.engineering.workhours;

import java.io.Serializable;
import java.util.Date;

public class EngWorkHours implements Serializable{
    private String id;

    private Date workHoursDate;

    private String workCardNo;

    private String workCardItem;

    private Float workHours;

    private String workShiftId;

    private String workContent;

    private String userId;

    private String workContentCustom;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getWorkHoursDate() {
        return workHoursDate;
    }

    public void setWorkHoursDate(Date workHoursDate) {
        this.workHoursDate = workHoursDate;
    }

    public String getWorkCardNo() {
        return workCardNo;
    }

    public void setWorkCardNo(String workCardNo) {
        this.workCardNo = workCardNo == null ? null : workCardNo.trim();
    }

    public String getWorkCardItem() {
        return workCardItem;
    }

    public void setWorkCardItem(String workCardItem) {
        this.workCardItem = workCardItem == null ? null : workCardItem.trim();
    }

    public Float getWorkHours() {
        return workHours;
    }

    public void setWorkHours(Float workHours) {
        this.workHours = workHours;
    }

    public String getWorkShiftId() {
        return workShiftId;
    }

    public void setWorkShiftId(String workShiftId) {
        this.workShiftId = workShiftId == null ? null : workShiftId.trim();
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent == null ? null : workContent.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getWorkContentCustom() {
        return workContentCustom;
    }

    public void setWorkContentCustom(String workContentCustom) {
        this.workContentCustom = workContentCustom == null ? null : workContentCustom.trim();
    }
}