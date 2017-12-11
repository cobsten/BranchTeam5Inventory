<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Product Detail page</h3>
<form:form method="POST" modelAttribute="product"
	action="${pageContext.request.contextPath}/product/detail/${product.partNo}.html">
	
	<table>
		<tbody>
			<tr>
				<td><spring:message code="product.partNo" /></td>
				<td>${product.partNo}</td>
			</tr>
			<tr>
				<td><spring:message code="product.carDealer" /></td>
				<td>${product.carDealer}</td>
			</tr>
			<tr>
				<td><spring:message code="product.partDescription" /></td>
				<td>${product.partDescription}</td>
			</tr>			
			<tr>
				<td><spring:message code="product.availableQty" /></td>
				<td>${product.availableQty}</td>
			</tr>
			<tr>
				<td><spring:message code="product.color" /></td>
				<td>${product.color}</td>
			</tr>
			<tr>
				<td><spring:message code="product.dimension" /></td>
				<td>${product.dimension}</td>
			</tr>
			<tr>
				<td><spring:message code="product.reorderLevel" /></td>
				<td>${product.reorderLevel}</td>
			</tr>
			<tr>
				<td><spring:message code="product.shelfLocation" /></td>
				<td>${product.shelfLocation}</td>
			</tr>
			<tr>
				<td><input type="submit" value="Use" class="blcass"/></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>

