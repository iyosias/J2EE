<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View all COffee Names</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
<s:include value="header.jsp" />
<br /><br />
<table border="1px">
	<tbody>
		<tr>
			<th>Coffee Name</th>
		</tr>
		<s:iterator value="nameslist" status="statusVar">
		<tr>
 			<td><s:property/></td>
 		</tr>
 		</s:iterator>
	</tbody>
</table>
</body>
</html>