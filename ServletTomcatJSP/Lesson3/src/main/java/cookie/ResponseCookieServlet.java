package cookie;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cookies")
public class ResponseCookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie username = new Cookie("admin", "subble");
		resp.addCookie(username);
		
		Cookie[] cookies = req.getCookies();
		if (cookies != null && cookies.length > 0)
			System.out.println(Arrays.toString(cookies));
	}
}

// cookieler client'in bilgisayarında saklanan küçük bilgilerdir.
// cookieler özel header'lardır.
