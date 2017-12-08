<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@ page import="java.util.*,model.Paper.*,action.*" %> 
 
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>  
    <table width="500" border="1" align="center" cellpadding="5" cellspacing="0">  
  <tr>  
    <td colspan="5" align="center" valign="middle"><strong><font color="#FF00CC" size="5">所有商品信息</font></strong></td>  
  </tr>  
  <tr align="center" valign="middle">  
    <td><strong>ID</strong></td>  
    <td><strong>书名</strong></td>  
    <td><strong>价格</strong></td>  
    <td><strong>数量</strong></td>  
    
  </tr>  
    
    
  <s:iterator value="#session.list"> 
   <tr align="center" valign="middle"> 
	 <td ><s:property value="paperID"/></td>
	 <td ><s:property value="title"/></td>
	 <td ><s:property value="date"/></td>
	 <td ><s:property value="keyword"/></td>
	  </tr>  
  </s:iterator>
 

<tr align="center" valign="middle">  
    <td colspan="5">  
        <%=request.getAttribute("s") %>      
    </td>  
  </tr>  
 
</table>  
</body>  
</html>