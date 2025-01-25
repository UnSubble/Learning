package com.unsubble._02.aspectj.annotation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unsubble._02.aspectj.annotation.service.EmployeeService;

public class AspectJTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aspectjannotation.xml");
		EmployeeService service = context.getBean(EmployeeService.class);
		
		service.saveEmployee();
	}
}
