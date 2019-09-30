package cn.chiucheung.pojo.finance.checksheet;

import java.util.Date;


public class LogTravelSpendingRecordsMultipleDataCustomForExportExcelForCheckSheet {
	private Date travelDate;
	
	private int lunch;
	
	private int dinner;
	
	private int midnightSnack;
	
	private int livePrice;
	
	private float trafficPrice;
	
	private float trainAndAirTicket;
	
	private float other1;
	
	private float other2;
	
	private float other3;
	
	private float other4;
	
	private float other5;
	
	private float other6;
	
	private float other7;
	
	private float other8;
	
	private float other9;
	
	private float other10;
	
	private float other11;
	
	private float count;

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public int getLunch() {
		return lunch;
	}

	public void setLunch(int lunch) {
		this.lunch = lunch;
	}

	public int getDinner() {
		return dinner;
	}

	public void setDinner(int dinner) {
		this.dinner = dinner;
	}

	public int getMidnightSnack() {
		return midnightSnack;
	}

	public void setMidnightSnack(int midnightSnack) {
		this.midnightSnack = midnightSnack;
	}

	public int getLivePrice() {
		return livePrice;
	}

	public void setLivePrice(int livePrice) {
		this.livePrice = livePrice;
	}

	public float getTrafficPrice() {
		return trafficPrice;
	}

	public void setTrafficPrice(float trafficPrice) {
		this.trafficPrice = trafficPrice;
	}

	public float getTrainAndAirTicket() {
		return trainAndAirTicket;
	}

	public void setTrainAndAirTicket(float trainAndAirTicket) {
		this.trainAndAirTicket = trainAndAirTicket;
	}

	public float getOther1() {
		return other1;
	}

	public void setOther1(float other1) {
		this.other1 = other1;
	}

	public float getOther2() {
		return other2;
	}

	public void setOther2(float other2) {
		this.other2 = other2;
	}

	public float getOther3() {
		return other3;
	}

	public void setOther3(float other3) {
		this.other3 = other3;
	}

	public float getOther4() {
		return other4;
	}

	public void setOther4(float other4) {
		this.other4 = other4;
	}

	public float getOther5() {
		return other5;
	}

	public void setOther5(float other5) {
		this.other5 = other5;
	}

	public float getOther6() {
		return other6;
	}

	public void setOther6(float other6) {
		this.other6 = other6;
	}

	public float getOther7() {
		return other7;
	}

	public void setOther7(float other7) {
		this.other7 = other7;
	}

	public float getOther8() {
		return other8;
	}

	public void setOther8(float other8) {
		this.other8 = other8;
	}

	public float getOther9() {
		return other9;
	}

	public void setOther9(float other9) {
		this.other9 = other9;
	}

	public float getOther10() {
		return other10;
	}

	public void setOther10(float other10) {
		this.other10 = other10;
	}

	public float getOther11() {
		return other11;
	}

	public void setOther11(float other11) {
		this.other11 = other11;
	}

	public float getCount() {
		return lunch + dinner + midnightSnack + livePrice + trafficPrice +trainAndAirTicket + other1
				+ other2 + other3 + other4 + other5 + other6 + other7 + other8 + other9 + other10 + other11;
	}
	
}