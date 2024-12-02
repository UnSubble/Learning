package http.response._01;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/http-response")
public class HttpResponseResource {

	@GET
	@Path("response200") // HTTP CODE: [200, 399] -> successful
	public String response200() {
		return "hello, response200!";
	}

	@GET
	@Path("responseNull") // HTTP CODE: 204 -> no content
	public String responseNull() {
		return null;
	}

	@POST // GET isteği atarsak:
	@Path("response405") // HTTP CODE: 405 -> method not allowed
	public String response405() {
		return "response405 is invoked.";
	}
}
