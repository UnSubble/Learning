package com.unsubble._01.jdbc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unsubble._01.jdbc.dao.PersonDAO;
import com.unsubble._01.jdbc.model.Person;

public class PersonTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("_01.xml");
		PersonDAO personDAO = applicationContext.getBean("personDAOImplId", PersonDAO.class);
		personDAO.createTableIfNotExists();
		personDAO.insertPerson(new Person(1, "test", "test", 1900));	
	}
}
