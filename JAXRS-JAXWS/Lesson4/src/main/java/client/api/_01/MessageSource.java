package client.api._01;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/message-client-api")
public class MessageSource {

	@GET
	@Path("/message")
	public String getMessage() {
		System.out.println("getMessage is invoked!");
		return "hello client!";
	}
	
	@GET
	@Path("/messages")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getMessages() {
		System.out.println("getMessages is invoked!");
		return Arrays.asList("hello client!", "123", "4567");
	}
}
