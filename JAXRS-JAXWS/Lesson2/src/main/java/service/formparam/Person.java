package service.formparam;

import javax.ws.rs.FormParam;

public class Person {
	@FormParam("name")
	private String name;
	
	@FormParam("surname")
	private String surname;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + "]";
	}
	
}
