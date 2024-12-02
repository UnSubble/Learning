package jaxb.xml;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

// JAXB -> Java Architecture for XML Binding
// Marshalling -> Java objesini XML objesine dönüştürmek.
// Unmarshalling -> XML objesini Java objesine dönüştürmek. 

@Path("/person-jaxb-xml")
public class PersonResource {

	@GET
	@Path("/person")
	@Produces(MediaType.APPLICATION_XML)
	public Person getPerson() {
		Person person = new Person(1, "ad", "soyad");
		return person;
	}
	
	@GET
	@Path("/person-unmarshal")
	@Produces(MediaType.APPLICATION_XML)
	public String getPersonWithJaxbContext() throws JAXBException {
		Person person = new Person(1, "ad", "soyad");
		JAXBContext context = JAXBContext.newInstance(Person.class);
		StringWriter writer = new StringWriter();
		context.createMarshaller().marshal(person, writer);
		return writer.toString();
	}

	@GET
	@Path("/person-list")
	@Produces(MediaType.APPLICATION_XML)
	@Wrapped(element = "list", namespace = "http://foo.org", prefix = "foo")
	// RETURNS <foo:list xmlns:foo="http://foo.org"></foo:list>
	public List<Person> getPersonList() {
		List<Person> list = List.of(new Person(1, "ad", "soyad"), new Person(2, "ad2", "soyad2"),
				new Person(3, "ad3", "soyad3"));
		return new ArrayList<Person>(list);
	}
	
	@GET
	@Path("/person-array")
	@Produces(MediaType.APPLICATION_XML)
	public Person[] getPersonArray() {
		Person[] arr = new Person[] {new Person(1, "ad", "soyad"), new Person(2, "ad2", "soyad2"),
				new Person(3, "ad3", "soyad3")};
		return arr;
	}
}
