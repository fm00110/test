<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'teachermain.jsp' starting page</title>
    
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
	<h2>教师主页面</h2>
	<p>您可以点击面板标题来显示详细资料</p>
	${updateScoreSucc }
	<div style="margin:20px 0 10px 0;"></div>
	<div class="easyui-accordion" style="width:500px;height:300px;">
		<div title="关于" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
			<h3 style="color:#0099FF;">简介</h3>
			<p>这里是学生管理系统的教师主页面，在这里教师可以在主菜单中选择自己所需要的操作</p>
		</div>
		<div title="帮助" data-options="iconCls:'icon-help'" style="padding:10px;">
			<p>手风琴样式的主界面使您一个或多个面板。
                                                  每个面板都有内置的支撑来展开和折叠。
		                    单击面板标题可展开或折叠该面板主体。
		                    你也可以点击主菜单上的文字来实现你的操作</p> 		
		</div>
		<div title="主菜单" data-options="iconCls:'icon-search'" style="padding:10px;">
			<ul>
			<li><a href="findMyStudentInfo.do" style="text-decoration: none;">查看学生信息</a></li>
			<li><a href="insertMyStudent.jsp" style="text-decoration: none;">增加学生</a></li>
			<li><a href="selectStudentScore.do" style="text-decoration: none;">修改分数</a></li>
			<li><a href="checkInform.do" style="text-decoration: none;">发布通知或公告</a></li>
			
			</ul>
		</div>
	</div>
</body>
</html>