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
 //命名空间，即传过来的请求必须添加这个前缀,再加上资源名
public class MyController{
	
	@RequestMapping(value="/register.do")
	public ModelAndView doRegister(String name, int age) {
//  public ModelAndView doRegister(@requestParam("pname") String name, @requestParam("page") int age) {	
//  @requestParam("pname") 是用来矫正参数的，即传过来的参数名与这里的形参名不一致时可以用这种方式矫正参数		
		System.out.println(name);
		System.out.println(age);
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.addObject("age", age);	
		//参照路径为http://localhost:8080/spring-mvc10
		//mv.setViewName("redirect:other.do");  //这是重定向的方式转发
		mv.setViewName("other.do");  //默认的转发方式是请求转发
		return mv;
		
	}
	
	/*http协议里面不能放对象,只能放字符串*/
	
	
	@RequestMapping(value="/other.do")
	//要求的访问路径为http://localhost:8080/spring-mvc10/other.do
	public ModelAndView doOther(String name, int age) {
//  public ModelAndView doRegister(@requestParam("pname") String name, @requestParam("page") int age) {	
//  @requestParam("pname") 是用来矫正参数的，即传过来的参数名与这里的形参名不一致时可以用这种方式矫正参数		
		System.out.println(name);
		System.out.println(age);
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.addObject("age", age);
		//mv.setViewName("/welcome.jsp");  //默认的转发方式时请求转发
		mv.setViewName("redirect:welcome.jsp");  //这是重定向的方式转发
		return mv;
		
	}
	
	@RequestMapping("/myAjax.do")
	@ResponseBody
	public Object doAjax(){
		User u1 = new User("方敏","1234");
		return u1;
	}
	
	@RequestMapping("/returnStr.do")
	@ResponseBody
	public Object doreturnString(){
		User u1 = new User("方敏","1234");
		return "hello";
	}
	
	@RequestMapping(value="/returnUser.do",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object doreturnUser(){
		User u1 = new User("方敏","1234");
		return u1;
	}
	
	@RequestMapping(value="/returnuse.do")
	@ResponseBody
	public Object doreturnuse(){
		System.out.println("=====");
		User u1 = new User("方敏","1234");
		return u1;
	}
	
	@RequestMapping(value="/returnmap.do")
	@ResponseBody
	public Object doreturnmap(){
		System.out.println("======");
		Map<String,User> map = new HashMap<String, User>();
		User u1 = new User("方敏","1234");
		User u2 = new User("张飞","1234");
		map.put("u1", u1);
		map.put("u2", u2);
		
		return map;
	}
	
	@RequestMapping(value="/returnlist.do")
	@ResponseBody
	public Object doreturnlist(){

		User u1 = new User("方敏","1234");
		User u2 = new User("张飞","1234");
	
		List<User> lists = new ArrayList<User>();
		lists.add(u1);
		lists.add(u2);
		return lists;
	}
	
	@RequestMapping(value="/tables.do")
	@ResponseBody
	public Object returnTables(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//System.out.println("进入控制器");
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
