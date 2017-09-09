<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:set var="title" value="${product.name}" scope="request"/>
<jsp:include page="../components/head.jsp"/>
<body>
<jsp:include page="../components/header.jsp"/>
<div id="main" class="container">
    <div class="row">

        <div class="col-12 text-center text-sm-left mt-5">
            <a href="<c:url value="/productsR"/>" class=" btn btn-light">
                <i class="fa fa-chevron-left" aria-hidden="true"></i>
                Return
            </a>
        </div>

        <div class="col-12 mt-3">

            <c:if test="${currentCheck.productList.size() > 0}">
                <div class="alert alert-dark">
                    <div class="row">
                        <div class="col-12 col-sm-7 col-md-8">
                            <div>Product in check: <strong>${currentCheck.productList.size()}</strong></div>
                            <div>All sum <strong>${currentCheck.summa}</strong></div>
                        </div>
                        <div class="col-12 col-sm-5 col-md-4 text-center text-sm-right">
                            <a href="<c:url value="/checks/newCheck"/>" class="btn btn-outline-dark">
                                Go to the order form
                                <i class="fa fa-chevron-right" aria-hidden="true"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </c:if>

            <div id="product" class="row">
                <div class="col-12 col-sm-4">
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
                </div>
                <div class="col-12 col-sm-8">
                    <h1 class="text-center text-sm-left">${product.name}</h1>
                    <div class="price text-center text-sm-right">Price:
                        <span class="text-danger">${product.priceForSale} USD</span></div>
                    <table class="table">
                        <thead class="thead-default">
                        <tr>
                            <th colspan="2">About dishes:</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">description:</th>
                            <td>${product.text}</td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="mt-3 text-center text-sm-right">
                        <form:form method="post" servletRelativeAction="/productsR/${product.id}/addToCheck">
                            <button type="submit" class="btn btn-dark">Add to check</button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
        <p></p>
    </div>
</div>
<jsp:include page="../components/footer.jsp"/>
</body>
</html>
