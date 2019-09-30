package cn.chiucheung.pojo.system.message;

import java.util.List;

public class SysMessageVo {
	private String loginName;
	
	private List<String> ids;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	
}
