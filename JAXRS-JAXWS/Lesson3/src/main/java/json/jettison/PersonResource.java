package json.jettison;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

@Path("/person-json-jettison")
public class PersonResource {

	@GET
	@Path("/person")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPerson() {
		Person person = new Person(1, "ad", "soyad");
		return person;
	}

	@GET
	@Path("/person-list")
	@Produces(MediaType.APPLICATION_JSON)
	@Wrapped(element = "list", namespace = "http://foo.org", prefix = "foo")
	public List<Person> getPersonList() {
		List<Person> list = List.of(new Person(1, "ad", "soyad"), new Person(2, "ad2", "soyad2"),
				new Person(3, "ad3", "soyad3"));
		return new ArrayList<Person>(list);
	}
	
	@GET
	@Path("/person-array")
	@Produces(MediaType.APPLICATION_JSON)
	public Person[] getPersonArray() {
		Person[] arr = new Person[] {new Person(1, "ad", "soyad"), new Person(2, "ad2", "soyad2"),
				new Person(3, "ad3", "soyad3")};
		return arr;
	}
}
