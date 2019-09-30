package cn.chiucheung.po.purchase.material;

import java.io.Serializable;

public class PurMaterialBaseData implements Serializable{
    private String id;

    private String keyword;

    private Integer dictionarieCode;

    private String dictionarieName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getDictionarieCode() {
        return dictionarieCode;
    }

    public void setDictionarieCode(Integer dictionarieCode) {
        this.dictionarieCode = dictionarieCode;
    }

    public String getDictionarieName() {
        return dictionarieName;
    }

    public void setDictionarieName(String dictionarieName) {
        this.dictionarieName = dictionarieName == null ? null : dictionarieName.trim();
    }
}