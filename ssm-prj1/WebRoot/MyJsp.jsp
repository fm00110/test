<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <script type="text/javascript">
  function validate(){
  	 var scores = document.getElementsByName('name');
		for(var i=0;i<scores.length;i++){
			if(isNaN(scores[i].value)){
			window.alert("您输入的成绩包含了非数字部分,请仔细确认");
	
  			return;
			}
			if(scores[i].value < 0 || scores[i].value>100){
			window.alert("您输入的成绩应该在0~100之间");

  			return;
			}
		}
  		
  		document.studentScoreForm.submit();
  	 
  }
  </script>
    <form action="" name="test" method="post">
    	name:<input type="text" name="name"><br>
    	name:<input type="text" name="name"><br>
    	name:<input type="text" name="name"><br>
    	name:<input type="text" name="name"><br>
    	name:<input type="text" name="name"><br>
    	name:<input type="text" name="name"><br>
    	name:<input type="text" name="name"><br>
    	pass:<input type="text" name="pass"><br>
    	<input type="button" value="提交" onclick="validate()">
    </form>
   </body>
</html>
