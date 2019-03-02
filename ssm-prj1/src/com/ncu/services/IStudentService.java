package com.ncu.services;

import java.util.ArrayList;

import com.ncu.bean.CouTeacher;
import com.ncu.bean.Course;
import com.ncu.bean.Evaluation;
import com.ncu.bean.Inform;
import com.ncu.bean.Score;
import com.ncu.bean.Student;

public interface IStudentService {

	Student checkStudent(String username, String password);

	ArrayList<Score> findStudentScoreInfo(String stuname);

	ArrayList<CouTeacher> findAllCourse();

	ArrayList<String> findMyCourse(String stuname);

	String findMyGrade(String stuname);

	void updateCourse(String cname, String stuname, String tcname, String grname);

	void updatePartEvaluation(String cname, String tcname, String stuname);

	ArrayList<Evaluation> selectMyEvaluation(String stuname);

	void updateEvaluation(String string, String string2, String string3, double score, String string5);

	ArrayList<Inform> seeInform();

	String findMyPassword(String username);

	void updateMyPassword(String username, String password);


	

	

}
