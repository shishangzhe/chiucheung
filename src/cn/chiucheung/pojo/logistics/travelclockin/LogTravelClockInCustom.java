package cn.chiucheung.pojo.logistics.travelclockin;

import java.text.SimpleDateFormat;
import java.util.Date;


public class LogTravelClockInCustom{
	private String id;
	
	private String workNo;
	
	private String username;
	
	private String password;
	
	private String deviceSerialNumber;
	
	private Date clockOn;
	
	private String address;

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

	public String getClockOn() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(clockOn);
	}

	public void setClockOn(Date clockOn) {
		this.clockOn = clockOn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
