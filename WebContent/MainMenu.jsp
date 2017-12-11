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
				<li role="presentation"><a href="<s:url action="workload"/>">查看工作量</a></li>
			</ul>
		</div>
		<br />
		<div align="center"></div>
			<table class="table table-hover">


				<tr>
					<th >编号</th>
					<th>题目</th>
					<th>作者</th>
					<th>时间</th>
					<th>操作</th>
					<th>状态</th>
					
				</tr>

				<s:iterator value="user.papers">
					<tr>
						<td><s:property value="paperID" /></td>
						<td><a
								href="showDetail.action?keyword=<s:property value="paperID"/>&selectchoice=0"><s:property value="title" /></a></td>
						<td><a href="searchAuthor.action?keyword=<s:property value="author"/>"><s:property value="author" /></a></td>
						<td><a
								href="chooseSearch.action?selectchoice=4&keyword=<s:property value="date"/>"><s:property value="date" /></a></td>
						<td><a
							href="<s:url action="Paper_delete"><s:param name="paperID" value="paperID"/></s:url>">
								删除 </a> &nbsp; <a
							href="<s:url action="Paper_edit"><s:param name="paperID" value="paperID"/></s:url>">编辑
						</a></td>
						<td><s:if test="Status==0">
		                  <span>待审核</span>
                        </s:if>
						<s:if test="Status==1">
		                  <span>已发布</span>
                        </s:if>
                        <s:if test="Status==2">
		                  <span>不合格</span>
                        </s:if>
                        

						</td>
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
