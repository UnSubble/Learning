package com.unsubble._02.aspectj.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unsubble._02.aspectj.service.EmployeeService;

public class AspectJTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aspectj.xml");
		EmployeeService service = context.getBean(EmployeeService.class);
		
		service.saveEmployee();
	}
}
