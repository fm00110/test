<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ncu.bean.Student" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'findMyStudent.jsp' starting page</title>
    
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
	<h2>学生信息栏</h2>
	<p>${teacher.tcname },您好，在这里你可以查看学生的个人信息</p>
	<div style="margin:20px 0;"></div>
	<table class="easyui-datagrid" title="学生基本信息表" style="width:700px;height:250px"
			data-options="rownumbers:true,singleSelect:true,iconCls:'icon-ok',url:'datagrid_data1.json',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'itemid',width:80">学号</th>
				<th data-options="field:'productid',width:100">姓名</th>
				<th data-options="field:'listprice',width:80,align:'right',formatter:formatPrice">性别</th>
				<th data-options="field:'unitcost',width:120,align:'right'">电话号码</th>
				
			</tr>			
		</thead>
		<%
		ArrayList<Student> myStudents = (ArrayList<Student>)session.getAttribute("myStudents");
		for(Student student : myStudents){		
		 %>
		 <tr>
		 <td><%=student.getStuid() %></td>
		 <td><%=student.getSname() %></td>
		 <td><%=student.getSex() %></td>
		 <td><%=student.getPhone() %></td>
		 </tr>
		 <% } %>
	</table>
	<script>
		function formatPrice(val,row){
			if (val < 30){
				return '<span style="color:red;">('+val+')</span>';
			} else {
				return val;
			}
		}
	</script>
</body>
</html>