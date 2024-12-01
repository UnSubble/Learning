package service.pathparam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/customer-pathparam")
public class CustomerResourcePathParam {

	@GET
	@Path("/customer/{id}") // -> illaki /{id} olmasına gerek yok. -{id} gibi de yapabiliyoruz.
							// veya birden fazla parametre de gönderebiliriz. {id}/{name}...
	public String getCustomerById(@PathParam("id") String customerId) {
		return "CustomerResourcePathParam#Customer?customerId=" + customerId;
	}
	
	@GET
	@Path(value = "/customer-date/{date : \\d{2}\\-\\d{2}\\-\\d+}") // böylelikle regEx de tanımlayabiliyoruz.
	public String getCustomerDate(@PathParam("date") String date) {
		return "CustomerResourcePathParam#Customer?date=" + date;
	}
}
