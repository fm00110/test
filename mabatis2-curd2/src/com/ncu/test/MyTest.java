package com.ncu.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.ncu.bean1.Student;
import com.ncu.dao.IStudentDao;
import com.ncu.dao.StudentDaoImpl;

public class MyTest {
	private IStudentDao dao;
	@Before
	public void before(){	
		dao = new StudentDaoImpl();
	}

	@Test
	public void test(){
		Student student = new Student("张三飞",23, 95.5);
		dao.insertStudent(student);
	}
	@Test
	public void test2(){
		Student student = new Student("李四",23, 95.5);
		System.out.println(student);    //Student [id=null, name=李四, age=23, score=95.5]
		dao.insertStudentCacheId(student);
		System.out.println(student);    //Student [id=13, name=李四, age=23, score=95.5]获得id
	}
	
	@Test
	public void test3(){
		dao.deleteStudentById(12);
	}
	
	@Test
	public void test4(){
		Student student = new Student("张三",24, 95.5);
		student.setId(4);	
	    dao.updateStudent(student);
	}
	
	@Test
	public void test5(){
		List<Student> students = dao.selectAllStudents();
		/*Iterator<Student> it = students.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}*/
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	@Test
	public void test6(){
		Map<String, Object> map = dao.selectAllStudentsMap();
		System.out.println(map.get("张三"));
	
		
	}
	@Test
	public void test7(){
		Student student = dao.selectStudentById(5);
		System.out.println(student);
	
		
	}
	
	
	
	@Test
	public void test8(){
		List<Student> students = dao.selectStudentByName("张三飞");
		/*Iterator<Student> it = students.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}*/
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
