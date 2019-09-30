package cn.chiucheung.filter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.po.system.user.Privilege;
import cn.chiucheung.po.system.user.SysUser;

public class MyPrivilegeInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {
		if (request.getRequestURI().contains("market/conductPropagandaFile/downloadConductPropagandaFileById.action") && "OfficeWebApps".equals(request.getParameter("origin"))){
			return true;
		}
		SysUser user = (SysUser) request.getSession().getAttribute("user");
		if ( user != null && user.getLoginName().equals("admin")){
			return true;
		}else{
			List<Privilege> privileges = (List<Privilege>) request.getSession().getAttribute("privileges");
			HandlerMethod method = (HandlerMethod)handler;
			if (method.getMethod().isAnnotationPresent(AnnotationLimit.class)){//如果有注解，没有注解则直接放行
				if (privileges != null && privileges.size() > 0){
					AnnotationLimit annotationLimit = method.getMethodAnnotation(AnnotationLimit.class);
					String mid = annotationLimit.mid();
					String pid = annotationLimit.pid();
					Privilege privilege = new Privilege();
					privilege.setMid(mid);
					privilege.setPid(pid);
					if (privileges.contains(privilege)){//如果有权限，则放行
						return true;
					}else{
						response.sendError(403);
						//request.getRequestDispatcher("/WEB-INF/jsp/noPrivilege.jsp").forward(request, response);
						return false;
					}
				}else{
					response.sendError(403);
					return false;
				}
			}else{
				return true;
			}
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView view) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		
	}
}
