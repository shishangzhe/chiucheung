package cn.chiucheung.po.sales.workcard;

public class SalWorkCardDsqWithBLOBs extends SalWorkCardDsq {
    private String bedplateColor;

    private String bcRemark;

    private String pRemark;

    public String getBedplateColor() {
        return bedplateColor;
    }

    public void setBedplateColor(String bedplateColor) {
        this.bedplateColor = bedplateColor == null ? null : bedplateColor.trim();
    }

    public String getBcRemark() {
        return bcRemark;
    }

    public void setBcRemark(String bcRemark) {
        this.bcRemark = bcRemark == null ? null : bcRemark.trim();
    }

    public String getpRemark() {
        return pRemark;
    }

    public void setpRemark(String pRemark) {
        this.pRemark = pRemark == null ? null : pRemark.trim();
    }
}