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
	
		//根据ID获取jQuery对象，jQuery对象其实是一个数组，数组的长度取决于 jQuery获取页面元素的个数
		//根据ID只能获取到一个，这些数组中存放的元素都是DOM对象
		var v_jquery = $("#name")
		//alert(v_jquery.val())
		
		var v_dom = v_jquery[0]; //将jQuery对象转换为DOM对象
		alert(v_dom.value)
	})
	</script>
  </head>
  
  <body>
   <input type="text" value="张三" id="name">
  </body>

</html>
