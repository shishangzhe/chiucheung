package cn.chiucheung.po.production.standard;

public class ProTechnologyWorkHoursBasicData {
    private String id;

    private String technologyDescription;

    private Integer technologyTime;

    private String proTechnologyBasicDataId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTechnologyDescription() {
        return technologyDescription;
    }

    public void setTechnologyDescription(String technologyDescription) {
        this.technologyDescription = technologyDescription == null ? null : technologyDescription.trim();
    }

    public Integer getTechnologyTime() {
        return technologyTime;
    }

    public void setTechnologyTime(Integer technologyTime) {
        this.technologyTime = technologyTime;
    }

    public String getProTechnologyBasicDataId() {
        return proTechnologyBasicDataId;
    }

    public void setProTechnologyBasicDataId(String proTechnologyBasicDataId) {
        this.proTechnologyBasicDataId = proTechnologyBasicDataId == null ? null : proTechnologyBasicDataId.trim();
    }
}