package cn.chiucheung.pojo.production.producttechnologyworkhours;

import java.io.Serializable;

import cn.chiucheung.po.production.producttechnologyworkhours.ProProductTechnologyProcessWorkHours;

public class ProProductTechnologyProcessWorkHoursCustom extends ProProductTechnologyProcessWorkHours implements Serializable{
	
	private Integer processNumber;

    private Integer parentProcessNumber;

    private String processName;

    private String processCategory;

    private Integer machineGroupNumber;

    private Integer perMachineGroupPeopleNumber;

    private String calculationFormula;

	public Integer getProcessNumber() {
		return processNumber;
	}

	public void setProcessNumber(Integer processNumber) {
		this.processNumber = processNumber;
	}

	public Integer getParentProcessNumber() {
		return parentProcessNumber;
	}

	public void setParentProcessNumber(Integer parentProcessNumber) {
		this.parentProcessNumber = parentProcessNumber;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getProcessCategory() {
		return processCategory;
	}

	public void setProcessCategory(String processCategory) {
		this.processCategory = processCategory;
	}

	public Integer getMachineGroupNumber() {
		return machineGroupNumber;
	}

	public void setMachineGroupNumber(Integer machineGroupNumber) {
		this.machineGroupNumber = machineGroupNumber;
	}

	public Integer getPerMachineGroupPeopleNumber() {
		return perMachineGroupPeopleNumber;
	}

	public void setPerMachineGroupPeopleNumber(Integer perMachineGroupPeopleNumber) {
		this.perMachineGroupPeopleNumber = perMachineGroupPeopleNumber;
	}

	public String getCalculationFormula() {
		return calculationFormula;
	}

	public void setCalculationFormula(String calculationFormula) {
		this.calculationFormula = calculationFormula;
	}
    
    
}
