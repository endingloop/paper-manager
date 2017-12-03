<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>用户注册</title>
</head>

<body>
	<s:form action="Registration_save" validate="false">
    	<s:textfield name="username" label="账号" type="text" />
    	<s:password name="password" showPassword="true" label="密码" type="password"/>
		<s:password name="password2" showPassword="true" label="重复密码" type="password"/>
		<span style="color:red;"><s:actionerror/></span>
   		<s:submit value="点击注册"/>
    	<s:reset value="重置"/>
	</s:form>
	
	<br></br>
	<span>Already have <a href="<s:url action="Login_input" />" id="left">an account?</a> </span>
</body>
</html>
