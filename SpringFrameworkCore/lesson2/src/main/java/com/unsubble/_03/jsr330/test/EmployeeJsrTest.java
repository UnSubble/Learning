package com.unsubble._03.jsr330.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unsubble._03.jsr330.model.Employee;
import com.unsubble._03.jsr330.service.EmployeeService;
import com.unsubble._03.jsr330.service.EmployeeServiceImpl;


public class EmployeeJsrTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("_03jsr330.xml");
		EmployeeService e = applicationContext.getBean("employeeServiceId", EmployeeServiceImpl.class);
		Employee employee = new Employee();
		employee.setName("a");
		employee.setSurname("b");
		e.saveEmployee(employee);
		
	}
}
