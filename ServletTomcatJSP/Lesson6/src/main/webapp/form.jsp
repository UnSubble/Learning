<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- param adındaki özel object ile form'daki element'lere erişim sağlayabiliriz. -->
	<span>${param.username}</span>
	<span>${param.password}</span>
	<span>${paramValues.check[0]}</span>
	<span>${paramValues.check[1]}</span>
</body>
</html>