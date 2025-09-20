<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { border-collapse: collapse; width: 100%; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background: #f2f2f2; }
        .form-container { margin-bottom: 30px; padding: 15px; border: 1px solid #ddd; border-radius: 5px; }
        .form-container h2 { margin-top: 0; }
        label { display: inline-block; width: 150px; }
        input, select, textarea { padding: 6px; width: 250px; }
        .submit-btn { margin-top: 10px; }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Products</h2>
    <%--@elvariable id="product" type="com.unsubble.lesson4._01.model.Product"--%>
    <form:form method="post" modelAttribute="product">

        <div>
            <label for="productId">Id:</label>
            <form:input path="productId" id="productId"/>
            <form:errors path="productId" />
        </div>

        <div>
            <label for="name">Name:</label>
            <form:input path="name" id="name"/>
        </div>

        <div>
            <label for="price">Price:</label>
            <form:input path="price" id="price"/>
        </div>

        <div>
            <label for="description">Description:</label>
            <form:textarea path="description" id="description"/>
        </div>

        <div>
            <label for="manufacturer">Manufacturer:</label>
            <form:radiobuttons path="manufacturer" items="${manufacturerMap}" cssStyle="width: 75px"/>
        </div>

        <div>
            <label for="category">Category:</label>
            <form:input path="category" id="category"/>
        </div>

        <div>
            <label for="unitsInStock">Units In Stock:</label>
            <form:input path="unitsInStock" id="unitsInStock" type="number"/>
        </div>

        <div>
            <label for="condition">Condition:</label>
            <form:select path="condition" items="${conditionsList}" />
        </div>

        <div class="submit-btn">
            <input type="submit" value="Save"/>
        </div>

    </form:form>
</div>

<h2>All Products</h2>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Manufacturer</th>
        <th>Category</th>
        <th>Units In Stock</th>
        <th>Condition</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.productId}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.description}</td>
            <td>${p.manufacturer}</td>
            <td>${p.category}</td>
            <td>${p.unitsInStock}</td>
            <td>${p.condition}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
