package com.ncu.services;

import java.util.ArrayList;

import com.ncu.bean.Inform;
import com.ncu.bean.Student;
import com.ncu.bean.StudentScore;
import com.ncu.bean.Teacher;

public interface ITeacherService {

	Teacher checkTeacher(String username, String password);

	ArrayList<Student> findMyStudent(String tcname);

	void addMyStudent(int stuid, String sname, String sex, String phone, String stuusername);

	String findMyCname(String tcname);

	void addMyStudentScore(String cname, String stuname, double score, String tcname, String grname);

	void addMyStudentGra(String grname, String stuname);

	int findMyDegree(String username);

	ArrayList<Inform> findAllInform();

	void insertInform(String title, String content, String tcname);

	ArrayList<StudentScore> findMyStudentScore(String tcname);

	void modifyMyStudentScore(String stuname, double score, String tcname);

	

	

	

}
