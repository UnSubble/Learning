<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>${cookie.username.value}</p>
	<p><%=request.getMethod() %></p>
	<p>${pageContext.request.method}</p>
	<br>
	<p><%=request.getHeader("host")%></p>
	<p>${header.host}</p>
	<br>
	<p>${myAttribute}</p>
	<p>${requestScope.myAttribute}</p>
	<p>${sessionScope.myAttribute}</p>
	<br>
	<p>${foo}</p> <!-- exception fırlatmaz -->
	<p>${foo[bar]}</p> <!-- exception fırlatmaz -->
	<br>
	<p>${100+foo}</p> <!-- 100-> exception fırlatmaz -->
	<p>${100/foo}</p> <!-- Infinity-> exception fırlatmaz -->
	<p>${100*foo}</p> <!-- 0-> exception fırlatmaz -->
	<br>
	<p>${100 < foo}</p> <!-- false -->
	<p>${100 == foo}</p> <!-- false -->
	<p>${foo == foo}</p> <!-- true -->
	<p>${100 != foo}</p> <!-- true -->
	<p>${true and foo}</p> <!-- false -->
	<p>${true or foo}</p> <!-- true -->
	<p>${not foo}</p> <!-- true -->
	<br>
	
</body>
</html> 