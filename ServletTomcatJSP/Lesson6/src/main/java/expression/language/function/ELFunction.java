package expression.language.function;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/function")
public class ELFunction extends HttpServlet {
	
	// public static olmalı
	public static int sumNumber(int number1, int number2) {
		return number1 + number2;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("elFunction.jsp");
		dispatcher.forward(req, resp);
	}
}
