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
<title>用户注册</title>
</head>

<body>
<div class="page-container">
<h1>Sign up</h1>
	<s:form action="Registration_save" validate="true">
    	<s:textfield name="username" placeholder="账号" type="text" />
    	<s:fielderror cssStyle="color: red">
			<s:param>username</s:param>
		</s:fielderror> 
    	<s:password name="password" showPassword="true" placeholder="密码" type="password"/>
    	<s:fielderror cssStyle="color: red">
			<s:param>password</s:param>
		</s:fielderror> 
		<s:password name="password2" showPassword="true" placeholder="重复密码" type="password"/>
		<s:fielderror cssStyle="color: red">
			<s:param>password2</s:param>
		</s:fielderror> 
		<s:textfield name="email" placeholder="电子邮箱" type="text" />
		<s:fielderror cssStyle="color: red">
			<s:param>email</s:param>
		</s:fielderror> 
		<s:textfield name="realName" placeholder="真实姓名" type="text" />
		<s:fielderror cssStyle="color: red">
			<s:param>realName</s:param>
		</s:fielderror> 
		<span style="color:red;"><s:actionerror/></span>
   		<s:submit value="点击注册"/>
    	<s:reset value="重置"/>
	</s:form>
	
	<br></br>
	<span>Already have <a href="<s:url action="Login_input" />" id="left">an account?</a> </span>
	</div>
	        <!-- Javascript -->
        <script src="js/jquery-1.8.2.min.js"></script>
        <script src="js/supersized.3.2.7.min.js"></script>
        <script src="js/supersized-init.js"></script>
</body>

</html>
