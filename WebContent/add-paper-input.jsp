<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>add</title>
    <s:head />
  </head>
  <body>
    <h3>发表一篇论文</h3>
    <s:form action="regpaper" method="post" enctype="multipart/form-data">
      <s:textfield key="paperBean.author" />
      <s:textfield key="paperBean.title" />
      <s:textfield key="paperBean.keyword" />
      <s:textfield key="paperBean.date" />
      <s:textfield key="paperBean.publication" />
      <s:textfield key="paperBean.category" />
      文件: <input type="file" name="file"><br>
      <s:submit/>
    </s:form>
	
	<p><a href="<s:url action='index' />" >Return to home page</a>.</p>
	<hr />
	<s:text name="contact" />
  </body>
</html>