<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>
<!-- Form goes here -->


<c:url var="formAction" value="/actorList" />


<form method="GET" class = "form-inline" >
    <input class="form-control" name="search" placeholder="search">
    <input class="btn" name="submit" value="Submit" type="submit"/>

</form>


<table class="table">
<tr>
<th>Name</th>
</tr>
<c:forEach items="${actor}" var="actor">
<tr>
    <!-- What do we print here for each actor? -->
    <td> 
    
    	<c:out value = "${actor.firstName}" /> 
    	 <c:out value = "${actor.lastName}" />
    	 
    </td>	 
</tr>
</c:forEach>
</table>



<%@include file="common/footer.jspf"%>