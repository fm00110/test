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
    <c:set var="pageno" value="3"></c:set>
    <c:set var="pages"  value="10"></c:set>
    <c:choose>
    <c:when test="${pageno==1 }">
    首页    上一页   <a href="#">下一页</a>   <a href="#">尾页</a>   当前是第${pageno }页/${pages }页
    </c:when>
    <c:when test="${pageno==pages }">
   <a href="#">首页</a>   <a href="#">上一页</a>  下一页      尾页       当前是${pageno }页/${pages }页
    </c:when>
    <c:otherwise>
    <a href="#">首页</a>   <a href="#">上一页</a>  <a href="#">下一页</a>   <a href="#">尾页</a>  当前是${pageno }页/${pages }页
    </c:otherwise>
    
    </c:choose>
    
    
    
  </body>
</html>
