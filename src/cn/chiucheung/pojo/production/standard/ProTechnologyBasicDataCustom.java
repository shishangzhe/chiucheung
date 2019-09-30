package cn.chiucheung.pojo.production.standard;

import java.util.List;

import cn.chiucheung.po.production.standard.ProTechnologyBasicData;

public class ProTechnologyBasicDataCustom extends ProTechnologyBasicData{
	private List<ProTechnologyWorkHoursBasicDataCustom> technologyWorkHoursBasicDatas;//计算页面存储工艺下拉的工时选项
	    
    private String value;//计算页面修改的时候，之前的值

	public List<ProTechnologyWorkHoursBasicDataCustom> getTechnologyWorkHoursBasicDatas() {
		return technologyWorkHoursBasicDatas;
	}

	public void setTechnologyWorkHoursBasicDatas(
			List<ProTechnologyWorkHoursBasicDataCustom> technologyWorkHoursBasicDatas) {
		this.technologyWorkHoursBasicDatas = technologyWorkHoursBasicDatas;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
    
}
