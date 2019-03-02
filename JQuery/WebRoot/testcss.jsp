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
	/* $(document).mousemove(function(e){
	$("span").text("X:"+e.pageX+"Y:"+e.pageY)
	}) */
	
	$(":button").click(function (){
	$("div").scrollTop(100);
	$("div").scrollLeft(100);
	})
	
	})
	</script>
  </head>
  
  <body>
  <input type="button" value="按钮"><br>
    <p>显示鼠标的位置:<span></span></p><br>
    <div style="height: 1000px">
    <div style="border:1px solid black;width:200px;height:200px;overflow:auto">This is some text. 
    This is some text.This is some text. This is some text. This is s  ome text. This is some text. This is some text. This is some text.
   This is some text. This is some text. This is some text. This is some text. This is some text. This is some text. This is some text.
   This is some text. This is some text. This is some text. This is some text. This is some text. This is some text. This is some text.
    This is some text. This is some text. This is some text. This is some text. This is some text</div>
  </div>
  </body>

  
</html>
