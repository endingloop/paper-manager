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
<script  type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Paper-Manager</title>
</head>
<body>
<div class="container">

   <header>
			<a href="<s:url action="index" />" id="index">论文管理器</a> 
			<a href="<s:url action="Logout" />" id="right">注销</a> 
			<a href="<s:url action='MainMenu' />" id="left">
				<s:property	value="user.username" /></a> 
 </header>
 <hr>
		<div  style="align: center; margin-left: 5%; margin-right: 5%;">
		<div id="content2_top">
			<ul class="nav nav-tabs nav-justified">
				<li role="presentation" ><a href="<s:url action="MainMenu"/>">我的论文</a></li>
				<li role="presentation"><a href="<s:url action="Paper_input"/>">上传论文</a></li>
				<li role="presentation" class="active"><a href="workload.jsp">查看工作量</a></li>
			</ul>
		</div>
  <br>
<div  style="text-align:center;">
<form action="workload.action" method="post">
<h4>工作量日期区间</h4>
<input name="startdate" style="width: 120px;" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd '})" />&nbsp;——&nbsp; <input name="enddate" style="width: 120px;" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd '})" />
<br>
<s:if test="getUser().getAuthority()==0">
		<input type ="hidden" name="author" label="输入作者" value="<s:property	value="user.realName" />">		
</s:if>
<s:if test="getUser().getAuthority()==3">
		<input name="author">		
</s:if>

<button type="submit">提交</button>
</form>
</div>
<br>
<br>
<br>
<div style="align: center; margin-left: 5%; margin-right: 5%;">
<h4><s:property  value="author"/><s:property  value="startdate"/><s:property  value="enddate"/>的工作量分数如下：</h4>
<table class="table table-hover">
<tr><th>姓名</th><th>成绩</th><th>作为第一作者发布文章数目</th><th>以第二作者参与发布文章数目</th><tr>
<s:iterator  value="scoreresult">
<tr>
<td><s:property  value="Name"/></td>
<td><s:property value="score"/></td>
<td><s:property value="fauthornum"/></td>
<td><s:property value="sauthornum"/></td>
</tr>

</s:iterator>
</table>
  <a href="fileDownloads.action?tip=0&&authorname=<s:property  value="user.username"/>"  style="float:right;"><button class="btn btn-default">下载工作量总表</button></a>
  <br>
  <br>
<h4><s:property  value="author"/>总分（<s:property value="scoretemp"/>分）   <s:property  value="startdate"/><s:property  value="enddate"/>的具体得分细化如下表：</h4>
<table class="table table-hover">
<tr><th>论文题目</th><th>第一作者</th><th>第二作者</th><th>发布时间</th><th>论文类型</th><th>论文等级</th><th>分值</th><th>所获分值</th></tr>
<s:iterator  value="list1">
<tr>

<td><s:property value="title"/></td>
<td><s:property value="author"/></td>
<td><s:property value="secondAuthor"/></td>
<td><s:property value="date"/></td>
<td><s:property  value="sortname"/></td>
<td><s:property value="levelname"/></td>
<td><s:property value="level"/></td>
<td><s:property value="gotscore"/></td>
</tr>

</s:iterator>
</table>

<a href="fileDownloads.action?tip=1" style="float:right; margin-bottom:5%;"><button class="btn btn-default">下载个人工作量明细表</button></a>
</div>
</div>
	<footer>
		<br /> <span>Created by Group YST</span> <br /> <br />
	</footer>
	</div>


</body>
</html>