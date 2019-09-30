package cn.chiucheung.pojo.sales.workcard;

import java.util.List;

import cn.chiucheung.po.sales.workcard.SalWorkCardEia;
import cn.chiucheung.po.sales.workcard.SalWorkCardEiaOther;

public class SalWorkCardEiaCustom extends SalWorkCardEia{
	private String confirmation;
	
	private List<SalWorkCardEiaOther> workCardConfirmationOthers;

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public List<SalWorkCardEiaOther> getWorkCardConfirmationOthers() {
		return workCardConfirmationOthers;
	}

	public void setWorkCardConfirmationOthers(
			List<SalWorkCardEiaOther> workCardConfirmationOthers) {
		this.workCardConfirmationOthers = workCardConfirmationOthers;
	}

}
