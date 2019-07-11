package com.mooop.def.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mooop.def.helper.RequestHelper;



/**
 * 
 *  외부 요청에 대한 정보 출력
 * 
 * @author MOoop
 *
 */
public class LoggingInterceptor extends HandlerInterceptorAdapter{
	private static Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.debug("================================================================");
		logger.debug("** schema : {}" , RequestHelper.getRequestSchema(request));
		logger.debug("** context : {}",request.getContextPath());
		logger.debug("** URI : {}",RequestHelper.getRequestURI(request));
		logger.debug("** isAjax : {}",RequestHelper.isAjaxRequest(request));
		logger.debug("** Client IP : {}",RequestHelper.getRemoteRequestIp(request));
		logger.debug("================================================================");
		
		return super.preHandle(request, response, handler);
	}
	
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

}
