package com.ncu.handlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ncu.bean.User;

@Controller
 //�����ռ䣬�����������������������ǰ׺,�ټ�����Դ��
public class MyController{
	
	@RequestMapping(value="/register.do")
	public ModelAndView doRegister(String name, int age) {
//  public ModelAndView doRegister(@requestParam("pname") String name, @requestParam("page") int age) {	
//  @requestParam("pname") ���������������ģ����������Ĳ�������������β�����һ��ʱ���������ַ�ʽ��������		
		System.out.println(name);
		System.out.println(age);
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.addObject("age", age);	
		//����·��Ϊhttp://localhost:8080/spring-mvc10
		//mv.setViewName("redirect:other.do");  //�����ض���ķ�ʽת��
		mv.setViewName("other.do");  //Ĭ�ϵ�ת����ʽ������ת��
		return mv;
		
	}
	
	/*httpЭ�����治�ܷŶ���,ֻ�ܷ��ַ���*/
	
	
	@RequestMapping(value="/other.do")
	//Ҫ��ķ���·��Ϊhttp://localhost:8080/spring-mvc10/other.do
	public ModelAndView doOther(String name, int age) {
//  public ModelAndView doRegister(@requestParam("pname") String name, @requestParam("page") int age) {	
//  @requestParam("pname") ���������������ģ����������Ĳ�������������β�����һ��ʱ���������ַ�ʽ��������		
		System.out.println(name);
		System.out.println(age);
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.addObject("age", age);
		//mv.setViewName("/welcome.jsp");  //Ĭ�ϵ�ת����ʽʱ����ת��
		mv.setViewName("redirect:welcome.jsp");  //�����ض���ķ�ʽת��
		return mv;
		
	}
	
	@RequestMapping("/myAjax.do")
	@ResponseBody
	public Object doAjax(){
		User u1 = new User("����","1234");
		return u1;
	}
	
	@RequestMapping("/returnStr.do")
	@ResponseBody
	public Object doreturnString(){
		User u1 = new User("����","1234");
		return "hello";
	}
	
	@RequestMapping(value="/returnUser.do",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object doreturnUser(){
		User u1 = new User("����","1234");
		return u1;
	}
	
	@RequestMapping(value="/returnuse.do")
	@ResponseBody
	public Object doreturnuse(){
		System.out.println("=====");
		User u1 = new User("����","1234");
		return u1;
	}
	
	@RequestMapping(value="/returnmap.do")
	@ResponseBody
	public Object doreturnmap(){
		System.out.println("======");
		Map<String,User> map = new HashMap<String, User>();
		User u1 = new User("����","1234");
		User u2 = new User("�ŷ�","1234");
		map.put("u1", u1);
		map.put("u2", u2);
		
		return map;
	}
	
	@RequestMapping(value="/returnlist.do")
	@ResponseBody
	public Object doreturnlist(){

		User u1 = new User("����","1234");
		User u2 = new User("�ŷ�","1234");
	
		List<User> lists = new ArrayList<User>();
		lists.add(u1);
		lists.add(u2);
		return lists;
	}
	
	@RequestMapping(value="/tables.do")
	@ResponseBody
	public Object returnTables(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//System.out.println("���������");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_stockmanage","root","1234");
		Statement stmt = conn.createStatement();
		String tableName = request.getParameter("tableName");
		if("".equals(tableName)){
			return 0;
		}
		
		String sql = "select count(*) totalCount from "+tableName;
		ResultSet rs = stmt.executeQuery(sql);
		int rowCount = 0;
		while (rs.next()) {
			rowCount = rs.getInt("totalCount");
		}
		
		
		return rowCount;
	}

}
