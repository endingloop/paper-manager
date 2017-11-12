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
 <a href="<s:url action='addend' />" id="left">用户</a>
 </header>
  <hr>
  <div class="content2" >
  
  <div id="content2_top" >
  <ul class="nav nav-tabs nav-justified">
  <li role="presentation" class="active"><a href="user-papers.jsp">我的论文</a></li>
  <li role="presentation"><a href="add-paper-input.jsp">上传论文</a></li>
  <li role="presentation"><a href="workload.jsp">查看工作量</a></li>
  </ul>
  </div>
<br>
   <div id="content2_center" >

    <table class="table table-hover">

        <tr>
            <th>编号</th>
            <th>题目</th>
            <th>作者</th>
            <th>发表时间</th>
            <th>操作</th>
        </tr>

        <s:iterator value="user.papers">
            <tr>
                <td>
                    <s:property value="paperID"/>
                </td>
                <td >
                    <a href="searchPaperID.action?keyword=<s:property value="paperID"/>" ><s:property value="title" /></a>
                </td>
                <td >
                    <a href="searchAuthor.action?keyword=<s:property/>"><s:property/></a>
                </td>
                <td >
                    <a href="searchDate.action?keyword=<s:property value="date"/>"><s:property value="date"/></a>
                </td>
                <td >

                    <a href="<s:url action="Paper_delete"><s:param name="paperID" value="paperID"/></s:url>">删除 </a>
                    &nbsp;
                    <a href="<s:url action="update"><s:param name="paperID" value="paperID"/></s:url>">修改</a>
                     &nbsp;
                     <a href="<s:url action="fileDownload"><s:param name="paperID" value="paperID"/></s:url>">下载</a>
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

