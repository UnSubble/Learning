package _03;

public class AjaxBean {
	private String name;
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

	public String getHelloMessage() {
		if (name != null && !name.isBlank()) {
			return "Hello, " + name;
		}
		return "Hello";
	}
}
