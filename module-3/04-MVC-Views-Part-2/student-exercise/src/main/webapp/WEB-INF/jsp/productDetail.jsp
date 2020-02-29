<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product Details" />
</c:import>

<!-- Container for the Product -->
<!-- The current product is available using the `product` variable -->
<div id="product-detail">

	<c:url var="productImageURL"
		value="/images/product-images/${product.imageName}" />
	<img class="productImage" src="${productImageURL}">

	<div class="product-description">
		<h3>${product.name}</h3>

		<!-- .filled will make the star solid -->
		<div class="rating">
			<c:forEach begin="1" end="5" var="ratingCount">
				<c:choose>

					<c:when test="${ratingCount <= product.averageRating}">

						<span class="filled">&#9734;</span>

					</c:when>



					<c:otherwise>
						<span class=" ">&#9734;</span>
					</c:otherwise>

				</c:choose>



			</c:forEach>

		</div>

		<!-- Include this if the product has a Remaining Stock of 5 or less -->
		<c:if
			test="${product.remainingStock > 0 && product.remainingStock <= 5}">
			<p class="alert-remaining">BUY NOW! Only
				${product.remainingStock} left!</p>
		</c:if>





		<p class="description">${product.description}</p>


		<p class="price">

			<fmt:formatNumber value="${product.price}" type="currency" />

		</p>

		<c:choose>
			
			<c:when test="${product.remainingStock == 0}">
				
				<button disabled>Sold Out</button>
			
			</c:when>
			
			<c:otherwise>
				
				<button class="action">Add to Cart</button>
			
			</c:otherwise>
		
		</c:choose>


	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />