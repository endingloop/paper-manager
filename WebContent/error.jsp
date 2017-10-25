<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>出错啦：程序发生异常</title>
</head>
<body>
	<h4>抱歉，程序运行出错了……</h4>

	<p>请反馈如下错误信息：</p>

	<h4>Exception Name: <s:property value="exception"/></h4>
	<h4>Exception Details: <s:property value="exceptionStack"/></h4>

	<p><a href="index.jsp">回到主页</a></p>
</body>

</html>