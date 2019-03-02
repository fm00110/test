<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ncu.bean.CouTeacher" %>
<%@ page import="com.ncu.bean.Student" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'selectCourse.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="updateCourse.do" method="post">
    	<table align="center" border="1" cellspacing="0">
    	<caption>你可以选择的课程有如下几门</caption>
    		<tr border="2" bgcolor="yellow">
    		<td>课程编号</td>
    		<td>课程名字</td>
    		<td>教师姓名</td>
    		<td>选课</td>
    		</tr>
    		<%
    		ArrayList<CouTeacher> courses = (ArrayList<CouTeacher>)session.getAttribute("courses");
    		Student student = (Student)session.getAttribute("student");
    		String myGrade = (String)session.getAttribute("myGrade");
    		for(CouTeacher course : courses){  		
    		 %>
    		 <tr>
    		 <td><%=course.getCid() %></td>
    		 <td><%=course.getCname() %></td>
    		 <td><%=course.getTcname() %></td>
    		 <td>
    		 <input name="cname" type="checkbox" value="<%=course.getCname() %>">
    		 <input name="stuname" type="hidden" value="<%=student.getSname() %>">
    		 <input name="tcname" type="hidden" value="<%=course.getTcname() %>">
    		 <input name="cid" type="hidden" value="<%=course.getCid() %>">
    		 <input name="grname" type="hidden" value="<%=myGrade %>">
    		 </td>
    		 </tr>
    		 <% } %>
    	</table>
    	<input type="submit" value="提交">
    </form>
   </body>
</html>
