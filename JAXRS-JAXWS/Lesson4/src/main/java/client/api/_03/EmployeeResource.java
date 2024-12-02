package client.api._03;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/employee-client-api")
public class EmployeeResource {

	@POST
	@Path("/addEmployee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addEmployee(Employee employee) {
		System.out.println("addEmployee is called.");
		System.out.println(employee);
		return "addEmployee succeed";
	}
	
	@POST
	@Path("/addEmployeeXML")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String addEmployeeXML(Employee employee) {
		System.out.println("addEmployeeXML is called.");
		System.out.println(employee);
		return "addEmployeeXML succeed";
	}
	
	
}
