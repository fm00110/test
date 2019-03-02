package com.ncu.handlers;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncu.bean.Admin;
import com.ncu.bean.Student;
import com.ncu.bean.Teacher;
import com.ncu.services.IAdminService;
import com.ncu.services.IStudentService;
import com.ncu.services.ITeacherService;

@Controller
public class UserController {

	@Resource(name="sservice")
	private IStudentService sservice;
	@Resource(name="tservice")
	private ITeacherService tservice;
	@Resource(name="aservice")
	private IAdminService aservice;
	public IStudentService getSservice() {
		return sservice;
	}
	public void setSservice(IStudentService sservice) {
		this.sservice = sservice;
	}
	public ITeacherService getTservice() {
		return tservice;
	}
	public void setTservice(ITeacherService tservice) {
		this.tservice = tservice;
	}
	public IAdminService getAservice() {
		return aservice;
	}
	public void setAservice(IAdminService aservice) {
		this.aservice = aservice;
	}
	@RequestMapping("/login.do")
	public void doLogin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String users = request.getParameter("users");
		HttpSession session = request.getSession();
		if(users == null){
			session.setAttribute("userserrorMSG", "没有选择登录身份");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		if("student".equals(users)){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Student student = sservice.checkStudent(username, password);
			if(student != null){
				session.setAttribute("student", student);
				
				response.sendRedirect("studentmain.jsp");
			}
			else
			{
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				session.setAttribute("loginerrorMSG", "登录名或密码错误，请重新登录");
				response.sendRedirect("index.jsp");
			}
		}
		if("teacher".equals(users)){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Teacher teacher = tservice.checkTeacher(username, password);
			int degree = tservice.findMyDegree(username);
			if(teacher != null){
				session.setAttribute("degree", degree);
				session.setAttribute("teacher", teacher);
				request.getRequestDispatcher("/teachermain.jsp").forward(request, response);
			}
			else
			{
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				session.setAttribute("loginerrorMSG", "登录名或密码错误，请重新登录");
			}
		}
		if("admin".equals(users)){
			String ausername = request.getParameter("username");
			String password = request.getParameter("password");
			Admin admin = aservice.checkAdmin(ausername, password);
			if(admin != null){
				session.setAttribute("admin", admin);
				request.getRequestDispatcher("/adminmain.jsp").forward(request, response);
			}
			else
			{
				session.setAttribute("username", ausername);
				session.setAttribute("password", password);
				session.setAttribute("loginerrorMSG", "登录名或密码错误，请重新登录");
			}
		}
	}
}
