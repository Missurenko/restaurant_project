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

<c:if test="${materials.size() == 0}">
    Material на данный момент отсутствует
</c:if>


${materials.size()}
<c:forEach var="material" items="${materials}" >

    <strong>${material.id}</strong>
    <strong>${material.price}</strong>
    <strong>${material.name}</strong>
    <strong>${material.provider}</strong>


<p> SOMETING </p>

</c:forEach>



</body>
</html>
