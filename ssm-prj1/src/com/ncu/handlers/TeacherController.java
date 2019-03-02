package com.ncu.handlers;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncu.bean.Inform;
import com.ncu.bean.Student;
import com.ncu.bean.StudentScore;
import com.ncu.bean.Teacher;
import com.ncu.services.ITeacherService;

@Controller
public class TeacherController {

	@Resource(name="tservice")
	private ITeacherService tservice;

	public ITeacherService getTservice() {
		return tservice;
	}

	public void setTservice(ITeacherService tservice) {
		this.tservice = tservice;
	}
	@RequestMapping("/findMyStudentInfo.do")
	public void doFirst(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		ArrayList<Student> myStudents = (ArrayList<Student>)tservice.findMyStudent(teacher.getTcname());
		session.setAttribute("myStudents", myStudents);
		response.sendRedirect("findMyStudent.jsp");
	}
	
	@RequestMapping("/insertMyStudentScore.do")
	public void doInsertMyStudent(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		String tcname = teacher.getTcname();
		String cname = tservice.findMyCname(teacher.getTcname());
		String stuidStr = request.getParameter("stuid");
		int stuid = Integer.valueOf(stuidStr);
		String stuname = request.getParameter("stuname");
		String sname = request.getParameter("stuname");
		String stuusername = request.getParameter("username");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String grname = request.getParameter("grname");
		String scoreStr = request.getParameter("score");
		double score = Double.valueOf(scoreStr);
		tservice.addMyStudent(stuid, sname, sex, phone, stuusername);
		tservice.addMyStudentScore(cname,stuname,score,tcname,grname);
		tservice.addMyStudentGra(grname,stuname);
		
		response.sendRedirect("insertMyStudent.jsp");
	}
	
	@RequestMapping("/checkInform.do")
	public void doCheckInform(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		ArrayList<Inform> informs = (ArrayList<Inform>)tservice.findAllInform();
		session.setAttribute("informs", informs);
		response.sendRedirect("announcement.jsp");
	}
	
	@RequestMapping("/insertInform.do")
	public void doInsertInform(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		tservice.insertInform(title,content,teacher.getTcname());
		session.setAttribute("success", "发布成功");
		request.getRequestDispatcher("/announcement.jsp").forward(request, response);
	}
	
	@RequestMapping("/selectStudentScore.do")
	public void doSelectStudentScore(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		ArrayList<StudentScore> studentScores = (ArrayList<StudentScore>)tservice.findMyStudentScore(teacher.getTcname());
		session.setAttribute("studentScores", studentScores);
		request.getRequestDispatcher("/modifyStudentScore.jsp").forward(request, response);
	}
	
	@RequestMapping("/updateMyStudentScore.do")
	public void doUpdateMyStudentScore(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		String tcname = teacher.getTcname();
		String[] stunames = request.getParameterValues("stuname");
		String[] scores = request.getParameterValues("score");
		System.out.println(scores.length);
		for(int i=0;i<scores.length/2;i++){			
			double score = Double.valueOf(scores[i]);
			tservice.modifyMyStudentScore(stunames[i],score,tcname);
		}
		session.setAttribute("updateScoreSucc", "更新数据成功,请重新进入本页面查看");
		request.getRequestDispatcher("/teachermain.jsp").forward(request, response);
	}
}
