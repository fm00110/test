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
		 
		//hql�Ĳ�ѯ����
		
		//1������query����
		//����λ�õĲ���FROM Employee�Ǵ�ʵ�����в��Ҷ�Ӧ�ı�
		String hql = "FROM Employee e where e.salary > ? and e.name like ?";
		Query query = session.createQuery(hql);

		//2�����Ǹ�����
		query.setFloat(0, 2000).setString(1,"%A%");     //�������һ�����.setxxx�������а󶨲�����Ҫע��󶨲�����λ��
		
		//3��ִ�в�ѯ
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
