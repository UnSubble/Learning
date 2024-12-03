package _03.link.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

@Path("/customer-link")
public class CustomerResource {

	@GET
	@Path("/customer/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Customer getCustomer(@PathParam("id") int id) {

		Customer customer = new Customer(id, "isim", "soyisim");

		UriBuilder builder = UriBuilder.fromResource(CustomerResource.class).path(CustomerResource.class,
				"updateCustomer");

		Link updateLink = Link.fromUri(builder.build()).rel("update").build();

		builder = UriBuilder.fromResource(CustomerResource.class).path(CustomerResource.class, "deleteCustomer");
		Link deleteLink = Link.fromUri(builder.build()).rel("delete").build();

		List<Link> links = new ArrayList<>();

		links.add(updateLink);
		links.add(deleteLink);

		customer.setLinks(links);
		return customer;
	}

	@PUT
	@Path("/customer.update")
	@Consumes(MediaType.APPLICATION_XML)
	public void updateCustomer(Customer customer) {

	}

	@DELETE
	@Path("/customer.delete")
	public void deleteCustomer(int id) {

	}

}
