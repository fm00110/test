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
		
		/*获得接口的全限定名，和mapper的命名空间向匹配,就不要写IStudentDao的实现类了*/
	}
	
	@After
	public void after(){
		if(sqlSession != null){
			sqlSession.close();
		}
	}

	@Test
	public void test(){
		Student student = new Student("张三飞",23, 95.5);
		dao.insertStudent(student);
		sqlSession.commit();
		/*进行插入 ，删除， 更新操作都要提交，查询不需要提交就可以
		 * 而且，增、删改操作会清空一级缓存，无论是否提交
		 * 一级缓存的生命周期和SQL session的生命周期是一致的
		 * 
		 * 开启内置的二级缓存步骤：
		 * 1)对实体进行序列化
		 * 2)在映射文件中添加<cathe/>标签
		  */
	}
	@Test
	public void test2(){
		Student student = new Student("李四",23, 95.5);
		System.out.println(student);    //Student [id=null, name=李四, age=23, score=95.5]
		dao.insertStudentCacheId(student);
		System.out.println(student);    //Student [id=13, name=李四, age=23, score=95.5]获得id
		sqlSession.commit();
		/*进行插入 ，删除， 更新操作都要提交*/
	}
	
	@Test
	public void test3(){
		dao.deleteStudentById(12);
		sqlSession.commit();
		/*进行插入 ，删除， 更新操作都要提交*/
	}
	
	@Test
	public void test4(){
		Student student = new Student("张三",24, 95.5);
		student.setId(4);	
	    dao.updateStudent(student);
	    sqlSession.commit();
		/*进行插入 ，删除， 更新操作都要提交*/
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
		System.out.println(map.get("张三"));
	
		
	}*/  //没有定义该id
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
