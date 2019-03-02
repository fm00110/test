<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ncu.bean.Inform" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'inform.jsp' starting page</title>
    
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

<!-- 

<div style="margin:20px 0;"></div>
	<input class="easyui-textbox" data-options="multiline:true" value="This TextBox will allow the user to enter multiple lines of text." style="width:300px;height:100px">
</body>
 -->

  </head>
  
<body>
	<h2>通知页面</h2>
	<div  style="color: blue;"><p>你可以在这里查看对您有用的通知</p></div>
	<div style="margin:20px 0;"></div>
	<%
	ArrayList<Inform> informs = (ArrayList<Inform>)session.getAttribute("informs");
	for(Inform inform : informs){	
	 %>
	 <div style=" text-align:center; width:500px;height:300px ">
	 <%=inform.getTitle() %><br><br>
	 发布者:<%=inform.getTcname() %><br><br>
	 <%=inform.getContent() %>
	 </div>
	<% } %>
	<br>
	<a href="studentmain.jsp">返回主页面</a>
</body>
</html>
