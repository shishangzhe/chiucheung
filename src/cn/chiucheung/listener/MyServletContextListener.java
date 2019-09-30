package cn.chiucheung.listener;

import java.util.LinkedHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import cn.chiucheung.po.system.user.SysUser;

/**
 * 用来记录在线用户和用户不能同时登陆，当同一个用户登录时候，会把之前登陆的用户踢下线
 * @author adm-03
 *
 */
public class MyServletContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
			
	}

	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext context = arg0.getServletContext();
		context.setAttribute("userMap", new LinkedHashMap<SysUser, HttpSession>());
	}

}
