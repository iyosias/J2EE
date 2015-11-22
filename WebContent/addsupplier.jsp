<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Supplier</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
<s:include value="header.jsp" />
<br>
<h2>Add Supplier</h2>
<s:fielderror name="invalid" />
<s:form action="AddSupplierAction" validate="true" method="post" >
	<s:textfield key="supplierBean.sup_id" id="sup_id"  />
	<s:textfield key="supplierBean.sup_name" id="sup_name"  />
	<s:textfield key="supplierBean.street" id="street"  />
	<s:textfield key="supplierBean.city" id="city"   />
	<s:textfield key="supplierBean.state" id="state"  />
	<s:textfield key="supplierBean.zip" id="sup_name"  />
	<s:submit value="add" />
</s:form>
</body>
</html>