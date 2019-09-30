package cn.chiucheung.po.sales.projectinfo;

public class SalProjectInfoPic {
    private String id;

    private String suffix;

    private String salProjectInfoId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? null : suffix.trim();
    }

    public String getSalProjectInfoId() {
        return salProjectInfoId;
    }

    public void setSalProjectInfoId(String salProjectInfoId) {
        this.salProjectInfoId = salProjectInfoId == null ? null : salProjectInfoId.trim();
    }
}