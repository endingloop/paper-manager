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
  <li role="presentation"> <a href="<s:url action='addend' />">我的论文</a></li>
  <li role="presentation" ><a href="add-paper-input.jsp">上传论文</a></li>
  <li role="presentation"class="active"><a href="workload.jsp">查看工作量</a></li>
  </ul>
  </div>
  <br>
<form action="workload.action" method="post">
<div id="part1">
      <span>请选择日期区间：</span>
      <input name="startdate" value="<s:property  value="startdate"/>"  style="width: 120px;" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd '})" />-<input name="enddate" value="<s:property  value="enddate"/>"  style="width: 120px;" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd '})" />
</div>
<div id="part2">
      <span>请输入作者姓名:</span><input name="author" value="<s:property  value="author"/>">
</div>
<button type="submit" class="btn btn-info">提交</button> 
</form>
 <table class="table">
<tr><td>姓名</td><td>成绩</td><td>起始日期</td><td>终止日期</td></tr>
<s:iterator  value="scoreresult">
<tr>
<td><s:property  value="Name"/></td>
<td><s:property value="score"/></td>
<td><s:property  value="startdate"/></td>
<td><s:property value="enddate"/></td>
</tr>

</s:iterator>
</table>
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