package service.headerparam;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

@Path("/login-headerparam")
public class LoginResourceHeaderParam {

	@GET
	@Path("/user-agent")
	public String getUserAgent(@HeaderParam("user-agent") String userAgent) {
		return userAgent;
	}
	
	@GET
	@Path("/headerinfo")
	public String getHeadersInfo(@Context HttpHeaders headers) {
		String message = "";
		for (String headerName : headers.getRequestHeaders().keySet()) {
			message = message + "<br/>" + headerName + ": " + headers.getRequestHeader(headerName);
		}
		return message;
	}
}
