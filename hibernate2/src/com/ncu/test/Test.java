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
		
		//先插入1的一端，再插入n的一端只会有insert语句，而且是依次插入
		//session.save(customer);
	//	session.save(order1);
	//	session.save(order2);
		
		//先插入n的一端，再插入1的一端，会多出update语句，因为它没有确定外键值，所以随机插入一个外键值，然后
		//再根据你自己插入的外键值去更新
		session.save(order1);
		session.save(order2);
		session.save(customer);
		
		
	
		
	}
	@org.junit.Test
	public void testGet(){
		//懒加载的方式，只有用到的属性才会查询，没用到的不会查询
		Order order = (Order) session.get(Order.class, 1);
		System.out.println(order);
	}
}
