package cn.chiucheung.pojo.production.producttechnologyworkhours;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import cn.chiucheung.po.production.standard.ProProcess;

public class ProCalculateProcessTimesCustom extends ProProcess implements Serializable{
	
	private BigDecimal totalTime;
	
	private BigDecimal totalArtificialTime;
	
	private String state;
	
	private List<ProCalculateProcessTimesCustom> children;

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<ProCalculateProcessTimesCustom> getChildren() {
		return children;
	}

	public void setChildren(List<ProCalculateProcessTimesCustom> children) {
		this.children = children;
	}
	
}
