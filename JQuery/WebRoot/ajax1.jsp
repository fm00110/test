<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajax1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <script type="text/javascript">
  function checkUsername(username){
  //1、创建AJAX核心对象XMLHttpRequest（浏览器内置的，可以直接使用）
  if(window.XMLHttpRequest){
 			 var xhr = new XMLHttpRequest();
  				} 
  				else 
  				{
  							var xhr = new ActiveXObject("Microsoft.XMLHTTP");
 				}
  //2、注册回调函数,程序执行到这里是回调函数并不会立即执行，只是将回调函数注册给xhr对象
      //等xhr对象的readState发生改变时，后面的回调函数才会执行
      //XMLHttpRequest对象再请求和响应的过程当中，该对象的readState状态从0~4；
  			xhr.onreadystatechange = function(){  //当xhr对象的readState的值发生改变时，回调一次，一共会调用4次
  				if(xhr.readyState == 4){
  					if(xhr.status == 200){  //200表示服务器正常响应结束
  					//再浏览器端使用xhr接受服务器响应回来的文本
  					//var s = xhr.responseText;
  					//alert(s);
  					var nameTisMsg = document.getElementById("nameTisMsg");
  					nameTisMsg.innerHTML = xhr.responseText;
  					}
  					else{
  					alert(xhr.status);
  					
  					}
  				}
  			}
  //3、开启浏览器和服务器之间的通道  有三个形参  method  url async 这里只开启通道，不发送请求
  			xhr.open("post", "checkusername.do?username="+username, true)
  //4、发生AJAX请求
 			 xhr.send();
  }
  
  </script>
    用户名:<input type="text" name="username" onblur="checkUsername(this.value);" >
    <span id="nameTisMsg" style="font: 14"></span><br>
    密码:<input type="password" name="password">
  </body>
</html>
