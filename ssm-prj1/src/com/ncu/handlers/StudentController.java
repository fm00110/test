package com.ncu.handlers;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncu.bean.CouTeacher;
import com.ncu.bean.Course;
import com.ncu.bean.Evaluation;
import com.ncu.bean.Inform;
import com.ncu.bean.Score;
import com.ncu.bean.Student;
import com.ncu.services.IStudentService;



@Controller
public class StudentController {

	@Resource(name="sservice")
	private IStudentService sservice;

	public IStudentService getSservice() {
		return sservice;
	}

	public void setSservice(IStudentService sservice) {
		this.sservice = sservice;
	}
	@RequestMapping("/selectStudentInfo.do")
	public void doSelectStudentInfo(HttpServletRequest request, HttpServletResponse response)
			throws IOException{
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		String stuname = student.getSname();
		ArrayList<Score> scores = sservice.findStudentScoreInfo(stuname);
		session.setAttribute("scores", scores);
		response.sendRedirect("scoreform.jsp");
	}
	
	@RequestMapping("/selectCourse.do")
	public void doSelectCourse(HttpServletRequest request, HttpServletResponse response)
			throws IOException{
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		String stuname = student.getSname();
		ArrayList<CouTeacher> courses = sservice.findAllCourse();		
		ArrayList<String> mycourses = sservice.findMyCourse(stuname);
		ArrayList<CouTeacher> repeats = new ArrayList<CouTeacher>();
		String myGrade = sservice.findMyGrade(stuname);
		for(CouTeacher course : courses){
			for(String mycourse : mycourses){
				if(course.getCname().equals(mycourse)){	
					repeats.add(course);
				}
			}
		}
		courses.removeAll(repeats);
		session.setAttribute("myGrade", myGrade);
		session.setAttribute("courses", courses);
		response.sendRedirect("selectCourse.jsp");
	}
	@RequestMapping("/updateCourse.do")
	public void doUpdateCourse(HttpServletRequest request, HttpServletResponse response)
			throws IOException{
		HttpSession session = request.getSession();
		String[] cnames = request.getParameterValues("cname");
		String[] tcnames = request.getParameterValues("tcname");
		String[] grnames = request.getParameterValues("grname");
		String[] stunames = request.getParameterValues("stuname");
		for(int i = 0;i<cnames.length;i++){
			sservice.updateCourse(cnames[i], stunames[i], tcnames[i], grnames[i]);
			sservice.updatePartEvaluation(cnames[i],stunames[i],tcnames[i]);
		}
	response.sendRedirect("studentmain.jsp");
	}
	
	@RequestMapping("/evaluation.do")
	public void doEvaluation(HttpServletRequest request, HttpServletResponse response)
			throws IOException{
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		String stuname = student.getSname();
		ArrayList<Evaluation> evaluations = sservice.selectMyEvaluation(stuname);
		session.setAttribute("evaluations", evaluations);
		response.sendRedirect("evaluation.jsp");
	}
	
	@RequestMapping("/updateEvaluation.do")
	public void doUpdateEvaluation(HttpServletRequest request, HttpServletResponse response)
			throws IOException{
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		String stuname = student.getSname();
		String[] scores = request.getParameterValues("score");
		String[] evaluations = request.getParameterValues("evaluation");
		String[] cnames = request.getParameterValues("cname");
		String[] tcnames = request.getParameterValues("tcname");
		String[] stunames = request.getParameterValues("stuname");
		for(int i=0;i<evaluations.length;i++){
			double score = Double.valueOf(scores[i]);
			sservice.updateEvaluation(cnames[i], tcnames[i], stunames[i], score, evaluations[i]);
		}
		response.sendRedirect("studentmain.jsp");
	}
	
	@RequestMapping("/seeInformation.do")
	public void doSeeInfom(HttpServletRequest request, HttpServletResponse response)
			throws IOException{
		HttpSession session = request.getSession();
		ArrayList<Inform> informs = sservice.seeInform();
		session.setAttribute("informs", informs);
		response.sendRedirect("inform.jsp");
	}
	
	@RequestMapping("/modifyPassword.do")
	public void doModifyPassword(HttpServletRequest request, HttpServletResponse response)
			throws IOException{
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		String password = sservice.findMyPassword(student.getStuusername());
		session.setAttribute("password", password);
		response.sendRedirect("modifyPassword.jsp");
	}
	@RequestMapping("/updatePassword.do")
	public void doupdatePassword(HttpServletRequest request, HttpServletResponse response)
			throws IOException{
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		String username = student.getStuusername();
		String password = request.getParameter("password");
		sservice.updateMyPassword(username, password);
		session.setAttribute("passwordMSG", "密码已修改,请重新登录");
		response.sendRedirect("index.jsp");
	}
}
