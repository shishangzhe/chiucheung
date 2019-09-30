package cn.chiucheung.pojo.sales.reviewer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import cn.chiucheung.po.sales.reviewer.SalReviewerFile;
import cn.chiucheung.po.sales.reviewer.SalReviewerSubsidiary;
import cn.chiucheung.po.sales.reviewer.SalReviewerWithBLOBs;

public class SalReviewerCustom extends SalReviewerWithBLOBs implements Serializable{
	
	private String workCardNo;
	
	private List<SalReviewerSubsidiary> reviewerSubsidiaries;//工程所填项的集合，（项次、项目名称、产品型号、产品数量、产品类型。。。。这些的数据的集合）
	
	private List<SalReviewerFile> reviewerFiles;
	
	private Integer sequence;

    private String projectName;

    private String productModel;

    private Integer quantity;

    private String unit;

    private String category;

    private String engLeader;

    private String engActualNeedTime;

    private Date engExpectedStartTime;

    private Date engExpectedShortestCompletionTime;

    private Date engExpectedLongestCompletionTime;
	
	public String getWorkCardNo() {
		return workCardNo;
	}

	public void setWorkCardNo(String workCardNo) {
		this.workCardNo = workCardNo;
	}

	public List<SalReviewerSubsidiary> getReviewerSubsidiaries() {
		return reviewerSubsidiaries;
	}
	
	public void setReviewerSubsidiaries(
			List<SalReviewerSubsidiary> reviewerSubsidiaries) {
		this.reviewerSubsidiaries = reviewerSubsidiaries;
	}
	
	public List<SalReviewerFile> getReviewerFiles() {
		return reviewerFiles;
	}
	
	public void setReviewerFiles(List<SalReviewerFile> reviewerFiles) {
		this.reviewerFiles = reviewerFiles;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEngLeader() {
		return engLeader;
	}

	public void setEngLeader(String engLeader) {
		this.engLeader = engLeader;
	}

	public String getEngActualNeedTime() {
		return engActualNeedTime;
	}

	public void setEngActualNeedTime(String engActualNeedTime) {
		this.engActualNeedTime = engActualNeedTime;
	}

	public Date getEngExpectedStartTime() {
		return engExpectedStartTime;
	}

	public void setEngExpectedStartTime(Date engExpectedStartTime) {
		this.engExpectedStartTime = engExpectedStartTime;
	}

	public Date getEngExpectedShortestCompletionTime() {
		return engExpectedShortestCompletionTime;
	}

	public void setEngExpectedShortestCompletionTime(
			Date engExpectedShortestCompletionTime) {
		this.engExpectedShortestCompletionTime = engExpectedShortestCompletionTime;
	}

	public Date getEngExpectedLongestCompletionTime() {
		return engExpectedLongestCompletionTime;
	}

	public void setEngExpectedLongestCompletionTime(
			Date engExpectedLongestCompletionTime) {
		this.engExpectedLongestCompletionTime = engExpectedLongestCompletionTime;
	}
}
