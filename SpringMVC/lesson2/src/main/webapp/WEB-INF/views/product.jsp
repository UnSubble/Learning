<%--
  Created by IntelliJ IDEA.
  User: unsubble
  Date: 2025-09-15
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>Name: ${product.name}<br>
        Price: $${product.price}<br>
        Description: ${product.description}<br>
        Manufacturer: ${product.manufacturer}<br>
        Category: ${product.category}<br>
        Stock: ${product.unitsInStock} items<br>
        Condition: ${product.condition}<br>
    </div>
</body>
</html>
