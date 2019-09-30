package cn.chiucheung.po.sales.workcard;

import java.io.Serializable;

public class SalWorkCardFile implements Serializable{
    private String id;

    private String fileName;

    private String filePath;

    private Boolean drawingsFile;

    private String processInstanceId;

    private String salWorkCardId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Boolean getDrawingsFile() {
        return drawingsFile;
    }

    public void setDrawingsFile(Boolean drawingsFile) {
        this.drawingsFile = drawingsFile;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
    }

    public String getSalWorkCardId() {
        return salWorkCardId;
    }

    public void setSalWorkCardId(String salWorkCardId) {
        this.salWorkCardId = salWorkCardId == null ? null : salWorkCardId.trim();
    }
}