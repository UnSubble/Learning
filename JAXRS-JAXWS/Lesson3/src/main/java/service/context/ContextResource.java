package service.context;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

// context annotatiion'ı ile bu sınıfları kullanabiliyoruz.
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.ws.rs.core.HttpHeaders;
//import javax.ws.rs.core.Request;
//import javax.ws.rs.core.SecurityContext;
//import javax.ws.rs.core.UriInfo;

@Path("/context")
public class ContextResource {
	
	@GET
	@Path("/servletcontext")
	public String injectServletContext(@Context ServletContext context) {
		return context.getContextPath();
	}
	
	
	@GET
	@Path("/servletrequest")
	public String injectHttpServletRequest(@Context HttpServletRequest request) {
		return request.getContextPath();
	}
}
