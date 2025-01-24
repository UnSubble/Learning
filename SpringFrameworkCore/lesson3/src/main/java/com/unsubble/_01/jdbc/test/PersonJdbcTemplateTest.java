package com.unsubble._01.jdbc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unsubble._01.jdbc.dao.PersonDAOJDBCTemplate;
import com.unsubble._01.jdbc.model.Person;

public class PersonJdbcTemplateTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("_01.xml");
		PersonDAOJDBCTemplate personDAO = applicationContext.getBean("personDAOJDBCTemplateImplId", PersonDAOJDBCTemplate.class);
		personDAO.insertPerson(new Person(1, "test", "test", 1900));	
	}
}
