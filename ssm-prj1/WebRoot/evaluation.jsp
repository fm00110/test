<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.ncu.bean.Evaluation" %>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'evaluation.jsp' starting page</title>
    
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
	<h2>这里是学生评教页面</h2>
	<div  style="color: blue;"><p>您选择的课程需要在这里评教，希望您能认真对待</p></div>
	<div style="margin:20px 0;"></div>
	<form name="evaluationform" action="updateEvaluation.do" method="post">
	<table class="easyui-datagrid" title="学生评教" style="width:700px;height:250px">
			<thead>
			<tr>
				<th data-options="field:'itemid',width:80">课程名称</th>
				<th data-options="field:'productid',width:100">教师姓名</th>
				<th data-options="field:'listprice',width:80,align:'right'">评教学生</th>
				<th data-options="field:'unitcost',width:80,align:'right'">评分</th>
				<th data-options="field:'attr1',width:250">意见或建议</th>
			</tr>
		</thead>
		<%
			ArrayList<Evaluation> evaluations = (ArrayList<Evaluation>)session.getAttribute("evaluations");
				for(int i=0;i<evaluations.size();i++){
				Evaluation evaluation = evaluations.get(i);
		%>
		 <tr>
		 <td><%=evaluation.getCname() %></td>
		 <td><%=evaluation.getTcname() %></td>
		 <td><%=evaluation.getStuname() %></td>
		 <td>
		 <input type="text" name="score">
		 </td>
		 <td>
		 <%
		 if(evaluation.getEvaluation() == null){		 
		  %>
		  <input type="text" name="evaluation" size="50">
		  <input type="hidden" name="cname" value="<%=evaluation.getCname() %>">
		  <input type="hidden" name="tcname" value="<%=evaluation.getTcname() %>">
		  <input type="hidden" name="stuname" value="<%=evaluation.getStuname() %>">
		  <% } else{
		  out.print(evaluation.getEvaluation());
		  }
		   %>
		 </td>
		 </tr>
		<% } %>
	</table>
	<input type="button" value="提交" onclick="validate()">
	<script type="text/javascript">
	function validate(){
		var score = document.evaluationform.score.value;
		if(isNaN(score)){
		window.alert("您输入的评分包含了非数字字符，请重新输入");
		document.evaluationform.score.focus();
		return;
		}
  		if(score < 0 || score >100){
  		window.alert("您输入的评分应在0~100之间");
		document.evaluationform.score.focus();
		return;
  		}
  		document.studentScoreForm.submit();
		}
	</script>
 </form>
</body>
</html>
