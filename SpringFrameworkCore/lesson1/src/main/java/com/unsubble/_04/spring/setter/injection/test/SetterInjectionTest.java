package com.unsubble._04.spring.setter.injection.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unsubble._04.spring.setter.injection.model.Employee;
import com.unsubble._04.spring.setter.injection.model.Employee2;

public class SetterInjectionTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("setterInjection2.xml");
		Employee em = applicationContext.getBean("employeeId", Employee.class);
		System.out.println(em);
		Employee em2 = applicationContext.getBean("employeeId2", Employee.class);
		System.out.println(em2);
		Employee2 em3 = applicationContext.getBean("employeeId3", Employee2.class);
		System.out.println(em3);
	}
}
