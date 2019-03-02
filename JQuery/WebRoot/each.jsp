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
	$('#btn').click(function (){
	$(".name").each(function (){
	if(($(this).val()).trim() == ""){
	alert("空")
	}
	else{
	alert($(this).val())
	alert("非空")
	}
	})
	var txt1="<input type='text'  class='name' value='张三'><br>";               // 以 HTML 创建新元素
	var txt2=$("<p></p>").text("Text.");   // 以 jQuery 创建新元素
	
	$(".div2").append(txt1,txt2)   //在div2后追加
	$(".div2").before("<input type='text'  class='name' value='王五'><br>")   //在div2前追加
	
	
	})
	})


	</script>
  </head>
  
  <body>
  <div class="div1">
  <input type="button" value="按钮" id="btn" class="btn"><br>
    <input type="text"  class="name" ><br>
    <input type="text"  class="name" value="李四" ><br>
    </div>
    <div class="div2">
    <input type="text"  class="name" value="李四" ><br>
    </div>
    
  </body>
  
</html>
