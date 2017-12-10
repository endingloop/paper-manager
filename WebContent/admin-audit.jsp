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
  <li role="presentation"><a href="<s:url action="Admin_welcome" />">欢迎页面</a></li>
  <li role="presentation" class="active"><a href="<s:url action="Admin_audit" />">待审核文章</a></li>
  <li role="presentation"><a href="Admin_user">用户管理</a></li>
  </ul>
  </div>
<br>
			<div id="content2_center">
				<table class="table table-hover">
					<tr>
						<th align="center" width="30%">编号</th>
						<th align="center" width="25%">题目</th>
						<th align="center" width="10%">作者</th>
						<th align="center" width="10%">时间</th>
						<th align="center" width="15%">操作</th>
					</tr>
					<s:iterator value="paperList">
						<tr>
							<td align="left"><s:property value="paperID" /></td>
							<td align="left"><a
								href="showDetail.action?keyword=<s:property value="paperID"/>&selectchoice=0"><s:property value="title" /></a></td>
							<td align="center">
								<a href="searchAuthor.action?keyword=<s:property value="author"/>"><s:property value="author" /></a></td>
							<td align="center"><s:property value="date" /></td>
							<td align="center"><a
								href="<s:url action="fileDownload"><s:param name="paperID" value="paperID"/></s:url>">查看</a>
								&nbsp; <a
								href="<s:url action="Admin_pass"><s:param name="paperID" value="paperID"/></s:url>">通过</a>
								&nbsp; <a
								href="<s:url action="Admin_refuse"><s:param name="paperID" value="paperID"/></s:url>">不通过</a>
							</td>
						</tr>
					</s:iterator>
				</table>
			</div>
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

