package com.unsubble._01.jdbc.dao;

import com.unsubble._01.jdbc.model.Person;

public interface PersonDAO {
	
	public void createTableIfNotExists();

	public void insertPerson(Person person);
}
