<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New User page</h3>
<form:form method="POST" commandName="user"
	action="${pageContext.request.contextPath}/user/create.html">
	<table>
		<tbody>
			<tr>
				<td><spring:message code="user.userId" /></td>
				<td><form:input path="userId" /></td>
				<td><form:errors path="userId" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.userName" /></td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.password" /></td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="user.userRole" /></td>
				<td><form:input path="userRole" /></td>
				<td><form:errors path="userRole" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>

