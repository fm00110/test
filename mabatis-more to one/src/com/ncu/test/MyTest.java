package com.ncu.test;



import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ncu.bean1.Minister;
import com.ncu.dao.IMinisterDao;
import com.ncu.util.MyBatisUtil;




public class MyTest {
	private IMinisterDao dao;
	private SqlSession sqlSession;
	
	
	@Before
	public void before(){
		sqlSession = MyBatisUtil.getSqlSession();
		dao = sqlSession.getMapper(com.ncu.dao.IMinisterDao.class);
	}
	
	@After
	public void after(){
		if(sqlSession != null){
			sqlSession.close();
		}
	}
	
	@Test
	public void test1(){
		Minister minister = dao.selectMinisterBuId(2);
		System.out.println(minister);
	}

}
