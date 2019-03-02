<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testdialog.jsp' starting page</title>
    
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
  $(function(){
  $("#btn").click(function(){
  $("#dlg").dialog("open").dialog("setTitle","添加供应商信息");
  })
  })
  </script>
  <script type="text/javascript">
  function closeProviderDialog(){
  $("#dlg").dialog("close")
  }
  </script>
  <body>
    <input type="button" value="按钮" id="btn"><br>
    <div id="dlg" class="easyui-dialog" style="width:580px;height:350px;padding: 10px 20px"
	closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px;">
				<tr>
					<td>供应商编号：</td>
					<td><input type="text" name="provider.proId" id="proId" class="easyui-validatebox" required="true"/></td>
					
					<td>供应商名：</td>
					<td><input type="text" name="provider.proName" id="proName" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>联系人：</td>
					<td><input type="text" name="provider.linkman" id="linkman" class="easyui-validatebox" required="true"/></td>
					
					<td>联系电话：</td>
					<td><input  name="provider.proPhone" id="proPhone" class="easyui-validatebox" required="true" /></td>
				</tr>
				<tr>
					<td valign="top">供应商备注：</td>
					<td colspan="3"><textarea rows="7" cols="45" name="provider.proDesc" id="proDesc"></textarea></td>
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
