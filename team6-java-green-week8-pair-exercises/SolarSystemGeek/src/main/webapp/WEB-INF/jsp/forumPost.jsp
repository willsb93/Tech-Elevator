<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<div style="background-color: white">

	
	 
	


<c:url value="/forumPost" var="formAction" />
		
<form:form action="${formAction}" method="POST" modelAttribute="ForumPost">


<label for="username">Username</label> 
<form:input path="username"/>
<form:errors path="username" cssClass="error"/>


<label for="subject">Subject</label>
<form:input path="subject"/> <br />
<form:errors path="subject" cssClass="error"/>

<label for="message">Message</label>
<form:input path="message"/> <br />
<form:errors path="message" cssClass="error"/>

<input class="formSubmitButton" type="submit" value="Submit" />

</form:form>

</div>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />


