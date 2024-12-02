package service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import jaxb.xml.CustomerResource;
import jaxb.xml.PersonResource;
import service.context.ContextResource;
import service.encoded.EmployeeResource;
import service.standardentityprovider.ProviderResource;

@ApplicationPath("/resteasy/")
public class RegisterApplication extends Application {
	
private Set<Object> singletons = new HashSet<>();
	
	public RegisterApplication() {
		singletons.add(new EmployeeResource());
		singletons.add(new ContextResource());
		singletons.add(new ProviderResource());
		singletons.add(new PersonResource());
		singletons.add(new CustomerResource());
		singletons.add(new json.jackson.PersonResource());
		singletons.add(new json.jettison.PersonResource());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
