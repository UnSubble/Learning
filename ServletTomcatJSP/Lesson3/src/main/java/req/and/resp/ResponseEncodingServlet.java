package req.and.resp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/resp")
public class ResponseEncodingServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("ISO-8859-9");
		PrintWriter pw = resp.getWriter();
		// pw.println("ıİşŞçÇöÖüÜğĞ"); // her iki uçta da kullanılan charset encoding'in aynı olması gerek.
		pw.println("""
				<!DOCTYPE html>
				<html>
				<head>
					<meta charset="UTF-8"> 
				</head>
				<body>
					<p> ıİşŞçÇöÖüÜğĞ </p>
				</body>
				</html>
				"""); 
	}
}
