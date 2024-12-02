package client.api._02;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/library-client-api")
public class LibraryResource {

	@GET
	@Path("/welcome")
	@Produces(MediaType.TEXT_PLAIN)
	public Response welcome() {
		ResponseBuilder builder = Response.ok();
		return builder.build();
	}
	
	@GET
	@Path("/book/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBook(@PathParam("id") int id) {
		Book book = new Book("sdaf");
		ResponseBuilder builder = Response.ok(book);
		return builder.build();
	}
}
