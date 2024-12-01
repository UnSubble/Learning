package service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import service.beanparam.BeanResourceBeanParam;
import service.cookieparam.UserResourceCookieParam;
import service.defaultvalue.CarResourceDefaultValue;
import service.formparam.PersonResource;
import service.headerparam.LoginResourceHeaderParam;
import service.matrixparam.CarResourceMatrixParam;
import service.path.CustomerResource;
import service.pathparam.CustomerResourcePathParam;
import service.pathsegment.CarResourcePathSegment;
import service.queryparam.LibraryResourceQueryParam;

@ApplicationPath("/resteasy/")
public class RegisterApplication extends Application {
	
private Set<Object> singletons = new HashSet<>();
	
	public RegisterApplication() {
		singletons.add(new MessageService());
		singletons.add(new CustomerResource());
		singletons.add(new CustomerResourcePathParam());
		singletons.add(new CarResourcePathSegment());
		singletons.add(new CarResourceMatrixParam());
		singletons.add(new LibraryResourceQueryParam());
		singletons.add(new PersonResource());
		singletons.add(new LoginResourceHeaderParam());
		singletons.add(new UserResourceCookieParam());
		singletons.add(new BeanResourceBeanParam());
		singletons.add(new CarResourceDefaultValue());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
