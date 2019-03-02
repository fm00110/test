<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jqueryajax.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
  <script type="text/javascript">
  $(function(){
 $("#loginname").blur(function(){
 $("#loginname").css("background-color","#FFFFCC");
 var v_name = $("#loginname").val();
 $.ajax({
 type: "POST",
 url: "checkname",
 data: "name="+v_name,
 dataType: "json",
 success: function(data){
 if(!data){
 $("#info").text("对不起这个账号正在使用，请更换");
 } else{
 $("#info").text("您可以使用这个账号")
 }

 },

 error : function(){
 $("#info").html('<p style="color: red">对不起，服务器出错了，请重新登录浏览器!</p>')
 }
 })
 })
  })
  
  </script>
  <body>
    姓名:<input type="text" name="name" id="loginname">
    <div id="info">
    
    </div>
  </body>
</html>
