package cn.chiucheung.po.market.devicenameserialnumber;

public class MarDeviceNameSerialNumber {
    private String id;

    private String deviceModel;

    private String useName;

    private String serialNumber;

    private Boolean isAllowedDownload;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel == null ? null : deviceModel.trim();
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName == null ? null : useName.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public Boolean getIsAllowedDownload() {
        return isAllowedDownload;
    }

    public void setIsAllowedDownload(Boolean isAllowedDownload) {
        this.isAllowedDownload = isAllowedDownload;
    }
}