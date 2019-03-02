package com.ncu.daos;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ncu.bean.Inform;
import com.ncu.bean.Student;
import com.ncu.bean.StudentScore;
import com.ncu.bean.Teacher;

public interface ITeacherDao {

	Teacher selectTeacherByUP(@Param("username")String username, @Param("password")String password);

	ArrayList<Student> selectMyStudent(String tcname);

	void insertMyStudent(@Param("stuid")int stuid, @Param("sname")String sname, @Param("sex")String sex, @Param("phone")String phone, @Param("stuusername")String stuusername);

	String selectMyCname(@Param("tcname")String tcname);

	void insertMyStudentScore(@Param("cname")String cname, @Param("stuname")String stuname, @Param("score")double score, @Param("tcname")String tcname, @Param("grname")String grname);

	void insertMyStudentGra(@Param("grname")String grname, @Param("stuname")String stuname);

	int selectMyDegree(@Param("username")String username);

	ArrayList<Inform> selectAllInform();

	void insertInform(@Param("title")String title, @Param("content")String content, @Param("tcname")String tcname);

	ArrayList<StudentScore> selectMyStudentScore(@Param("tcname")String tcname);

	void updateMyStudentScore(@Param("stuname")String stuname, @Param("score")double score, @Param("tcname")String tcname);

	
}
