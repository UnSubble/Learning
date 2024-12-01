package service.defaultvalue;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/car-defaultvalue")
public class CarResourceDefaultValue {

	// GET: http://localhost:8080/Lesson2/resteasy/car-pathsegment/car
	// RETURNED: getCarById: 1000
	@GET
	@Path("/car")
	public String getCarById(@DefaultValue("1000") @QueryParam("id") int id) {
		return "getCarById: " + id;
	}
}
