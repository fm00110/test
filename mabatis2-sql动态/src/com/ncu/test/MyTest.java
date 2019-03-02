package com.ncu.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import com.ncu.bean1.Student;
import com.ncu.dao.IStudentDao;

import com.ncu.util.MyBatisUtil;

public class MyTest {
	private SqlSession sqlSession;
	private IStudentDao dao;
	@Before
	public void before(){	
		sqlSession = MyBatisUtil.getSqlSession();
		dao = sqlSession.getMapper(com.ncu.dao.IStudentDao.class);
		
	}
	
	@Test
	public void test1(){
		Student stu = new Student("уе", 23, 90);
		List<Student> students = dao.selectStudents(stu);
		for (Student student : students) {
			System.out.println(student);
		}
	}
	@Test
	public void test2(){
		Student stu = new Student("уе", 23, 90);
		List<Student> students = dao.selectStudentsByChoose(stu);
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	public void test3(){
		int[] ids = {1,3,5};
		List<Student> students = dao.selectStudentsForeach(ids); 
		for (Student student : students) {
			System.out.println(student);
		}
	}


}
