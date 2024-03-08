package com.unsubble.main;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello, Servlet!");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<h1> Header </h1>");
		pw.println("Hello, Servlet!");
	}
	
}
