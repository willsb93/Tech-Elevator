<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Films List"/>

<%@include file="common/header.jspf"%>

<form method="GET" class = "form-inline" action="${formAction}">

<label for = "maximumLenght"> Maximum Length: </label><input name = "maximumLength" />

<label for = "minimumLenght"> Minimum Length: </label><input name = "minimumLength" />

<label for = "genre">Genre: </label>

<select name = "genre">

<option value = "Comedy">Comedy</option>
<option value = "Action">Action</option>
<option value = "Horror">Horror</option>
<option value = "Family">Family</option>
<option value = "Drama">Drama</option>


</select>

<%-- maybe have to add divs? --%>

<input name = "submit" value = "search" type = "submit" class = "btn"/>

</form>

<table class = "table">

<tr>
<th>Title</th>
<th>Description</th>
<th>Release Year</th>
<th>Length</th>
<th>Rating</th>
</tr>

<c:forEach items = "${films}" var = "film">

<tr>
<td><c:out value = "${film.title}"/>
<td><c:out value = "${film.description}"/></td>
<td><c:out value = "${film.releaseYear}" /></td>
<td><c:out value = "${film.length}" /></td>
<td><c:out value = "${film.rating}" /></td>
</tr>

</c:forEach>

</table>


<%@include file="common/footer.jspf"%>