<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'all-no.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
  </head>
  <script type="text/javascript">
  function alloption(){
  	var v_ahObj = $(".ah");
  	for(var i = 0;i<v_ahObj.length;i++){
  	$(v_ahObj[i]).attr("checked",true)     
  	 //attr() 获取属性的值，第一个参数为属性名，第二个参数为你要设定的值，也可以不写第二个参数
  	 //$(v_ahObj[i]).prop("checked",true)     prop专门操作属性值为boolean值属性
  	 //attr专门操作属性值不为boolean
  	}
  }
  $(function(){
  $("#but").click(function(){
  alert("我点击了这个按钮")
  })
  })
  function nooption(){
  var v_ahObj = $(".ah");
  	for(var i = 0;i<v_ahObj.length;i++){
  	$(v_ahObj[i]).attr("checked",false)   //$(v_ahObj[i]).prop("checked",false)
  	}
  }
  </script>
  <body>
   <input type="button" value="全选" onclick="alloption()">
   <input type="button" value="反选" id="but">
   <input type="button" value="取消" onclick="nooption()"><br>
   爱好:<input type="checkbox"  class="ah"  value="eat">吃
   <input type="checkbox" class="ah" value="drink">喝
   <input type="checkbox" class="ah" value="play">玩
   <input type="checkbox" class="ah" value="happy">乐
  </body>
</html>
