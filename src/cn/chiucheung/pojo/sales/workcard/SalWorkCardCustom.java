package cn.chiucheung.pojo.sales.workcard;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.chiucheung.po.sales.workcard.SalWorkCard;
import cn.chiucheung.po.sales.workcard.SalWorkCardFile;
import cn.chiucheung.po.sales.workcard.SalWorkCardSubsidiary;

public class SalWorkCardCustom extends SalWorkCard{
	
	private String quotationNo;
	
	private List<SalWorkCardSubsidiary> workCardSubsidiaries;
	
	private List<SalWorkCardFile> workCardFiles;
	
	public String getQuotationNo() {
		return quotationNo;
	}

	public void setQuotationNo(String quotationNo) {
		this.quotationNo = quotationNo;
	}

	public List<SalWorkCardSubsidiary> getWorkCardSubsidiaries() {
		return workCardSubsidiaries;
	}

	public void setWorkCardSubsidiaries(
			List<SalWorkCardSubsidiary> workCardSubsidiaries) {
		this.workCardSubsidiaries = workCardSubsidiaries;
	}

	public List<SalWorkCardFile> getWorkCardFiles() {
		return workCardFiles;
	}

	public void setWorkCardFiles(List<SalWorkCardFile> workCardFiles) {
		this.workCardFiles = workCardFiles;
	}
	
}
