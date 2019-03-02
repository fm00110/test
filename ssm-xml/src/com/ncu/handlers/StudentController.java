package com.ncu.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.ncu.bean.Student;
import com.ncu.services.IStudentService;

public class StudentController implements Controller {
	private IStudentService service;
	

	public void setService(IStudentService service) {
		this.service = service;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		ModelAndView mv = new ModelAndView("/welcome.jsp");
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		int age = Integer.valueOf(ageStr);
		Student student = new Student(name, age);
		service.addStudent(student);
		return mv;
	}

}
