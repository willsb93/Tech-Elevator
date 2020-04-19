<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<div style="background-color: white">

<c:url value="/forumBoard" var="formAction" />
		
<form method="POST" action="${formAction}">

<label for="username">Username</label> 
<input type="text"name="username" id = "username"/> 


<label for="subject">Subject</label>
<input type="text" name="subject" id="subject" /> 


<label for="message">Message</label>
<textarea name="message" rows="6" cols="100"></textarea>


<input class="formSubmitButton" type="submit" value="Submit" />

</form>

</div>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />