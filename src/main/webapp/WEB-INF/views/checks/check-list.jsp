<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:set var="title" value="Предыдущие заказы" scope="request"/>
<jsp:include page="../components/head.jsp"/>
<body>
<jsp:include page="../components/header.jsp"/>
<div id="main" class="container">
    <div class="row">

        <div class="col-12 mt-5">

            <h1 class="text-center">Предыдущие заказы</h1>

            <c:if test="${checks.size() == 0}">
                <div class="alert alert-dark">
                    Истоиря заказов на данный момент отсутствует
                </div>
            </c:if>

            <table class="table mt-3 table-responsive">
                <tbody>
                <c:forEach items="${checks}" var="check">
                    <tr class="table-dark">
                        <th>Дата</th>
                        <%--<td colspan="2">${check.dateTime.format(dateTimeFormatter)}</td>--%>
                    </tr>
                    <tr>
                        <th>Имя</th>
                        <th>Товары</th>
                        <th>Общая сумма</th>
                    </tr>
                    <tr>
                        <td>${check.name}</td>
                        <td>
                            <c:forEach items="${check.productList}" var="product">
                                ${product.name} ${product.text}<br/>
                            </c:forEach>
                        </td>
                        <td>${check.summa}</td>
                    </tr>
                    <tr>
                        <th>Почта</th>
                        <th>Телефон</th>

                    </tr>
                    <tr>
                        <td>${check.email}</td>
                        <td>${check.phone}</td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="text-center text-sm-left mt-5">
                <a href="<c:url value="/"/>" class="btn btn-light">
                    <i class="fa fa-chevron-left" aria-hidden="true"></i>
                   To main
                </a>
            </div>

        </div>
    </div>
</div>
<jsp:include page="../components/footer.jsp"/>
</body>
</html>
