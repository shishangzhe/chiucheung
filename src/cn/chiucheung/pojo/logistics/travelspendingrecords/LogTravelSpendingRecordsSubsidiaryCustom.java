package cn.chiucheung.pojo.logistics.travelspendingrecords;

public class LogTravelSpendingRecordsSubsidiaryCustom {
	private String id;
	
	private String travelDate;

    private String startPoint;

    private String endPoint;
    
    private String trafficType;
    
    private String invoiceType;

    private Float trafficPrice;

    private String description;
    
    private Float otherPrice;

    private Boolean isSubsidies;
    
    private String subsidiesType;
    
    private String checkSheetNo;//报账单页面数据展开用

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTravelDate() {
		return travelDate == null ? "" : travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public String getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public Float getTrafficPrice() {
		return trafficPrice;
	}

	public void setTrafficPrice(Float trafficPrice) {
		this.trafficPrice = trafficPrice;
	}

	public String getTrafficType() {
		return trafficType;
	}

	public void setTrafficType(String trafficType) {
		this.trafficType = trafficType;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getOtherPrice() {
		return otherPrice;
	}

	public void setOtherPrice(Float otherPrice) {
		this.otherPrice = otherPrice;
	}

	public Boolean getIsSubsidies() {
		return isSubsidies;
	}

	public void setIsSubsidies(Boolean isSubsidies) {
		this.isSubsidies = isSubsidies;
	}

	public String getSubsidiesType() {
		if (isSubsidies != null){
			if (isSubsidies){
				return "津贴补贴";
			}else{
				return "其他费用";
			}
		}else{
			return "";
		}
	}

	public String getCheckSheetNo() {
		return checkSheetNo == null ? "" : checkSheetNo;
	}

	public void setCheckSheetNo(String checkSheetNo) {
		this.checkSheetNo = checkSheetNo;
	}

}
