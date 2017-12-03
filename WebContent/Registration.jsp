<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

<title>用户注册</title>
</head>

<body>
<div class="page-container">
<h1>Sign up</h1>
	<s:form action="Registration_save" validate="false" theme="simple">
    	<s:textfield name="username" placeholder="账号" type="text" />
    	<s:password name="password" showPassword="true" placeholder="密码" type="password"/>
		<s:password name="password2" showPassword="true" placeholder="重复密码" type="password"/>
		<span style="color:red;"><s:actionerror/></span>
   		<s:submit value="点击注册"/>
    	<s:reset value="重置"/>
	</s:form>
	
	<br></br>
	<span>Already have <a href="<s:url action="Login_input" />" id="left">an account?</a> </span>
	</div>
</body>

</html>
