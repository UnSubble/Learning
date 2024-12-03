package _03.link.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;

@Path("/link-root")
public class LinkResource {

	@GET
	@Path("/test1")
	public Response test1LinkMethod() {
		// rel : relation
		// https://tools.ietf.org/html/rfc5988
		Link link1 = Link.fromUri("http://localhost/root/customers/all").rel("section").type("text/plain").build();

		Link link2 = Link.fromUri("http://{host}/root/customers/{id}").rel("self").type("text/plain").build("localhost",
				"1234");

		System.out.println(link1.toString());
		System.out.println(link2.toString());

		Response response = Response.ok("Check Response Header!").links(link1, link2).build();
		return response;
	}
}
