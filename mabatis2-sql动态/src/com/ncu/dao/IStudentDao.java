package com.ncu.dao;

import java.util.List;
import java.util.Map;

import com.ncu.bean1.Student;

public interface IStudentDao {

	void insertStudent(Student student);
	List<Student> selectStudents(Student student);
	List<Student> selectStudentsByChoose(Student student);
	List<Student> selectStudentsForeach(int[] ads);
}
