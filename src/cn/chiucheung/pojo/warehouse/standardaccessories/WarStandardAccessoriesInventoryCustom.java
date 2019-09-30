package cn.chiucheung.pojo.warehouse.standardaccessories;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import cn.chiucheung.po.warehouse.standardaccessories.WarStandardAccessories;

public class WarStandardAccessoriesInventoryCustom extends WarStandardAccessories implements Serializable{
	
	private String fileId;

    private Integer existingQuantity;//现存数量
    
    private String warStandardAccessoriesId;
    
    private String expectQuantity;//预计入库量
    
    private String occupyQuantity;//占有量

	public String getFileId() {
		if (StringUtils.isNotBlank(fileId)){
			fileId = "<a href='readFileById.action?id="+fileId+"' target='target_'>查看</a>";
		}
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getExistingQuantity() {
		if (existingQuantity < getLowestWarehousingQuantity()){
			return "<font color='red'>"+existingQuantity+"</font>";
		}else{
			return existingQuantity + "";
		}
	}

	public void setExistingQuantity(Integer existingQuantity) {
		this.existingQuantity = existingQuantity;
	}

	public String getWarStandardAccessoriesId() {
		return warStandardAccessoriesId;
	}

	public void setWarStandardAccessoriesId(String warStandardAccessoriesId) {
		this.warStandardAccessoriesId = warStandardAccessoriesId;
	}

	public String getExpectQuantity() {
		return expectQuantity;
	}

	public void setExpectQuantity(String expectQuantity) {
		this.expectQuantity = expectQuantity;
	}

	public String getOccupyQuantity() {
		return occupyQuantity;
	}

	public void setOccupyQuantity(String occupyQuantity) {
		this.occupyQuantity = occupyQuantity;
	}
    
}
