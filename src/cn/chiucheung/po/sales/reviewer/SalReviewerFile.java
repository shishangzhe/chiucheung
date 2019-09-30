package cn.chiucheung.po.sales.reviewer;

import java.io.Serializable;

public class SalReviewerFile implements Serializable{
    private String id;

    private String docId;

    private String filename;

    private String extension;

    private String salReviewerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension == null ? null : extension.trim();
    }

    public String getSalReviewerId() {
        return salReviewerId;
    }

    public void setSalReviewerId(String salReviewerId) {
        this.salReviewerId = salReviewerId == null ? null : salReviewerId.trim();
    }
}