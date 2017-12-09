<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="css/operation1.css">
<title>Paper Manager System</title>
</head>
<body>
<div class="container">
 <header>
			<a href="<s:url action="index" />" id="index">论文管理器</a> 
			<a href="<s:url action="Logout" />" id="right">注销</a> 
			<a href="<s:url action='Admin_welcome' />" id="left">
				<s:property	value="user.username" />(管理员)</a> 
 </header>
  <hr>
   <div class="content2" >
  
  <div id="content2_top" >
  <ul class="nav nav-tabs nav-justified">
  <li role="presentation" class="active"><a href="<s:url action="Admin_welcome" />">欢迎页面</a></li>
  <li role="presentation"><a href="<s:url action="Admin_audit" />">待审核文章</a></li>
  <li role="presentation"><a href="Admin_user">用户管理</a></li>
  </ul>
  </div>
<br>
<h2>欢迎您，管理员&nbsp; <s:property value="user.username" /></h2>
   </div>   <!--  for  content2 -->

<footer>
<br/>
<span>Created by Group YST</span>
<br/>
<br/>
</footer>
</div>
</body>
</html>

