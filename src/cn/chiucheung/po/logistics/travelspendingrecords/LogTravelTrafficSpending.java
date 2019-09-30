package cn.chiucheung.po.logistics.travelspendingrecords;

public class LogTravelTrafficSpending {
    private String id;

    private Integer sequence;

    private String startPoint;

    private String endPoint;

    private String trafficType;

    private String invoiceType;

    private Float price;

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

    public String getTrafficType() {
        return trafficType;
    }

    public void setTrafficType(String trafficType) {
        this.trafficType = trafficType == null ? null : trafficType.trim();
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType == null ? null : invoiceType.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getLogTravelSpendingRecordsId() {
        return logTravelSpendingRecordsId;
    }

    public void setLogTravelSpendingRecordsId(String logTravelSpendingRecordsId) {
        this.logTravelSpendingRecordsId = logTravelSpendingRecordsId == null ? null : logTravelSpendingRecordsId.trim();
    }
}