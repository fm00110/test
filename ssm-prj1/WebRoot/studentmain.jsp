<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentmain.jsp' starting page</title>
    
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
	<h2>欢迎来到学生管理系统</h2>
	<p>${student.sname },这里是学生主页面，你可以选择以下操作</p>
	<div style="margin:20px 0 10px 0;">
		<a href="studentmain.jsp" class="easyui-linkbutton" onclick="javascript:$('#p').panel('open')">Open</a>
		<a href="studentmain.jsp" class="easyui-linkbutton" onclick="javascript:$('#p').panel('close')">Close</a>
	</div>
	<div id="p" class="easyui-panel" title="学生管理系统" style="width:700px;height:200px;padding:10px;">
		<p style="font-size:14px">您可以在这里选择以下操作</p>
		<ul>
			<li><a href="selectStudentInfo.do" style="text-decoration: none;">查看个人信息</a></li>
			<li><a href="selectCourse.do" style="text-decoration: none;">选择课程</a></li>
			<li><a href="evaluation.do" style="text-decoration: none;">网上评教</a></li>
			<li><a href="modifyPassword.do" style="text-decoration: none;">修改密码</a></li>
			<li><a href="seeInformation.do" style="text-decoration: none;">查看最新公告和通知</a></li>
		
		</ul>
	</div>
</body>
</html>