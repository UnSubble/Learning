package handle.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConfigServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletConfig config = this.getServletConfig();
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		
		PrintWriter pw = resp.getWriter();
		pw.printf("""
				<!DOCTYPE html>
				<html lang="tr">
					<head>
						<meta charset="UTF-8">
					</head>
					<body>
						<p>%s</p>
						<p>%s</p>
					</body>
				</html>%n	
				""", username, password);
		
		ServletContext context = this.getServletContext();

	}
}
