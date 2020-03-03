<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		
		
		<c:url var = "forDummies" value = "/etc/forDummies.png" />
		<img src ="">
		
		<h1>Hello, <c:out value="${param.forDummies}" />!</h1>
	</body>
</html>