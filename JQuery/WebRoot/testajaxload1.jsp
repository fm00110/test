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
	$("#btn").click(function (){
	htmlobj=$.ajax({url:"testajaxload2.jsp",async:false});
	$("body").html(htmlobj.responseText);
	//$("#mydiv").html(htmlobj.responseText);
	//$("myDiv").html(htmlobj.responseText);
	})
	})
	</script>
  </head>
  
  <body>
  <input type="button" value="加载" id="btn"><br>
    <div style="width: 300px; height: 100px;background-color: green;"></div>
    <div id="mydiv" style="width: 300px; height: 100px;background-color: red;"></div>
    <div id="myDiv"></div>
  </body>

</html>
