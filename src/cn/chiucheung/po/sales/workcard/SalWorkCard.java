package cn.chiucheung.po.sales.workcard;

import java.util.Date;

public class SalWorkCard {
    private String id;

    private String quotationNo;

    private String workCardNo;

    private Date workCardDate;

    private String approvalProcedures;

    private String approvalProceduresContent1;

    private String approvalProceduresContent2;

    private String approvalProceduresContent3;

    private String qcAttentionMatters;

    private String outwardProcessing;

    private Boolean specialInspection;

    private String deliveryPlace;

    private String deliveryPlaceContent1;

    private String deliveryPlaceContent2;

    private String shipmentWay;

    private String contractAmount;

    private Boolean sceneInstallation;

    private String assemblyAfterCheck;

    private String packaging;

    private Boolean equinoctialDelivery;

    private String sceneElectricityTime;

    private String floorCompleteTime;

    private String equinoctialDeliveryInstructions;

    private String assemblyWay;

    private String assemblyWayContent1;

    private String assemblyWayContent2;

    private String assemblyWayContent3;

    private String partsWay;

    private String partsWayContent1;

    private String partsWayContent2;

    private String attachment;

    private String attachmentCad;

    private String saleOweData;

    private String engLeader;

    private String proLeader;

    private String workCardLeader;

    private String signer;

    private String processInstanceId;

    private String state;

    private String salReviewerId;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getQuotationNo() {
        return quotationNo;
    }

    public void setQuotationNo(String quotationNo) {
        this.quotationNo = quotationNo == null ? null : quotationNo.trim();
    }

    public String getWorkCardNo() {
        return workCardNo;
    }

    public void setWorkCardNo(String workCardNo) {
        this.workCardNo = workCardNo == null ? null : workCardNo.trim();
    }

    public Date getWorkCardDate() {
        return workCardDate;
    }

    public void setWorkCardDate(Date workCardDate) {
        this.workCardDate = workCardDate;
    }

    public String getApprovalProcedures() {
        return approvalProcedures;
    }

    public void setApprovalProcedures(String approvalProcedures) {
        this.approvalProcedures = approvalProcedures == null ? null : approvalProcedures.trim();
    }

    public String getApprovalProceduresContent1() {
        return approvalProceduresContent1;
    }

    public void setApprovalProceduresContent1(String approvalProceduresContent1) {
        this.approvalProceduresContent1 = approvalProceduresContent1 == null ? null : approvalProceduresContent1.trim();
    }

    public String getApprovalProceduresContent2() {
        return approvalProceduresContent2;
    }

    public void setApprovalProceduresContent2(String approvalProceduresContent2) {
        this.approvalProceduresContent2 = approvalProceduresContent2 == null ? null : approvalProceduresContent2.trim();
    }

    public String getApprovalProceduresContent3() {
        return approvalProceduresContent3;
    }

    public void setApprovalProceduresContent3(String approvalProceduresContent3) {
        this.approvalProceduresContent3 = approvalProceduresContent3 == null ? null : approvalProceduresContent3.trim();
    }

    public String getQcAttentionMatters() {
        return qcAttentionMatters;
    }

    public void setQcAttentionMatters(String qcAttentionMatters) {
        this.qcAttentionMatters = qcAttentionMatters == null ? null : qcAttentionMatters.trim();
    }

    public String getOutwardProcessing() {
        return outwardProcessing;
    }

    public void setOutwardProcessing(String outwardProcessing) {
        this.outwardProcessing = outwardProcessing == null ? null : outwardProcessing.trim();
    }

    public Boolean getSpecialInspection() {
        return specialInspection;
    }

