package com.unsubble._01.autowire.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unsubble._01.autowire.model.Employee;

public class AutowireTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("_01autowire.xml");
		Employee e = applicationContext.getBean("employeeId", Employee.class);
		System.out.println(e);
	}
}
