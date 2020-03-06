<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<c:set var="pageTitle" value="Registration"/>
<%@include file="common/header.jspf" %>

<h3>Registration</h3>

<c:url var="registration" value="/register" />
<form:form action="${registration}" method="POST" modelAttribute="registration">

	<div class="form-group">
		<label for="firstName">First Name:</label>
		<form:input path="firstName" class="form-control" />
		<form:errors path="firstName" cssClass="error"/>	
		</div>
	
	<div class="form-group">
		<label for="lastName">Last Name:</label>
		<form:input path="lastName" class="form-control" />
		<form:errors path="lastName" cssClass="error"/>	
	</div>
	
	<div class="form-group">
		<label for="email">Email:</label>
		<form:input path="email" class="form-control" />
		<form:errors path="email" cssClass="error"/>	
	</div>
	
	<div class="form-group">
		<label for="confirmEmail">Confirm Email:</label>
		<form:input path="confirmEmail" class="form-control" />
		<form:errors path="confirmEmail" cssClass="error"/>	
	</div>
	
	<div class="form-group">
		<label for="password">Password:</label>
		<form:password path="password" class="form-control" />
		<form:errors path="password" cssClass="error"/>	
	</div>
	
	<div class="form-group">
		<label for="confirmPassword">Confirm Password:</label>
		<form:password path="confirmPassword" class="form-control" />
		<form:errors path="confirmPassword" cssClass="error"/>	
	</div>
	
	<div class="form-group">
		<label for="birthDate">Date of Birth (YYYY-MM-DD):</label>
		<form:input path="birthDate" class="form-control" />
		<form:errors path="birthDate" cssClass="error"/>	
	</div>
	
	<div class="form-group">
		<label for="numOfTickets">Number of Tickets:</label>
		<form:input path="numOfTickets" class="form-control" />
		<form:errors path="numOfTickets" cssClass="error"/>	
	</div>
	
	
	<input type="submit" value="register" class="btn btn-default">


</form:form>

<%@include file="common/footer.jspf" %>