    public void setSpecialInspection(Boolean specialInspection) {
        this.specialInspection = specialInspection;
    }

    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace == null ? null : deliveryPlace.trim();
    }

    public String getDeliveryPlaceContent1() {
        return deliveryPlaceContent1;
    }

    public void setDeliveryPlaceContent1(String deliveryPlaceContent1) {
        this.deliveryPlaceContent1 = deliveryPlaceContent1 == null ? null : deliveryPlaceContent1.trim();
    }

    public String getDeliveryPlaceContent2() {
        return deliveryPlaceContent2;
    }

    public void setDeliveryPlaceContent2(String deliveryPlaceContent2) {
        this.deliveryPlaceContent2 = deliveryPlaceContent2 == null ? null : deliveryPlaceContent2.trim();
    }

    public String getShipmentWay() {
        return shipmentWay;
    }

    public void setShipmentWay(String shipmentWay) {
        this.shipmentWay = shipmentWay == null ? null : shipmentWay.trim();
    }

    public String getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(String contractAmount) {
        this.contractAmount = contractAmount == null ? null : contractAmount.trim();
    }

    public Boolean getSceneInstallation() {
        return sceneInstallation;
    }

    public void setSceneInstallation(Boolean sceneInstallation) {
        this.sceneInstallation = sceneInstallation;
    }

    public String getAssemblyAfterCheck() {
        return assemblyAfterCheck;
    }

    public void setAssemblyAfterCheck(String assemblyAfterCheck) {
        this.assemblyAfterCheck = assemblyAfterCheck == null ? null : assemblyAfterCheck.trim();
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging == null ? null : packaging.trim();
    }

    public Boolean getEquinoctialDelivery() {
        return equinoctialDelivery;
    }

    public void setEquinoctialDelivery(Boolean equinoctialDelivery) {
        this.equinoctialDelivery = equinoctialDelivery;
    }

    public String getSceneElectricityTime() {
        return sceneElectricityTime;
    }

    public void setSceneElectricityTime(String sceneElectricityTime) {
        this.sceneElectricityTime = sceneElectricityTime == null ? null : sceneElectricityTime.trim();
    }

    public String getFloorCompleteTime() {
        return floorCompleteTime;
    }

    public void setFloorCompleteTime(String floorCompleteTime) {
        this.floorCompleteTime = floorCompleteTime == null ? null : floorCompleteTime.trim();
    }

    public String getEquinoctialDeliveryInstructions() {
        return equinoctialDeliveryInstructions;
    }

    public void setEquinoctialDeliveryInstructions(String equinoctialDeliveryInstructions) {
        this.equinoctialDeliveryInstructions = equinoctialDeliveryInstructions == null ? null : equinoctialDeliveryInstructions.trim();
    }

    public String getAssemblyWay() {
        return assemblyWay;
    }

    public void setAssemblyWay(String assemblyWay) {
        this.assemblyWay = assemblyWay == null ? null : assemblyWay.trim();
    }

    public String getAssemblyWayContent1() {
        return assemblyWayContent1;
    }

    public void setAssemblyWayContent1(String assemblyWayContent1) {
        this.assemblyWayContent1 = assemblyWayContent1 == null ? null : assemblyWayContent1.trim();
    }

    public String getAssemblyWayContent2() {
        return assemblyWayContent2;
    }

    public void setAssemblyWayContent2(String assemblyWayContent2) {
        this.assemblyWayContent2 = assemblyWayContent2 == null ? null : assemblyWayContent2.trim();
    }

    public String getAssemblyWayContent3() {
        return assemblyWayContent3;
    }

    public void setAssemblyWayContent3(String assemblyWayContent3) {
        this.assemblyWayContent3 = assemblyWayContent3 == null ? null : assemblyWayContent3.trim();
    }

    public String getPartsWay() {
        return partsWay;
    }

    public void setPartsWay(String partsWay) {
        this.partsWay = partsWay == null ? null : partsWay.trim();
    }

    public String getPartsWayContent1() {
        return partsWayContent1;
    }

    public void setPartsWayContent1(String partsWayContent1) {
        this.partsWayContent1 = partsWayContent1 == null ? null : partsWayContent1.trim();
    }

    public String getPartsWayContent2() {
        return partsWayContent2;
    }

    public void setPartsWayContent2(String partsWayContent2) {
        this.partsWayContent2 = partsWayContent2 == null ? null : partsWayContent2.trim();
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment == null ? null : attachment.trim();
    }

    public String getAttachmentCad() {
        return attachmentCad;
    }

    public void setAttachmentCad(String attachmentCad) {
        this.attachmentCad = attachmentCad == null ? null : attachmentCad.trim();
    }

    public String getSaleOweData() {
        return saleOweData;
    }

    public void setSaleOweData(String saleOweData) {
        this.saleOweData = saleOweData == null ? null : saleOweData.trim();
    }

    public String getEngLeader() {
        return engLeader;
    }

    public void setEngLeader(String engLeader) {
        this.engLeader = engLeader == null ? null : engLeader.trim();
    }

    public String getProLeader() {
        return proLeader;
    }

    public void setProLeader(String proLeader) {
        this.proLeader = proLeader == null ? null : proLeader.trim();
    }

    public String getWorkCardLeader() {
        return workCardLeader;
    }

    public void setWorkCardLeader(String workCardLeader) {
        this.workCardLeader = workCardLeader == null ? null : workCardLeader.trim();
    }

    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer == null ? null : signer.trim();
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
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