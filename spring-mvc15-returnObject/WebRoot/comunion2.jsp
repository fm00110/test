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
	
	
<style type="text/css">
.input-medium{
color: green;
right: 0px;
top: 0px;
font-size: 2em;
}

</style>
  
  </head>
  
  <script type="text/javascript">
    function getmodule() {
    var name=$("#s1").val(); //获得第一个列表元素的主键
	var obj=document.getElementById("s2");
	
	$.ajax({
	    type : 'GET',
	    data: "name="+name,
	    url : "comunion2.do", //调用后台控制类的方法
	    datatype: "json",
	    success: function(data){
	    $("#s2").val(""); //将之前存在的数据清除，维持级联联动
	    $("#s2").text("");
	    alert(data.length);
	    //alert(data.length)
   		for(var i=0;i<data.length;i++){
			var option = document.createElement("OPTION");
			option.text = data[i].name;//这就是取出<cityname>中的值
			option.value = data[i].name;//这就是取出<cityvalue>中的值
			obj.options.add(option);
			
		}

	    }
	    
        });
    }
</script> 
  
  
  
  <body>
    <select id="s1"	onchange="getmodule()" name="s1" class="input-medium">
    <option value="默认">--请选择--</option>
        <c:forEach items="${l2}" var="st" >
	    <option value="${st.name}"> ${st.name} </option>
	</c:forEach>
</select>
<div style="height: 50px"></div>
<select id="s2" name="s2" class="input-medium">
   	
    
    <option value="默认">--请选择--</option>
      								
</select>

  </body>
</html>
