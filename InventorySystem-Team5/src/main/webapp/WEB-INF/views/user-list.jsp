
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>User List Page</h3>
<a href="${pageContext.request.contextPath}/user/create">Add
	User</a>
<table>

		<thead>
			<tr>
				<th><spring:message code="user.userId" /></th>
				<th><spring:message code="user.userName" /></th>
				<th><spring:message code="user.password" /></th>
				<th><spring:message code="user.userRole" /></th>
				<th><spring:message code="caption.edit" /></th>
				<th><spring:message code="caption.delete" /></th>
			</tr>
		</thead>

<tbody>


	<c:forEach var="user" items="${userList}">
		<tr class="listRecord">
			<td align="left">${user.userId}</td>
			<td align="left">${user.userName}</td>
			<td align="center"><a
				href="${pageContext.request.contextPath}/admin/department/edit/${department.departmentId}.html"><spring:message
						code="caption.edit" /></a></td>
			<td><a
				href="${pageContext.request.contextPath}/admin/department/delete/${department.departmentId}.html"><spring:message
						code="caption.delete" /></a></td>
		</tr>
	</c:forEach>


</tbody>

</table>


</body>
</html>