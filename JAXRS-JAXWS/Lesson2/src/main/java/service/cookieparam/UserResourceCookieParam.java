package service.cookieparam;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/user-cookieparam")
public class UserResourceCookieParam {
	
	@GET
	@Path("addCookie")
	public Response addCookie() {
		String resultMessage = "addCookie is invoked";
		ResponseBuilder builder = Response.ok(resultMessage);
		builder.cookie(new NewCookie("myCookie", "cookieValue"));
		return builder.build();
	}

	@GET
	@Path("/addcookie")
	public String getCookie(@CookieParam("myCookie") String cookie) {
		return cookie;
	}
	
	@GET
	@Path("/getCookieWithContext")
	public Response getCookieWithContext(@Context HttpHeaders headers) {
		String result = "getCookieWithContext";
		for(String name : headers.getCookies().keySet()) {
			Cookie cookie = headers.getCookies().get(name);
			result = result + "Cookie: " + cookie.getName() + " ," + cookie.getValue();
		}
		ResponseBuilder builder = Response.ok(result);
		return builder.build();
	}
}
