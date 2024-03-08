package req.and.resp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Locale;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/req")
public class RequestPostForm extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		String[] checks = req.getParameterValues("check");
		resp.getWriter().printf("%s %s %s %n", name, pass, Arrays.toString(checks));
		
		PrintWriter writer = resp.getWriter();
		
		Locale locale = req.getLocale();
		int localPort = req.getLocalPort();
		int serverPort = req.getServerPort();
		String remoteAddr = req.getRemoteAddr();
		ServletContext context = req.getServletContext();
		String hostName = req.getHeader("host");
		Enumeration<String> headerNames = req.getHeaderNames();
		
		writer.println();
		writer.println(locale);
		writer.println(localPort);
		writer.println(serverPort);
		writer.println(remoteAddr);
		writer.println(context);
		writer.println(hostName);
		writer.println();
		
		while (headerNames.hasMoreElements()) {
			String hname = headerNames.nextElement();
			String hvalue = req.getHeader(hname);
			writer.println(hname + " " + hvalue);
		}
	}
}
