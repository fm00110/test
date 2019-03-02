package com.ncu.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ncu.entity.Employee;
import com.ncu.util.HibernateSessionFactory;




public class TestHql {
	private Session session;
	private Transaction  transaction;
	@Before
	public void init(){
		session = HibernateSessionFactory.getSession();
		 transaction = session.beginTransaction();
	}

	@After
	public void destroy(){
		transaction.commit();
		session.close();
	}
	@Test
	public void testHql1(){
		 
		//hql的查询步骤
		
		//1、创建query对象
		//基于位置的参数FROM Employee是从实体类中查找对应的表
		String hql = "FROM Employee e where e.salary > ? and e.name like ?";
		Query query = session.createQuery(hql);

		//2、绑定那个参数
		query.setFloat(0, 2000).setString(1,"%A%");     //后面可以一致添加.setxxx方法进行绑定参数，要注意绑定参数的位置
		
		//3、执行查询
		List<Employee> emps = query.list();
		System.out.println(emps.size());
		
	}
	@Test
	public void testPageQuery(){
		String hql = "FROM Employee";
		Query query = session.createQuery(hql);
		int pageNo = 3;
		int pageSize = 5;
		List<Employee> emps = query.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
		System.out.println(emps);
	}
}
