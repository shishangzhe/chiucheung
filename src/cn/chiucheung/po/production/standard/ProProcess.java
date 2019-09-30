package cn.chiucheung.po.production.standard;

public class ProProcess {
    private String id;

    private Integer processNumber;

    private Integer parentProcessNumber;

    private String processName;

    private String processCategory;

    private Integer machineGroupNumber;

    private Integer perMachineGroupPeopleNumber;

    private String calculationFormula;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
        this.processName = processName == null ? null : processName.trim();
    }

    public String getProcessCategory() {
        return processCategory;
    }

    public void setProcessCategory(String processCategory) {
        this.processCategory = processCategory == null ? null : processCategory.trim();
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
        this.calculationFormula = calculationFormula == null ? null : calculationFormula.trim();
    }
}