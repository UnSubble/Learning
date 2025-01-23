package com.unsubble._01.autowire.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {

	private String name;
	private String surname;
	
	@Autowired
	@Qualifier(value = "addressId") // -> eğer xml'de birden fazla bean olsaydı bunun sayesinde seçebilecektik.
	private Address address;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", address=" + address + "]";
	}

}
