package cn.chiucheung.pojo.warehouse.standardaccessoriesstockout;

import cn.chiucheung.po.warehouse.standardaccessoriesstockout.WarStandardAccessoriesStockOutSubsidiary;

public class WarStandardAccessoriesStockOutSubsidiaryCustom extends WarStandardAccessoriesStockOutSubsidiary{
	private String stockOutNo;
	
	private String accessoriesCode;
	
	private String accessoriesName;
	
	private String unit;
	
	private String accessoriesModel;
	
	private String warehouseInventory;
	
	private String warehousePositions;

	public String getStockOutNo() {
		return stockOutNo == null ? "" : stockOutNo;
	}

	public void setStockOutNo(String stockOutNo) {
		this.stockOutNo = stockOutNo;
	}

	public String getAccessoriesCode() {
		return accessoriesCode;
	}

	public void setAccessoriesCode(String accessoriesCode) {
		this.accessoriesCode = accessoriesCode;
	}

	public String getAccessoriesName() {
		return accessoriesName;
	}

	public void setAccessoriesName(String accessoriesName) {
		this.accessoriesName = accessoriesName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getAccessoriesModel() {
		return accessoriesModel;
	}

	public void setAccessoriesModel(String accessoriesModel) {
		this.accessoriesModel = accessoriesModel;
	}

	public String getWarehouseInventory() {
		return warehouseInventory;
	}

	public void setWarehouseInventory(String warehouseInventory) {
		this.warehouseInventory = warehouseInventory;
	}

	public String getWarehousePositions() {
		return warehousePositions;
	}

	public void setWarehousePositions(String warehousePositions) {
		this.warehousePositions = warehousePositions;
	}
	
	
}
