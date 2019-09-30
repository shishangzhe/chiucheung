package cn.chiucheung.pojo.system.role;

import java.util.List;

import cn.chiucheung.po.system.user.SysMenujztreeKey;
/**
 * 用于权限设置页面排布的domain，看jsp/system/roleIndex.jsp
 * @author adm-03
 *
 */
public class MenujztreeCustom extends SysMenujztreeKey{
	private String name;

	private List<MenujztreeCustom> MenujztreeCustoms;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MenujztreeCustom> getMenujztreeCustoms() {
		return MenujztreeCustoms;
	}

	public void setMenujztreeCustoms(List<MenujztreeCustom> menujztreeCustoms) {
		MenujztreeCustoms = menujztreeCustoms;
	}
	
}
