package com.unsubble._04.spring.setter.injection.model;

public class Employee2 {

	private String name;
	private String surname;
	private long salary;
	private int birthYear;
	private char gender;
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

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee2 [name=" + name + ", surname=" + surname + ", salary=" + salary + ", birthYear=" + birthYear
				+ ", gender=" + gender + ", address=" + address + "]";
	}

}
