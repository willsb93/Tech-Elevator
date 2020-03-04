<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




<!DOCTYPE html>
<html>
<head>
<title>Review</title>
</head>

<body>

	
	<c:url value="/writeReview" var="formAction"  />
	

	<img src = "portal_content/images/forDummies.png"/>
	<form class = "form-inline" method="POST" action="${formAction}" >
	

		<label for="username">Username :</label> <input type="text"
			name="username" placeholder="Username " /> <label for="rating">Rating:</label>

		<select name="rating">

			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>

		</select> <label for="title">Review Title</label> <input type="text"
			name="title" placeholder="Review Title" /> <label for="title">Review
			Text</label>
		<textarea name="text" rows="6" cols="100" placeholder="Review Text"></textarea>

		<input class="btn" type="submit" value = "submit" name = "submit"/>

	</form>

	<h3>Reviews</h3>

	<c:forEach var="review" items="${reviews}">

		<p>
			<span style = "font-weight:bold" class="reviewTitle"><c:out value="${review.title}" /></span>
		</p>
		
		<p>
		
		<c:out value = "${review.username}" />
		</p>
		
		
		<p>
			
			
			
			<c:out value = "${review.dateSubmitted.getMonthValue()}/${review.dateSubmitted.getDayOfMonth()}/${review.dateSubmitted.getYear()}"/>
		</p>
		
		<c:forEach var="rating" begin="1" end="${review.rating}">
			<img class="ratingImage" src = "portal_content/images/star.png"/>
		</c:forEach>		

			<p>
				<c:out value="${review.text}" />
			</p>
	

		</c:forEach>
</body>
</html>