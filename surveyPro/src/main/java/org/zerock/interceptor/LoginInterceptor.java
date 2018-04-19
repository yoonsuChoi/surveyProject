package org.zerock.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("Interceptor in...");
		
		HttpSession session = request.getSession(true);
		
		if ("../joinus/login".equals(request.getRequestURI())) {
			return true;
		}
		
		if (session.getAttribute("login") == null) {
			System.out.println("로그인 세션이 없는 경우...");
			response.sendRedirect("../joinus/login");
			return false;
			
		} else {
			System.out.println("로그인 세션이 있는 경우...");
			return true;
		}
		
	}

}
