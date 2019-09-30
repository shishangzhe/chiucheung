package cn.chiucheung.pojo.engineering.workhours;

import java.util.Date;

public class EngWorkHoursVo {
	
	private Date startWorkHoursDate;
	
	private Date endWorkHoursDate;
	
	private String username;
	
	private String workCardNo;
	
	private String workCardItem;
	
	private String workContent;
	
	private String workShiftId;
	
	private String userId;//用来权限控制的
	
	private String groupsId;//用来权限控制的
	
	private String departmentId;//用来权限控制的
	
	private int page;//第几页
	
	private int rows;//每页多少条记录
	
	private int startPage;
	
	private String sort;
	
	private String order;
	
	public Date getStartWorkHoursDate() {
		return startWorkHoursDate;
	}
	public void setStartWorkHoursDate(Date startWorkHoursDate) {
		this.startWorkHoursDate = startWorkHoursDate;
	}
	public Date getEndWorkHoursDate() {
		return endWorkHoursDate;
	}
	public void setEndWorkHoursDate(Date endWorkHoursDate) {
		this.endWorkHoursDate = endWorkHoursDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getWorkCardNo() {
		return workCardNo;
	}
	public void setWorkCardNo(String workCardNo) {
		this.workCardNo = workCardNo;
	}
	public String getWorkCardItem() {
		return workCardItem;
	}
	public void setWorkCardItem(String workCardItem) {
		this.workCardItem = workCardItem;
	}
	public String getWorkContent() {
		return workContent;
	}
	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public String getWorkShiftId() {
		return workShiftId;
	}
	public void setWorkShiftId(String workShiftId) {
		this.workShiftId = workShiftId;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getStartPage() {
		return (page-1)*rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getGroupsId() {
		return groupsId;
	}
	public void setGroupsId(String groupsId) {
		this.groupsId = groupsId;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
