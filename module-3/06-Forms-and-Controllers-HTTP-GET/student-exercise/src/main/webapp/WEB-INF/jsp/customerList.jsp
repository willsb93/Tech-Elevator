<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>

<%@include file="common/header.jspf"%>

<form method="GET" class = "form-inline" action="${formAction}">

<input name = "search" type = "text" placeholder = "search" />
<label for = "sort"> Sort: </label>

<select name = "sort" >

<option value = "lastName"> Last Name</option>
<option value = "email"> E-mail</option>
<option value = "active"> Active </option>

</select>

<%-- maybe have to add divs? --%>

<input name = "submit" value = "search" type = "submit" class = "btn"/>

</form>

<table class = "table">

<tr>
<th>Name</th>
<th>E-mail</th>
<th>Active</th>
</tr>

<c:forEach items = "${customers}" var = "customers">

<tr>
<td><c:out value = "${customers.firstName}"/> <c:out value = "${customers.lastName}"/></td>
<td><c:out value = "${customers.email}"/></td>
<td><c:out value = "${customers.active ?}" /></td> <%-- loop to see if its true or false --%>
</tr>

</c:forEach>

</table>

</form>

<%@include file="common/footer.jspf"%>