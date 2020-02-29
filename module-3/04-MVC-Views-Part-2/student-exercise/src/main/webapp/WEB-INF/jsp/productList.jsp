<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product List View" />
</c:import>

<div id="card-page">
	<c:import url="/WEB-INF/jsp/common/filters.jsp">
		<%-- Modify the baseRoute to apply filters to the current route. --%>
		<c:param name="baseRoute" value="/products" />
	</c:import>

	<div class="main-content">




		<div id="sorting-options">

			<h3>Sort By</h3>

			<ul>

				<li><a href="/products/productList/?sortOrder = PriceLowToHigh">Price -
						Low to High</a></li>

				<li><a href="/products/productList/?sortOrder = PriceHighToLow">Price -
						High to Low</a></li>

				<li><a href="/products/productList/?sortOrder = RatingHighToLow">Rating
						- High to Low</a></li>

			</ul>

		</div>

		<!-- Container for all of the Products -->
		<!-- The list of products is available using the `products` variable -->
		<div id="grid">

			<!-- 
			The following HTML shows different examples of what HTML could be rendered based on different rules. 
			For purposes of demonstration we've written it out so you can see it when you load the page up. 
			-->

			<c:forEach var="product" items="${products}">

				<c:set var="tileHolder" value="" />
				<c:set var="topSellerHolder" value="false" />
				<c:set var="soldOutHolder" value="false" />

				<c:choose>

					<c:when test="${product.topSeller}">
						<c:set var="tileHolder" value="top-seller" />
						<c:set var="topSellerHolder" value="true" />
					</c:when>

					<c:when test="${product.remainingStock == 0}">
						<c:set var="tileHolder" value="sold-out" />
						<c:set var="soldOutHolder" value="true" />
					</c:when>

				</c:choose>

				<!-- Standard Product -->
				<div class="tile ${product}">


					<c:url var="productImage"
						value="/images/product-images/${product.imageName}" />

					<c:url var="productDetail" value="/products/detail">

						<c:param name="id" value="${product.id}" />

					</c:url>


					<a class="product-image" href="${productDetail}"> <img
						src="${productImage}">
					</a>


					<div class="details">
						<p class="name">${product.name}</p>

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



						<c:if test="${topSellerHolder}">
							<!-- Add the Top Seller <br/> and product alert if the product is considered a Top Seller -->
							<br />
							<p class="product-alert">Top Seller!</p>
						</c:if>



						<c:if test="${soldOutHolder}">

							<span class="banner">Sold Out</span>

						</c:if>


						<c:if
							test="${product.remainingStock > 0 && product.remainingStock <= 5}">
							<span class="product-alert">${product.remainingStock}
								remaining!</span>
						</c:if>

						<p class="price">

							<fmt:formatNumber value="${product.price}" type="currency" />

						</p>
					</div>
				</div>

			</c:forEach>
		</div>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />