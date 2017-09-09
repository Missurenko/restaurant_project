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
<c:set var="title" value="Каталог товаров" scope="request"/>
<jsp:include page="../components/head.jsp"/>
<body>
<jsp:include page="../components/header.jsp"/>
<c:if test="${products.size() == 0}">
    Material на данный момент отсутствует
</c:if>
<div id="main" class="container">
    <div class="row">
        <div class="col-12 mt-5">
            <h1 class="text-center">Menu</h1>
            <div class="row mt-1">
                <div class="col-12 col-sm-3 col-md-4 col-lg-4">
                    <form>
                        <div class="form-group">
                            <label for="name">Dishes name</label>
                            <input type="text" id="name" name="name" value="${param.name}" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <input type="radio" name="category" value="ALL"> ALL <br>
                            <input type="radio" name="category" value="HOT" checked> HOT<br>
                            <input type="radio" name="category" value="SECOND"> SECOND<br>

                        </div>
                        <div class="form-group text-center">
                            <button type="submit" class="btn btn-light">Search</button>
                        </div>
                    </form>
                </div>
                <div class="col-12 col-sm-9 col-md-8 col-lg-8">
                    <div id="catalog" class="row">
                        <c:forEach var="product" items="${products}">
                            <jsp:useBean id="product" type="edu.bionic.domain.my.Product"/>

                            <div class="col-xs-6 col-sm-6">
                                <div class="text-center">${product.name}</div>

                                    <a href="<c:url value="productsR/${product.id}"/>" class="product">
                                        <c:if test="${product.name == 'Soup with potatoes'}">
                                        <img src="/resources/img/coup.jpg" class="img-thumbnail">
                                        </c:if>
                                        <c:if test="${product.name == 'Barbecue'}">
                                            <img src="/resources/img/barbecue.jpg" class="img-thumbnail">
                                        </c:if>
                                        <c:if test="${product.name == 'Vareniki'}">
                                            <img src="/resources/img/vareniks.jpg" class="img-thumbnail">

                                        </c:if>
                                        <c:if test="${product.name == 'Chicken cabbage rolls'}">
                                            <img src="/resources/img/Chicken cabbage rolls.jpg" class="img-thumbnail">
                                        </c:if>
                                        <c:if test="${product.name == 'ketchup'}">
                                            <img src="/resources/img/ketchup.jpg" class="img-thumbnail">
                                        </c:if>
                                        <c:if test="${product.name == 'boiled rice'}">
                                            <img src="/resources/img/boiled rice.gif" class="img-thumbnail">
                                        </c:if>
                                        <c:if test="${product.name == 'Pilaf with mushrooms'}">
                                            <img src="/resources/img/boiled rice.gif" class="img-thumbnail">
                                        </c:if>

                                    </a>

                                <div class="text-center">Price:${product.priceForSale}</div>

                            </div>

                        </c:forEach>
                    </div>
                    <nav>
                        <c:set var="page" value="${param.page != null ? param.page : 1}"/>
                        <c:set var="query" value="${pageContext.request.queryString != null ? pageContext.request.queryString.replaceFirst('&page=\\\\d+', '') : ''}"/>
                        <ul class="pagination">
                            <c:forEach begin="1" end="${productCount % pageSize == 0 ? productCount / pageSize : productCount / pageSize + 1 }" varStatus="loop">
                                <c:choose>
                                    <c:when test="${page == loop.index}">
                                        <li class="page-item active">
                                            <span class="page-link">${loop.index}</span>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item">
                                            <a href="<c:url value="productsR?${query}&page=${loop.index}"/>" class="page-link">
                                                    ${loop.index}
                                            </a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </ul>
                    </nav>
                    <div class="text-center text-sm-left">

                        <a href="<c:url value="/"/>">
                        <i class="fa fa-chevron-left" aria-hidden="true"></i>
                        Main page
                        </a>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<jsp:include page="../components/footer.jsp"/>
</body>
</html>
