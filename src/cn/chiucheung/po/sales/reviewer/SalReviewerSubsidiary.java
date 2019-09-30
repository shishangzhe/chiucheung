package cn.chiucheung.po.sales.reviewer;

import java.util.Date;

public class SalReviewerSubsidiary {
    private String id;

    private Integer sequence;

    private String productName;

    private String productModel;

    private Integer quantity;

    private String unit;

    private String category;

    private String engLeader;

    private String engActualNeedTime;

    private Date engExpectedStartTime;

    private Date engExpectedShortestCompletionTime;

    private Date engExpectedLongestCompletionTime;

    private String salReviewerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel == null ? null : productModel.trim();
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
        this.unit = unit == null ? null : unit.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getEngLeader() {
        return engLeader;
    }

    public void setEngLeader(String engLeader) {
        this.engLeader = engLeader == null ? null : engLeader.trim();
    }

    public String getEngActualNeedTime() {
        return engActualNeedTime;
    }

    public void setEngActualNeedTime(String engActualNeedTime) {
        this.engActualNeedTime = engActualNeedTime == null ? null : engActualNeedTime.trim();
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

    public void setEngExpectedShortestCompletionTime(Date engExpectedShortestCompletionTime) {
        this.engExpectedShortestCompletionTime = engExpectedShortestCompletionTime;
    }

    public Date getEngExpectedLongestCompletionTime() {
        return engExpectedLongestCompletionTime;
    }

    public void setEngExpectedLongestCompletionTime(Date engExpectedLongestCompletionTime) {
        this.engExpectedLongestCompletionTime = engExpectedLongestCompletionTime;
    }

    public String getSalReviewerId() {
        return salReviewerId;
    }

    public void setSalReviewerId(String salReviewerId) {
        this.salReviewerId = salReviewerId == null ? null : salReviewerId.trim();
    }
}