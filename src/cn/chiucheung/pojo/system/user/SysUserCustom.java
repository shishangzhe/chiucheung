package cn.chiucheung.pojo.system.user;

import cn.chiucheung.po.system.user.SysUser;

/**
 * 用于存储用户和用户角色，用于用户的添加、修改、查询
 * @author adm-03
 *
 */
public class SysUserCustom extends SysUser{
	private String roleId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
}
