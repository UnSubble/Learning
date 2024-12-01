package service.encoded;

import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/employee-encoded")
public class EmployeeResource {

	// GET: http://localhost:8080/Lesson2/resteasy/employee-encoded/getEmployeeNameEncoded?name=name%20surname
	// RETURNED: name%20surname
	@GET
	@Path("/getEmployeeNameEncoded")
	public String getEmployeeNameEncoded(@Encoded @QueryParam("name") String name) {
		return "name: " + name;
	}
	
	// GET: http://localhost:8080/Lesson2/resteasy/employee-encoded/getEmployeeName?name=name%20surname
	// RETURNED: name surname
	@GET
	@Path("/getEmployeeName")
	public String getEmployeeName(@QueryParam("name") String name) {
		return "name: " + name;
	}
}
