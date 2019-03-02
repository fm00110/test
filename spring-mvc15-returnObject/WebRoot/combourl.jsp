<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'combourl.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.5.1/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.5.1/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.5.1/demo/demo.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.1/jquery.easyui.min.js"></script>

  </head>
<script type="text/javascript">
 $(function(){
 //"&applicant="+Math.random()

 //alert(v_state)
 $("#btn").click(function(){
  var v_state = $('#com').combobox('getValue')   //得到的是value的值
  var vstate = $('#com').combobox('getText')    //得到的是文本内容
 //alert(v_state)
 $.ajax({
		type: "POST",
		url: "combox.do",
		data: "name="+v_state,
		datatype: "json",
		success: function(data){
		$("#d1").html(data.inv)
		}
 })
 alert(vstate)
 })
 
 })
 </script>
  <body>
    <h2>Basic ComboBox</h2>
	<p>Type in ComboBox to try auto complete.</p>
	<div style="margin:20px 0"></div>
	
	
	
	<select class="easyui-combobox" id="com" name="state" >
	
	<option value="默认">---请选择---</option>
	<c:forEach items="${l1}" var="st" >
        <option value="${st.name}"> ${st.name} </option>
    </c:forEach>
	
	</select>
	<input type="button" value="查询" id="btn">
 <div id="d1"></div>
  </body>
   
  
  
</html>
