package cn.chiucheung.po.system.user;

import java.io.Serializable;
import java.util.LinkedHashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


public class SysUser implements HttpSessionBindingListener, Serializable{
    private String id;

    private String loginName;

    private String loginPassword;

    private String username;

    private String departmentId;

    private String groupsId;

    private String isAllowedLogin;
    
    private String assignee;//username(loginName)格式输出，用于activiti的assignee

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getGroupsId() {
        return groupsId;
    }

    public void setGroupsId(String groupsId) {
        this.groupsId = groupsId == null ? null : groupsId.trim();
    }

    public String getIsAllowedLogin() {
        return isAllowedLogin;
    }

    public void setIsAllowedLogin(String isAllowedLogin) {
        this.isAllowedLogin = isAllowedLogin == null ? null : isAllowedLogin.trim();
    }
    
    public String getAssignee() {
		return getUsername() + "(" + getLoginName() + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysUser other = (SysUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		//当用户登录时,代表用户的bean存入了session中,此时自动向用户列表中添加自己
		HttpSession session = event.getSession();
		ServletContext context = session.getServletContext();
		LinkedHashMap<SysUser, HttpSession> map = (LinkedHashMap<SysUser, HttpSession>) context.getAttribute("userMap");
		map.put(this, session);
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		//当用户下线时,无论是手动注销还是超时下线,代表用户的bean都移除出了session,此时自动从用户列表中移除自己
		HttpSession session = event.getSession();
		ServletContext context = session.getServletContext();
		LinkedHashMap<SysUser, HttpSession> map = (LinkedHashMap<SysUser, HttpSession>) context.getAttribute("userMap");
		map.remove(this);
	}
}