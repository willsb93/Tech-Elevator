<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Customers List"/>

<%@include file="common/header.jspf"%>


<c:url value="/searchCustomer" var="formAction"/>

<form method="GET" class = "form-inline" action="${formAction}">

<input name = "search" type = "text" placeholder = "search" />
<label for = "sort"> Sort: </label>

<select name = "sort" >

<option value = "last_name"> Last Name</option>
<option value = "email"> E-mail</option>
<option value = "active"> Active </option>

</select>

<%-- maybe have to add divs? --%>

<input name = "submit" value = "submit" type = "submit" class = "btn"/>

</form>

<table class = "table">

<tr>
<th>Name</th>
<th>E-mail</th>
<th>Active</th>
</tr>

<c:forEach items = "${customers}" var = "customer">

<tr>
<td><c:out value = "${customer.firstName}"/> <c:out value = "${customer.lastName}"/></td>
<td><c:out value = "${customer.email}"/></td>
 <%-- loop to see if its true or false <td><c:out value = "${customers.active ?}" /></td>--%>
</tr>

</c:forEach>

</table>



<%@include file="common/footer.jspf"%>