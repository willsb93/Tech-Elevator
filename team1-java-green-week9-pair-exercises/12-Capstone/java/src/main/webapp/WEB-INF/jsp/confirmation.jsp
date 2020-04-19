<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<c:import url="/WEB-INF/common/header.jsp">
</c:import>

<center><br>Thank you for submitting our survey!
 <br>Please view our most popular parks below:</center>
<div class="confirmation-container">
<c:forEach var="park" items="${popularparks }">
<div class="confirmation-box">

<c:url var="parkImageSrc" value="/img/parks/${park.parkCode.toLowerCase()}.jpg"/>
<br><img src="${parkImageSrc}" alt="park">
<br>${park.count} votes
<br>${park.parkName }
</div>
</c:forEach>
</div>

<c:import url="/WEB-INF/common/footer.jsp">
</c:import>