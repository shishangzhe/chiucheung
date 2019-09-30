package cn.chiucheung.pojo.sales.workcard;

import java.util.List;

import cn.chiucheung.po.sales.workcard.SalWorkCardKztOther;
import cn.chiucheung.po.sales.workcard.SalWorkCardKztWithBLOBs;

public class SalWorkCardKztCustom extends SalWorkCardKztWithBLOBs{
	private String confirmation;
	
	private List<SalWorkCardKztOther> workCardConfirmationOthers;

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public List<SalWorkCardKztOther> getWorkCardConfirmationOthers() {
		return workCardConfirmationOthers;
	}

	public void setWorkCardConfirmationOthers(
			List<SalWorkCardKztOther> workCardConfirmationOthers) {
		this.workCardConfirmationOthers = workCardConfirmationOthers;
	}
	
}
