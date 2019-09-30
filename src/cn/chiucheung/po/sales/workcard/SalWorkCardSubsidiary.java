package cn.chiucheung.po.sales.workcard;

import java.util.Date;

public class SalWorkCardSubsidiary {
    private String id;

    private Integer sequence;

    private String productCode;

    private String productName;

    private String productModel;

    private Integer quantity;

    private String unit;

    private Date expectedDeliveryDate;

    private Date engReleaseDataDate;

    private String proPeriod;

    private String confirmation;

    private String salReviewerSubsidiaryId;

    private String salWorkCardId;

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

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
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

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public Date getEngReleaseDataDate() {
        return engReleaseDataDate;
    }

    public void setEngReleaseDataDate(Date engReleaseDataDate) {
        this.engReleaseDataDate = engReleaseDataDate;
    }

    public String getProPeriod() {
        return proPeriod;
    }

    public void setProPeriod(String proPeriod) {
        this.proPeriod = proPeriod == null ? null : proPeriod.trim();
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation == null ? null : confirmation.trim();
    }

    public String getSalReviewerSubsidiaryId() {
        return salReviewerSubsidiaryId;
    }

    public void setSalReviewerSubsidiaryId(String salReviewerSubsidiaryId) {
        this.salReviewerSubsidiaryId = salReviewerSubsidiaryId == null ? null : salReviewerSubsidiaryId.trim();
    }

    public String getSalWorkCardId() {
        return salWorkCardId;
    }

    public void setSalWorkCardId(String salWorkCardId) {
        this.salWorkCardId = salWorkCardId == null ? null : salWorkCardId.trim();
    }
}