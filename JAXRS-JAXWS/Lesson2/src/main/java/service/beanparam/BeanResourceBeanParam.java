package service.beanparam;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/bean-beanparam")
public class BeanResourceBeanParam {

	// GET: http://localhost:8080/Lesson2/resteasy/bean-beanParam/computer;brand=apple;price=250.55?id=1000
	// RETURNED: Product [id=1000, brand=apple, price=250.55, category=computer]
	@GET
	@Path("/product/{category}")
	public String getProduct(@BeanParam Product product) {
		return product.toString();
	}
}
