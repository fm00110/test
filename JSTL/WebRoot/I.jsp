<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  
  
  <c:set var="topic" value="<h1>我爱中国</h1>"></c:set>
    <c:out value="${topic }"></c:out><br>
    <c:out value="${topic }" escapeXml="default"></c:out><br>
    ${topic }<br>
    
    
    <c:set var="msg" scope="session" value="欢迎!"></c:set>
    <c:out value="${sessionScope.msg }"></c:out><br>
    <c:out value="${msg }"></c:out><br>
    ${msg }<br>
    
    <c:remove var="msg" scope="session"></c:remove>
    
    ${sessionScope.msg }
    
    
    
    <br>--------------c:catch------------<br>
    <c:catch var="ex">
    <%
    int i=3 / 0;
     %>
    
    </c:catch>
    ${ex.message }
    
    
  </body>
</html>
