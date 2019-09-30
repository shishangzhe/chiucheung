package cn.chiucheung.pojo.engineering.workhours;

import java.io.Serializable;
import java.util.Date;
/**
 * 这里不继承WorkHours，是因为返回json的时候，需要这个顺序来
 * @author adm-03
 *
 */
public class EngWorkHoursCustom implements Serializable{
	private String id;

    private Date workHoursDate;

	private String workCardCategory;
	
    private String workCardNo;
    
	private String workCardYear;

    private String workCardItem;

    private Float workHours;

    private String workShiftId;

    private String workContent;
    
    private String username;

    private String userId;

    private String workContentCustom;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getWorkHoursDate() {
		return workHoursDate;
	}

	public void setWorkHoursDate(Date workHoursDate) {
		this.workHoursDate = workHoursDate;
	}

	public String getWorkCardCategory() {
		return workCardCategory;
	}

	public void setWorkCardCategory(String workCardCategory) {
		this.workCardCategory = workCardCategory;
	}

	public String getWorkCardNo() {
		return workCardNo;
	}

	public void setWorkCardNo(String workCardNo) {
		this.workCardNo = workCardNo;
	}

	public String getWorkCardYear() {
		return workCardYear;
	}

	public void setWorkCardYear(String workCardYear) {
		this.workCardYear = workCardYear;
	}

	public String getWorkCardItem() {
		return workCardItem;
	}

	public void setWorkCardItem(String workCardItem) {
		this.workCardItem = workCardItem;
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
		this.workShiftId = workShiftId;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getWorkContentCustom() {
		return workContentCustom;
	}

	public void setWorkContentCustom(String workContentCustom) {
		this.workContentCustom = workContentCustom;
	}
	
}
