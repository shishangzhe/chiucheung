package cn.chiucheung.po.sales.workcard;

import java.io.Serializable;

public class SalWorkCardEiaOther implements Serializable{
    private String id;

    private Integer sequence;

    private String otherContent;

    private String otherContentQuantity;

    private String otherContentRemark;

    private String salWorkCardEiaId;

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

    public String getOtherContent() {
        return otherContent;
    }

    public void setOtherContent(String otherContent) {
        this.otherContent = otherContent == null ? null : otherContent.trim();
    }

    public String getOtherContentQuantity() {
        return otherContentQuantity;
    }

    public void setOtherContentQuantity(String otherContentQuantity) {
        this.otherContentQuantity = otherContentQuantity == null ? null : otherContentQuantity.trim();
    }

    public String getOtherContentRemark() {
        return otherContentRemark;
    }

    public void setOtherContentRemark(String otherContentRemark) {
        this.otherContentRemark = otherContentRemark == null ? null : otherContentRemark.trim();
    }

    public String getSalWorkCardEiaId() {
        return salWorkCardEiaId;
    }

    public void setSalWorkCardEiaId(String salWorkCardEiaId) {
        this.salWorkCardEiaId = salWorkCardEiaId == null ? null : salWorkCardEiaId.trim();
    }
}