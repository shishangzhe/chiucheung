package cn.chiucheung.po.market.costbudget;

import java.io.Serializable;
import java.util.Date;

public class MarCostBudget implements Serializable{
    private String id;

    private String theme;

    private String customerName;

    private String productName;

    private String peripheralSize;

    private Boolean calculate;

    private Date beginTime;

    private Date submitTime;

    private String rawMaterial;

    private String difficulty;

    private String engCost;

    private String additional;

    private String packaging;

    private String totalNumber;

    private String description;

    private String unitPrice;

    private String totalPrice;

    private String preparer;

    private String reviewer;

    private String salReviewerId;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getPeripheralSize() {
        return peripheralSize;
    }

    public void setPeripheralSize(String peripheralSize) {
        this.peripheralSize = peripheralSize == null ? null : peripheralSize.trim();
    }

    public Boolean getCalculate() {
        return calculate;
    }

    public void setCalculate(Boolean calculate) {
        this.calculate = calculate;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(String rawMaterial) {
        this.rawMaterial = rawMaterial == null ? null : rawMaterial.trim();
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty == null ? null : difficulty.trim();
    }

    public String getEngCost() {
        return engCost;
    }

    public void setEngCost(String engCost) {
        this.engCost = engCost == null ? null : engCost.trim();
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional == null ? null : additional.trim();
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging == null ? null : packaging.trim();
    }

    public String getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(String totalNumber) {
        this.totalNumber = totalNumber == null ? null : totalNumber.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice == null ? null : unitPrice.trim();
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice == null ? null : totalPrice.trim();
    }

    public String getPreparer() {
        return preparer;
    }

    public void setPreparer(String preparer) {
        this.preparer = preparer == null ? null : preparer.trim();
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer == null ? null : reviewer.trim();
    }

    public String getSalReviewerId() {
        return salReviewerId;
    }

    public void setSalReviewerId(String salReviewerId) {
        this.salReviewerId = salReviewerId == null ? null : salReviewerId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}