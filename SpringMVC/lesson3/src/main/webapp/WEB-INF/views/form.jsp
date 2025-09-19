<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
    <meta charset="UTF-8">
    <title><spring:message code="form.title"/></title>
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

<div>
    <a href="<c:url value='/products/form?language=en'/>">en</a>
    <a href="<c:url value='/products/form?language=tr'/>">tr</a>
</div>

<div class="form-container">
    <h2><spring:message code="form.title"/></h2>
    <%--@elvariable id="product" type="com.unsubble.lesson2._01.model.Product"--%>
    <form:form method="post" modelAttribute="product">

        <div>
            <label for="productId"><spring:message code="form.productId"/>:</label>
            <form:input path="productId" id="productId"/>
            <form:errors path="productId" />
        </div>

        <div>
            <label for="name"><spring:message code="form.name"/>:</label>
            <form:input path="name" id="name"/>
        </div>

        <div>
            <label for="price"><spring:message code="form.price"/>:</label>
            <form:input path="price" id="price" type="number" step="0.01"/>
        </div>

        <div>
            <label for="description"><spring:message code="form.description"/>:</label>
            <form:textarea path="description" id="description"/>
        </div>

        <div>
            <label for="manufacturer"><spring:message code="form.manufacturer"/>:</label>
            <form:radiobuttons path="manufacturer" items="${manufacturerMap}" cssStyle="width: 75px"/>
        </div>

        <div>
            <label for="category"><spring:message code="form.category"/>:</label>
            <form:input path="category" id="category"/>
        </div>

        <div>
            <label for="unitsInStock"><spring:message code="form.unitsInStock"/>:</label>
            <form:input path="unitsInStock" id="unitsInStock" type="number"/>
        </div>

        <div>
            <label for="condition"><spring:message code="form.condition"/>:</label>
            <form:select path="condition" items="${conditionsList}" />
        </div>

        <div class="submit-btn">
            <input type="submit" value="<spring:message code='form.save'/>"/>
        </div>

    </form:form>
</div>

<h2><spring:message code="list.title"/></h2>
<table>
    <thead>
    <tr>
        <th><spring:message code="list.id"/></th>
        <th><spring:message code="list.name"/></th>
        <th><spring:message code="list.price"/></th>
        <th><spring:message code="list.description"/></th>
        <th><spring:message code="list.manufacturer"/></th>
        <th><spring:message code="list.category"/></th>
        <th><spring:message code="list.unitsInStock"/></th>
        <th><spring:message code="list.condition"/></th>
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
