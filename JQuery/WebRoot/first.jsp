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
	
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
	<script type="text/javascript">
	//alert(document.getElementById("name").value) 不能卸载这里，因为这里的id还未出现
	alert(1)
	$(function(){
	window.alert("我启动了jiquery！")
	 alert(document.getElementById("name").value)
	})
	alert(2)
	</script>
  </head>
  
  <body>
    <input type="text" id="name" value="张三">
  </body>
  <script type="text/javascript">
  alert(document.getElementById("name").value)
  </script>
</html>
