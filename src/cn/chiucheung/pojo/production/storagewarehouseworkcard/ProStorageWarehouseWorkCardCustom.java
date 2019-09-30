package cn.chiucheung.pojo.production.storagewarehouseworkcard;

import java.util.List;

import cn.chiucheung.po.production.storagewarehouseworkcard.ProStorageWarehouseWorkCard;
import cn.chiucheung.po.production.storagewarehouseworkcard.ProStorageWarehouseWorkCardSubsidiary;

public class ProStorageWarehouseWorkCardCustom extends ProStorageWarehouseWorkCard{
	private List<ProStorageWarehouseWorkCardSubsidiary> storageWarehouseWorkCardSubsidiaries;
	
	private List<ProStorageWarehouseWorkCardSubsidiaryShowDataCustom> subsidiaries;

	public List<ProStorageWarehouseWorkCardSubsidiary> getStorageWarehouseWorkCardSubsidiaries() {
		return storageWarehouseWorkCardSubsidiaries;
	}

	public void setStorageWarehouseWorkCardSubsidiaries(
			List<ProStorageWarehouseWorkCardSubsidiary> storageWarehouseWorkCardSubsidiaries) {
		this.storageWarehouseWorkCardSubsidiaries = storageWarehouseWorkCardSubsidiaries;
	}

	public List<ProStorageWarehouseWorkCardSubsidiaryShowDataCustom> getSubsidiaries() {
		return subsidiaries;
	}

	public void setSubsidiaries(
			List<ProStorageWarehouseWorkCardSubsidiaryShowDataCustom> subsidiaries) {
		this.subsidiaries = subsidiaries;
	}
	
}
