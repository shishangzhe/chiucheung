package cn.chiucheung.po.warehouse.material;

public class WarMaterialFile {
    private String id;

    private String fileName;

    private String filePath;

    private String warMaterialId;

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

    public String getWarMaterialId() {
        return warMaterialId;
    }

    public void setWarMaterialId(String warMaterialId) {
        this.warMaterialId = warMaterialId == null ? null : warMaterialId.trim();
    }
}