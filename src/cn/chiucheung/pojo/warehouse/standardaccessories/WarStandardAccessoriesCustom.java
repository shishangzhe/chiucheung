package cn.chiucheung.pojo.warehouse.standardaccessories;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import cn.chiucheung.po.warehouse.standardaccessories.WarStandardAccessories;

public class WarStandardAccessoriesCustom extends WarStandardAccessories implements Serializable{
	private String fileId;
	
	public String getFileId() {
		if (StringUtils.isNotBlank(fileId)){
			fileId = "<a href='readFileById.action?id="+fileId+"' target='target_'>查看</a>";
		}
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
}
