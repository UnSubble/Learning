package service.formparam;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.jboss.resteasy.annotations.Form; // sadece resteasy'de var

@Path("/person-formparam")
public class PersonResource {

	@POST
	@Path("/addPerson")
	public String addPerson(@FormParam("name") String name, @FormParam("surname") String surname) {
		return "new Person(" + name + ", " + surname + ");";
	}
	
	@POST
	@Path("/addPersonFormAnnotation")
	public String addPersonFormAnnotation(@Form Person person) {
		return person.toString();
	}
}
