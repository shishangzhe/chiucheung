package cn.chiucheung.pojo.finance.checksheet;

import java.util.List;

import cn.chiucheung.po.finance.checksheet.FinCheckSheet;


public class FinExportExcelForCheckSheetCustom extends FinCheckSheet{
	
	private List<LogTravelSpendingRecordsMultipleDataCustomForExportExcelForCheckSheet> list;

	public List<LogTravelSpendingRecordsMultipleDataCustomForExportExcelForCheckSheet> getList() {
		return list;
	}

	public void setList(List<LogTravelSpendingRecordsMultipleDataCustomForExportExcelForCheckSheet> list) {
		this.list = list;
	}
	
}