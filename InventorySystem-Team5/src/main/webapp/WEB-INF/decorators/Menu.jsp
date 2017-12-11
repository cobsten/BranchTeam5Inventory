<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/logout" var="logout" />
<spring:url value="/admin/user/list" var="ulist"
							htmlEscape="true" /> <a href="${ulist}">
							Listing page
							</a>

