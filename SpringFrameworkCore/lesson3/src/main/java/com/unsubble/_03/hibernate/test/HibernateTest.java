package com.unsubble._03.hibernate.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unsubble._03.hibernate.dao.SpringHibernateDAO;
import com.unsubble._03.hibernate.model.Person;

public class HibernateTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("hibernate.xml");
		SpringHibernateDAO dao = context.getBean(SpringHibernateDAO.class);
		dao.insert(new Person(1, "test", "test", 10));
	}
}
