package service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import http.exception.CustomerResource;
import http.exception.mapper.CustomerResourceMapper;
import http.response._01.HttpResponseResource;
import http.response._02.PersonResource;

@ApplicationPath("/resteasy/")
public class RegisterApplication extends Application {

	private Set<Object> singletons = new HashSet<>();

	public RegisterApplication() {
		singletons.add(new HttpResponseResource());
		singletons.add(new PersonResource());
		singletons.add(new CustomerResource());
		singletons.add(new CustomerResourceMapper());
		singletons.add(new client.api._01.MessageSource());
		singletons.add(new client.api._02.LibraryResource());
		singletons.add(new client.api._03.EmployeeResource());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
