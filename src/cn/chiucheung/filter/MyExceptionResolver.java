package cn.chiucheung.filter;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;


public class MyExceptionResolver extends SimpleMappingExceptionResolver{
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
			Logger logger = Logger.getLogger(handler.getClass());
			StringWriter sw = new StringWriter();   
			ex.printStackTrace(new PrintWriter(sw, true));
			logger.error(sw.toString());
		return super.doResolveException(request, response, handler, ex);
	}
	
}
