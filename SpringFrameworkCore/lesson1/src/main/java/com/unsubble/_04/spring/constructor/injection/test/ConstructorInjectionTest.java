package com.unsubble._04.spring.constructor.injection.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unsubble._04.spring.constructor.injection.model.Employee;
import com.unsubble._04.spring.constructor.injection.model.Employee2;

public class ConstructorInjectionTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("constructorInjection.xml");
		Employee em = applicationContext.getBean("employeeId", Employee.class);
		System.out.println(em);
		Employee2 em2 = applicationContext.getBean("employeeIdd", Employee2.class);
		System.out.println(em2);
	}
}
