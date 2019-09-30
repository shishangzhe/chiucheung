package cn.chiucheung.pojo.production.producttechnologyworkhours;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProCalculateProcessTimesForExportExcelCustom implements Serializable{
	
    private BigDecimal totalTime;

    private BigDecimal totalArtificialTime;

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
	
	@Override
	public String toString() {
		return totalTime.toString();
	}
}
