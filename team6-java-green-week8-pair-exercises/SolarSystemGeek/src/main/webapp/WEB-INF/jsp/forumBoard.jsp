
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<c:import url="/WEB-INF/jsp/common/header.jsp" />
    
<div style="background-color: white"> 
    <h3>Message Board</h3>

	<c:forEach var="message" items="${ForumPost}">

		<p>
			<span style = "font-weight:bold" class="reviewTitle"><c:out value="${message.subject}" /></span>
		</p>
		
		<p>
		
		<c:out value = "${message.username}" />
		</p>
		
		
		<p>
			
			
			
			<c:out value = "${message.datePosted.getMonthValue()}/${message.datePosted.getDayOfMonth()}/${message.datePosted.getYear()}"/>
		</p>
		
		<c:out value ="${message.message}"/>
	

		</c:forEach>

</div>		
		
<c:import url="/WEB-INF/jsp/common/footer.jsp" />		

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<div style="background-color: white">
 <div>
 
 <c:url var="forumPost" value="/forumPost"></c:url>
 <a href="${forumPost}">Add Post to Forum!</a>
 
</div>
<c:forEach var="post" items="${posts}">
<div>
${post.username} <br />
${post.subject} <br />
${post.message} <br />

<hr style="border : 1px black solid" />

</div>


</c:forEach>



</div>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />

