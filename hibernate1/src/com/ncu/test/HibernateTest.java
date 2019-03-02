package com.ncu.test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import com.ncu.bean.News;
import com.ncu.bean.Pay;
import com.ncu.bean.Worker;

import resources.HibernateSessionFactory;

public class HibernateTest {

	@Test
	public void test(){
		//1.1创建一个sessionFactory对象
		SessionFactory sessionFactory = null;
		//1.2创建configuration对象：对应hibernate的基本配置信息和对象关系映射信息
		Configuration configuration = new Configuration().configure();
		
		//2.创建一个serviceRegistry对象
		//hibernate的任何配置都需要再该对象中注册后才能有效
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		//3.创建一个session对象
		Session session = sessionFactory.openSession();
		
		//4.开启事务
		Transaction transaction = session.beginTransaction();
		
		//5.执行保存操作
		News news = new News("java","fm",new Date(new java.util.Date().getTime()));
		
		session.save(news);
		
		//6.提交事务
		transaction.commit();
		
		//7.关闭session对象
		session.close();
		
		//8.关闭sessionFactory对象
		sessionFactory.close();
		
		
	}
	
	@Test
	public void test2(){
		//也可以从hibernateSessionFactory中获得session和session Factory对象
		News news = new News("web","fm",new Date(new java.util.Date().getTime()));
		Session session = HibernateSessionFactory.getSession();
		session.save(news);
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		session.close();
	}
	/**
	 * flush:是数据表中的记录和session缓存中的对象状态保存一致，为了保存一致，则可能发送对应的sql语句
	 * flush可能会发送sql语句，但是并不一定会提交
	 */
	@Test
	public void test3(){
		//也可以从hibernateSessionFactory中获得session和session Factory对象
		
		Session session = HibernateSessionFactory.getSession();
		News news = (News)session.get(News.class, 1);
		news.setAuthor("zfl");
		News news2 = (News)session.get(News.class, 1);
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		System.out.println(news);
		System.out.println(news2);
		session.close();
	}
	@Test
	public void test4(){
		Session session = HibernateSessionFactory.getSession();
		News news = (News)session.get(News.class, 1);
		session.refresh(news);
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		System.out.println(news);
		
		session.close();
	}
	@Test
	public void test5(){
		Session session = HibernateSessionFactory.getSession();
		News news = new News("学习","zzz",new Date(new java.util.Date().getTime()));
		System.out.println(news);
		session.save(news);
		System.out.println(news);
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		System.out.println(news);
		
		session.close();
	}
	@Test
	public void testWorker(){
		Worker worker = new Worker();
		Pay pay = new Pay();
		
		pay.setAddr("洛阳路211号");
		pay.setPname("中兴软创");
		worker.setId(1);
		worker.setName("方敏");
		worker.setPay(pay);
		
		//1.1创建一个sessionFactory对象
		SessionFactory sessionFactory = null;
		//1.2创建configuration对象：对应hibernate的基本配置信息和对象关系映射信息
		Configuration configuration = new Configuration().configure();
		
		//2.创建一个serviceRegistry对象
		//hibernate的任何配置都需要再该对象中注册后才能有效
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		//3.创建一个session对象
		Session session = sessionFactory.openSession();
		
		//4.开启事务
		Transaction transaction = session.beginTransaction();
		session.save(worker);
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	}
}
