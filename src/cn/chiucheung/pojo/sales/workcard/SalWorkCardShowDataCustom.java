package cn.chiucheung.pojo.sales.workcard;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SalWorkCardShowDataCustom implements Serializable{
	private String id;
	
	private String quotationNo;
	
	private String workCardNo;
	
	private String workCardLeader;
	
	private String workCardDate;
	
	private String processInstanceId;
	
	private String state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuotationNo() {
		return quotationNo;
	}

	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}

	public String getWorkCardNo() {
		return workCardNo;
	}

	public void setWorkCardNo(String workCardNo) {
		this.workCardNo = workCardNo;
	}

	public String getWorkCardLeader() {
		return workCardLeader;
	}

	public void setWorkCardLeader(String workCardLeader) {
		this.workCardLeader = workCardLeader;
	}

	public String getWorkCardDate() {
		return workCardDate;
	}

	public void setWorkCardDate(String workCardDate) {
		this.workCardDate = workCardDate;
	}
	
	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
