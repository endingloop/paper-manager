<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/> 
<!-- Javascript -->
<script src="assets/js/jquery-1.8.2.min.js"></script>
<script src="assets/js/supersized.3.2.7.min.js"></script>
<script src="assets/js/supersized-init.js"></script>
<script src="assets/js/scripts.js"></script>
<!-- CSS -->
<link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
<link rel="stylesheet" href="assets/css/reset.css">
<link rel="stylesheet" href="assets/css/supersized.css">
<link rel="stylesheet" href="assets/css/style.css">
<title>Paper Manager System</title>
</head>

<body>
<div class="page-container">
<h1>Welcome to Login Paper Manager</h1>

<s:form action="Login" validate="true" theme="simple">
    <s:textfield key="username" placeholder="Username"/>

    <s:password key="password" showPassword="true" placeholder="Password"/>

    <s:submit key="button.logon" class="button1" value="登录"/>

    <s:reset key="button.reset" class="button1" value="重置"/>

    <s:submit action="Login_cancel" key="button.cancel"
                onclick="form.onsubmit=null" class="button1"  value="取消"/>
</s:form>
</div>
<div class="footer">
<span>Created by YST</span>
</div> 
</body>
</html>
