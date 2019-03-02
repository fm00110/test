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
    
    <title>My JSP 'comunion.jsp' starting page</title>
    
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
    function getmodule() {
    var name=$("#search_systemKey").val(); //获得第一个列表元素的主键
	var obj=document.getElementById("search_moduleKey");//回去id为。。的html元素
	$.ajax({
	    type : 'GET',
	    data: "name="+name,
	    url : "comunion.do", //调用后台控制类的方法
	    dataType : 'json',	
	    success : function(data) {
	    //alert(data.l1.length())
	      obj.options.length=0;  
		$.each(data,function(i,item) {
		    obj.options.add(new Option(item.name));
	         });
	         /* alert(data.length);
	         for(var i = 0;i<data.length;i++){
	         obj.append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
	         } */
	    }
        });
    }
</script> 
  
  
  
  <body>
    <select id="search_systemKey"	onchange="getmodule()" name="search_systemKey" class="input-medium">
    <option value="默认">--请选择--</option>
        <c:forEach items="${l2}" var="st" >
	    <option value="${st.name}"> ${st.name} </option>
	</c:forEach>
</select>
<div style="height: 50px"></div>
<select id="search_moduleKey" name="search_moduleKey" class="input-medium">
    <option value="">--请选择--</option>										
</select>

  </body>
</html>
