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
			<a href="index.jsp" id="index">论文管理器</a> <a href="#" id="right">登录</a>
			<a href="#" id="left">注册</a>
		</header>
		<div class="content1" style="background-image: url(img/11.png);">
			<div>

				<br>
			</div>
			<div id="SearchInput" style="margin-left: 32%;">
				<s:form name="form2" action="chooseSearch">
					<div>
						<select name="selectchoice"
							style="width: 6.7em; margin-left: -11%; margin-bottom: -24%;">
							<option value="1">论文主题</option>
							<option value="2">论文题目</option>
							<option value="3">作者姓名</option>
							<option value="4">发表时间</option>
							<option value="5">刊物名称</option>
						</select>
					</div>
					<s:textfield key="keyword" />
					<div>
						<s:submit class="btn btn-default" value="搜索"
							style="margin-right: -27%;margin-top: -36%;" />
					</div>
				</s:form>
			</div>
		</div>
		<div class="content2">

			<div id="content2_center">
				<div class="shownum">
					<span>共搜索出<s:property value="papernum" />篇论文
					</span>
				</div>
				<table class="table table-hover">
					<tr>
						<td>编号</td>
						<td>标题</td>
						<td>第一作者</td>
						<td>第二作者</td>
						<td>出版社</td>
						<td>发表日期</td>
						<td>关键词</td>
						<td>下载</td>
					</tr>
					<s:iterator value="result" status="index">
						<tr>
							<td><s:property value="#index.index+1" /></td>
							<td><a
								href="searchPaperID.action?keyword=<s:property value="paperID"/>"><s:property
										value="title" /></a></td>
							<td><a
								href="searchAuthor.action?keyword=<s:property value="author"/>"><s:property
										value="author" /></a></td>
							<td><s:iterator value="secondauthor" status="index">
									<a href="searchAuthor.action?keyword=<s:property/>"><s:property /></a>
								</s:iterator></td>
							<td><a
								href="searchJournal.action?keyword=<s:property value="publication"/>"><s:property
										value="publication" /> </a></td>
							<td><a
								href="searchDate.action?keyword=<s:property value="date"/>"><s:property
										value="date" /></a></td>
							<td><s:iterator value="keywords2" status="index">
									<a href="searchKeyword.action?keyword=<s:property/>"><s:property /></a>
								</s:iterator></td>
							<td><a
								href="<s:url action="fileDownload"><s:param name="paperID" value="paperID"/></s:url>">下载</a></td>
						</tr>
						
					</s:iterator>

				</table>
					
				<a href="js/QueryRseult.xls" download="查询结果">导出为Excel表格</a>


			</div>
		</div>
		<!--  for  content2 -->


		<footer>
			<br /> <span>Created by Group YST</span> <br /> <br />
		</footer>
	</div>
</body>
</html>