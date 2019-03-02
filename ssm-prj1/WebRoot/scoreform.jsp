<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ncu.bean.Score" %>
<%@ page import="com.ncu.bean.Student" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'scoreform.jsp' starting page</title>
    
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
    <table align="center" border="1" cellspacing="0">
    	<caption>学生个人成绩查看</caption>
    	<tr border="2" bgcolor="yellow">
    	<td>课程</td>
    	<td>姓名</td>
    	<td>教师</td>
    	<td>班级</td>
    	<td>成绩</td>
    	</tr>
    	<%
    	ArrayList<Score> scores = (ArrayList<Score>)session.getAttribute("scores");
    	Student student = (Student)session.getAttribute("student");
    	for(Score score : scores){
    	
    	 %>
        <tr border="2" bgcolor="pink">
     	<td><%=score.getCname() %></td>
    	<td><%=student.getSname() %></td>
     	<td><%=score.getTcname() %></td>
     	<td><%=score.getGrname() %></td>
     	<td><%=score.getScore() %></td>
    	</tr>
     	<% } %>
    </table>
    <br><br>
    <br>
    <a href="studentmain.jsp" style="text-decoration: none;">返回上一层</a>
   </body>
</html>
