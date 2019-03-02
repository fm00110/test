package com.ncu.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ncu.bean1.NewsLabel;
import com.ncu.dao.INewsLabelDao;
import com.ncu.util.MyBatisUtil;




public class MyTest {
	private INewsLabelDao dao;
	private SqlSession sqlSession;
	
	
	@Before
	public void before(){
		sqlSession = MyBatisUtil.getSqlSession();
		dao = sqlSession.getMapper(com.ncu.dao.INewsLabelDao.class);
	}
	
	@After
	public void after(){
		if(sqlSession != null){
			sqlSession.close();
		}
	}
	
	@Test
	public void test1(){
		List<NewsLabel> childrens = dao.selectChildrenByParent(4);
		for (NewsLabel newsLabel : childrens) {
			System.out.println(newsLabel);
		}
	}
	@Test
	public void test2(){
		List<NewsLabel> childrens = dao.selectChildrenById(9);
		for (NewsLabel newsLabel : childrens) {
			System.out.println(newsLabel);
		}
	}

}
