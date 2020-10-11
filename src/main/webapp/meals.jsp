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

<table border = "2">
    <caption>Meals</caption>
    <tr>
    <th>Date</th>
    <th>Description</th>
    <th> Calories</th>
    <th> </th>
    <th> </th>
    </tr>
<c:forEach var="meal" items="${mealList}">
    <jsp:useBean id="meal" scope="page" type = "ru.javawebinar.topjava.model.MealTo"/>
   <tr bgcolor="${meal.excess == true ? 'green' : 'red'}">
        <td><c:set var ="dateTime" value ="${meal.dateTime}"/>
    <fmt:parseDate value="${dateTime}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
    <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value="${parsedDateTime}" />
        </td>
        <td>${meal.description}</td>
        <td>${meal.calories}</td>
       <td><form>
           <button>Update</button>
       </form></td>
       <td><form>
           <button>Delete</button>
           </form></td>
    </tr>


</c:forEach>
</table>
<form>
    <button>Add Meal</button>
</form>

</body>
</html>
