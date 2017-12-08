<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@ page import="java.util.*,model.Paper.*,action.*" %> 
 
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="css/operation1.css">
<title>Paper Manager System</title>

<script language="JavaScript">
function myrefresh()
{
       window.location.reload();
}
setTimeout('myrefresh()',1000); //指定1秒刷新一次
</script>
</head>
<body>
	<div class="container">
		<header>
			<s:if test="user == null">
			<a href="<s:url action="index" />" id="index">论文管理器</a> 
			<a href="<s:url action="Login_input" />" id="right">登录</a>
			<a href="<s:url action="Registration_input" />" id="left">注册</a>
			</s:if>
			<s:else>
			<a href="<s:url action="index" />" id="index">论文管理器</a> 
			<a href="<s:url action="Logout" />" id="right">注销</a> 
			<a href="<s:url action='MainMenu' />" id="left">
				<s:property	value="user.username" /></a> 
			</s:else>
		</header>
		<div class="content1" style="background-image: url(images/11.jpg);">

			<div id="SearchInput" style="margin-left: 34%;">
				<s:form name="form2" action="chooseSearch">
					<div>
						<select name="selectchoice"
							style="width: 7em; margin-left: 0px; margin-bottom: -4.5em;">
							<option value="1">论文主题</option>
							<option value="2">论文题目</option>
							<option value="3">作者姓名</option>
							<option value="4">发表时间</option>
							<option value="5">刊物名称</option>
							<option value="6">论文分类</option>						
						</select>
					</div>
					<s:textfield style="width:12em; margin-left: 8em;margin-top:0.6em;"  key="keyword" />
					<div>
						<s:submit class="btn btn-info" value="搜索"
							style="margin-left:22em;margin-top: -5.1em;" />
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
					 <s:iterator value="#session.list" status="index">
						<tr>
						   
							<td><s:property value="#index.index+1" /></td>
							<td><a
								href="searchPaperID.action?keyword=<s:property value="paperID"/>"><s:property
										value="title" /></a></td>
							<td><a
								href="searchAuthor.action?keyword=<s:property value="author"/>"><s:property
										value="author" /></a></td>
							<td><s:iterator value="secondAuthorList" status="index">
									<a href="searchAuthor.action?keyword=<s:property/>"><s:property /></a>
								</s:iterator></td>
							<td><a
								href="searchJournal.action?keyword=<s:property value="publication"/>"><s:property
										value="publication" /> </a></td>
							<td><a
								href="searchDate.action?keyword=<s:property value="date"/>"><s:property
										value="date" /></a></td>
							<td><s:iterator value="keywordList" status="index">
									<a href="searchKeyword.action?keyword=<s:property/>"><s:property /></a>
								</s:iterator></td>
							<td><a	href="<s:url action="fileDownload"><s:param name="paperID" value="paperID"/></s:url>">下载[<s:property value="clickTime"/>]</a></td>
						 
						</tr>
				</s:iterator>
				</table>
				<a href="fileDownloads.action?tip=2" class="btn btn-info">导出为excel表格</a>
                 <div style="align:center;"> <%=request.getAttribute("s") %>  </div>

			</div>
		</div>
		<!--  for  content2 -->


		<footer>
			<br /> <span>Created by Group YST</span> <br /> <br />
		</footer>
	</div>
</body>
</html>