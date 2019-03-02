package com.ncu.interceptor;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TeacherInter implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String grname = request.getParameter("grname");
		String scoreStr = request.getParameter("score");
		double score = Double.valueOf(scoreStr);
		String phone = request.getParameter("phone");
		String str1 = "信安151班";
		String str2 = "信安152班";
		String str3 = "信安153班";
		String str4 = "信安154班";
		if(!(str1.equals(grname)) && !(str2.equals(grname)) && !(str3.equals(grname)) && !(str4.equals(grname))){
			session.setAttribute("grnameEror", "只能输入信安1~4班");
			request.getRequestDispatcher("/insertMyStudent.jsp").forward(request, response);
			return false;
		}
		if(score < 0 || score > 100){
			session.setAttribute("scoreEror", "成绩不能小于0或者大于100");
			request.getRequestDispatcher("/insertMyStudent.jsp").forward(request, response);
			return false;
		}
		if(!Pattern.matches("^(13|15|16|18)\\d{9}$", phone)){
			session.setAttribute("phoneEror", "手机格式错误，请重新输入,格式如13698785675");
			request.getRequestDispatcher("/insertMyStudent.jsp").forward(request, response);
			return false;
		}
		
		return true;
	}

}
