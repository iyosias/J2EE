<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-jquery-tags" prefix="sj" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<sj:head/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Coffee</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
<s:include value="header.jsp" />
<br>
<h2>Search Coffee By Name</h2>


<s:form action="SearchCoffeeAction">
	<s:textfield name="searchcoffee" id="searchcoffee" label="Coffee Name" />
	<s:submit 
		value="Search" />
</s:form>
<br>

<table border="1px">
	<tbody>
		<tr>
			<th>Coffee Name</th>
			<th>Supplier Id</th>
			<th>Price</th>
			<th>Sales</th>
			<th>Total</th>
		</tr>
		<s:if test="cof.cof_name!=null ">
		<tr>
 			<td><s:property value="cof.cof_name" /></td>
 			<td><s:property value="cof.sup_id" /></td>
 			<td><s:property value="cof.price" /></td>
 			<td><s:property value="cof.sales" /></td>
 			<td><s:property value="cof.total" /></td>
 		</tr>
 		</s:if>

	</tbody>
</table>


</body>
</html>