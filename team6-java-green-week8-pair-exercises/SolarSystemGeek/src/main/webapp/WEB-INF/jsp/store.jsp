<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />




<h2> Solar System Geek Store</h2>


<c:forEach var="product" items="${productList}">

<div style="background-color: white; display = flex">

<c:url var = "productImage" value = "/img/${product.imageName}"/>



	<c:url var="productDetail" value="/productDetail">
	<c:param name = "id"> ${product.id } </c:param>
	</c:url>
	
<a class = "product-image" href= "${productDetail}">
<img src = "${productImage}">
</a>


<div style = "background-color: white; display = inline-block">

<p>
${product.name}
</p>
<p>
${product.price}
</p>
</div>


</div>
</c:forEach>





<c:import url="/WEB-INF/jsp/common/footer.jsp" />