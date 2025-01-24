package com.unsubble._01.jdbc.dao;

import java.util.List;

import com.unsubble._01.jdbc.model.Person;

public interface PersonDAONamedJDBCTemplate {

	public void insertPerson(Person person);
	
	public List<Person> getAllPersons();
}
