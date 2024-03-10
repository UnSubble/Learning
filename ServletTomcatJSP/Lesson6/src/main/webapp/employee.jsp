<%@ page import="model.Employee" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Employee employee = (Employee) request.getAttribute("employeeAttribute"); %>
	<%=employee.getId() %>
	<%=employee.getName() %>
	<%=employee.getSalary() %>
	<%=employee.getDepartment().getName() %>
	
	<br>
	
	<jsp:useBean id="employeeAttribute" class="model.Employee" scope="request"/>
	<jsp:getProperty property="id" name="employeeAttribute"/>
	<jsp:getProperty property="name" name="employeeAttribute"/>
	<jsp:getProperty property="salary" name="employeeAttribute"/>
	<!-- department'ın property'lerine ulaşamayız. -->
	
	<br>
	
	<!-- Expression Language -->
	<p> ${employeeAttribute.id} </p>
	<p> ${employeeAttribute.name} </p>
	<p> ${employeeAttribute.salary} </p>
	<p> ${employeeAttribute.department.name} </p>
	
	<br>
	
	<p> ${myMap.key1} </p>	
	<p> ${myMap.key2} </p>
	<p> ${myMap.key3} </p>
	<p> ${myMap.key4} </p> <!-- Map'te hata veya null değer vermez. (Map'in kendisi de yoksa hata vermez.) -->
	
	<br>
	
	<p> ${employeeAttribute['id']} </p>
	<p> ${employeeAttribute['name']} </p>
	<p> ${employeeAttribute['salary']} </p>
	<p> ${employeeAttribute['department']['name']} </p>
	
	<br>
	
	<p> ${myMap['key1']} </p>
	<p> ${myMap['key2']} </p>
	<p> ${myMap['key3']} </p>
	
	<br>
	
	<p> ${myList[0]} </p>
	<p> ${myList['0']} </p>
	<p> ${myList["0"]} </p>
	<p>	${myArray[3]} </p>
</body>
</html>