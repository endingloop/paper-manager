<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title><s:text name="login.title"/></title>
</head>

<body>

<s:form action="Login" validate="true" onsubmit="return formCheck();" name="login" >
    <s:textfield key="username" label="账号" name="username" type="text" />

    <s:password key="password" showPassword="true" label="密码" name="password" type="password"/>

    <s:submit key="button.logon" label="登陆"/>

    <s:reset key="button.reset" label="重置"/>

    <s:submit action="Login_cancel" key="button.cancel"
                onclick="form.onsubmit=null"/>
</s:form>
<span id="form" style="color:red;"></span>
<br></br>
<span>Already have <a href="<s:url action="Registration_input" />" id="left">an account?</a> </span>
 <span style="color:red;"><s:actionerror/></span>
<script language="javascript">
function isEmpty(str) {
    return str === null || str === '';
}
function formCheck() {
    var userId = document.forms['login']['username'].value;
    var password = document.forms['login']['password'].value;
    if (isEmpty(userId)) {
        document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
        document.getElementById('form').innerHTML = '*请填写账号';
        return false;
    }
    if (isEmpty(password)) {
        document.getElementById('form').setAttribute('class', 'list-group-item list-group-item-danger');
        document.getElementById('form').innerHTML = '*请填写密码';
        return false;
    }
}
 
</script>


</body>
</html>
