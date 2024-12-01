package service.queryparam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("/library-queryparam")
public class LibraryResourceQueryParam {

	// GET: http://localhost:8080/Lesson2/resteasy/library-queryparam/book?id=5
	// RETURNED: getBookById: 5
	
	// .../path?queryParam=value&queryParam2=value2&queryParam3=value3
	@GET
	@Path("/book")
	public String getBookById(@QueryParam("id") int id) {
		return "getBookById: " + id;
	}
	
	@GET
	@Path("/books")
	public String getBooks(@QueryParam("start") int start, @QueryParam("end") int end) {
		return "getBooks: " + start + " to " + end;
	}
	
	@GET
	@Path("/book-uri-info")
	public String getBooksUTIInfo(@Context UriInfo uriInfo) {
		String id = uriInfo.getQueryParameters().getFirst("id");
		return id;
	}
}
