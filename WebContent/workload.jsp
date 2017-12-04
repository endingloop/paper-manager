<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script  type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>workload-show</title>
</head>
<body>
<form action="workload.action" method="post">
<div id="partd">
        <span>统计工作量日期区间</span>
        <input name="startdate" style="width: 120px;" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd '})" />-<input name="enddate" style="width: 120px;" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd '})" />
</div>
 按照姓名查询工作量分数：<input name="author" value="">；
<button type="submit">提交</button>
</form>
<table border="2px">
<s:property  value="author"/><s:property  value="startdate"/>---<s:property  value="enddate"/>的工作量分数如下： 
<tr><td>姓名</td><td>成绩</td><td>作为第一作者发布文章数目</td><td>以第二作者参与发布文章数目</td></tr>
<s:iterator  value="scoreresult">
<tr>
<td><a href="workdetail.action?authorname=<s:property value="Name"/>&&startdate=<s:property  value="startdate"/>&&enddate=<s:property  value="enddate"/>&&scoretemp=<s:property value="score"/>&&author=<s:property value="getAuthor()"/>"><s:property  value="Name"/></a></td>
<td><s:property value="score"/></td>
<td><s:property value="fauthornum"/></td>
<td><s:property value="sauthornum"/></td>
</tr>
</s:iterator>
</table>
<br>
<a href="fileDownloads.action?tip=0&&authorname=null">下载工作量总表</a>
<br>
<table border="2px">
<s:property  value="authorname"/>（总分<s:property value="scoretemp"/>分） <s:property  value="startdate"/>------------<s:property  value="enddate"/>的具体得分细化如下表： 
<tr><td>论文题目</td><td>第一作者</td><td>第二作者</td><td>发布时间</td><td>论文类型</td><td>论文等级</td><td>分值</td><td>所获分值</td></tr>
<s:iterator  value="list1">
<tr>
<td><s:property  value="title"/></td>
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
<br>
<a href="fileDownloads.action?tip=1">下载个人工作量明细表</a>
<br>
<a href="index.jsp">返回首页</a>
</body>
</html>