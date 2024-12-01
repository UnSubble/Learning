package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/messages")
public class MessageService {
	
	@GET
	@Path("/message1")
	public String getMessage() {
		return "Hello, again!";
	}
}
