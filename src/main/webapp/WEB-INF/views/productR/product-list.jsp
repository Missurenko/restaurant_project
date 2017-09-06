<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: bm
  Date: 27.08.17
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All product for sale</title>
</head>
<body>

<c:if test="${products.size() == 0}">
    Material на данный момент отсутствует
</c:if>

<h1 class="text-center">Menu</h1>
<div class="row mt-1">
    <div class="col-12">
        <form>
            <div class="form-group">
                <label for="name">Dishes name</label>
                <input type="text" id="name" name="name" value="${parem.name}" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Price</label>
                <div class="row">
                    <div class="col-12">
                        <label for="min" class="text-left text-sm-right">min</label>
                    </div>
                    <div class="col-12">
                        <input type="text" id="min" name="min" value="${param.min}" class="form-control"/>
                    </div>
                    <div class="col-12">
                        <label for="max" class="text-left text-sm-right">max</label>
                    </div>
                    <div class="col-12">
                        <input type="text" id="max" name="max" value="${param.max}" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="productSort">Sorting</label>
                <select id="productSort" name="productSort" class="form-control">

                </select>
            </div>
            <div class="form-group text-center">
                <button type="submit" class="btn btn-light">Search</button>
            </div>
        </form>
    </div>
    <div class="col-12">
        <div id="catalog" class="row">
            <c:forEach var="product" items="${products}">
                <jsp:useBean id="product" type="edu.bionic.domain.my.Product"/>
               <div class="col-xs-6">
                   <a href="<c:url value="products/${product.id}"/>" class="product">
                       <span class="info">${product.toString()}</span>
                   </a>
               </div>

                           </c:forEach>
        </div>
    </div>

</div>


</body>
</html>
