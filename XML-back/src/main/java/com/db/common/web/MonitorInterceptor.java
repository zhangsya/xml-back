package com.db.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MonitorInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Monitor.preHandle");
		long startTime=System.currentTimeMillis();
		request.setAttribute("startTime",startTime);
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Monitor.postHandle");
		long endTime=System.currentTimeMillis();
		long startTime=(Long)request.getAttribute("startTime");
		System.out.println("execute time "+(endTime-startTime));
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("Monitor.afterCompletion");
	}
}
