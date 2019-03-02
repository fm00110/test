package com.ncu.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;

import com.ncu.bean.Customer;
import com.ncu.bean.Order;
import com.ncu.util.HibernateSessionFactory;


public class Test {
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
	@org.junit.Test
	public void testManyToOne(){
		 
		Customer customer = new Customer();
		customer.setCustomerName("zf");

		Order order1 = new Order();
		order1.setOrderName("o3");
		
		Order order2 = new Order();
		order2.setOrderName("o4");
		
		order1.setCustomer(customer);
		order2.setCustomer(customer);
		
		//�Ȳ���1��һ�ˣ��ٲ���n��һ��ֻ����insert��䣬���������β���
		//session.save(customer);
	//	session.save(order1);
	//	session.save(order2);
		
		//�Ȳ���n��һ�ˣ��ٲ���1��һ�ˣ�����update��䣬��Ϊ��û��ȷ�����ֵ�������������һ�����ֵ��Ȼ��
		//�ٸ������Լ���������ֵȥ����
		session.save(order1);
		session.save(order2);
		session.save(customer);
		
		
	
		
	}
	@org.junit.Test
	public void testGet(){
		//�����صķ�ʽ��ֻ���õ������ԲŻ��ѯ��û�õ��Ĳ����ѯ
		Order order = (Order) session.get(Order.class, 1);
		System.out.println(order);
	}
}
