package handle.request;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/context")
public class ContextServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		context = getServletConfig().getServletContext(); // üsttekinin aynısı...

		PrintWriter pw = resp.getWriter();
		pw.println(context.getInitParameter("role"));
		pw.println(this.getServletConfig().getInitParameter("role"));
		
		String realPath = context.getRealPath("/test.txt");
		System.out.println(realPath);
		
		String contextPath = context.getContextPath();
		System.out.println(contextPath);
		
		String serverInfo = context.getServerInfo();
		System.out.println(serverInfo);
	}
}