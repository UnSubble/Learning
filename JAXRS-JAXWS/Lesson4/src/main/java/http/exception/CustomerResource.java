package http.exception;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer-exception")
public class CustomerResource {

	@GET
	@Path("/customer/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@PathParam("id") int id) {
		if (id == 1) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return new Customer(id, "name", "surname");
	}
}
