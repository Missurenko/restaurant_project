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
    <title>All checks</title>
</head>
<body>

<c:if test="${checks.size() == 0}">
    checks на данный момент отсутствует
</c:if>


${checks.size()}
<c:forEach var="check" items="${checks}" >

    <strong>${check.id}</strong>
    <strong>${check.position}</strong>
    <strong>${check.datePay}</strong>
    <c:forEach var="product" items="${products}" >

        <strong>${product.id}</strong>
        <strong>${product.name}</strong>
        <strong>${product.priceForSale}</strong>
        <strong>${product.category}</strong>
        <b>

        </b>
    </c:forEach>

    <p> SOMETING </p>

</c:forEach>



</body>
</html>
