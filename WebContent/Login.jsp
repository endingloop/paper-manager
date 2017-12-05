<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head> 
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<!-- CSS -->
<link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'/>
<link rel="stylesheet" href="css/login-reset.css"/>
<link rel="stylesheet" href="css/login-supersized.css"/>
<link rel="stylesheet" href="css/login-style.css"/>
</head>

<body>
<div class="page-container">
 <h1>Sign in</h1>
<s:form action="Login" validate="true" name="login" theme="simple" >
    <s:textfield name="username" placeholder="账号" type="text" />

    <s:password name="password" showPassword="true" placeholder="密码" type="password"/>
    
	<span style="color:red;"><s:actionerror/></span>

    <s:submit value="登陆"/>

    <s:reset value="重置"/>

</s:form>
<span id="form" style="color:red;"></span>
<br/>
<span>Don't have <a href="<s:url action="Registration_input" />" id="left">an account?</a> </span>
</div>
        <!-- Javascript -->
        <script src="js/jquery-1.8.2.min.js"></script>
        <script src="js/supersized.3.2.7.min.js"></script>
        <script src="js/supersized-init.js"></script>
 
</body>
</html>
