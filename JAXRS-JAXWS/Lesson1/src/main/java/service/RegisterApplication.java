package service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/") // /* kullanmıyoruz. Ayrıca web.xml configuration kullanırken bunu kaldırmayı unutma!
					// /root-path de yapabiliriz.
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
