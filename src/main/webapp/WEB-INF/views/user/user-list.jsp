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

<c:if test="${users.size() == 0}">
    Material на данный момент отсутствует
</c:if>




<c:forEach var="user" items="${users}" >

    <strong>${user.id}</strong>
    <strong>${user.email}</strong>
    <strong>${user.password}</strong>
    <strong>${user.name}</strong>
    <strong>${user.salary}</strong>
    <strong>${user.dateStartWork}</strong>
    <strong>${user.sex}</strong>

    <%--<strong>${user.role.name}</strong>--%>
    <p> SOMETING </p>
</c:forEach>

</body>
</html>
