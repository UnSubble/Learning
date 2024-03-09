package jsp.action.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jsp.action.Person;

@WebServlet(urlPatterns = "/person")
public class PersonController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Person person1 = new Person("name", "surname", 20);
		req.setAttribute("model", person1);
		//RequestDispatcher dispatcher = req.getRequestDispatcher("person.jsp");
		//dispatcher.forward(req, resp);
		RequestDispatcher dispatcher = req.getRequestDispatcher("personUseBean.jsp");
		dispatcher.forward(req, resp);
	}
}
