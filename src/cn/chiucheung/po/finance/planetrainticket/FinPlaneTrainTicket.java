package cn.chiucheung.po.finance.planetrainticket;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import cn.chiucheung.utils.CustomDateSerializer;

public class FinPlaneTrainTicket implements Serializable{
    private String id;

    private String trafficType;

    private String workCardNo;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderTicketsDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date departureTime;

    private String travelPersonnel;

    private String startPoint;

    private String endPoint;

    private String planeTrainNumber;

    private String seat;

    private String berth;

    private Float price;

    private String orderNumber;

    private String remark;

    private Boolean isLock;

    private Boolean isReceiveReceipt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTrafficType() {
        return trafficType;
    }

    public void setTrafficType(String trafficType) {
        this.trafficType = trafficType == null ? null : trafficType.trim();
    }

    public String getWorkCardNo() {
        return workCardNo;
    }

    public void setWorkCardNo(String workCardNo) {
        this.workCardNo = workCardNo == null ? null : workCardNo.trim();
    }

    public Date getOrderTicketsDate() {
        return orderTicketsDate;
    }

    public void setOrderTicketsDate(Date orderTicketsDate) {
        this.orderTicketsDate = orderTicketsDate;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getTravelPersonnel() {
        return travelPersonnel;
    }

    public void setTravelPersonnel(String travelPersonnel) {
        this.travelPersonnel = travelPersonnel == null ? null : travelPersonnel.trim();
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint == null ? null : startPoint.trim();
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint == null ? null : endPoint.trim();
    }

    public String getPlaneTrainNumber() {
        return planeTrainNumber;
    }

    public void setPlaneTrainNumber(String planeTrainNumber) {
        this.planeTrainNumber = planeTrainNumber == null ? null : planeTrainNumber.trim();
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat == null ? null : seat.trim();
    }

    public String getBerth() {
        return berth;
    }

    public void setBerth(String berth) {
        this.berth = berth == null ? null : berth.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(Boolean isLock) {
        this.isLock = isLock;
    }

    public Boolean getIsReceiveReceipt() {
        return isReceiveReceipt;
    }

    public void setIsReceiveReceipt(Boolean isReceiveReceipt) {
        this.isReceiveReceipt = isReceiveReceipt;
    }
}