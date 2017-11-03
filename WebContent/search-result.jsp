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
<title>论文管理器</title>
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
      <div id="SearchMenu">
         <ul class="nav nav-tabs nav-justified "  >

            <li role="presentation" class="active"><a href="#">文献主题</a></li>
            <li role="presentation"><a href="#">论文名称</a></li>
            <li role="presentation"><a href="#">作者姓名</a></li>
            <li role="presentation"><a href="#">刊物名称</a></li>
            <li role="presentation"><a href="#">发表时间</a></li>
            <li role="presentation"><a href="#">文献类别</a></li>
        </ul>
      </div>
      <div class="input-group" id="SearchInput"> 
      <input type="text" class="form-control" id="Search1" aria-describedby="basic-addon1">
       <span class="input-group-addon " id="basic-addon1"><a href="#">Search</a></span>
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
   <a href="#"><s:property value="author" /></a>
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