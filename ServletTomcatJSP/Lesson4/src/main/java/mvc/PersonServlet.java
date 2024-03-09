package mvc;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/person.servlet")
public class PersonServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message = "request attribute message";
		
		req.setAttribute("message", message);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("person.jsp");
		dispatcher.forward(req, resp); // req ve resp objelerini jsp'ye yönlendirdik. Url de değişmez.
	}
}
