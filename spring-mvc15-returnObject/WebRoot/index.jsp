<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
 <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
  <script type="text/javascript">
$(function(){
$("#but").click(function(){
$.ajax({
url: "returnuse.do",
dataType:"json",
success:function(data){
alert(data.name+" " +data.password);
}

})
})



})

  </script>
  <script type="text/javascript">
  $(function(){
$("#but2").click(function(){   //这个按钮只能安一次
$.ajax({
url: "returnmap.do?id="+Math.random(),
dataType:"json",
success:function(data){
alert(data.u1.name+"  "+ data.u2.password)
//var jsonObj = JSON.parse(data);
var json = eval(data);
$.each(json, function (index, item) {
                 //循环获取数据  
                 var name = json[index].name;
                 var password = json[index].password;
                 //    + "<br>"  + "<input type='text' id='" + Id + "' /><br/>"      
                 $(".user").html($(".user").html() +"<tr"+"border: '2'"+">"+"<td>" +name+"</td>"+"<td>"+password+"</td>"+"</tr>" );
             });



}
})
})
})
  </script>
  
    <script type="text/javascript">
  $(function(){
$("#but3").click(function(){
$.ajax({
url: "returnlist.do",
dataType:"json",
success:function(data){
$(data).each(function(index){
alert(data[index].name+" "+data[index].password)
})
}

})
})



})
  </script>
  
  <body>
  <input type="button" value="提交ajax请求" id="but">
  <input type="button" value="提交ajax2请求" id="but2">
   <input type="button" value="提交ajax2请求" id="but3"><br>
   <table   class="user"    border="2"  cellspacing="0">
   <tr>
   <td>名字</td>
   <td>年龄</td>
   </tr>
  
   
   </table>
  </body>
</html>
