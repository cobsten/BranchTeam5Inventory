
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h4>Product List Page</h4>

	<form:form modelAttribute="product" method="POST"
		action="${pageContext.request.contextPath}/product/search">
		
		<table >
			<tr>
			<td><spring:message code="partNo" /></td>
				<td><form:input path="partNo" /></td>
				<td><form:errors path="partNo" cssStyle="color: red;" /></td>
			<td></td>				
			</tr>
			<tr>
				<td><spring:message code="product.carDealer" /></td>

				<c:forEach var="product" items="${carDealerList}" varStatus="mapIndex">

					<td><input type="radio" id="chk${mapIndex.index}"
						name="chk${mapIndex.index}" /> ${product}</td>
				</c:forEach>
			</tr>
			
			<tr>
				<td><spring:message code="product.partDescription" /></td>

				<c:forEach var="product" items="${partDescriptionList}" varStatus="mapIndex">

					<td><input type="checkbox" id="chk${mapIndex.index}"
						name="chk${mapIndex.index}" /> ${product}</td>
				</c:forEach>
			</tr>

			
		</table>

		<form:button name="submit" type="submit" value="Search">
			<img src="${pageContext.request.contextPath}/image/button_submit.gif"
				alt="" align="middle">
		</form:button>
	</form:form>

	<a href="${pageContext.request.contextPath}/product/create">Add
		Product</a>
	<c:if test="${fn:length(productList) gt 0}">
		<table>

			<thead>
				<tr>
					<th><spring:message code="product.partNo" /></th>
					<th><spring:message code="product.carDealer" /></th>
					<th><spring:message code="product.partDescription" /></th>
					<th><spring:message code="product.shelfLocation" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${productList}">
					<tr class="listRecord">
						<td align="left">${product.partNo}</td>
						<td align="left">${product.carDealer}</td>
						<td align="left">${product.partDescription}</td>
						<td align="left">${product.shelfLocation}</td>
						<td align="center"><a
							href="${pageContext.request.contextPath}/product/detail/${product.partNo}.html"><spring:message
									code="caption.detail" /></a></td>
						<td align="center"><a
							href="${pageContext.request.contextPath}/product/edit/${product.partNo}.html"><spring:message
									code="caption.edit" /></a></td>
						<td><a
							href="${pageContext.request.contextPath}/product/delete/${product.partNo}.html"><spring:message
									code="caption.delete" /></a></td>
					</tr>
				</c:forEach>	
			</tbody>
		</table>
		<c:url value="/product/list" var="prev">
		<c:param name="page" value="${page-1}" />
	</c:url>
	<c:if test="${page > 1}">
		<a href="<c:out value="${prev}" />" class="pn prev">Prev</a>
	</c:if>

	<c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
		<c:choose>
			<c:when test="${page == i.index}">
				<span>${i.index}</span>
			</c:when>
			<c:otherwise>
				<c:url value="/product/list" var="url">
					<c:param name="page" value="${i.index}" />
				</c:url>
				<a href='<c:out value="${url}" />'>${i.index}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:url value="/product/list" var="next">
		<c:param name="page" value="${page + 1}" />
	</c:url>
	<c:if test="${page + 1 <= maxPages}">
		<a href='<c:out value="${next}" />' class="pn next">Next</a>
	</c:if>
	</c:if>
</body>
</html>