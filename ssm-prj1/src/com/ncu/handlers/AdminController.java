package com.ncu.handlers;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncu.bean.Student;
import com.ncu.bean.Teacher;
import com.ncu.bean.TeacherAllInfo;
import com.ncu.services.IAdminService;

@Controller
public class AdminController {

	@Resource(name="aservice")
	private IAdminService aservice;

	public IAdminService getAservice() {
		return aservice;
	}

	public void setAservice(IAdminService aservice) {
		this.aservice = aservice;
	}
	
	@RequestMapping("/showAllUserInfo.do")
	public void doFirst(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		ArrayList<TeacherAllInfo> allTeachers = (ArrayList<TeacherAllInfo>)aservice.findAllTeacherInfo();
		response.sendRedirect("findMyStudent.jsp");
	}
}
