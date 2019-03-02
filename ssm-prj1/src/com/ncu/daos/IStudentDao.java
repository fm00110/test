package com.ncu.daos;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ncu.bean.CouTeacher;
import com.ncu.bean.Course;
import com.ncu.bean.Evaluation;
import com.ncu.bean.Inform;
import com.ncu.bean.Score;
import com.ncu.bean.Student;

public interface IStudentDao {

	Student selectStudentByUP(@Param("username")String username, @Param("password")String password);
	
	ArrayList<Score> selectStudentScoreInfo(@Param("stuname")String stuname);
	
	ArrayList<CouTeacher> selectAllCourse();
	
	ArrayList<String> selectMyCourse(@Param("stuname")String stuname);
	
	String selectGrade(@Param("stuname")String stuname);
	
	void updateCourse(@Param("cname")String cname, @Param("stuname")String stuname, @Param("tcname")String tcname, @Param("grname")String grname);

	void insertPartEvaluation(@Param("cname")String cname, @Param("tcname")String tcname, @Param("stuname")String stuname);
	
	ArrayList<Evaluation> selectMyEvaluation(@Param("stuname")String stuname);

	void updateEvaluation(@Param("cname")String cname, @Param("tcname")String tcname, @Param("stuname")String stuname, @Param("score")double score, @Param("evaluation")String evaluation);

	ArrayList<Inform> selectInform();

	String selectMyPassword(@Param("username")String username);

	void updateMyPassword(@Param("username")String username, @Param("password")String password);
}
