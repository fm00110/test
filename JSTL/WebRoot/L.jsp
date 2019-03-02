<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<style type="text/css">
	.odd{
	background-color: red;
	}
	.even{
	background-color: green;
	}
	</style>

  </head>
  <body>
    <%
    Map<String,Integer> map=new HashMap<String,Integer>();
    map.put("张三", 23);
    map.put("李四", 24);
    map.put("王五", 25);
    map.put("赵六", 26);
    map.put("田七", 27);
    session.setAttribute("map", map);
     %>
    <table border="1px" cellspacing="0">
    <tr>
    <td>序号</td>
    <td>姓名</td>
    <td>年龄</td>
    </tr>
    <c:forEach items="${map }" var="person"  varStatus="personno">
    <tr class="${personno.count % 2==0?'odd':'even' }"><!-- 隔行换色 -->
    <td>${personno.count }</td>
    <td>${person.key }</td>
    <td>${person.value }</td> 
    </tr>
    
    </c:forEach>
    </table>
  </body>
</html>
