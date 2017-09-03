<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>All material for cooking</title>
</head>
<body>

<c:if test="${products.size() == 0}">
    Material на данный момент отсутствует
</c:if>




<c:forEach var="product" items="${products}" >

    <strong>${product.id}</strong>
    <strong>${product.name}</strong>
    <strong>${product.priceForSale}</strong>
    <strong>${product.category}</strong>
<b>
    <c:forEach var="material" items="${product.materials}" >
        <strong>${material.id}</strong>
        <strong>${material.price}</strong>
        <strong>${material.name}</strong>
        <strong>${material.provider}</strong>
    </c:forEach>
</b>
    <p> SOMETING </p>
</c:forEach>




</body>
</html>
