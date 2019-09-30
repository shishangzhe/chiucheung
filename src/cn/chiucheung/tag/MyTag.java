package cn.chiucheung.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import cn.chiucheung.po.system.user.Privilege;
import cn.chiucheung.po.system.user.SysUser;


public class MyTag extends SimpleTagSupport{
	private String mid;
	
	private String pid;
	
	public void setMid(String mid) {
		this.mid = mid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Override
	public void doTag() throws JspException, IOException {
		HttpSession session = ((PageContext)getJspContext()).getSession();
		SysUser user = (SysUser) session.getAttribute("user");
		if (user.getLoginName().equals("admin")){
		    //达到条件显示属于该标签的所有内容
			getJspBody().invoke(null);
		}else{
			List<Privilege> privileges = (List<Privilege>) session.getAttribute("privileges");
			//判断当前用户的mid是否有多种
			if (mid.indexOf(",")<0){
				Privilege privilege = new Privilege();
				privilege.setMid(mid);
				privilege.setPid(pid);
				if (privileges.contains(privilege)){
					getJspBody().invoke(null);
				}
			}else{
				String[] mids = mid.split(",");
				for (String mid : mids) {
					Privilege privilege = new Privilege();
					privilege.setMid(mid);
					privilege.setPid(pid);
					if (privileges.contains(privilege)){
						getJspBody().invoke(null);
						break;
					}
				}
			}
		}
	}
}
