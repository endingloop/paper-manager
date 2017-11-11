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
<button type="submit">提交</button>
</form>
<table border="2px">

<tr><td>姓名</td><td>成绩</td></tr>
<s:iterator  value="scoreresult">
<tr>
<td><s:property  value="Name"/></td>
<td><s:property value="score"/></td>
</tr>

</s:iterator>
</table>

</body>
</html>