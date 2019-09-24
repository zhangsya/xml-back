package com.db.common.web;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * Spring MVC 中的拦截器对象：
 * 要实现的功能：时间访问限制
 */
@Component
public class AccessInterceptor extends HandlerInterceptorAdapter {
	/**此方法会在控制层方法执行之前执行
	 * ，返回值决定了是否要继续执行控制
	 * 层方法*/
	/*@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		long time=System.currentTimeMillis();
		//日历对象
		Calendar c=Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 14);//小时
		c.set(Calendar.MINUTE, 0);//分钟
		c.set(Calendar.SECOND, 0);//秒
		long start=c.getTimeInMillis();//获取当前毫秒
		c.set(Calendar.HOUR_OF_DAY, 18);
		long end=c.getTimeInMillis();
		if(time<start||time>end)
		throw new ServiceException("不在访问时间内");
		return true;//true表示放行，false表示不放行
}*/	
}








