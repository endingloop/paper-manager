<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<meta charset="UTF-8">
	    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script  type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
    <script  type="text/javascript" src="js/ChooseSort.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="css/error.css">
	<title>Error</title>
</head>
<body>
<div class="container">
    <div id="Error1" >
    <img src="img/error.jpg"/>
    <h1>Sorry，运行出错啦</h1>
    </div>
    
	<h4>Exception Name:<s:property value="exception"/></h4>
	<h4>Exception Details: <s:property value="exceptionStack"/></h4>
    <div id="Error2">
	<p><a href="index.jsp">回到主页</a></p>
	</div>
	</div>
</body>


</html>