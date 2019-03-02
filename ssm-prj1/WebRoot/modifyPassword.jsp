<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifyPassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.5.1/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.5.1/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.5.1/demo/demo.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.1/jquery.easyui.min.js"></script>


  </head>
  
  <body>
  <script type="text/javascript">
  function validate(){
  			var firstpassword = document.modify.firstpassword.value;
  			var password = document.modify.password.value;
  			if(firstpassword == ""){
  			window.alert("密码不能为空");
  			document.modify.firstpassword.focus();
  			return;
  			}
  			if(firstpassword != password){
  			window.alert("两次输入的密码不一样，请重新输入");
  			document.modify.firstpassword.focus();
  			return;
  			}
  			document.modify.submit();
  }
  </script>
	<h2>密码修改页面</h2>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="修改密码" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    <form name="modify" action="updatePassword.do" method="post">
	    
	   请输入新密码:<input type="text" name="firstpassword"><br><br>
	   
	           请确认新密码:<input type="text" name="password"><br><br>
	           <input  type="button" onclick="validate()" value="提交">
	     </form>
	    </div>
	</div>
	
</body>
</html>