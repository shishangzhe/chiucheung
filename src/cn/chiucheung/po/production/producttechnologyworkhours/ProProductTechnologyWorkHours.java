package cn.chiucheung.po.production.producttechnologyworkhours;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProProductTechnologyWorkHours implements Serializable{
    private String id;

    private BigDecimal processCoefficient;

    private BigDecimal accessoriesCoefficient;

    private BigDecimal totalTime;

    private BigDecimal totalArtificialTime;

    private String warStandardAccessoriesId;

    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public BigDecimal getProcessCoefficient() {
        return processCoefficient;
    }

    public void setProcessCoefficient(BigDecimal processCoefficient) {
        this.processCoefficient = processCoefficient;
    }

    public BigDecimal getAccessoriesCoefficient() {
        return accessoriesCoefficient;
    }

    public void setAccessoriesCoefficient(BigDecimal accessoriesCoefficient) {
        this.accessoriesCoefficient = accessoriesCoefficient;
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

    public String getWarStandardAccessoriesId() {
        return warStandardAccessoriesId;
    }

    public void setWarStandardAccessoriesId(String warStandardAccessoriesId) {
        this.warStandardAccessoriesId = warStandardAccessoriesId == null ? null : warStandardAccessoriesId.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}