
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/common/header.jsp">
</c:import>
<c:forEach var = "park" items = "${parks}">
<div class = "homeBody">
<c:url var="DetailsHref" value="/details">
    	<c:param name="parkCode">${park.parkCode}</c:param>
    	</c:url>
<c:url var="parkImageSrc" value="/img/parks/${park.parkCode.toLowerCase()}.jpg"/>
<div class="park-image">
<br><a href="${DetailsHref }"><img src="${parkImageSrc}" alt="park"></a>

<div class="topleft"><br>${park.parkName}
<br>${park.state}</div>
</div>
<div class="park-description">

<br>${park.parkDescription}
</div>
</div>
</c:forEach>


<c:import url="/WEB-INF/common/footer.jsp">
</c:import>