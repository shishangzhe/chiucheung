package cn.chiucheung.po.production.producttechnologyflowchart;

import java.io.Serializable;

public class ProProductTechnologyFlowChartLinkDataArray implements Serializable{
    private String id;

    private String from;

    private String to;

    private String fromPort;

    private String toPort;

    private String points;

    private String proProductTechnologyWorkHoursId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from == null ? null : from.trim();
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to == null ? null : to.trim();
    }

    public String getFromPort() {
        return fromPort;
    }

    public void setFromPort(String fromPort) {
        this.fromPort = fromPort == null ? null : fromPort.trim();
    }

    public String getToPort() {
        return toPort;
    }

    public void setToPort(String toPort) {
        this.toPort = toPort == null ? null : toPort.trim();
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points == null ? null : points.trim();
    }

    public String getProProductTechnologyWorkHoursId() {
        return proProductTechnologyWorkHoursId;
    }

    public void setProProductTechnologyWorkHoursId(String proProductTechnologyWorkHoursId) {
        this.proProductTechnologyWorkHoursId = proProductTechnologyWorkHoursId == null ? null : proProductTechnologyWorkHoursId.trim();
    }
}