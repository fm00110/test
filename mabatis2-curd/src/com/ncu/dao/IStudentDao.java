package com.ncu.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ncu.bean1.Student;

public interface IStudentDao {

	void insertStudent(Student student);
	void insertStudentCacheId(Student student);
	
	void deleteStudentById(int id);
	void updateStudent(Student student);
	
	List<Student> selectAllStudents();
	Map<String, Object> selectAllStudentsMap();
	
	Student selectStudentById(int id);
	List<Student> selectStudentByName(String name);
	
	ArrayList selectStudent();
}
