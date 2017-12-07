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
 <a href="<s:url action="Login_input" />" id="right">登录</a>
 <a href="<s:url action="Registration_input" />" id="left">注册</a>
 </header>
  <hr>
  <div class="content2">

   <div id="content2_center" >
         	<s:iterator value="result" status="index">
      <h3><s:property value="title" /></h3>
      <span>第一作者：</span>
      <a href="searchAuthor.action?keyword=<s:property value="author"/>"><s:property value="author" /></a>
       <br>
      <span>第二作者：</span>
      <s:iterator value="secondauthor" status="index">
           <a href="searchAuthor.action?keyword=<s:property/>"><s:property/></a>
         </s:iterator>
       <div class="publication">
      <a href="searchJournal.action?keyword=<s:property value="publication"/>"><s:property value="publication"/></a>
      </div>
        
      <div class="description text-left">
          <span style="color:grey;">摘要：</span><span>近两年,MOOC(大规模开放在线课程)给全球大学的传统教育带来了前所未有的冲击,计算机与软件工程专业教育又是首当其冲。如何应对MOOC挑战和借助MOOC促进我国高等教育改革、特别是计算机与软件工程专业教育改革的问题就摆在我们面前。本文从多个角度探讨了我国大学通过MOOC促进教育改革的途径,并着重从MOOC建设、利用、改革、联盟四个方面阐述了我国计算机与软件工程MOOC课程建设与教学方法改革的发展途径。文中还就教学方法改革、学习方法改革、学院教学改革等层次探讨了如何利用MOOC促进计算机与软件工程专业教与学方法的改革问题。最后,给出了关于 计算机与软件工程MOOC课程建设的思考与建议。 
                  </span>
      </div>
      <div class="date">
       <span style="color:grey;">发表时间：</span><a href="searchDate.action?keyword=<s:property value="date"/>"><s:property value="date"/></a>
      </div>
      
       <div class="keyword">
       <span>关键词：</span>
       <s:iterator value="keywords2" status="index">
           <a href="searchKeyword.action?keyword=<s:property/>"><s:property/></a>
         </s:iterator>
      </div>
      <div class="download">
        <a href="#"><button class="btn btn-default" type="submit">下载论文</button></a>
        </div>
      
    
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