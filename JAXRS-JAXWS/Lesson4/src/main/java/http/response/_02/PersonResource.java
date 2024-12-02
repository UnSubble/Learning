package http.response._02;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/person-response")
public class PersonResource {

	@GET
	@Path("/name")
	public Response getPersonName() {
		String name = "isim";
		ResponseBuilder builder = Response.ok(name);
		builder.header("myHeader", "value");
		builder.cookie(new NewCookie("myCookie", "value"));
		return builder.build();
	}
	
	@GET
	@Path("/people")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPeople() {
		Person person1 = new Person(1, "isim", "soyisim");
		Person person2 = new Person(2, "isim2", "soyisim2");
		Person person3 = new Person(3, "isim3", "soyisim3");
		List<Person> list = List.of(person1, person2, person3);
		return Response.ok(list).build();
	}
	
	@GET
	@Path("/people-genericentity")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPeopleAsGeneric() {
		Person person1 = new Person(1, "isim", "soyisim");
		Person person2 = new Person(2, "isim2", "soyisim2");
		Person person3 = new Person(3, "isim3", "soyisim3");
		List<Person> list = List.of(person1, person2, person3);
		GenericEntity<List<Person>> genericEntity = new GenericEntity<List<Person>>(list) {};
		return Response.ok(genericEntity).build();
	}
}
