package cn.chiucheung.pojo.warehouse.storagewarehouseworkcardstockin;

import cn.chiucheung.po.warehouse.storagewarehouseworkcardstockin.WarStorageWarehouseWorkCardStockInSubsidiary;

public class WarStorageWarehouseWorkCardStockInSubsidiaryCustom extends WarStorageWarehouseWorkCardStockInSubsidiary{
	private String stockInNo;
	
	private String workCardNo;
	
	private String materialCode;
	
	private String materialName;
	
	private String useUnit;
	
	private String materialModel;
	
	private String warehouse;
	
	private String warehousePositions;

	public String getStockInNo() {
		return stockInNo;
	}

	public void setStockInNo(String stockInNo) {
		this.stockInNo = stockInNo;
	}

	public String getWorkCardNo() {
		return workCardNo;
	}

	public void setWorkCardNo(String workCardNo) {
		this.workCardNo = workCardNo;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getUseUnit() {
		return useUnit;
	}

	public void setUseUnit(String useUnit) {
		this.useUnit = useUnit;
	}

	public String getMaterialModel() {
		return materialModel;
	}

	public void setMaterialModel(String materialModel) {
		this.materialModel = materialModel;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public String getWarehousePositions() {
		return warehousePositions;
	}

	public void setWarehousePositions(String warehousePositions) {
		this.warehousePositions = warehousePositions;
	}
	
}
