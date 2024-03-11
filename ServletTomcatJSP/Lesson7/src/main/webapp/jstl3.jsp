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
		<c:set var="examResult" value="80" scope="request" />
		<c:set var="name" value="admin" scope="request" />

		<c:if test="${examResult > 65}">
			<!-- 				   == -> eq
								   != -> ne
								   > -> gt
								   < -> lt
								   >= -> ge
								   <= -> le
								   || -> or
								   && -> and
								   ! -> not 
			-->
			<p>Sinavi gectin</p>
		</c:if>
		
		<% String result = (String)request.getAttribute("examResult");
		if (Integer.parseInt(result) > 65) {
		%>
		<%="<p>Sinavi gectin Java</p>" %>
		<% } %>
		
		<c:if test="${name eq 'admin'}">
			<p>welcome admin!</p>
		</c:if>
		
		<c:set var="salary" value="50000" scope="request" />
		
		<c:choose>
			<c:when test="${salary lt 15000}">
				<p>Dusuk maas</p>
			</c:when>
			<c:when test="${salary eq 50000}">
				<p>Iyi maas</p>
			</c:when>
			<c:otherwise>
				<p>Super maas</p>
			</c:otherwise>
		</c:choose>
</body>
</html>