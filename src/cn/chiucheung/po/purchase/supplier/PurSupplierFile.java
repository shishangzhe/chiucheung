package cn.chiucheung.po.purchase.supplier;

public class PurSupplierFile {
    private String id;

    private String fileName;

    private String filePath;

    private String purSupplierId;

    private String fileType;

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

    public String getPurSupplierId() {
        return purSupplierId;
    }

    public void setPurSupplierId(String purSupplierId) {
        this.purSupplierId = purSupplierId == null ? null : purSupplierId.trim();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }
}