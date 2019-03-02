<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'first.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- DOM对象就是HTML中的标签 -->
	
	<!-- 启动jquery等效代码
	$ 等价 jquery ,$其实就是jquery库中定义的一个全局变量，用于表示jQuery这个对象
	 -->
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript">
	jQuery(function(){
	alert("我的jquery已经启动!")
	})
	
	$(function(){
	alert("你好!")
	})
	
	</script>
  </head>
  
  <body>
    <input type="text" id="name" value="张三">
  </body>
 
</html>
