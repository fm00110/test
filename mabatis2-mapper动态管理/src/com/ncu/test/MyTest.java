package com.ncu.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ncu.bean1.Student;
import com.ncu.dao.IStudentDao;
import com.ncu.util.MyBatisUtil;

public class MyTest {
	private IStudentDao dao;
	private SqlSession sqlSession;
	@Before
	public void before(){	
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		dao = sqlSession.getMapper(com.ncu.dao.IStudentDao.class);
		
		/*��ýӿڵ�ȫ�޶�������mapper�������ռ���ƥ��,�Ͳ�ҪдIStudentDao��ʵ������*/
	}
	
	@After
	public void after(){
		if(sqlSession != null){
			sqlSession.close();
		}
	}

	@Test
	public void test(){
		Student student = new Student("������",23, 95.5);
		dao.insertStudent(student);
		sqlSession.commit();
		/*���в��� ��ɾ���� ���²�����Ҫ�ύ����ѯ����Ҫ�ύ�Ϳ���
		 * ���ң�����ɾ�Ĳ��������һ�����棬�����Ƿ��ύ
		 * һ��������������ں�SQL session������������һ�µ�
		 * 
		 * �������õĶ������沽�裺
		 * 1)��ʵ��������л�
		 * 2)��ӳ���ļ������<cathe/>��ǩ
		  */
	}
	@Test
	public void test2(){
		Student student = new Student("����",23, 95.5);
		System.out.println(student);    //Student [id=null, name=����, age=23, score=95.5]
		dao.insertStudentCacheId(student);
		System.out.println(student);    //Student [id=13, name=����, age=23, score=95.5]���id
		sqlSession.commit();
		/*���в��� ��ɾ���� ���²�����Ҫ�ύ*/
	}
	
	@Test
	public void test3(){
		dao.deleteStudentById(12);
		sqlSession.commit();
		/*���в��� ��ɾ���� ���²�����Ҫ�ύ*/
	}
	
	@Test
	public void test4(){
		Student student = new Student("����",24, 95.5);
		student.setId(4);	
	    dao.updateStudent(student);
	    sqlSession.commit();
		/*���в��� ��ɾ���� ���²�����Ҫ�ύ*/
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
	
/*	@Test
	public void test6(){
		Map<String, Object> map = dao.selectAllStudentsMap();
		System.out.println(map.get("����"));
	
		
	}*/  //û�ж����id
	@Test
	public void test7(){
		Student student = dao.selectStudentById(5);
		System.out.println(student);
	
		
	}
	
	
	
	@Test
	public void test8(){
		List<Student> students = dao.selectStudentByName("������");
		/*Iterator<Student> it = students.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}*/
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
