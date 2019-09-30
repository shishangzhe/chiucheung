package cn.chiucheung.pojo.sales.workcard;

import java.util.List;

import cn.chiucheung.po.sales.workcard.SalWorkCardDsqOther;
import cn.chiucheung.po.sales.workcard.SalWorkCardDsqWithBLOBs;

public class SalWorkCardDsqCustom extends SalWorkCardDsqWithBLOBs{
	private String confirmation;
	
	private List<SalWorkCardDsqOther> workCardConfirmationOthers;

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public List<SalWorkCardDsqOther> getWorkCardConfirmationOthers() {
		return workCardConfirmationOthers;
	}

	public void setWorkCardConfirmationOthers(
			List<SalWorkCardDsqOther> workCardConfirmationOthers) {
		this.workCardConfirmationOthers = workCardConfirmationOthers;
	}

}
