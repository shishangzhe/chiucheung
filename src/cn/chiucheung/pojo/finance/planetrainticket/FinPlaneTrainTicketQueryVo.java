package cn.chiucheung.pojo.finance.planetrainticket;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import cn.chiucheung.utils.ZHConverter;

public class FinPlaneTrainTicketQueryVo {
	private String workCardNo;
	
	private String trafficType;
	
	private String travelPersonnel;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endTime;
	
	private String orderNumber;
	
	private Boolean isLock;

    private Boolean isReceiveReceipt;
	
	private int page;//第几页
	
	private int rows;//每页多少条记录
	
	private int startPage;
	
	private String sort;
	
	private String order;

	public String getWorkCardNo() {
		return workCardNo;
	}

	public void setWorkCardNo(String workCardNo) {
		this.workCardNo = workCardNo;
	}

	public String getTrafficType() {
		return trafficType;
	}

	public void setTrafficType(String trafficType) {
		this.trafficType = trafficType;
	}

	public String getTravelPersonnel() {
		if (StringUtils.isNotBlank(travelPersonnel)){
			return ZHConverter.cht2chs(travelPersonnel);
		}else{
			return travelPersonnel;
		}
	}

	public void setTravelPersonnel(String travelPersonnel) {
		this.travelPersonnel = travelPersonnel;
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

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
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
