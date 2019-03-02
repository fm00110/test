<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>绑定事件</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.img1{width: 70px;height: 70px}
.img2{width: 80px;height: 80px}
</style>
  </head>
  <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
  <script type="text/javascript">
  $(function(){
  	$("#img").hover(function(){      //这是鼠标移入事件
  	$(this).removeClass("img1")
  	$(this).addClass("img2")
  	},function(){             //这是鼠标移出事件
  	 	$(this).removeClass("img2")
  	$(this).addClass("img1")
  	})
  	$("#but").click(function(){
  	$("#info").toggle();
  	})
  })
 
  </script>
  <body>
     <img alt="图片丢失" src="images/a.png" id= "img" class="img1"><br>
     <input type="button" value="切换" id="but"><br>
     <div id="info">
      <img alt="图片丢失" src="images/a.png" id= "img" class="img2">
     </div>
  </body>
</html>
