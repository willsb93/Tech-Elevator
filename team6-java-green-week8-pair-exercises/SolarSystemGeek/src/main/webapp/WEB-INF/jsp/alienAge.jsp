<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

	
	<div style="background-color: white">
	<c:url value="/alienAgeResults" var="formAction" />
		<form method="GET" action="${formAction}">
			
			<ul style = "list-style-type: none">
			<li>
			<label for="choosePlanet">Choose a Planet: </label>
			<select id="choosePlanet" name="choosePlanet">
				<option value = "Mercury"> Mercury </option>
				<option value = "Jupiter"> Jupiter </option>
				<option value = "Venus"> Venus </option>
				<option value = "Saturn"> Saturn </option>
				<option value = "Earth"> Earth </option>
				<option value = "Uranus"> Uranus </option>
				<option value = "Mars"> Mars </option>
				<option value = "Neptune"> Neptune </option>
			</select>
			</li>
			
			<li>
			<label for="enterEarthAge">Enter your Earth Age:  </label>
			<input type="text" id="enterEarthAge" name="enterEarthAge" />
			</li>
			
			<li>
			<input type="submit" value="Calculate Age" />
			</li>
			</ul>
			
		</form>
		
		
		
</div>
<p> poop </p>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />