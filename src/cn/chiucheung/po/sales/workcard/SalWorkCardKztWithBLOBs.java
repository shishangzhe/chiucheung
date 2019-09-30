package cn.chiucheung.po.sales.workcard;

public class SalWorkCardKztWithBLOBs extends SalWorkCardKzt {
    private String allOneRemark;

    private String sidePanelColor;

    private String otherIronColor;

    private String otherEachConfig;

    private String pRemark;

    private String lsRemark;

    public String getAllOneRemark() {
        return allOneRemark;
    }

    public void setAllOneRemark(String allOneRemark) {
        this.allOneRemark = allOneRemark == null ? null : allOneRemark.trim();
    }

    public String getSidePanelColor() {
        return sidePanelColor;
    }

    public void setSidePanelColor(String sidePanelColor) {
        this.sidePanelColor = sidePanelColor == null ? null : sidePanelColor.trim();
    }

    public String getOtherIronColor() {
        return otherIronColor;
    }

    public void setOtherIronColor(String otherIronColor) {
        this.otherIronColor = otherIronColor == null ? null : otherIronColor.trim();
    }

    public String getOtherEachConfig() {
        return otherEachConfig;
    }

    public void setOtherEachConfig(String otherEachConfig) {
        this.otherEachConfig = otherEachConfig == null ? null : otherEachConfig.trim();
    }

    public String getpRemark() {
        return pRemark;
    }

    public void setpRemark(String pRemark) {
        this.pRemark = pRemark == null ? null : pRemark.trim();
    }

    public String getLsRemark() {
        return lsRemark;
    }

    public void setLsRemark(String lsRemark) {
        this.lsRemark = lsRemark == null ? null : lsRemark.trim();
    }
}