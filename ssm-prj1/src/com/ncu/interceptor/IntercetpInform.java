package com.ncu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class IntercetpInform implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("执行了拦截");
		HttpSession session = request.getSession();
		int degree = (int)session.getAttribute("degree");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		if(degree < 3){
			session.setAttribute("title", title);
			session.setAttribute("content", content);
			session.setAttribute("litledegree", "您的等级不够不能发布通知");
			request.getRequestDispatcher("/announcement.jsp").forward(request, response);
			return false;
		}
		return true;
	}

}
