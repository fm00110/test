<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tables.jsp' starting page</title>
    
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
  <style type="text/css">
.input-medium{
color: green;
right: 0px;
top: 0px;
font-size: 20px;
}

</style>
  <script type="text/javascript">
  
  function getmodule(){
  //alert("进入方法");
  var tableName = $("#s1").val();
  
  $.ajax({
  type: 'GET',
  url: "tables.do",
  data: "tableName="+tableName,
  dataType: "json",
  success: function(data){
  //alert("成功查询出数据");
  $("#a1").text(tableName);
  $("#t1").val(data);
  }
  
  })
  }
  
  
  </script>
  
  
  <body>
    请选择: <select id="s1" onchange="getmodule()" name="s1" class="input-medium">
    <option value="">---请选择---</option>
    <option value="t_b_book">t_b_book</option>
    <option value="t_b_lend">t_b_lend</option>
    <option value="t_b_press">t_b_press</option>
    <option value="t_export">t_export</option>
    <option value="t_goods">t_goods</option>
    <option value="t_goodstype">t_goodstype</option>
    <option value="t_import">t_import</option>
    </select><br>
   <!-- 查询: <input type="button" id="b1" value="提交" onclick="getmodule()"> <br> -->
  <a id="a1"></a>   总记录数:  <input type="text" id="t1" class="input-medium" size="15">
   
  </body>
</html>
