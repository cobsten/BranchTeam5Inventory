<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit Product page</h3>
<form:form method="POST" modelAttribute="product"
	action="${pageContext.request.contextPath}/product/edit/${product.partNo}.html">
	
	<table>
		<tbody>
			<tr>
				<td>Part No</td>
				<td><form:input path="partNo" readonly="true" /></td>
				<td><form:errors path="partNo" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Dealer</td>
				<td><form:input path="carDealer" /></td>
				<td><form:errors path="carDealer" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Part Description</td>
				<td><form:input path="partDescription" /></td>
				<td><form:errors path="partDescription" cssStyle="color: red;" /></td>
			</tr>			
			<tr>
				<td>Available Quantity</td>
				<td><form:input path="availableQty" /></td>
				<td><form:errors path="availableQty" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Color</td>
				<td><form:input path="color" /></td>
				<td><form:errors path="color" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Dimension</td>
				<td><form:input path="dimension" /></td>
				<td><form:errors path="dimension" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Reorder Level</td>
				<td><form:input path="reorderLevel" /></td>
				<td><form:errors path="reorderLevel" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Shelf Location</td>
				<td><form:input path="shelfLocation" /></td>
				<td><form:errors path="shelfLocation" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" class="blcass"/></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>

