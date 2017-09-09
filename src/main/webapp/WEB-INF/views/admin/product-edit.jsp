<%@ page import="edu.bionic.domain.Color" %>
<%@ page import="edu.bionic.domain.my.Category" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<c:set var="title" value="Редактирование продукта" scope="request"/>
<jsp:include page="../components/head.jsp"/>
<body>
<jsp:include page="../components/header.jsp"/>
<div id="main" class="container">
    <div class="row">
        <div class="col-12 mt-5">

            <h1 class="text-center">${isNew ? "Новый товар" : "Редактирование товара №".concat(product.id)}</h1>

            <c:if test="${updateIsSuccessful}">
                <div class="alert alert-success mt-5">Изменения сохранены</div>
            </c:if>

            <form:form modelAttribute="product">
                <form:hidden path="id"/>
                <div class="form-group">
                    <label for="name">Name</label>
                    <form:input path="name" class="form-control"/>
                    <form:errors path="name" class="text-danger"/>
                </div>
                <div class="form-group">
                    <label for="price">Price</label>
                    <form:input path="priceForSale" class="form-control"/>
                    <form:errors path="priceForSale" class="text-danger"/>
                </div>
                <div class="form-group">
                    <label for="text">Category</label>
                    <form:radiobuttons path="category" items="<%= Category.values()%>"/>
                    <form:errors path="category" class="text-danger"/>
                </div>
                <div class="form-group">
                    <label for="text">Text</label>
                    <form:input path="text" class="form-control"/>
                    <form:errors path="text" class="text-danger"/>
                </div>
                <div class="form-group">
                    <div class="row justify-content-between">
                        <div class="col-auto">
                            <a href="<c:url value="/admin/products"/>" class="btn btn-light">
                                <i class="fa fa-chevron-left" aria-hidden="true"></i>
                                Return
                            </a>
                        </div>
                        <div class="col-auto">
                            <button type="submit" class="btn btn-dark">Save</button>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>

<jsp:include page="../components/footer.jsp"/>
</body>
</html>
