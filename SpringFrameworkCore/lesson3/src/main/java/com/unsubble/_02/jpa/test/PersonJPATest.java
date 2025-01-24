package com.unsubble._02.jpa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unsubble._02.jpa.dao.PersonDAO;
import com.unsubble._02.jpa.model.Person;

public class PersonJPATest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("jpa.xml");
		PersonDAO personDAO = applicationContext.getBean(PersonDAO.class);
		personDAO.insertPerson(new Person("name", "surname", 1999));
		System.out.println(personDAO.getAllPersons());
	}
}
