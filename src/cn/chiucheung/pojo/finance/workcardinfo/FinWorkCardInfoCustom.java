package cn.chiucheung.pojo.finance.workcardinfo;

import cn.chiucheung.po.finance.workcardinfo.FinWorkCardInfo;

public class FinWorkCardInfoCustom extends FinWorkCardInfo{
	private int unSubmitCheckSheetNumber;//未提交的报账单数量
	
	private int unGeneratCheckSheetNumber;//未生成的报账单数量

	public int getUnSubmitCheckSheetNumber() {
		return unSubmitCheckSheetNumber;
	}

	public void setUnSubmitCheckSheetNumber(int unSubmitCheckSheetNumber) {
		this.unSubmitCheckSheetNumber = unSubmitCheckSheetNumber;
	}

	public int getUnGeneratCheckSheetNumber() {
		return unGeneratCheckSheetNumber;
	}

	public void setUnGeneratCheckSheetNumber(int unGeneratCheckSheetNumber) {
		this.unGeneratCheckSheetNumber = unGeneratCheckSheetNumber;
	}
	
}
