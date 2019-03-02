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
	$(function (){
	$("#btn").click(function(){
	/* $(".tx").each(function(){       //只适用于标签为class
	alert($(this).val())
	}) */
	alert($($(".tx")[1]).val())      //弹出第二个文本框的值     $(".tx")[1]是DOM对象
	})
	
	});
	</script>
  </head>
  
  <body>
   <input type="text" class="tx" name="name" value="zzz">
   <input type="text" class="tx" name="name" value="fff">
   <input type="text"class="tx" name="name" value="xxx">
   <input type="text" class="tx" name="name" value="ttt"><br>
   <input type="button"  id="btn"value="按钮">
   
  </body>

</html>
