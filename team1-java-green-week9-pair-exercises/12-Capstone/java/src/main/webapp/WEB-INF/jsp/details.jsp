<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/common/header.jsp">
</c:import>
<div class= "detailBody">
<c:url var="parkImageSrc" value="/img/parks/${park.parkCode.toLowerCase()}.jpg"/>
<br>
<div class="park-details-image"><img src="${parkImageSrc}" alt="park">
	<br><div class="topleft">${park.parkName}
	<br>${park.state}
	</div></div>
	<div class="park-details-description">
	<p>${park.parkDescription }</p>
	<br>
	<p>Come visit us in beautiful ${park.state }!  We have over ${park.acreage } acres to explore, ${park.miles } miles of trail to hike, and a chance to see upto ${park.numberOfAnimalSpecies} number of species!  This park was founded in 
	${park.yearFounded} and gets over ${park.annualVisitorCount} visitors annually.  

<br>
	<br>" ${park.inspirationalQuote} "  - ${park.inspirationalQuoteSource}
	<br>
	<br>${park.numberOfCampsites} camp sites
	<br>Park climate: ${park.climate} 
	<br>${park.elevation} feet above elevation
	<br>Entry fee: $${park.entryFee}
	</div>
</div>
<c:url value="/degreetype" var ="formAction"/>
<form action ="${formAction }" method = "POST">
<input type="hidden" id="parkCode" name="parkCode" value="${park.parkCode }"/>
<label for="Degrees"> Choose a temperature type: </label>
<select id="Degrees" name="Degrees">
<option value="Celsius" id = "Celsius"> °C </option>
<option value="Farenheit" id = "Farenheit"> °F </option>
</select>
<input class="btn" type="submit" value = "submit" name = "submit"/>
</form>
<div class="weather-container">
<c:forEach var = "weather" items = "${weathers}">
<div class = "weather-card">
<c:forEach begin = "1" end ="5" var = "num">




<c:set var="HighDegrees" value="${weather.stringTempHigh }" scope="session"/>
<c:set var="LowDegrees" value="${weather.stringTempLow }" scope="session"/>




<c:if test = "${weather.fiveDayForecastValue == num}">
<h3>${park.parkName}</h3>
<h4>${weather.date.plusDays(num-1)}</h4><span> · ${weather.forecast } · </span>
<h2 id="low">${weather.stringTempLow}  </h2><h2 id="high"> ${weather.stringTempHigh}</h2>
<div class="weather-emoji">${weather.weatherEmoji}</div>
<br>
<center>Recommendations for today</center>
<br>
<div class = "forecast-advice">${weather.forecastAdvice }</div>
<div class = "temperature-advice">${weather.temperatureAdvice }</div>
</c:if>



</c:forEach>
</div>

</c:forEach>
</div>

<c:import url="/WEB-INF/common/footer.jsp">
</c:import>