<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	
	<div style= "background-color: white; display: flex;">
			<c:url var="planetImgSrc" value="/img/${planet.toLowerCase()}.jpg" />
			<img src="${planetImgSrc}" alt="planet">
	
			<ul style = "list-style-type: none">
			<li>
			If you are ${earthAge} years old on planet Earth, then you are <c:out value= "${alienAge}"/> ${planet} years old.
			</li>
			</ul>
		
	</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />