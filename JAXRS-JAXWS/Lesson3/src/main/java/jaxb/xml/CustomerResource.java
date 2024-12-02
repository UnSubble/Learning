package jaxb.xml;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/customer-jaxb-xml")
public class CustomerResource {

	@GET
	@Path("/customer")
	@Produces(MediaType.APPLICATION_XML)
	public Customer getCustomer() {
		Address address = new Address("Balıkesir", "10000");
		Customer customer = new Customer(1, "name", "surname", address);
		return customer;
	}
}
