<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <script src="js/jquery-3.2.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script  type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
    <script  type="text/javascript" src="js/ChooseSort.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="css/operation1.css">
    <title>Paper Manager System</title>
    <s:head />
  </head>

  <body>
  <div class="container">
   <header>
 <a href="index.jsp" id="index">论文管理器</a>
 <a href="#" id="right">注销</a>
 <a href="#" id="left">用户</a>
 </header>
 <hr>
    <div class="content_center" style="text-align:center;">
    <h3>成功发表一篇论文！</h3>
	<s:url action="fileDownload" var="downloadLink">
		<s:param name="paperID" value="%{paperBean.paperID}"></s:param>
	</s:url>
	<h4><a href="${downloadLink}">下载</a></h4>
	<h5><a href="<s:url action='addend' />" >回到首页</a></h5>
	<hr />
	<footer>
<br/>
<span>Created by Group YST</span>
<br/>
<br/>
</footer>
</div>
	</div>
  </body>
</html>