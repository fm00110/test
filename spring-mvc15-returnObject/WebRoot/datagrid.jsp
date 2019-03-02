<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic DataGrid - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.5.1/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.5.1/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.5.1/demo/demo.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.5.1/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
</head>
<script type="text/javascript">
/* 
{"total":3,"rows":[{"itemid":"value11","productid":"value12","listprice":"value13","unitcost":"value14","attr1":"value15","status":"value16"},
{"itemid":"value11","productid":"value12","listprice":"value13","unitcost":"value14","attr1":"value15","status":"value16"},
{"itemid":"value11","productid":"value12","listprice":"value13","unitcost":"value14","attr1":"value15","status":"value16"}]} 
*/
$(function(){
$("#btn").click(function (){
$.ajax({
type: "GET",
url: "datagrid.do",
data: "&applicant="+001,
datatype: "json",
success: function(data){
alert(data.length)
var data1 = [{
"itemid": '',"productid": '',"listprice": '',"unitcost": '',"attr1": '',"status": ''
}]
/* for(var i = 0;i<data.length;i++){
data1.push({
"itemid": data[i].itemid,
"productid" : data[i].productid,
"listprice": data[i].listprice,
"unitcost": data[i].unitcost,
"attr1": data[i].attr1,
"status": data[i].status
})
} */
$(data).each(function(index){
data1.push({
"itemid": data[index].itemid,
"productid" : data[index].productid,
"listprice": data[index].listprice,
"unitcost": data[index].unitcost,
"attr1": data[index].attr1,
"status": data[index].status
})
})
alert(data1.length)
data1.splice(0, 1)
$("#dg1").datagrid("loadData",data1);
}
})
})
})
</script>
<body>
	<h2>Basic DataGrid</h2>
	<p>The DataGrid is created from markup, no JavaScript code needed.</p>
	<input type="button" value="加载" id="btn">
	<div style="margin:20px 0;"></div>
	<!--  url:'datagrid_data1.json',  -->
	<table class="easyui-datagrid" title="Basic DataGrid" style="width:700px;height:250px"  id="dg1"
			data-options="singleSelect:true,collapsible:true,method:'get'">
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