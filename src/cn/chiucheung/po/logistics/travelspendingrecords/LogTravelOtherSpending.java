package cn.chiucheung.po.logistics.travelspendingrecords;

public class LogTravelOtherSpending {
    private String id;

    private Integer sequence;

    private String description;

    private Float price;

    private Boolean isSubsidies;

    private String logTravelSpendingRecordsId;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getIsSubsidies() {
        return isSubsidies;
    }

    public void setIsSubsidies(Boolean isSubsidies) {
        this.isSubsidies = isSubsidies;
    }

    public String getLogTravelSpendingRecordsId() {
        return logTravelSpendingRecordsId;
    }

    public void setLogTravelSpendingRecordsId(String logTravelSpendingRecordsId) {
        this.logTravelSpendingRecordsId = logTravelSpendingRecordsId == null ? null : logTravelSpendingRecordsId.trim();
    }
}