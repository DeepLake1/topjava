<%--
  Created by IntelliJ IDEA.
  User: sawk
  Date: 08.10.2020
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="ru">

<head>
    <title>Meals</title>
</head>
<body>
<h2><c:forEach var="meal" items="${mealList}">
    <p>${meal}</p>
    <c:set var ="dateTime" value ="${meal.dateTime}"/>
    <fmt:parseDate value="${dateTime}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
    <p><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value="${parsedDateTime}" /></p>
</c:forEach>
</h2>

</body>
</html>
