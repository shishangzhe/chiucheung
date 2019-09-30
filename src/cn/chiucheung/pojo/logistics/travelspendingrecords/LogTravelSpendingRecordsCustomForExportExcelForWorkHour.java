package cn.chiucheung.pojo.logistics.travelspendingrecords;


public class LogTravelSpendingRecordsCustomForExportExcelForWorkHour {
	private String workNo;
	
	private String username;
	
	private String travelDate;
	
	private String workCardNo;
	
	private String startTime1;
	
	private String endTime1;
	
	private String startTime2;
	
	private String endTime2;
	
	private String startTime3;
	
	private String endTime3;
	
	private float morning;
	
	private float afternoon;
	
	private float evening;
	
	private float count;

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

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public String getWorkCardNo() {
		return workCardNo;
	}

	public void setWorkCardNo(String workCardNo) {
		this.workCardNo = workCardNo;
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

	public float getMorning() {
		return morning;
	}

	public void setMorning(float morning) {
		this.morning = morning;
	}

	public float getAfternoon() {
		return afternoon;
	}

	public void setAfternoon(float afternoon) {
		this.afternoon = afternoon;
	}

	public float getEvening() {
		return evening;
	}

	public void setEvening(float evening) {
		this.evening = evening;
	}

	public float getCount() {
		return morning + afternoon + evening;
	}
	
}
