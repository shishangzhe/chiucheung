package cn.chiucheung.pojo.logistics.travelspendingrecords;

import java.util.Date;

public class LogTravelSpendingRecordsQueryVo {
	private String finCheckSheetid;//用来生成报账单的时候，将所有符合条件的差旅记录表的外键更新成这个
	
	private boolean isNull;
	
	private String username;
	
	private String workCardNo;
	
	private String provinces;
	
	private String city;
	
	private Date startTime;
	
	private Date endTime;
	
	private String groupsId;//用于导出分组
	
	private int page;//第几页
	
	private int rows;//每页多少条记录
	
	private int startPage;
	
	private String sort;
	
	private String order;

	public String getFinCheckSheetid() {
		return finCheckSheetid;
	}

	public void setFinCheckSheetid(String finCheckSheetid) {
		this.finCheckSheetid = finCheckSheetid;
	}

	public boolean getIsNull() {
		return isNull;
	}

	public void setIsNull(boolean isNull) {
		this.isNull = isNull;
	}

	public String getUsername() {
		if (username != null && !"".equals(username)){
			if (username.indexOf(",") > 0){
				String[] usernames = username.split(",");
				if (usernames.length > 1){
					StringBuffer buffer = new StringBuffer();
					buffer.append("AND (u.username LIKE ");
					for (int i=0;i<usernames.length;i++) {
						if (i==0){
							buffer.append("'%" + usernames[i] + "%'");
						}else if (i == usernames.length - 1){
							buffer.append(" OR u.username LIKE '%" + usernames[i] + "%')");
						}else{
							buffer.append(" OR u.username LIKE '%" + usernames[i] + "%'");
						}
					}
					return buffer.toString();
				}else{
					return "AND u.username LIKE '%" + usernames[0] + "%'";
				}
			}else{
				return "AND u.username LIKE '%" + username + "%'";
			}
		}else{
			return username;
		}
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getGroupsId() {
		return groupsId;
	}

	public void setGroupsId(String groupsId) {
		this.groupsId = groupsId;
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
	
}
