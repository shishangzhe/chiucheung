package cn.chiucheung.pojo.engineering.workhours;

import java.util.Date;

/**
 * 用于导出数据的pojo，1、和2、和3、分别用于多种的数据导出
 * @author adm-03
 *
 */
public class EngExportResultsExcelCustom {
	private String username;//1、用户姓名   2、用户姓名  3、工咭类型 5、用户姓名
	
	private float workHours1;//1、当月实用工时  2、BJ/CJ工时  3、总工时
	
	private float workHours2;//1、验证、跟单工时  2、HJ工时  3、工咭数量
	
	private float workHours3;//1、出差  2、Q/HK工时  3、参数人数
	
	private float workHours4;//1、工作沟通、资料整理及移交  2、RD工时
	
	private float workHours5;//1、完成工时合计  2、FG/SG/I工时
	
	private float workHours6;//1、其他  2、标准类工时
	
	private float workHours7;//1、待工  2、出差工时
	
	private float workHours8;//1、请假  2、资料整理工时
	
	private float workHours9;//1、其他合计  2、待工工时
	
	private float workHours10;//2、验货、跟单工时
	
	private float workHours11;//2、其他工时
	
	private float workHours12;//2、个人合计工时
	
	private float workHours13;//2、请假工时
	
	private String workCardNo;//5、工咭号
	
	private Date startTime;//5、开始时间
	
	private Date endTime;//5、结束时间
	
	private float sumTimes;//5、完成工时(总工时)
	
	private String reviewer;//5、审核人
	
	private String groupsId;//5、分组id，不是用于导出，而是用于获取reviewer

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public float getWorkHours1() {
		return workHours1;
	}

	public void setWorkHours1(float workHours1) {
		this.workHours1 = workHours1;
	}

	public float getWorkHours2() {
		return workHours2;
	}

	public void setWorkHours2(float workHours2) {
		this.workHours2 = workHours2;
	}

	public float getWorkHours3() {
		return workHours3;
	}

	public void setWorkHours3(float workHours3) {
		this.workHours3 = workHours3;
	}

	public float getWorkHours4() {
		return workHours4;
	}

	public void setWorkHours4(float workHours4) {
		this.workHours4 = workHours4;
	}

	public float getWorkHours5() {
		return workHours5;
	}

	public void setWorkHours5(float workHours5) {
		this.workHours5 = workHours5;
	}

	public float getWorkHours6() {
		return workHours6;
	}

	public void setWorkHours6(float workHours6) {
		this.workHours6 = workHours6;
	}

	public float getWorkHours7() {
		return workHours7;
	}

	public void setWorkHours7(float workHours7) {
		this.workHours7 = workHours7;
	}

	public float getWorkHours8() {
		return workHours8;
	}

	public void setWorkHours8(float workHours8) {
		this.workHours8 = workHours8;
	}

	public float getWorkHours9() {
		return workHours9;
	}

	public void setWorkHours9(float workHours9) {
		this.workHours9 = workHours9;
	}

	public float getWorkHours10() {
		return workHours10;
	}

	public void setWorkHours10(float workHours10) {
		this.workHours10 = workHours10;
	}

	public float getWorkHours11() {
		return workHours11;
	}

	public void setWorkHours11(float workHours11) {
		this.workHours11 = workHours11;
	}

	public float getWorkHours12() {
		return workHours12;
	}

	public void setWorkHours12(float workHours12) {
		this.workHours12 = workHours12;
	}

	public float getWorkHours13() {
		return workHours13;
	}

	public void setWorkHours13(float workHours13) {
		this.workHours13 = workHours13;
	}

	public String getWorkCardNo() {
		return workCardNo;
	}

	public void setWorkCardNo(String workCardNo) {
		this.workCardNo = workCardNo;
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

	public float getSumTimes() {
		return sumTimes;
	}

	public void setSumTimes(float sumTimes) {
		this.sumTimes = sumTimes;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getGroupsId() {
		return groupsId;
	}

	public void setGroupsId(String groupsId) {
		this.groupsId = groupsId;
	}

}
