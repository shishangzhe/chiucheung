package cn.chiucheung.pojo.production.standard;

import cn.chiucheung.po.production.standard.ProTechnologyWorkHoursBasicData;

public class ProTechnologyWorkHoursBasicDataCustom extends ProTechnologyWorkHoursBasicData{
	private boolean selected = false;//用于计算页面是否选中为默认，修改计算的时候，重新赋值回去的时候需要用到

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
}
