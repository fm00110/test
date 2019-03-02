<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ncu.bean.StudentScore" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifyStudentScore.jsp' starting page</title>
    
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
	<h2>Custom DataGrid Pager</h2>
	<p>You can append some buttons to the standard datagrid pager bar.</p>
	${updateScoreSucc }
	<div style="margin:20px 0;"></div>
	<form action="updateMyStudentScore.do" name="studentScoreForm" method="post">
	<table id="dg" title="Custom DataGrid Pager" style="width:700px;height:250px"
			data-options="rownumbers:true,singleSelect:true,pagination:true,url:'datagrid_data1.json',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'itemid',width:80">学号</th>
				<th data-options="field:'productid',width:100">课程</th>
				<th data-options="field:'listprice',width:80,align:'right'">姓名</th>
				<th data-options="field:'unitcost',width:80,align:'right'">性别</th>
				<th data-options="field:'attr1',width:240">班级</th>
				<th data-options="field:'status',width:60,align:'center'">成绩</th>
			</tr>
		</thead>
		<%
		ArrayList<StudentScore> studentScores = (ArrayList<StudentScore>)session.getAttribute("studentScores");
		for(StudentScore studentScore : studentScores){		
		 %>
		<tr>
		<td><%=studentScore.getStuid() %></td>
		<td><%=studentScore.getCname() %></td>
		<td><input style="border: 0px;outline:none;" type="text" name="stuname" value="<%=studentScore.getStuname() %>"></td>
		<td><%=studentScore.getSex() %></td>
		<td><%=studentScore.getGrname() %></td>
		<td><input type="text" name="score" value="<%=studentScore.getScore()  %>"></td>
		</tr>
		<% } %>
     </table>
     <input type="button" value="提交" onclick="validate()">
	</form>
	<script type="text/javascript">
		$(function(){
			var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
			pager.pagination({
				buttons:[{
					iconCls:'icon-search',
					handler:function(){
						alert('search');
					}
				},{
					iconCls:'icon-add',
					handler:function(){
						alert('add');
					}
				},{
					iconCls:'icon-edit',
					handler:function(){
						alert('edit');
					}
				}]
			});			
		})
		function validate(){
		var scores = document.getElementsByName('score');
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
	<a href="teachermain.jsp">返回主页面</a>
</body>
</html>
