package cn.chiucheung.po.production.producttechnologyflowchart;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProProductTechnologyFlowChartNodeDataArray implements Serializable{
    private String id;

    private String category;

    private String key;

    private String loc;

    private BigDecimal totalTime;

    private String proProcessId;

    private String proProductTechnologyWorkHoursId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }

    public BigDecimal getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(BigDecimal totalTime) {
        this.totalTime = totalTime;
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