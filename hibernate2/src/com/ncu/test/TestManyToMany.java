package com.ncu.test;

import java.util.Set;

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
import com.ncu.n2n.Category;
import com.ncu.n2n.Item;
import com.ncu.util.HibernateSessionFactory;


public class TestManyToMany {
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
		Category category1 = new Category();
		category1.setName("c-aa");
		
		Category category2 = new Category();
		category2.setName("c-bb");
		
		Item item1 = new Item();
		item1.setName("i-aa");
		
		Item item2 = new Item();
		item2.setName("i-bb");
		
		category1.getItems().add(item1);
		category1.getItems().add(item2);
		
		category2.getItems().add(item1);
		category2.getItems().add(item2);
		
		session.save(category1);
		session.save(category2);
		
		session.save(item1);
		session.save(item2);
		
		
		
	}
	@Test
	public void testGet(){
		Category category = (Category) session.get(Category.class, 1);
		System.out.println(category.getName());
		
		Set<Item> items = category.getItems();
		System.out.println(items.size());
	}
	
}
