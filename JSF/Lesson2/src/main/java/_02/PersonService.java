package _02;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class PersonService implements Serializable {
	public String invokeMethod() {
		System.out.println("service log..");
		return "service.";
	}
}
