package jaxb.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="person")
@XmlAccessorType(XmlAccessType.FIELD) // default olarak getter metodunun üstünde oluyor.
										// Bunun gibi field olması için özellikle belirtmek lazım.
public class Person {

	@XmlElement(name="personID")
	private int id;
	@XmlElement
	private String name;
	@XmlElement
	private String surname;

	public Person() {
		super();
	}

	public Person(int id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

}
