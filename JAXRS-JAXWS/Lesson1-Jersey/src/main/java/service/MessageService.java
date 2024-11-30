package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/messages")
public class MessageService {
	
	@GET
	@Path("/hello")
	public String getMessage() {
		return "Hello, Jersey!";
	}
}
