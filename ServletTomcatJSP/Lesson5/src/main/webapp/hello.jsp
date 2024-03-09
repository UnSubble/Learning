<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List, java.util.ArrayList" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Document</title>
</head>
<body>
    <% // JSP Scriptlet
    	System.out.println("Hello JSP File");
    %>
    
    <%
    	String user = "admin user"; // Bütün kodlar local değişkendir. File translate edilince aynı metot 
    									// içerisinde yer alır.
    %>
    
    <%=user %>
    <!-- expression sonrasında ';' koyulmaz! 
    '='i unutma yoksa scriptlet olur.
    '<' ile '%' arasında boşluk olmasın. -->
    
    <%!
    	public int calculate(int n) {
    	return n + 3;
    }
    %>
    
    <%=calculate(4) %>
    
    <!-- Bu yorum browser'da gözükür. -->
    <%-- Bu yorum browser'da gözükmez. --%>
    
    
    <%
    	request.setAttribute("reqAttr", 1000);
    	session.setAttribute("str", "val");
    	application.setAttribute("app", "val2");
    	pageContext.setAttribute("page", 123);
    	pageContext.setAttribute("session", 123, PageContext.SESSION_SCOPE); // session scope'a ekler.
    %>
    
	<h1>Hello JSP</h1>
</body>
</html>