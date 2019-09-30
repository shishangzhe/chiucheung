package cn.chiucheung.pojo.purchase.material;

import java.io.Serializable;

public class PurMaterialBaseDataCustom implements Serializable{
	
	private String dictionarieCode;
	
	private String dictionarieName;

	public String getDictionarieCode() {
		return dictionarieCode;
	}

	public void setDictionarieCode(String dictionarieCode) {
		this.dictionarieCode = dictionarieCode;
	}

	public String getDictionarieName() {
		return dictionarieName;
	}

	public void setDictionarieName(String dictionarieName) {
		this.dictionarieName = dictionarieName;
	}
	
}
