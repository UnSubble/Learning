package _03.uriinfo.service;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path("/uriInfo-path")
public class URIInfoResource {

	@GET
	@Path("/test1")
	// http://localhost:8080/lesson5/resteasy/uriinfo-path/test1?queryParam=value1
	public String test1UriInfo(@Context UriInfo uriInfo) {

		URI requestURI = uriInfo.getRequestUri(); //
		//getRequestUri metodu, absolute URI döner ek olarak query parametresiyle birlikte.

		URI absolutePathURI = uriInfo.getAbsolutePath();
		//query paremetresini donmez.
		
		URI baseURI = uriInfo.getBaseUri();

		System.out.println(requestURI);
		System.out.println(absolutePathURI);
		System.out.println(baseURI);

		return "UriInfoResource#test1UriInfo";
	}
	
	@GET
	@Path("/test2")
	// http://localhost:8080/lesson5/resteasy/uriinfo-path/test2
	public String test2UriInfo(@Context UriInfo uriInfo) {
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.queryParam("startIndex", 10);
		builder.queryParam("endIndex", 20);
		URI uri = builder.build();
		return uri.toString();
	}
	
}
