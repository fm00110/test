package com.ncu.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ncu.bean.Customer;
import com.ncu.bean.Order;
import com.ncu.entity.Department;
import com.ncu.entity.Manager;
import com.ncu.util.HibernateSessionFactory;


public class TestOnetoOne {
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
public void test1(){
	Department deptment = new Department();
	deptment.setDeptName("dept-aa");
	
	Manager manager = new Manager();
	manager.setMgrName("mgr-aa");
	
	//设置关联关系
	deptment.setMgr(manager);
	manager.setDept(deptment);
	
	//保存
	session.save(manager);
	session.save(deptment);
	
}
	@Test
	public void testget(){
		//默认情况下使用懒加载
		//所以会出现懒加载异常
		Department dept = (Department) session.get(Department.class, 1);
		System.out.println(dept.getDeptName());
	}
}
