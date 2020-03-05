<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="title" value="Favorite Season" />
</c:import>

<c:url var="formAction" value="/Page4" />

<form method="POST" class= "form-inline" action = "${formAction}">
	<label for=""> What is your favorite season ?</label> 
	<input type="radio" name="season" value="Spring"> Spring<br> 
	<input type="radio" name="season" value="Summer"> Summer<br> 
	<input type="radio" name="season" value="Fall"> Fall <br> 
	<input type="radio" name="season" value="Winter"> Winter <br>
	<button type="submit">Next >>></button>
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />