<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>Users</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>

<table  style="border-collapse: collapse;">
    <caption>Дневник еды</caption>
    <tr>
        <th>Название</th>
        <th>Калории</th>
        <th>Время</th>
        <th>Пережор</th>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr style=" padding: 5px ">
            <td style="text-align: center; color: ${item.excess ? 'red' : 'green'}">${item.description}</td>
            <td style="text-align: center; color: ${item.excess ? 'red' : 'green'}">${item.calories}</td>
            <td style="text-align: center; color: ${item.excess ? 'red' : 'green'}">${item.dateTime.toLocalDate()} ${item.dateTime.toLocalTime()}</td>
            <td style="text-align: center; color: ${item.excess ? 'red' : 'green'}">${item.excess}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
