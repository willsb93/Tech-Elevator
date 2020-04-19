<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />




<div style="background-color: white">

<c:set var="totalPrice" value="0"/>

<c:forEach var="entrySet" items="${shoppingCart}" >
<div>

${entrySet.key.name}

<c:url var = "productImage" value = "/img/${entrySet.key.imageName}"/>
<img src = "${productImage}">

<p> Unit Price :  ${entrySet.key.price} </p>

<p> Quantity :  ${entrySet.value} </p>


<!--total price = from 1 -> entrySet.value entrySet.key.price.plus(entrySet.key.price)  -->


<%-- <c:forEach begin="1" end="${entrySet.value}">
  
<c:set var="totalPrice" value="${totalPrice.add(entrySet.key.price)}"/>  

</c:forEach> --%>
 
<c:set var="totalUnitPrice" value="${entrySet.key.price.dollars * entrySet.value}"/>

$${totalUnitPrice}

<c:set var="totalPrice" value="${totalPrice + totalUnitPrice}"/>

</div>
</c:forEach>

<p> Grand Total: $${totalPrice} </p>

<a href="/ssg-exercises-pair/terminate">Check Out</a>



</div>





<c:import url="/WEB-INF/jsp/common/footer.jsp" />