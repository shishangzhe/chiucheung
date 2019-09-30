package cn.chiucheung.po.sales.reviewer;

public class SalReviewerWithBLOBs extends SalReviewer {
    private String projectContent;

    private String engRemark;

    private String purRemark;

    private String proRemark;

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent == null ? null : projectContent.trim();
    }

    public String getEngRemark() {
        return engRemark;
    }

    public void setEngRemark(String engRemark) {
        this.engRemark = engRemark == null ? null : engRemark.trim();
    }

    public String getPurRemark() {
        return purRemark;
    }

    public void setPurRemark(String purRemark) {
        this.purRemark = purRemark == null ? null : purRemark.trim();
    }

    public String getProRemark() {
        return proRemark;
    }

    public void setProRemark(String proRemark) {
        this.proRemark = proRemark == null ? null : proRemark.trim();
    }
}