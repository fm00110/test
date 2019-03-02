<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="Test.css">

  </head>
  <script type="text/javascript">
  function fun(){
  window.location.href = "register.jsp";
  }
  
  </script>
  <body>

    <div class="a"></div>
    
    <div class="b">
    
       <div class="c">
       <ul>
       <li>欢迎来到学生成绩管理系统</li>
       <li>学生可以查看自己的成绩以及选课等操作</li>
       <li>教师可以查看并更改学生成绩等操作</li>
       <li>管理员拥有最大权限的操作功能</li>
       </ul>
       </div>         
       <div class="d">
       ${passwordMSG }
       <p>登录页面</p><br>
       <form name="loginform" action="login.do" method="post">
       账号:<input type="text" name="username" value="${username }"><br><br>
       密码:<input type="password" name="password" value="${password }"> ${loginerrorMSG }<br><br>
       登录角色:<input type="radio" name="users" value="admin">管理员
       <input type="radio" name="users" value="teacher">教师
       <input type="radio" name="users" value="student">学生   ${userserrorMSG }<br><br>
       <input type="button" value="登录" onclick="validate()">
       <input type="button" value="注册" onclick="fun()">
       
       
       </form>
 
       </div>
    
    </div>
    
    <div class="a"></div>
    <script type="text/javascript">
  function validate(){
  			var username = document.loginform.username.value;
  			var password = document.loginform.password.value;
  			if(username == ""){
  			window.alert("账号不能为空");
  			document.loginform.username.focus();
  			return;
  			}
  			if(password == ""){
  			window.alert("密码不能为空");
  			document.loginform.password.focus();
  			return;
  			}
  			document.loginform.submit();
  }
  </script>
  </body>
</html>
