package service.matrixparam;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;

@Path("/car-matrixparam")
public class CarResourceMatrixParam {

	// GET: http://localhost:8080/Lesson2/resteasy/car-pathsegment/car;brand=bmw;color=red;color=blue;
	// RETURNED: brand: bmw, colors: [red, blue]
	@GET
	@Path("/car")
	public String getCar(@MatrixParam("brand") String brand, List<String> colors) {
		return "brand: " + brand + ", colors: " + colors;
	}
}
