<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="/resources/demos/external/jquery-mousewheel/jquery.mousewheel.js"></script>
<script>
  $(function() {
		$(".spinner").spinner({
			min : 0
		});
	});
</script>

<h3>New Employee page</h3>
<form:form method="POST" modelAttribute="product"
	action="${pageContext.request.contextPath}/product/create.html">
	<table>
		<tbody>
			<tr>
				<td><spring:message code="product.partNo" /></td>
				<td><form:input path="partNo" /></td>
				<td><form:errors path="partNo" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="product.carDealer" /></td>
				<td><form:input path="carDealer" /></td>
				<td><form:errors path="carDealer" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="product.partDescription" /></td>
				<td><form:input path="partDescription" /></td>
				<td><form:errors path="partDescription" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="product.availableQty" /></td>
				<td><form:input path="availableQty" class="spinner" /></td>
				<td><form:errors path="availableQty" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="product.color" /></td>
				<td><form:input path="color" /></td>
				<td><form:errors path="color" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="product.dimension" /></td>
				<td><form:input path="dimension" /></td>
			</tr>
			<tr>
				<td><spring:message code="product.reorderLevel" /></td>
				<td><form:input path="reorderLevel" class="spinner" /></td>
				<td><form:errors path="reorderLevel" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="product.shelfLocation" /></td>
				<td><form:input path="shelfLocation" /></td>
			</tr>
			<tr>				<td><input type="reset" value="Reset" size="40" /></td>
				<td></td>
				<td></td>

				<td><input type="submit" value="Add" size="40" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>

