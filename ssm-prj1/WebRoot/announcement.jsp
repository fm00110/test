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
    
    <title>My JSP 'announcement.jsp' starting page</title>
    
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
  	var title = document.advice.title.value;
  	var content = document.advice.content.value;
  	if(title == ""){
  		window.alert("标题不能为空");
  		document.advice.title.focus();
  		return;
  		}
  	if(content == ""){
  		window.alert("内容不能为空");
  		document.advice.content.focus();
  		return;
  		}
  	document.advice.submit();
  	}
  </script>
  <div style="background-color: #80ff00">${litledegree } ${success }</div>
     <table align="center" border="1" cellspacing="0">
     	<caption>已发布的通知或公告</caption>
     	<tr border="2" bgcolor="yellow">
     	<td>标题</td>
     	<td>内容</td>
     	<td>发布者</td>    	
     	</tr>
     	<%
     	ArrayList<Inform> informs = (ArrayList<Inform>)session.getAttribute("informs");
     	for(Inform inform : informs){
     	
     	 %>
     	<tr border="2" bgcolor="pink">
     	<td><%=inform.getTitle() %></td>
     	<td><%=inform.getContent() %></td>
     	<td><%=inform.getTcname() %></td>
     	</tr>
     	<% } %>
     </table><br><br><br>
     <div id="p" class="easyui-panel" title="发布通知" style="width:700px;height:600px;padding:10px;">
	<div style="width:400px;height:400px;">
	<form name="advice" method="post" action="insertInform.do">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>标题:</td>
	    			<td><input class="easyui-textbox" type="text" name="title" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>内容:</td>
	    			<td><input class="easyui-textbox" name="content" data-options="multiline:true" style="height:60px"></input></td>
	    		</tr>	    		
	    	</table>
	    	<input type="button" value="提交" onclick="validate()">
	    </form>
	    </div>
	</div>
	<a href="teachermain.jsp">返回教师主页面</a>
  </body>
</html>
