package com.unsubble._02.jpa.dao;

import java.util.List;

import com.unsubble._02.jpa.model.Person;

public interface PersonDAO {

	public void insertPerson(Person person);
	
	public List<Person> getAllPersons();
}
