package service.path;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/customer")
public class CustomerResource {

	@GET // eğer path annotation'ı kullanılmayacaksa her Http isteğine karşılık bir method tanımlanabilir.
	public String greeting() {
		return "CustomerResource#greeting";
	}
	
	@POST
	public String greeting2() {
		return "CustomerResource#greeting2";
	}
}
