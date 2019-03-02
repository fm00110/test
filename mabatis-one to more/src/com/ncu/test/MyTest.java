package com.ncu.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ncu.bean1.Country;
import com.ncu.dao.ICountryDao;
import com.ncu.util.MyBatisUtil;




public class MyTest {
	private ICountryDao dao;
	private SqlSession sqlSession;
	
	
	@Before
	public void before(){
		sqlSession = MyBatisUtil.getSqlSession();
		dao = sqlSession.getMapper(com.ncu.dao.ICountryDao.class);
	}
	
	@After
	public void after(){
		if(sqlSession != null){
			sqlSession.close();
		}
	}
	
	@Test
	public void test1(){
		Country country = dao.selectCountryById(2);
		System.out.println(country);
	}

}
