<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
   <%
   Map<String,Integer> m=new HashMap<String,Integer>();
   m.put("name", 1);
   m.put("addr", 2);
   m.put("id", 3);
   session.setAttribute("map", m);
   
    %>
    ${sessionScope.map.get("name") }<br>
    ${sessionScope.map.get("addr") }<br>
    ${sessionScope.map.get("id") }<br>
    
  </body>
</html>
