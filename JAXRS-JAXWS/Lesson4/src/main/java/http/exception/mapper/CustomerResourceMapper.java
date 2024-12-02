package http.exception.mapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import http.exception.Customer;

@Path("/customer-exceptionmapper")
public class CustomerResourceMapper {
	
	@GET
	@Path("/customer/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@PathParam("id") int id) {
		if (id == 1) {
			throw new CustomerNotFoundException("Customer not found: " + id);
		}
		return new Customer(id, "name", "surname");
	}
}
