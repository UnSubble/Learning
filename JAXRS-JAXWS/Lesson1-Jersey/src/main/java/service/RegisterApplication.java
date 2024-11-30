package service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

// web_1.xml için gerek yok bu sınıfa

@ApplicationPath("/jersey/") // diğer web.xml'leri kullanacaksan silmeyi unutma!
public class RegisterApplication extends Application {
	
	private Set<Object> singletons = new HashSet<>();
	
	public RegisterApplication() {
		singletons.add(new MessageService());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
