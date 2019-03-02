<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doubledata.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<!-- 
ng-init  是单向数据绑定            view——>mode  从页面到内存
ng-model 是双向数据绑定  支持   view——>mode  mode——>view
{{}}     是单向数据绑定             mode——>view  从内存加载

 -->
  </head>
  <!-- <script src="https://cdn.staticfile.org/angular.js/1.4.6/angular.min.js"></script> -->
  <script type="text/javascript" src="js/angular.js"></script>
  <body>
    <div ng-app="myApp" ng-controller="myctrl">
    	<input type="text" ng-model="names"><br>
    	<span ng-bind="names"></span><br>
    	<input type="text" ng-model="names"><br>
    	<span ng-bind="names"></span><br>
    </div>
  </body>
  <script>
  var app = angular.module('myApp',[]);
  app.controller('myctrl',function($scope){
  $scope.names="fm";
  });
  
  </script>
</html>
