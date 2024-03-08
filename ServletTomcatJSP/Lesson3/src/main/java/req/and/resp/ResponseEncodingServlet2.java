package req.and.resp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/resp2")
public class ResponseEncodingServlet2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("ISO-8859-9");
		PrintWriter pw = resp.getWriter();
		pw.println("""
				<!DOCTYPE html>
				<html>
				<head>
					<meta charset="ISO-8859-9"> 
				</head>
				<body>
					<p> ıİşŞçÇöÖüÜğĞ </p>
				</body>
				</html>
				"""); // set'lediğimiz charset ile html'deki charset aynı olmalıdır.
	}
}
