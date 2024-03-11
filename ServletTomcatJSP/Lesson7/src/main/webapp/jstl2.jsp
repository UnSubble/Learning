<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List, java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<c:forEach begin="1" end="10" var="number">
			<p> <c:out value="${number}"/> </p>
		</c:forEach>
		
		<%
			int[] arr = {1,2,344,678,567,798};
			request.setAttribute("numArray", arr);
		%>
		
		<c:forEach var="i" items="${numArray}">
			<p> <c:out value="${i}"></c:out> </p>
		</c:forEach>
		
		<br>
		
		<c:forEach var="i" items="${numArray}" varStatus="loopStatus">
			${loopStatus.index} -> ${i} <br>
		</c:forEach>
		
		<%
			List<Integer> list = List.of(2,5,67,8,7,5,9);
			request.setAttribute("myList", list);
		%>
		
		<c:forEach var="i" items="${myList}"> 
			<p> ${i} </p>
		</c:forEach>
		
		<%
			Map<Integer, Integer> map = Map.of(1, 12, 2, 456, 3, 45, 4, 78);
			request.setAttribute("myMap", map);
		%>
		
		<c:forEach var="entry" items="${myMap}">
			<p> ${entry.key} -> ${entry.value} </p>
		</c:forEach>
		
		<br>
		
		<c:forTokens items="key1,key2,key3,key4" delims="," var="e">
			<span>${e} </span>
		</c:forTokens>
</body>
</html>