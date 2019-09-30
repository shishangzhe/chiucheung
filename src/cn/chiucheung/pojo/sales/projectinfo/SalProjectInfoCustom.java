package cn.chiucheung.pojo.sales.projectinfo;

import java.util.Arrays;
import java.util.List;

import cn.chiucheung.po.sales.projectinfo.SalProjectInfo;

public class SalProjectInfoCustom extends SalProjectInfo{
	private String picIds;

	public List<String> getPicIds() {
		return picIds == null ? null : Arrays.asList(picIds.split(","));
	}

	public void setPicIds(String picIds) {
		this.picIds = picIds;
	}
	
}
