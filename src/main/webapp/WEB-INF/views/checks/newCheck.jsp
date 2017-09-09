<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:set var="title" value="Оформление заказа" scope="request"/>
<jsp:include page="../components/head.jsp"/>
<body>
<jsp:include page="../components/header.jsp"/>
<div id="main" class="container">
    <div class="row">

        <div class="col-12 text-center text-sm-left mt-5">
            <a href="<c:url value="/productsR"/>" class=" btn btn-light">
                <i class="fa fa-chevron-left" aria-hidden="true"></i>
                Return to menu
            </a>
        </div>

        <div class="col-12">

            <c:if test="${currentCheck.productList.size() == 0}">
                <div class="alert alert-dark">
                    На данный момент товаров в корзине нет
                </div>
            </c:if>

            <c:if test="${currentCheck.productList.size() > 0}">

                <div id="cart">
                    <h1 class="text-center">Товары в корзине</h1>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>№</th>
                            <th></th>
                            <th>Product</th>
                            <th>Price</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${currentCheck.productList}" var="product" varStatus="loop">

                            <tr>
                                <td>${loop.index + 1}</td>
                                <td>
                                    <c:if test="${product.name == 'Soup with potatoes'}">

                                        <img src="/resources/img/coup.jpg" width="100" height="111"
                                             alt="Soup with potatoes">

                                    </c:if>
                                    <c:if test="${product.name == 'Barbecue'}">


                                        <img src="/resources/img/barbecue.jpg" width="100" height="111" alt="Barbecue">

                                    </c:if>
                                    <c:if test="${product.name == 'Vareniki'}">
                                        <img src="/resources/img/vareniks.jpg" width="100" height="111" alt="Vareniki">

                                    </c:if>
                                    <c:if test="${product.name == 'Chicken cabbage rolls'}">
                                        <img src="/resources/img/Chicken cabbage rolls.jpg" width="100" height="111"
                                             alt="Chicken cabbage rolls">

                                    </c:if>
                                    <c:if test="${product.name == 'ketchup'}">
                                        <img src="/resources/img/ketchup.jpg" width="100" height="111"
                                             alt="Chicken cabbage rolls">

                                    </c:if>
                                    <c:if test="${product.name == 'boiled rice'}">
                                        <img src="/resources/img/ketchup.jpg" width="100" height="111"
                                             alt="boiled rice">

                                    </c:if>
                                    <c:if test="${product.name == 'Pilaf with mushrooms'}">
                                        <img src="/resources/img/boiled rice.gif" width="100" height="111"
                                             alt="Pilaf with mushrooms">

                                    </c:if></td>
                                <td>${product.name} ${product.text}</td>
                                <td class="text-center">${product.priceForSale}</td>
                                <td width="5">
                                    <form:form servletRelativeAction="/ckecks/newCheck/delete?index=${loop.index}">
                                        <button type="submit" class="btn btn-outline-danger">
                                            <i class="fa fa-times" aria-hidden="true"></i></button>
                                    </form:form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="4" class="text-right">All sum:</td>
                            <td class="text-left font-weight-bold">${currentCheck.summa} USD</td>
                            <td></td>
                        </tr>
                        </tfoot>
                    </table>
                </div>

                <h2>Оформление заказа: </h2>
                <div class="row  justify-content-center">
                    <div class="col-12 col-sm-10 col-md-6 col-lg-6">
                        <form:form modelAttribute="currentCheck">
                            <div class="form-group">
                                <label for="name">Имя:</label>
                                <form:input path="name" class="form-control"/>
                                <form:errors path="name" class="text-danger"/>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <form:input path="email" class="form-control"/>
                                <form:errors path="email" class="text-danger"/>
                            </div>
                            <div class="form-group">
                                <label for="phone">Телефон:</label>
                                <form:input path="phone" id="phone" class="form-control"/>
                                <form:errors path="email" class="text-danger"/>
                            </div>

                            <div class="form-group text-center">
                                <button type="submit" class="btn btn-dark">Отправить заказ</button>
                            </div>
                        </form:form>
                    </div>
                </div>

            </c:if>

        </div>

    </div>
</div>
<jsp:include page="../components/footer.jsp"/>
</body>
</html>
