package cn.chiucheung.pojo.system.user;

import java.io.Serializable;

/**
 * 用于设置用户角色
 * @author adm-03
 *
 */
public class SysUserRoleCustom implements Serializable{
	private String userID;//用户id
	private String loginName;//用户登录名
	private String username;//用户名
	private String roleId;//用户角色，多个角色用，分隔
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
}
