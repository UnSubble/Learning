import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
// @SessionScoped -> vermek için class'ımızın Serializable interface'ini implemente etmesi gerekiyor.
public class Bean {
	private Person person;

	public Bean() {
		person = new Person();
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
