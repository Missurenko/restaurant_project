<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>${title != null ? "iShop | ".concat(title) : "iShop"}</title>

    <%-- http://www.favicon-generator.org --%>

    <link rel="manifest" href="<c:url value="/resources/img/favicon/manifest.json"/>"/>
    <meta name="msapplication-TileColor" content="<c:url value="#ffffff"/>"/>

    <meta name="theme-color" content="<c:url value="#ffffff"/>"/>

    <link rel="stylesheet" href="<c:url value="/resources/lib/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/lib/font-awesome/css/font-awesome.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
    <script href="<c:url value="/resources/lib/js/jquery.3.2.1.js/"/>"></script>
    <script href="<c:url value="/resources/lib/js/popper.js/"/>"></script>
    <script href="<c:url value="/resources/lib/js/bootstrap.min.js"/>"></script>
    <script href="<c:url value="/resources/js/scripts.js"/>"></script>
</head>

