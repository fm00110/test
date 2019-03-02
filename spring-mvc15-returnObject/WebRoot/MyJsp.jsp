<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
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
	<!-- <script type="text/javascript" src="js/jquery-3.3.1.js"></script> -->

  </head>
  <script type="text/javascript">
/* 
{"total":3,"rows":[{"itemid":"value11","productid":"value12","listprice":"value13","unitcost":"value14","attr1":"value15","status":"value16"},
{"itemid":"value11","productid":"value12","listprice":"value13","unitcost":"value14","attr1":"value15","status":"value16"},
{"itemid":"value11","productid":"value12","listprice":"value13","unitcost":"value14","attr1":"value15","status":"value16"}]} 
*/
//  data: "&applicant="+001,
$(function(){
$.messager.alert('提醒消息','请选择一个部门')
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

$("#btn").click(function (){
$.ajax({
type: "GET",
url: "datagrid.do",
data: "&applicant="+Math.random(),
datatype: "json",
success: function(data){
alert(data.length)
var data1 = [{
"itemid": '',"productid": '',"listprice": '',"unitcost": '',"attr1": '',"status": ''
}]
//var data1 = [{}];
alert(data1.length);
for(var i = 0;i<data.length;i++){
data1.push({
"itemid": data[i].itemid,
"productid" : data[i].productid,
"listprice": data[i].listprice,
"unitcost": data[i].unitcost,
"attr1": data[i].attr1,
"status": data[i].status
})
}
/* $(data).each(function(index){
data1.push({
"itemid": data[index].itemid,
"productid" : data[index].productid,
"listprice": data[index].listprice,
"unitcost": data[index].unitcost,
"attr1": data[index].attr1,
"status": data[index].status
})
}) */
data1.splice(0, 1)     //删除第一个空的元素
alert(data1.length)
//data1 = JSON.parse(data1)
$('#dg').datagrid('loadData',data1);
//$("tr:even").css("background-color","#B2E0FF");     //隔行换色
}
})
})
})
</script>
  <body>

	<input type="button" value="加载" id="btn">
	<div style="margin:20px 0;"></div>
	<!--  url:'datagrid_data1.json',  -->
	<table class="easyui-datagrid" title="Basic DataGrid" style="width:700px;height:400px"  id="dg"
			data-options="singleSelect:true,collapsible:true, rownumbers:true,pagination:true,pageSize:10,method:'get'">
		<thead>
			<tr>
				<th data-options="field:'itemid',width:80">Item ID</th>
				<th data-options="field:'productid',width:100">Product</th>
				<th data-options="field:'listprice',width:80,align:'right'">List Price</th>
				<th data-options="field:'unitcost',width:80,align:'right'">Unit Cost</th>
				<th data-options="field:'attr1',width:250">Attribute</th>
				<th data-options="field:'status',width:60,align:'center'">Status</th>
			</tr>
		</thead>
	</table>

</body>
</html>
