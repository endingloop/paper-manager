<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title><s:text name="login.title"/></title>
</head>

<body>

<s:form action="Login" validate="true">

    <s:textfield key="username" />

    <s:password key="password" showPassword="true"/>
<a href="<s:url action="Login_input" />" id="right">登录</a>
<a href="<s:url action="Registration_input" />" id="left">注册</a>

    <s:submit action="Login_cancel" key="button.cancel"
                onclick="form.onsubmit=null"/>
</s:form>

</body>
</html>
