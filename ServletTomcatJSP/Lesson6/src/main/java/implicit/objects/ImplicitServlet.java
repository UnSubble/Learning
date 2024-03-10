package implicit.objects;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/implicit")
public class ImplicitServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = new Cookie("username", "admin");
		resp.addCookie(cookie);
		
		req.setAttribute("myAttribute", "request attribute");
		req.getSession().setAttribute("myAttribute", "session attribute");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("implicit.jsp");
		dispatcher.forward(req, resp);
	}
}
