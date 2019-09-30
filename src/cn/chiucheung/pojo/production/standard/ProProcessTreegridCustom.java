package cn.chiucheung.pojo.production.standard;

import java.util.List;

import cn.chiucheung.po.production.standard.ProProcess;

public class ProProcessTreegridCustom extends ProProcess{
	
	private List<ProProcessTreegridCustom> children;
	
	private String state;

	public List<ProProcessTreegridCustom> getChildren() {
		return children;
	}

	public void setChildren(List<ProProcessTreegridCustom> children) {
		this.children = children;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
