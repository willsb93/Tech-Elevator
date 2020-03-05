<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>
   

   
    
    <h1>Your Favorite Things:</h1>
		<h3>Favorite Color: ${favoriteThings.color}</h3>
		<h3>Favorite Food:  ${favoriteThings.food}</h3>
		<h3>Favorite Season: ${favoriteThings.season}</h3>
		
	
		
<c:import url="/WEB-INF/jsp/common/footer.jsp" />		