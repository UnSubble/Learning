package com.unsubble._02.stereotype.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unsubble._02.stereotype.model.Employee;
import com.unsubble._02.stereotype.service.EmployeeService;
import com.unsubble._02.stereotype.service.EmployeeServiceImpl;

public class EmployeeStereoTypeTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("_02stereotype.xml");
		EmployeeService e = applicationContext.getBean("employeeServiceId", EmployeeServiceImpl.class);
		Employee employee = new Employee();
		employee.setName("a");
		employee.setSurname("b");
		e.saveEmployee(employee);
		
	}
}
