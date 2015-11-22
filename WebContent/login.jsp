<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<s:head/>


</head>
<body>
<h1 align="center">Login App</h1>

<s:div style="float:left; position:relative; width:100%">
	<s:div style="float:left; position:relative; width:30%">
		<img src="../pictures/logo.jpg" style="width:60%; float:right">
	</s:div>
	<s:div style="float:left; position:relative; width:70%; padding-top:180px">
		<s:form action="LoginAction" namespace="action">
			<s:textfield key="user.email" />
			<s:password key="user.password"  />
			<s:submit/>
		</s:form>
		<br>
		<a href="<s:url action="Register" />">Create Account</a>
	</s:div>
</s:div>

</body>
</html>