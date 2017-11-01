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
    <title>Result</title>
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
    <h3>发表一篇论文</h3>
	<s:property value="paperBean" /><br/>
	<s:url action="fileDownload" var="downloadLink">
		<s:param name="paperID" value="%{paperBean.paperID}"></s:param>
	</s:url>
	<p><a href="${downloadLink}">下载</a></p>
	<p><a href="<s:url action='index' />" >回到首页</a>.</p>
	<hr />
	<s:text name="contact" />
	</div>
  </body>
</html>