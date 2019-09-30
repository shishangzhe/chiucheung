package cn.chiucheung.pojo.system.role;

import java.io.Serializable;

/**
 * 用于权限页面取得角色所含有的全部权限，从数据库中取值就将pid和mid组拼成pid_mid，页面中的checkbox的id和value就是这样的
 * @author adm-03
 *
 */
public class SysRoleMenujztreeCustom implements Serializable{
	private String selectoper;

	public String getSelectoper() {
		return selectoper;
	}

	public void setSelectoper(String selectoper) {
		this.selectoper = selectoper;
	}
	
}
