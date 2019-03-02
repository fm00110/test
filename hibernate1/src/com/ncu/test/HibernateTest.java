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
		//1.1����һ��sessionFactory����
		SessionFactory sessionFactory = null;
		//1.2����configuration���󣺶�Ӧhibernate�Ļ���������Ϣ�Ͷ����ϵӳ����Ϣ
		Configuration configuration = new Configuration().configure();
		
		//2.����һ��serviceRegistry����
		//hibernate���κ����ö���Ҫ�ٸö�����ע��������Ч
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		//3.����һ��session����
		Session session = sessionFactory.openSession();
		
		//4.��������
		Transaction transaction = session.beginTransaction();
		
		//5.ִ�б������
		News news = new News("java","fm",new Date(new java.util.Date().getTime()));
		
		session.save(news);
		
		//6.�ύ����
		transaction.commit();
		
		//7.�ر�session����
		session.close();
		
		//8.�ر�sessionFactory����
		sessionFactory.close();
		
		
	}
	
	@Test
	public void test2(){
		//Ҳ���Դ�hibernateSessionFactory�л��session��session Factory����
		News news = new News("web","fm",new Date(new java.util.Date().getTime()));
		Session session = HibernateSessionFactory.getSession();
		session.save(news);
		Transaction transaction = session.beginTransaction();
		transaction.commit();
		session.close();
	}
	/**
	 * flush:�����ݱ��еļ�¼��session�����еĶ���״̬����һ�£�Ϊ�˱���һ�£�����ܷ��Ͷ�Ӧ��sql���
	 * flush���ܻᷢ��sql��䣬���ǲ���һ�����ύ
	 */
	@Test
	public void test3(){
		//Ҳ���Դ�hibernateSessionFactory�л��session��session Factory����
		
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
		News news = new News("ѧϰ","zzz",new Date(new java.util.Date().getTime()));
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
		
		pay.setAddr("����·211��");
		pay.setPname("������");
		worker.setId(1);
		worker.setName("����");
		worker.setPay(pay);
		
		//1.1����һ��sessionFactory����
		SessionFactory sessionFactory = null;
		//1.2����configuration���󣺶�Ӧhibernate�Ļ���������Ϣ�Ͷ����ϵӳ����Ϣ
		Configuration configuration = new Configuration().configure();
		
		//2.����һ��serviceRegistry����
		//hibernate���κ����ö���Ҫ�ٸö�����ע��������Ч
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		//3.����һ��session����
		Session session = sessionFactory.openSession();
		
		//4.��������
		Transaction transaction = session.beginTransaction();
		session.save(worker);
		transaction.commit();
		session.close();
		sessionFactory.close();
		
	}
}
