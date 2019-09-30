package cn.chiucheung.po.market.conductpropagandafile;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import cn.chiucheung.utils.CustomDateSerializer;

public class MarConductPropagandaFile {
    private String id;

    private String fileName;

    private Float fileVersion;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date createTime;

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

    public Float getFileVersion() {
        return fileVersion;
    }

    public void setFileVersion(Float fileVersion) {
        this.fileVersion = fileVersion;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}