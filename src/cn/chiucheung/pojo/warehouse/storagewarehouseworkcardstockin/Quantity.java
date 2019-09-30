package cn.chiucheung.pojo.warehouse.storagewarehouseworkcardstockin;
/**
 * 用于入库单的重新审核，存储入库单对应物料的入库数量、现存数量、占有量
 * @author adm-03
 *
 */
public class Quantity {
	private Integer stockInQuantity;//入库数量
	
	private Integer existingQuantity;//现存数量
	
	private Integer occupyQuantity;//占有量

	public Integer getStockInQuantity() {
		return stockInQuantity;
	}

	public void setStockInQuantity(Integer stockInQuantity) {
		this.stockInQuantity = stockInQuantity;
	}

	public Integer getExistingQuantity() {
		return existingQuantity;
	}

	public void setExistingQuantity(Integer existingQuantity) {
		this.existingQuantity = existingQuantity;
	}

	public Integer getOccupyQuantity() {
		return occupyQuantity;
	}

	public void setOccupyQuantity(Integer occupyQuantity) {
		this.occupyQuantity = occupyQuantity;
	}

}