package com.unsubble._04.javabased.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.unsubble._04.javabased.configuration.JavaBasedConfiguration;
import com.unsubble._04.javabased.model.Employee;

public class JavaBasedTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaBasedConfiguration.class);
		Employee e = applicationContext.getBean(Employee.class);
		System.out.println(e);
	}
}
