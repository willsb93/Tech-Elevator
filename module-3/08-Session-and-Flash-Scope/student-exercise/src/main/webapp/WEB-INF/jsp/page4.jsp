<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>
   

   
    
    <h1>Your Favorite Things:</h1>
		<h2>Favorite Color: ${favoriteThings.color}</h2>
		<h2>Favorite Food:  ${favoritesThings.food}</h2>
		<h2>Favorite Season: ${favoritesThings.season}</h2>
		
	
		
<c:import url="/WEB-INF/jsp/common/footer.jsp" />		