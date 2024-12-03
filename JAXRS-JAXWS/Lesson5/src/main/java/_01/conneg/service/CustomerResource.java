package _01.conneg.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cutomer-root")
public class CustomerResource {

	@GET
	@Path("/customer")
	@Produces(MediaType.TEXT_HTML)
	public String getCustomerText() {
		System.out.println("getCustomerText");
		return new Customer(1, "isim", "soyisim").toString();
	}

	@GET
	@Path("/customer")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomerJson() {
		System.out.println("getCustomerJSON");
		return new Customer(1, "isim", "soyisim");
	}

	@GET
	@Path("/customer")
	@Produces(MediaType.APPLICATION_XML)
	public Customer getCustomerXml() {
		System.out.println("getCustomerXML");
		return new Customer(1, "isim", "soyisim");
	}

	@GET
	@Path("/customer")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Customer getCustomerXmlJSon() {
		System.out.println("getCustomerXMLJSON");
		return new Customer(1, "isim", "soyisim");
	}
}
