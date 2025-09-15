<%--
  Created by IntelliJ IDEA.
  User: unsubble
  Date: 2025-09-15
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="i" items="${products}">
        <div>Name: ${i.name}<br>
            Price: $${i.price}<br>
            Description: ${i.description}<br>
            Manufacturer: ${i.manufacturer}<br>
            Category: ${i.category}<br>
            Stock: ${i.unitsInStock} items<br>
            Condition: ${i.condition}<br>
            <span><a href="${i.productId}">Go</a></span></div>
        <hr>
    </c:forEach>
</body>
</html>
