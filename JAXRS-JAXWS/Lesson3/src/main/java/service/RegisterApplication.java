package service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

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
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
