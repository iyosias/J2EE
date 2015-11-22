<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>
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