<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'insertMyStudent.jsp' starting page</title>
    
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
  	<script type="text/javascript">
  function validate(){
  			var name = document.studentform.stuname.value;
  			var stuid = document.studentform.stuid.value;
  			var username = document.studentform.username.value;
  			var sex = document.studentform.sex.value;
  			var phone = document.studentform.phone.value;
  			var grname = document.studentform.grname.value;
  			var score = document.studentform.score.value;
  			if(name == ""){
  			window.alert("姓名不能为空");
  			document.studentform.name.focus();
  			return;
  			}
  			if(stuid == ""){
  			window.alert("学号不能为空");
  			document.studentform.stuid.focus();
  			return;
  			}
  			if(username == ""){
  			window.alert("用户名不能为空");
  			document.studentform.username.focus();
  			return;
  			}
  			if(sex == ""){
  			window.alert("性别不能为空");
  			document.studentform.sex.focus();
  			return;
  			}
  			if(phone == ""){
  			window.alert("电话号码不能为空");
  			document.studentform.phone.focus();
  			return;
  			}
  			if(grname == ""){
  			window.alert("班级名不能为空");
  			document.studentform.grname.focus();
  			return;
  			}
  			if(score == ""){
  			window.alert("成绩不能为空");
  			document.studentform.score.focus();
  			return;
  			}
  			if(isNaN(stuid)){
  			window.alert("您输入的学号不是数字,请重新输入");
  			document.studentform.stuid.focus();
  			return;
  			}
  			
  			if(isNaN(phone)){
  			window.alert("您输入的电话包含了非数字字符,请重新输入");
  			document.studentform.phone.focus();
  			return;
  			}
  			if(isNaN(score)){
  			window.alert("您输入的成绩包含了非数字字符,请重新输入");
  			document.studentform.phone.focus();
  			return;
  			}
  			
  			document.studentform.submit();
  }
  </script>
  <body>
	<h2>添加学生页面</h2>
	<div style="background-color: #00ff40"><p>本页面是为了添加学生而设计的，您需要输入学生的个人信息</p></div>
	<div style="margin:20px 0 10px 0;">
		<a href="#" class="easyui-linkbutton" onclick="javascript:$('#p').panel('open')">Open</a>
		<a href="#" class="easyui-linkbutton" onclick="javascript:$('#p').panel('close')">Close</a>
	</div>
	<div id="p" class="easyui-panel" title="添加学生界面" style="width:700px;height:600px;padding:10px;">
	<div style="width:400px;height:400px;">
	<form name="studentform" method="post" action="insertMyStudentScore.do">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>学号:</td>
	    			<td><input class="easyui-textbox" type="text" name="stuid" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>姓名:</td>
	    			<td><input class="easyui-textbox" type="text" name="stuname" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>用户名:</td>
	    			<td><input class="easyui-textbox" type="text" name="username" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>性别:</td>
	    			<td><input type="radio" name="sex" value="男">男
	    			<input type="radio" name="sex" value="女">女
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>电话号码:</td>
	    			<td><input class="easyui-textbox" type="text" name="phone" data-options="required:true" ></input></td>
	    			${phoneEror }
	    		</tr>
	    		<tr>
	    			<td>班级:</td>
	    			<td><input class="easyui-textbox" type="text" name="grname" data-options="required:true"></input></td>
	    			${grnameEror }
	    		</tr>
	    		
	    		<tr>
	    			<td>课程成绩:</td>
	    			<td><input class="easyui-textbox" type="text" name="score" data-options="required:true"></input></td>
	    			${scoreEror }
	    		</tr>
	    		
	    	</table>
	    	<input type="button" value="提交" onclick="validate()">
	    </form>
	    </div>
	</div>
	<a href="teachermain.jsp">返回教师主页面</a>
 
</body>
</html>
