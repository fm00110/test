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
	$(function(){
	var v_dom=document.getElementById("name");

	var v_jquery=$(v_dom);   //将DOM对象转换成jQuery对象
	//alert(v_jquery.value)  这是错误的，因为jQuery对象不能使用DOM对象的属性value
	alert(v_jquery.val())
	})
	
	</script>
  </head>
  
  <body>
   <input type="text" value="张三" id="name">
  </body>

</html>
