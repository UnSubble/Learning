<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="model" class="jsp.action.Person" scope="request"/>
	<jsp:getProperty property="name" name="model"/>
	<jsp:getProperty property="surname" name="model"/>
	<jsp:getProperty property="age" name="model"/>
</body>
</html>