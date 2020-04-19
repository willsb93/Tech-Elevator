<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	<!--
	request.setAttribute("earthAge", earthAge);
		request.setAttribute("transportationMethod", planet);
		request.setAttribute("totalYearsNeeded", totalYearsNeeded);
		request.setAttribute("planet", planet);  -->
	
	<div style= "background-color: white; display: flex;">
			<c:url var="planetImgSrc" value="/img/${planet.toLowerCase()}.jpg" />
			<img src="${planetImgSrc}" alt="planet">
	
			<ul style = "list-style-type: none">
			<li>
 			Traveling by <c:out value= "${transportationMethod}"/> you will reach <c:out value= "${planet}"/> in <c:out value= "${totalYearsNeeded}"/> years. You will be <c:out value= "${earthAge}"/> when you arrive.
			</li>
			</ul>
		
	</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />