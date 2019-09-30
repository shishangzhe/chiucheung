package cn.chiucheung.pojo.finance.workcardinfo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FinWorkCardInfoForGenerateExcel {
	private String workCardNo;//工咭号
	
	private String projectLeader;//项目经理
	
	private BigDecimal contractAmount;//合同金额
	
	private String office ;//办公室
	
	private String installationPlace;//安装地点
	
	private int installationNumber;//安装人数
	
	private String installationPersonnel;//安装人员
	
	private Float expectedInstallationTime;//预计安装工时
	
	private BigDecimal expectedInstallationCost;//预计安装费用
	
	private BigDecimal expectedInstallationCostPercent;//预计安装费用的百分比
	
	private Float actualInstallationTime;//实际的安装工时
	
	private Float actualAuxiliaryTime;//实际的辅助工时
	
	private BigDecimal actualInstallationCost;//实际安装费用
	
	private BigDecimal trafficCost;//交通费用
	
	private BigDecimal actualInstallationCostPercent;//实际安装费用的百分比
	
	private Float differTotalTime;//总工时差额
	
	private BigDecimal differAmount;//总费用差额
	
	private BigDecimal differPercent;//差额的百分比

	public String getWorkCardNo() {
		return workCardNo;
	}

	public void setWorkCardNo(String workCardNo) {
		this.workCardNo = workCardNo;
	}

	public String getProjectLeader() {
		return projectLeader;
	}

	public void setProjectLeader(String projectLeader) {
		this.projectLeader = projectLeader;
	}

	public BigDecimal getContractAmount() {
		return contractAmount;
	}

	public void setContractAmount(BigDecimal contractAmount) {
		this.contractAmount = contractAmount;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getInstallationPlace() {
		return installationPlace;
	}

	public void setInstallationPlace(String installationPlace) {
		this.installationPlace = installationPlace;
	}

	public int getInstallationNumber() {
		return installationNumber;
	}

	public void setInstallationNumber(int installationNumber) {
		this.installationNumber = installationNumber;
	}

	public String getInstallationPersonnel() {
		return installationPersonnel;
	}

	public void setInstallationPersonnel(String installationPersonnel) {
		this.installationPersonnel = installationPersonnel;
	}

	public Float getExpectedInstallationTime() {
		return expectedInstallationTime;
	}

	public void setExpectedInstallationTime(Float expectedInstallationTime) {
		this.expectedInstallationTime = expectedInstallationTime;
	}

	public BigDecimal getExpectedInstallationCost() {
		return expectedInstallationCost;
	}

	public void setExpectedInstallationCost(BigDecimal expectedInstallationCost) {
		this.expectedInstallationCost = expectedInstallationCost;
	}

	public BigDecimal getExpectedInstallationCostPercent() {
		try{
			return expectedInstallationCost.divide(contractAmount,4,RoundingMode.HALF_UP);
		}catch (Exception e){
			return new BigDecimal(0);
		}
	}

	public Float getActualInstallationTime() {
		return actualInstallationTime-actualAuxiliaryTime;
	}

	public void setActualInstallationTime(Float actualInstallationTime) {
		this.actualInstallationTime = actualInstallationTime;
	}

	public Float getActualAuxiliaryTime() {
		return actualAuxiliaryTime;
	}

	public void setActualAuxiliaryTime(Float actualAuxiliaryTime) {
		this.actualAuxiliaryTime = actualAuxiliaryTime;
	}

	public BigDecimal getActualInstallationCost() {
		return actualInstallationCost.add(trafficCost);
	}

	public void setActualInstallationCost(BigDecimal actualInstallationCost) {
		this.actualInstallationCost = actualInstallationCost;
	}

	public BigDecimal getTrafficCost() {
		return trafficCost;
	}

	public void setTrafficCost(BigDecimal trafficCost) {
		this.trafficCost = trafficCost;
	}

	public BigDecimal getActualInstallationCostPercent() {
		try{
			return getActualInstallationCost().divide(expectedInstallationCost,4,RoundingMode.HALF_UP);
		}catch (Exception e){
			return new BigDecimal(0);
		}
	}

	public Float getDifferTotalTime() {
		return expectedInstallationTime-actualInstallationTime;
	}

	public BigDecimal getDifferAmount() {
		return expectedInstallationCost.subtract(getActualInstallationCost());
	}

	public BigDecimal getDifferPercent() {
		try{
			return getDifferAmount().divide(expectedInstallationCost,4,RoundingMode.HALF_UP);
		}catch (Exception e){
			return new BigDecimal(0);
		}
	}
}
