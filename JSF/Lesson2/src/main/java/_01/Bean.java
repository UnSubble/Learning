package _01;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import _02.PersonService;

@Named
@RequestScoped
// @SessionScoped -> vermek için class'ımızın Serializable interface'ini implemente etmesi gerekiyor.
public class Bean {
	private Person person;
	
	@Inject
	private PersonService personService;

	public Bean() {
		person = new Person();
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String callService() {
		return personService.invokeMethod();
	}
}
