<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script  type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
    <script  type="text/javascript" src="js/ChooseSort.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="css/operation1.css">
    <title>Paper Manager System</title> 
  </head>
  <body>
  <div class="container">
   <header>
 <a href="index.jsp" id="index">论文管理器</a>
 <a href="<s:url action="Logout" />" id="right">注销</a>
 <a href="<s:url action='addend' />" id="left">用户</a>
 </header>
 <hr>
 <div class="content2">
   <div id="content2_top" >
  <ul class="nav nav-tabs nav-justified">
  <li role="presentation"><a href="user-papers.jsp">我的论文</a></li>
  <li role="presentation" class="active"><a href="add-paper-input.jsp">上传论文</a></li>
  <li role="presentation"><a href="workload.jsp">查看工作量</a></li>
  </ul>
  </div>
  <br>
     <s:form name="form1" action="regpaper" method="post" enctype="multipart/form-data" theme="simple">
 
     <div id="parta">
       <span>选择文件:</span> <input type="file" name="file">
    </div>
    <div id="partb">
      <div id="title">
          <span>论文标题:</span><s:textfield name="paperBean.title" />
      </div>
      <div id="firstauthor"> 
           <span >作者姓名:</span><s:textfield name="paperBean.author"  />
       </div>
      <div id="secondauthor">
      <span>第二作者:</span>
      <s:textfield name="author1"  class="input"/>
      <s:textfield name="author2"  class="input"/>
      <s:textfield name="author3"  class="input"/>
      <s:textfield name="author4"  class="input"/>
      <s:textfield name="author5"  class="input" />
      </div>
      <div id="keyword">
      <span>关键字:</span>
      <s:textfield name="keyword1" class="input"/>
      <s:textfield name="keyword2" class="input"/>
      <s:textfield name="keyword3" class="input"/>
      </div>
      <div id="publicaiton">
      <span>出版社:</span>
      <s:textfield name="paperBean.publication" class="input"/>
      </div>
    </div>
    <br>
     <div id="partc">
     
        <SELECT NAME="first" onChange="getSecond()" class="select">  
         <OPTION value="0">第一级目录 </OPTION> 
           <OPTION VALUE="1">基础学科 </OPTION>  
            <OPTION VALUE="2">工程科技</OPTION>  
            <OPTION VALUE="3">农业科技</OPTION>  
            <OPTION VALUE="4">医学卫生科技</OPTION>  
            <OPTION VALUE="5">哲学与人文科学</OPTION>
 			 <OPTION VALUE="6">社会科学</OPTION>  
            <OPTION VALUE="7">信息科学</OPTION>  
            <OPTION VALUE="8">经济管理科学</OPTION>  
        </SELECT>  
  

        <SELECT NAME="second" onChange="getThird()" class="select" >  
            <OPTION value="0">第二级目录</OPTION>  
        </SELECT> 
  
        <select name="third" class="select">
        <option value="0">第三级目录</option>
        </select> 
        </div>
        <br>
        <div id="partd">
        <span>请选择发表日期：</span>
        <input name="dates" style="width: 120px;" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd '})" />
        </div>
         <div id="partd" >
         <select name="level" class="select">
            <OPTION value="10">请选择论文等级 </OPTION> 
            <OPTION VALUE="60">SCI</OPTION>  
            <OPTION VALUE="45">EI，CSSCI,SSCI,一级刊物</OPTION>  
            <OPTION VALUE="30">核心期刊(国际会议)</OPTION>  
            <OPTION VALUE="15">公开发表</OPTION>
            <OPTION VALUE="10">普通论文</OPTION>  
        </select>
        </div>
        <br>
        <br>
        <br>
        <div id="parte">
         <s:submit class="btn btn-default"/>
	    </div>
	<hr />
	 
	    </s:form>
	
	</div>
	<footer>
<br>
<span>Created by Group YST</span>
<br/>
<br/>
</footer>
	</div>


  </body>
</html>