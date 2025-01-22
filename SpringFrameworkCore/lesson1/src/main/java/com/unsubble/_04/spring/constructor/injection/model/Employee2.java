package com.unsubble._04.spring.constructor.injection.model;

public class Employee2 {

	private String name;
	private String surname;
	private long salary;
	private int birthYear;
	private char gender;

	public Employee2(String name, String surname, long salary, int birthYear, char gender) {
		super();
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		this.birthYear = birthYear;
		this.gender = gender;
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

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", salary=" + salary + ", birthYear=" + birthYear
				+ ", gender=" + gender + "]";
	}

}
