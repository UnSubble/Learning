package handle.request;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/config2", initParams = {@WebInitParam(name = "username", value = "admin") ,
														@WebInitParam(name = "password", value = "123456")})
public class ConfigServletAnnotation extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletConfig config = this.getServletConfig();
		PrintWriter pw = resp.getWriter();
		pw.printf("<html> <body> %s <br> %s </body> </html>%n", 
				config.getInitParameter("username"), config.getInitParameter("password"));
	}
}
