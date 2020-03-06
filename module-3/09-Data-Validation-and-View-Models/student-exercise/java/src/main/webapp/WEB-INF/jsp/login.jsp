<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<%@include file="common/header.jspf" %>


<title>Login</title>

<h3>Login</h3>

<c:url var="login" value="/login" />
<form:form action="${login}" method="POST" modelAttribute="login">

	<div class="form-group">
		<label for="email">Email:</label>
		<form:input path="email" class="form-control" />
		<form:errors path = "email" cssClass = "email" />
	</div>
	
	<div class="form-group">
		<label for="password">Password:</label>
		<form:input path="password" class="form-control" />
		<form:errors path = "password" cssClass = "password" />
	</div>
	
	<input type="submit" value="login" class="btn btn-default">

</form:form>

<%@include file="common/footer.jspf" %>