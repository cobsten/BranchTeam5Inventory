<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New Employee page</h3>
<form:form method="POST" modelAttribute="product"
	action="${pageContext.request.contextPath}/product/create.html">
	<table>
		<tbody>
			<tr>
				<td><spring:message code="partNo" /></td>
				<td><form:input path="partNo" /></td>
			</tr>
			<tr>
				<td><spring:message code="carDealer" /></td>
				<td><form:input path="carDealer" /></td>
			</tr>
			<tr>
				<td><spring:message code="partDescription" /></td>
				<td><form:input path="partDescription" /></td>
			</tr>
			<tr>
				<td><spring:message code="availableQty" /></td>
				<td><form:input path="availableQty" /></td>
			</tr>
			<tr>
				<td><spring:message code="color" /></td>
				<td><form:input path="color" /></td>
			</tr>
			<tr>
				<td><spring:message code="dimension" /></td>
				<td><form:input path="dimension" /></td>
			</tr>
			<tr>
				<td><spring:message code="reorderLevel" /></td>
				<td><form:input path="reorderLevel" /></td>
			</tr>
			<tr>
				<td><spring:message code="shelfLocation" /></td>
				<td><form:input path="shelfLocation" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create" size="20"/></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>

