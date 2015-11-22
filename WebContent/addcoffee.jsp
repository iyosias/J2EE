<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Coffee</title>
<s:head/>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
<s:include value="header.jsp" />
<h1>Add Coffee</h1>
<s:form action="AddCoffeeAction" >
	<s:textfield key="coffeeBean.cof_name" id="cof_name" />
	<s:select key="coffeeBean.sup_id" 
					headerKey="-1" headerValue="Select Supplier ID" 
					id="sup_id" 
					list="supplier_id" />
	<s:textfield key="coffeeBean.price" id="price"  />
	<s:textfield key="coffeeBean.sales" id="sales"  />
	<s:textfield key="coffeeBean.total" id="total"  />
	<s:submit value="add" />
</s:form>
</body>
</html>