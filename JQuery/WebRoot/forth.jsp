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
	var v_name = $("#name");
	alert(v_name.length)  //ID是不能重复的因此如果有多个ID相同那么jQuery只会获取第一次出现的ID作为jQuery对象
	alert(v_name.val())   //这是获取ID选择器属性的默认值!
	})
	
	</script>
  </head>
  
  <body>
    <input type="text" id="name" value="张三"><br>
    <input type="text" id="name" value="李四"><br>
  </body>
  
</html>
