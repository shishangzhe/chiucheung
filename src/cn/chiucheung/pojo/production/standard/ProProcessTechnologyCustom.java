package cn.chiucheung.pojo.production.standard;

public class ProProcessTechnologyCustom {
	private String id;

    private Integer processNumber;

    private Integer parentProcessNumber;

    private String processName;

    private String processCategory;

    private Integer machineGroupNumber;

    private Integer perMachineGroupPeopleNumber;
    
    private String technology;

    private String technologyIdentification;

    private String calculationFormula;
    
    private String proProcessId;
    
    private String technologyDescription;

    private Integer technologyTime;

    private String proTechnologyBasicDataId;
    
    private String process;
    
    private String state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getTechnologyIdentification() {
		return technologyIdentification;
	}

	public void setTechnologyIdentification(String technologyIdentification) {
		this.technologyIdentification = technologyIdentification;
	}

	public String getCalculationFormula() {
		return calculationFormula;
	}

	public void setCalculationFormula(String calculationFormula) {
		this.calculationFormula = calculationFormula;
	}

	public String getProProcessId() {
		return proProcessId;
	}

	public void setProProcessId(String proProcessId) {
		this.proProcessId = proProcessId;
	}

	public String getTechnologyDescription() {
		return technologyDescription;
	}

	public void setTechnologyDescription(String technologyDescription) {
		this.technologyDescription = technologyDescription;
	}

	public Integer getTechnologyTime() {
		return technologyTime;
	}

	public void setTechnologyTime(Integer technologyTime) {
		this.technologyTime = technologyTime;
	}

	public String getProTechnologyBasicDataId() {
		return proTechnologyBasicDataId;
	}

	public void setProTechnologyBasicDataId(String proTechnologyBasicDataId) {
		this.proTechnologyBasicDataId = proTechnologyBasicDataId;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    
}
