package cn.chiucheung.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 用户是否登陆的过滤器
 * @author adm-03
 *
 */
public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {
		if (request.getSession().getAttribute("user") != null){
			return true;
		}
		String uri = request.getRequestURI();
		if (uri.contains("market/conductPropagandaFile/downloadConductPropagandaFileById.action") && "OfficeWebApps".equals(request.getParameter("origin"))){
			return true;
		}
		if (uri.contains("login.action") || uri.contains("loginIndex.action") || uri.contains("utils") || uri.contains("market/map/index.action")){
			return true;
		}
		//针对app请求的拦截
		if (uri.contains("/api/app")){
			return true;
		}
		//巡展报名
		if (uri.contains("/market/exhibitionContact/signUp")){
			return true;
		}
		//测试用
		if (uri.contains("/production/technologicalProcess")){
			return true;
		}
		
		
		//针对ajax请求的拦截
		if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			response.setDateHeader("Expires", 0);
			response.setHeader("sessionstatus", "timeout");
		}else{
			request.getRequestDispatcher("/logintimeout.jsp").forward(request, response);
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView view) throws Exception {
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		
	}
	
}
