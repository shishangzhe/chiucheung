package cn.chiucheung.po.production.producttechnologyworkhours;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProProductTechnologyProcessWorkHours implements Serializable{
    private String id;

    private Integer number;

    private BigDecimal totalTime;

    private BigDecimal totalArtificialTime;

    private String calculationMethod;

    private String proProcessId;

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

    public BigDecimal getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(BigDecimal totalTime) {
        this.totalTime = totalTime;
    }

    public BigDecimal getTotalArtificialTime() {
        return totalArtificialTime;
    }

    public void setTotalArtificialTime(BigDecimal totalArtificialTime) {
        this.totalArtificialTime = totalArtificialTime;
    }

    public String getCalculationMethod() {
        return calculationMethod;
    }

    public void setCalculationMethod(String calculationMethod) {
        this.calculationMethod = calculationMethod == null ? null : calculationMethod.trim();
    }

    public String getProProcessId() {
        return proProcessId;
    }

    public void setProProcessId(String proProcessId) {
        this.proProcessId = proProcessId == null ? null : proProcessId.trim();
    }

    public String getProProductTechnologyWorkHoursId() {
        return proProductTechnologyWorkHoursId;
    }

    public void setProProductTechnologyWorkHoursId(String proProductTechnologyWorkHoursId) {
        this.proProductTechnologyWorkHoursId = proProductTechnologyWorkHoursId == null ? null : proProductTechnologyWorkHoursId.trim();
    }
}