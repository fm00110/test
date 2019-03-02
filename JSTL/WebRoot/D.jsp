<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="beans.Stu" %>
<%@ page import="beans.School" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'C.jsp' starting page</title>
    
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
   <jsp:useBean id="school" class="beans.School" scope="session"></jsp:useBean>
   <jsp:setProperty property="name" name="school" value="南昌青山湖区"/>
   <jsp:setProperty property="addr" name="school" value="南昌大学"/>
   <jsp:getProperty property="name" name="school"/>
   
   <jsp:useBean id="student" class="beans.Stu" scope="session"></jsp:useBean>
   <jsp:setProperty property="stuname" name="student" value="方敏"/>
   <jsp:setProperty property="id" name="student" value="15"/>
   <jsp:setProperty property="age" name="student" value="15"/>
   <jsp:setProperty property="school" name="student" value="${school }" />  
   <jsp:getProperty property="stuname" name="student"/>
     
   
     
 </body>
</html>
