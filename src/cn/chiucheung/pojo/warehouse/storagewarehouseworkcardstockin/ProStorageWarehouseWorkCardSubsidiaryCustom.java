package cn.chiucheung.pojo.warehouse.storagewarehouseworkcardstockin;

import cn.chiucheung.po.warehouse.material.WarMaterial;

public class ProStorageWarehouseWorkCardSubsidiaryCustom extends WarMaterial{
	private String workCardNo;
	
	private int quantity;
	
	private String materialModel;

	public String getWorkCardNo() {
		return workCardNo;
	}

	public void setWorkCardNo(String workCardNo) {
		this.workCardNo = workCardNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMaterialModel() {
		return materialModel;
	}

	public void setMaterialModel(String materialModel) {
		this.materialModel = materialModel;
	}
	
}
