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
  <hr>
  <div class="content2">

   <div id="content2_center" >
         	<s:iterator value="result" status="index">
      <h3><s:property value="title" /></h3>
      <span>第一作者：</span>
      <a href="searchAuthor.action?keyword=<s:property value="author"/>"><s:property value="author" /></a>
       <br>
      <span>第二作者：</span>
      <s:iterator value="secondAuthorList" status="index">
           <a href="searchAuthor.action?keyword=<s:property/>"><s:property/></a>
         </s:iterator>
       <div class="publication">
      <a href="chooseSearch.action?selectchoice=5&keyword=<s:property value="publication"/>"><s:property value="publication"/></a>
      </div>
        
      <div class="description text-left">
          <span style="color:grey;">摘要：</span><span> <s:property value="description"/>
                  </span>
      </div>
      <div class="date">
       <span style="color:grey;">发表时间：</span><a href="chooseSearch.action?selectchoice=4&keyword=<s:property value="date"/>/>"><s:property value="date"/></a>
      </div>
      
       <div class="keyword">
       <span>关键词：</span>
       <s:iterator value="keywordList" status="index">
           <a href="chooseSearch.action?selectchoice=1&keyword=<s:property/>"><s:property/></a>
         </s:iterator>
      </div>
      <div class="download">
        <a href="<s:url action="fileDownload"><s:param name="paperID" value="paperID"/></s:url>">
        	<button class="btn btn-default" type="submit">下载论文</button></a>
        </div>
      
    
   	</s:iterator>
	<s:if test="result.size()==0">
		<h3>您搜索的篇目不存在，可能是正在审核中。</h3>
	</s:if>
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