<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />




<h2>Solar System Geek Store</h2>




<div style="background-color: white;">

	<c:url var="productImage" value="/img/${product.imageName}" />



	<img src="${productImage}">



	<div style="background-color: white;">

		<p>${product.name}</p>
		<p>${product.price}</p>
	</div>



	<c:url value="/cart" var="formAction" > <c:param name = "id"> ${product.id } </c:param>  </c:url>


	<form method="POST" action="${formAction}">
		<label for="quantity">Quantity To Buy</label> <input type="text"
			id="quantity" name="quantity" />
		<%-- <c:param name="id"> ${product.id} </c:param> --%>


		<input type="submit" value="add to cart" />

	</form>

	<%-- <c:param name = "quantity"> ${quantity} </c:param> --%>
</div>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />