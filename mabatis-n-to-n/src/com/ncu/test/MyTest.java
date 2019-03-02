package com.ncu.test;



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
		sqlSession = MyBatisUtil.getSqlSession();
		dao = sqlSession.getMapper(com.ncu.dao.IStudentDao.class);
	}
	
	@After
	public void after(){
		if(sqlSession != null){
			sqlSession.close();
		}
	}
	
	@Test
	public void test1(){
		Student student = dao.selectStudentById(2);
		System.out.println(student);
	}


}
