package cn.chiucheung.po.logistics.traveluser;

public class LogTravelUser {
    private String id;

    private String workNo;

    private String username;

    private String password;

    private String groupsId;

    private String isAllowedLogin;

    private String deviceSerialNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo == null ? null : workNo.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getGroupsId() {
        return groupsId;
    }

    public void setGroupsId(String groupsId) {
        this.groupsId = groupsId == null ? null : groupsId.trim();
    }

    public String getIsAllowedLogin() {
        return isAllowedLogin;
    }

    public void setIsAllowedLogin(String isAllowedLogin) {
        this.isAllowedLogin = isAllowedLogin == null ? null : isAllowedLogin.trim();
    }

    public String getDeviceSerialNumber() {
        return deviceSerialNumber;
    }

    public void setDeviceSerialNumber(String deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber == null ? null : deviceSerialNumber.trim();
    }
}