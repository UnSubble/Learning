package service.pathsegment;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.PathSegment;

@Path("/car-pathsegment")
public class CarResourcePathSegment {
	
	
	// GET: http://localhost:8080/Lesson2/resteasy/car-pathsegment/car/criteria;brand=bmw;color=red;color=blue;
	// RETURNED: brand: bmw, colors: [red, blue]
	
	// matrix parametresi için:
	// .../path/matrixParam=value; matrixParam2=value2; matrixParam3=value3;
	@GET
	@Path("/car/{search: criteria}")
	public String getCar(@PathParam("search") PathSegment pathSegment) {
		String brand = pathSegment.getMatrixParameters().getFirst("brand");
		List<String> colorList = pathSegment.getMatrixParameters().get("color");
		return "brand: " + brand + ", colors: " + colorList;
	}
	
	
}
