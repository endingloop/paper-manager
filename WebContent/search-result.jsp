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
 <a href="index.jsp" id="index">论文管理器</a>
 <a href="#" id="right">登录</a>
 <a href="#" id="left">注册</a>
 </header>
  <div class="content1" style="background-image:url(img/11.png);">
  <div>

  <br>
  </div>
    <div  id="SearchInput" style="margin-left:32%;" >
<s:form name="form2" action="chooseSearch" >
    <div>
    <select name="selectchoice"  style="width:6.7em;margin-left: -11%;margin-bottom: -22%;">
        <option value="1">论文主题</option>
        <option value="2">论文题目</option>
        <option value="3">作者姓名</option>
        <option value="4">发表时间</option>
        <option value="5">刊物名称</option>
    </select>
    </div>

    <s:textfield key="keyword" />   

    <div>
    <s:submit class="btn btn-default" value="搜索" style="margin-right: -27%;margin-top: -36%;"/>
    </div>

  </s:form>
  </div>
  </div>
  <div class="content2">

   <div class="content2_center" >
   	<s:iterator value="result">
   <div class="searchResult">
   <div class="part1">
   <a href="#" class="title"><s:property value="title" /></a>
   <a href="#" class="download">下载</a>
   </div>
     <br>
   <div class="part2">
   <a href="action/searchAuthor.action?keyword=author"><s:property value="author" /></a>
   <a href="#"><s:property value="publication"/></a>
   <time><s:property value="date" /></time>
   </div>
   <div class="part3">
   <span>摘要：如何利用有限的耕地生产尽量多的农产品,是现阶段我国农业面临的一个重要问题.对此,人们发展出了智能化和数字化的农业模式,具体表现为各种植物生长柜和监控决策系统.农作物的长势是上述系统进行决策的依据和基础,长势监控的准确性便成为评价这</span>
   </div>
   <div class="part4">
   <span>关键词：<s:property value="keyword" /></span>
   </div>
   </div> 
   <hr> 
   	</s:iterator>
   
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