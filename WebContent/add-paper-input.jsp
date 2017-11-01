<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="css/operation1.css">
    <title>add</title>
  </head>
  <body>
<header>
<span>论文管理器</span>
<a href="#" id="left">退出</a>
<a href="#" id="right">Username</a>
</header>
<div class="container">
  <div class="content1" style="background-image:url(img/11.png);">
      
  </div>
<div id="addpaper">
    <h3>发表一篇论文</h3>
    <s:form action="regpaper" method="post" enctype="multipart/form-data">
      <s:textfield key="paperBean.author" />
      <s:textfield key="paperBean.title" />
      <s:textfield key="paperBean.keyword" />
      <s:textfield key="paperBean.date" />
      <s:textfield key="paperBean.publication" />
      <s:textfield key="paperBean.category" />
      选择文件: <input type="file" name="file"><br>
      <s:submit/>
    </s:form>
</div>
</div>
	<p><a href="<s:url action='index' />" >Return to home page</a>.</p>
	<hr />
	<s:text name="contact" />
<footer>
<br>
<span>Created by Group YST</span>
<br/>
<br/>
</footer>
  </body>
</html>