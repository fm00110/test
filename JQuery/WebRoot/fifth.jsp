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
		var v_names = $(".name");
		//获取的jQuery对象是一个数组，如果直接使用jQuery那么jQuery会把数组中的第一个元素作为jQuery的对象使用
		alert(v_names.length);
		alert(v_names.val())
		alert($(v_names[1]).val()) //因为jQuery数组中元素的值是DOM对象，所以可以将它转变为jQuery对象再输出
		alert(v_names[1].value)   //或者用DOM对象的输出方式将它输出
	})


	</script>
  </head>
  
  <body>
    <input type="text"  class="name" value="张三"><br>
    <input type="text"  class="name" value="李四">
  </body>
  
</html>
