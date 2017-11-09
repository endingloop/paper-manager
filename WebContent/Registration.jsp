<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
        <title><s:text name="registration.title.create"/></title>
</head>

<body onLoad="self.focus();document.Registration_save_username.focus()">

	<s:form action="Registration_save" validate="false">
		<s:textfield key="username" />
		<s:password key="password" showPassword="true" />
		<s:password key="password2" />

		<s:submit key="button.save" action="Registration_save" />
		<s:reset key="button.reset" />
		<s:submit action="Welcome" key="button.cancel"
			onclick="form.onsubmit=null" />
	</s:form>

</body>
</html>
