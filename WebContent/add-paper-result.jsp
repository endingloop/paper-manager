<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>结果报告</title>
    <s:head />
  </head>
  <body>
    <h3>发表一篇论文</h3>
	<s:property value="paperBean" /><br/>
	<s:url action="fileDownload" var="downloadLink">
		<s:param name="paperID" value="%{paperBean.paperID}"></s:param>
	</s:url>
	<p><a href="${downloadLink}">下载</a></p>
	<p><a href="<s:url action='index' />" >Return to home page</a>.</p>
	<hr />
	<s:text name="contact" />
  </body>
</html>