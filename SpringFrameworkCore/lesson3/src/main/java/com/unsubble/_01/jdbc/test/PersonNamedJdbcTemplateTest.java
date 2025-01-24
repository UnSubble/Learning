package com.unsubble._01.jdbc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unsubble._01.jdbc.dao.PersonDAONamedJDBCTemplate;

public class PersonNamedJdbcTemplateTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("_01.xml");
		PersonDAONamedJDBCTemplate personDAO = applicationContext.getBean("personDAONamedJDBCTemplateImplId", PersonDAONamedJDBCTemplate.class);
		System.out.println(personDAO.getAllPersons());	
	}
}
