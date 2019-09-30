package cn.chiucheung.po.production.standard;


public class ProTechnologyBasicData {
    private String id;

    private String technology;

    private String technologyIdentification;

    private String proProcessId;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology == null ? null : technology.trim();
    }

    public String getTechnologyIdentification() {
        return technologyIdentification;
    }

    public void setTechnologyIdentification(String technologyIdentification) {
        this.technologyIdentification = technologyIdentification == null ? null : technologyIdentification.trim();
    }

    public String getProProcessId() {
        return proProcessId;
    }

    public void setProProcessId(String proProcessId) {
        this.proProcessId = proProcessId == null ? null : proProcessId.trim();
    }
}