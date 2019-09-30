package cn.chiucheung.po.production.producttechnologyworkhours;

import java.io.Serializable;

public class ProProductTechnologyAccessoriesWorkHours implements Serializable{
    private String id;

    private Integer number;

    private Integer eachNumber;

    private String proProductTechnologyAccessoriesWorkHoursId;

    private String proProductTechnologyWorkHoursId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getEachNumber() {
        return eachNumber;
    }

    public void setEachNumber(Integer eachNumber) {
        this.eachNumber = eachNumber;
    }

    public String getProProductTechnologyAccessoriesWorkHoursId() {
        return proProductTechnologyAccessoriesWorkHoursId;
    }

    public void setProProductTechnologyAccessoriesWorkHoursId(String proProductTechnologyAccessoriesWorkHoursId) {
        this.proProductTechnologyAccessoriesWorkHoursId = proProductTechnologyAccessoriesWorkHoursId == null ? null : proProductTechnologyAccessoriesWorkHoursId.trim();
    }

    public String getProProductTechnologyWorkHoursId() {
        return proProductTechnologyWorkHoursId;
    }

    public void setProProductTechnologyWorkHoursId(String proProductTechnologyWorkHoursId) {
        this.proProductTechnologyWorkHoursId = proProductTechnologyWorkHoursId == null ? null : proProductTechnologyWorkHoursId.trim();
    }
}