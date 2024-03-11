<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<c:out value="test" />
		<%="<h1>expression</h1>"%>
		<c:out value="<h1>expression</h1>" />
		<c:set var="sessionAttribute" scope="session" value="my value"></c:set>
		<p>
			<c:out value="${sessionAttribute}" />
		</p>
		<c:remove var="sessionAttribute" />
		<p>
			<c:out value="${sessionAttribute}"></c:out>
		</p>
	</div>
</body>
</html>