<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
</head>
<body>
<h1 align="center">Registration</h1>
<s:div style="float:left; position:relative; width:100%">
	<s:div style="float:left; position:relative; width:20%">
		&nbsp;
	</s:div>
	<s:div style="float:left; position:relative; width:60%; padding-top:100px">
	<s:form action="RegisterAction" validate="true" method="post">
		<s:textfield key="accountBean.email" id="email"  />
		<s:password key="accountBean.password" id="password" />
		<s:textfield key="accountBean.firstname" id="firstname"  />
		<s:textfield key="accountBean.middlename" id="middlename" label="Middle Name" />
		<s:textfield key="accountBean.lastname" id="lastname" label="Last Name" />
		<s:select key="accountBean.gender" 
					headerKey="-1" headerValue="Select Gender" 
					id="gender" 
					list="#{'Male': 'Male', 'Female' : 'Female'}" />
		<s:textfield key="accountBean.phone" id="phone" />
		<s:submit label="Register" />
	</s:form>
	<s:a href="Login">Back to Login Page</s:a>
	</s:div>
	<s:div style="float:left; position:relative; width:20%">
&nbsp;
	</s:div>
</s:div>
	
</body>
</html>