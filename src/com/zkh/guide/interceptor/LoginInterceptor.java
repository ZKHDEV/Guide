package com.zkh.guide.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {

		String url = request.getRequestURI();
		if(url.indexOf(request.getContextPath()+"/index.action")>=0){
			return true;
		}
		if(url.indexOf("/Account")>=0){
			return true;
		}
		
		HttpSession session = request.getSession();
		if(session.getAttribute("login_user") != null){
			return true;
		}
		
		response.sendRedirect(request.getContextPath()+"/index.action");
		
		return false;
	}

}
