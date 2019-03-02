<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'getslections.jsp' starting page</title>
    
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
  function pagerFilter(data){
			//alert(data.length)
			//alert(data)
			if (typeof data.length == 'number' &&  typeof data.splice == 'function'){	// is array         
				data = {
					total: data.length,
					rows: data
				}
			}
			var dg = $(this);
			var opts = dg.datagrid('options');
			var pager = dg.datagrid('getPager');
			pager.pagination({
				onSelectPage:function(pageNum, pageSize){
					opts.pageNumber = pageNum;
					opts.pageSize = pageSize;
					pager.pagination('refresh',{
						pageNumber:pageNum,
						pageSize:pageSize
					});
					dg.datagrid('loadData',data);
				}
			});
			if (!data.originalRows){
				data.originalRows = (data.rows);
			}
			var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
			var end = start + parseInt(opts.pageSize);
			data.rows = (data.originalRows.slice(start, end));
			return data;
		}
		
		$(function(){
			
			$('#dg').datagrid({loadFilter:pagerFilter});
			
			
		});
  </script>
  <script type="text/javascript">
  
  function resetValue(){
		$("#itemid").val("");
		$("#productid").val("");
		$("#listprice").val("");
		$("#unitcost").val("");
		$("#attr1").val("");
		$("#status").val("");
	}
  
  function editrow(){
  var selectedRows = $("#dg").datagrid("getSelections");
  if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要修改的数据");
			return ;
		}
  var row = selectedRows[0];
  $("#dlg").dialog("open").dialog("setTitle","修改信息");
  $("#itemid").val(row.itemid);
  $("#productid").val(row.productid);
  $("#listprice").val(row.listprice);
  $("#unitcost").val(row.unitcost);
  $("#attr1").val(row.attr1);
  $("#status").val(row.status);
  //url="${pageContext.request.contextPath}/stockManageSystem/provider!save?id="+row.id;
  }
  
  function saveProvider(){
		$("#fm").form("submit",{
			url:"getslect.do",
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
				if(result.errorMsg){
					$.messager.alert("系统提示",reuslt.errorMsg);
					return error;
				}else{
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
					$.messager.alert("系统提示","关闭成功");
				}
			}
		});
	}
  
  
  </script>
  <body>
    <h2>CheckBox Selection on DataGrid</h2>
	<p>Click the checkbox on header to select or unselect all selections.</p>
	<div style="margin:20px 0;"></div>
	
	<table id="dg" class="easyui-datagrid" title="CheckBox Selection on DataGrid" style="width:700px;height:450px"
			data-options="rownumbers:true,singleSelect:true,url:'datagrid_data.json',method:'get',pagination:true,
				pageSize:10,toolbar:'#tb'">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'itemid',width:80">Item ID</th>
				<th data-options="field:'productid',width:100">Product</th>
				<th data-options="field:'listprice',width:80,align:'right'">List Price</th>
				<th data-options="field:'unitcost',width:80,align:'right'">Unit Cost</th>
				<th data-options="field:'attr1',width:220">Attribute</th>
				<th data-options="field:'status',width:60,align:'center'">Status</th>
			</tr>
		</thead>
	</table>
	<div style="margin:10px 0;">
		<span>Selection Mode: </span>
		<select onchange="$('#dg').datagrid({singleSelect:(this.value==0)})">
			<option value="0">Single Row</option>
			<option value="1">Multiple Rows</option>
		</select><br/>
		SelectOnCheck: <input type="checkbox" checked onchange="$('#dg').datagrid({selectOnCheck:$(this).is(':checked')})"><br/>
		CheckOnSelect: <input type="checkbox" checked onchange="$('#dg').datagrid({checkOnSelect:$(this).is(':checked')})">
	</div>
 <div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
			<a href="javascript:editrow()" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
		</div>
		<div>
			Date From: <input class="easyui-datebox" style="width:80px">
			To: <input class="easyui-datebox" style="width:80px">
			Language: 
			<select class="easyui-combobox" panelHeight="auto" style="width:100px">
				<option value="java">Java</option>
				<option value="c">C</option>
				<option value="basic">Basic</option>
				<option value="perl">Perl</option>
				<option value="python">Python</option>
			</select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" style="width:580px;height:350px;padding: 10px 20px"
	closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px;">
				<tr>
					<td>供应商编号：</td>
					<td><input type="text" name="itemid" id="itemid" class="easyui-validatebox" required="true"/></td>
					
					<td>供应商名：</td>
					<td><input type="text" name="productid" id="productid" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>联系人：</td>
					<td><input type="text" name="listprice" id="listprice" class="easyui-validatebox" required="true"/></td>
					
					<td>联系电话：</td>
					<td><input  name="unitcost" id="unitcost" class="easyui-validatebox" required="true" /></td>
				</tr>
				<tr>
					<td>属性：</td>
					<td><input  name="attr1" id="attr1" class="easyui-validatebox" required="true" /></td>
					<td>状态：</td>
					<td><input  name="status" id="status" class="easyui-validatebox" required="true" /></td>
				
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveProvider()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeProviderDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
  </body>
</html>
