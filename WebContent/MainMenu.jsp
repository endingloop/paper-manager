<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/ChooseSort.js"></script>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="css/operation1.css">
<title>个人主页</title>
</head>

<body>
	<div class="container">
		<header>
			<a href="<s:url action="index" />" id="index">论文管理器</a> 
			<a href="<s:url action="Logout" />" id="right">注销</a> 
			<a href="<s:url action='MainMenu' />" id="left">
				<s:property	value="user.username" /></a> 
		</header>
		<hr />
		<div  style="align: center; margin-left: 5%; margin-right: 5%;">
		<div id="content2_top">
			<ul class="nav nav-tabs nav-justified">
				<li role="presentation" class="active"><a href="<s:url action="MainMenu"/>">我的论文</a></li>
				<li role="presentation"><a href="<s:url action="Paper_input"/>">上传论文</a></li>
				<li role="presentation"><a href="workload.jsp">查看工作量</a></li>
			</ul>
		</div>
		<br />
		<div align="center"></div>
			<table class="table table-hover">


				<tr>
					<th align="center" width="30%">编号</th>
					<th align="center" width="25%">题目</th>
					<th align="center" width="10%">作者</th>
					<th align="center" width="10%">时间</th>
					<th align="center" width="15%">操作</th>
				</tr>

				<s:iterator value="user.papers">
					<tr>
						<td align="left"><s:property value="paperID" /></td>
						<td align="left"><s:property value="title" /></td>
						<td align="center"><s:property value="author" /></td>
						<td align="center"><s:property value="date" /></td>
						<td align="center"><a
							href="<s:url action="Paper_delete"><s:param name="paperID" value="paperID"/></s:url>">
								删除 </a> &nbsp; <a
							href="<s:url action="Paper_edit"><s:param name="paperID" value="paperID"/></s:url>">编辑
						</a></td>
					</tr>
				</s:iterator>

			</table>
		</div>
		<footer> <br />
		<span>Created by Group YST</span> <br />
		<br />
		</footer>
	</div>
</body>
</html>
