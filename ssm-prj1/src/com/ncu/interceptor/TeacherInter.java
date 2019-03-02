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
		String str1 = "�Ű�151��";
		String str2 = "�Ű�152��";
		String str3 = "�Ű�153��";
		String str4 = "�Ű�154��";
		if(!(str1.equals(grname)) && !(str2.equals(grname)) && !(str3.equals(grname)) && !(str4.equals(grname))){
			session.setAttribute("grnameEror", "ֻ�������Ű�1~4��");
			request.getRequestDispatcher("/insertMyStudent.jsp").forward(request, response);
			return false;
		}
		if(score < 0 || score > 100){
			session.setAttribute("scoreEror", "�ɼ�����С��0���ߴ���100");
			request.getRequestDispatcher("/insertMyStudent.jsp").forward(request, response);
			return false;
		}
		if(!Pattern.matches("^(13|15|16|18)\\d{9}$", phone)){
			session.setAttribute("phoneEror", "�ֻ���ʽ��������������,��ʽ��13698785675");
			request.getRequestDispatcher("/insertMyStudent.jsp").forward(request, response);
			return false;
		}
		
		return true;
	}

}
