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
<title>Paper Manager System</title>
<script language="javascript" type="text/javascript">
 

    var count=0 ;
    var count1=0;
    function additem(id)
    {
        var row,cell,str;
        row = document.getElementById(id).insertRow();
     
        	if(row != null )
            {
        cell = row.insertCell();
        cell.innerHTML="<input  class=\"dongtai\" id=\"St"+count+"\" type=\"text\" name=\"St"+count+"\"><input type=\"button\" value=\"删除\" onclick=\'deleteitem(this);\'>";
        count ++;
            }      
    }
    
   
    function deleteitem(obj)
    {
        var curRow = obj.parentNode.parentNode;
        tb.deleteRow(curRow.rowIndex);
    }
    function additem1(id)
    {
        var row,cell,str;
        row = document.getElementById(id).insertRow();
     
        	if(row != null )
            {
        cell = row.insertCell();
        cell.innerHTML="<input  id=\"SS"+count1+"\" type=\"text\" name=\"SS"+count1+"\"><input type=\"button\" value=\"删除\" onclick=\'deleteitem1(this);\'>";
        count1 ++;
            }      
    }
    function deleteitem1(obj)
    {
        var curRow = obj.parentNode.parentNode;
        tb1.deleteRow(curRow.rowIndex);
    }
    function getsub()
    {
    	var re="";
    	for (var  i = 0 ;i<count;i++)
    	{
    		if(document.getElementById("St"+i)){
    			re += document.getElementsByName("St"+i)[0].value+",";
    		}
    	}
    	re+="@";
    	for(var i=0;i<count1;i++){
    		if(document.getElementById("SS"+i)){
    			re += document.getElementsByName("SS"+i)[0].value+",";
    		}
    	}
    	document.getElementById("Hidden1").value=re;
    	}
    
    </script>

