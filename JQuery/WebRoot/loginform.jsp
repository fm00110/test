<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loginform.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  function refresh(){
  loginform.imgValidate.src = "validatecode.jsp?id="+Math.random();
  var code = "<%=session.getAttribute("randStr")%>";
  alert(code)
  }
  </script>
  <body>
   欢迎登录本系统<br>
   <form action="Login" name="loginform" method="post">
   账号:<input type="text" name="name"><br>
   密码:<input type="password" name="password"><br>
   验证码:<input type="text" name="code" size="10"><img src="validatecode.jsp" border="0" name="imgValidate">
   <input type="button" value="看不清?点击刷新" onclick="refresh()"><br>
   <input type="submit"  value="提交">
   </form>
  </body>
</html>
