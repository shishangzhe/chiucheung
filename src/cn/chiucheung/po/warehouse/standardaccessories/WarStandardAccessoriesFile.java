package cn.chiucheung.po.warehouse.standardaccessories;

import java.io.Serializable;

public class WarStandardAccessoriesFile implements Serializable{
    private String id;

    private String fileName;

    private String filePath;

    private String warStandardAccessoriesId;

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

    public String getWarStandardAccessoriesId() {
        return warStandardAccessoriesId;
    }

    public void setWarStandardAccessoriesId(String warStandardAccessoriesId) {
        this.warStandardAccessoriesId = warStandardAccessoriesId == null ? null : warStandardAccessoriesId.trim();
    }
}