</head>
<body>
	<div class="container">
		<header>
			<a href="index.jsp" id="index">论文管理器</a> <a
				href="<s:url action="Logout" />" id="right">注销</a> <a href="#"
				id="left">用户</a>
		</header>
		<hr>
		<div class="content2"  >
			<div id="content2_top">
				<ul class="nav nav-tabs nav-justified">
					<li role="presentation"><a href="<s:url action="Login"/>">我的论文</a></li>
					<li role="presentation"><a href="<s:url action="Paper_input"/>">上传论文</a></li>
					<li role="presentation"><a href="workload.jsp">查看工作量</a></li>
				</ul>
	        <div id="content2_middle" style="margin-left:33%; font-size:1.2em;" >
			<s:form name="form1" action="Paper_save" method="post" enctype="multipart/form-data" theme="simple"  >
				<s:hidden name="task" />
				<s:hidden name="paperID" />
				<div id="part1">
			     <s:if test="task == 'Create'"> 
				   <h3 >请填写相应的文献信息：</h3>
				    <span>请选择文件：</span><input type="file" name="file" >
				 </s:if>
				 <s:if test="task == 'Edit'"> 
				   <h3 >请修改相应的论文信息：</h3>
				   <span>已选择文件：</span><s:property value="paper.filename" />
				   <br />
				   <span>选择新文件：</span><input type="file" name="file">
				   </s:if>
				   <s:if test="task == 'Delete'"> 
				   <h3 >请确认文献信息：</h3>
				 </s:if>
				</div>
				<div id="part2">
				    <span>论文标题：<s:textfield name="paper.title"/></span>
					<span>第一作者：<s:textfield name="paper.author"/></span>
					<s:if test="task == 'Create'"> 	 
      				<table id="tb"></table>
					<input name="button" type="button" onclick='additem("tb")' value="添加第二作者"/>
					<input id="Hidden1" name="Hidden1" type="hidden"  />
  					</s:if>
  				<s:if test="task == 'Edit'"> 
				   <span>第二作者：<s:textfield name="paper.secondAuthor"/></span>
				   </s:if>
				   
				   <s:if test="task == 'Create'"> 	 
      				<table id="tb1"></table>
					<input name="button" type="button" onclick='additem1("tb1")' value="添加关键字"/>
					<input id="Hidden2" name="Hidden2" type="hidden" />
  					</s:if>
					<s:if test="task == 'Edit'"> 
				  <span>关键字词：<s:textfield name="paper.keyword"/></span>
				   </s:if>
					
					<span>内容简介：<s:textarea name="paper.description"/></span>
					<span>出版机构：<s:textfield name="paper.publication"/></span>
				</div>
				
			    <div id="part3" >
					<span>请选择论文分类：</span> <br> <SELECT NAME="first"
						onChange="getSecond()" class="select">
						<OPTION value="0">第一级目录</OPTION>
						<OPTION VALUE="1">基础学科</OPTION>
						<OPTION VALUE="2">工程科技</OPTION>
						<OPTION VALUE="3">农业科技</OPTION>
						<OPTION VALUE="4">医学卫生科技</OPTION>
						<OPTION VALUE="5">哲学与人文科学</OPTION>
						<OPTION VALUE="6">社会科学</OPTION>
						<OPTION VALUE="7">信息科学</OPTION>
						<OPTION VALUE="8">经济管理科学</OPTION>
					</SELECT> <SELECT NAME="second" onChange="getThird()" class="select">
						<OPTION value="0">第二级目录</OPTION>
					</SELECT> <select name="third" class="select">
						<option value="0">第三级目录</option>
					</select>
				</div>
				<div class="clearfix">
				</div>
				<div id="part4" >
					<span>请选择发表日期：</span> <input name="paper.date"
						value="<s:property  value="paper.date"/>" style="width: 120px;"
						onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd '})" />
				</div>
				<div id="part5" >
					<select name="paper.level" class="select"  style="width:26%;">
						<OPTION value="10">请选择论文等级</OPTION>
						<OPTION VALUE="60">SCI</OPTION>
						<OPTION VALUE="45">EI，CSSCI,SSCI,一级刊物</OPTION>
						<OPTION VALUE="30">核心期刊(国际会议)</OPTION>
						<OPTION VALUE="15">公开发表</OPTION>
						<OPTION VALUE="10">普通论文</OPTION>
					</select>
		             <a id="example" class="btn btn-info" rel="popover" data-html="true"
		             data-content="
		                                                                                                ⭐SCI（科学引文索引）是美国科学信息研究所编辑出版的引文索引类刊物
		                                                                                               ⭐EI(工程索引)是美国工程信息公司出版的供查阅工程技术领域文献的综合性情报检索刊物
		                                                                                              ⭐CSSCI(中文社会科学引文索引)由南京大学中开发研制的供查阅中文社会科学领域文献的检索刊物
		                                                                                              ⭐SSCI(社会科学引文索引)是美国科学信息研究所编辑出版社会科学论文的引文索引类刊物
		                                                                                             ⭐一级期刊：指国内在中国科协所注册的全国一级学会所主办的会刊还有国内重点大学的学报
		                                                                                            ⭐ 核心期刊：一些单位、团体或组织，从全国合法期刊中，经过一定程序的筛选，进入其目录的期刊
		                                                                                             ⭐公开发表：在出版物或者其他平台上发布过的论文
		                                                                                              ⭐普通论文：用于学习的未经过发表的论文                  
		                                                                                                                                                                                  
		                           ">点击了解论文等级</a>
                   <script src="bootstrap/js/bootstrap.js"></script>
                   <script>
                      $(function (){ 
	                      $("#example").popover();
                      });
	               </script>
				</div>
								<div class="clearfix">
				</div>
				<div id="part6">
			       <s:if test="task == 'Create'"> 
                       <span>请保证您上传的论文已通过原作者的允许！<br></span>
				   </s:if>	
				
				<input type="submit" onclick="getsub()"  value="提交"/>
				</div>
			</s:form>
			</div>
		</div>
		</div>
		<footer>
			<br> <span>Created by Group YST</span> <br /> <br />
		</footer>
	</div>

</body>
</html>