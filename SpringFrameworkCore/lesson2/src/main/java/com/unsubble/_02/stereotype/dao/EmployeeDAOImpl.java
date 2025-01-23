package com.unsubble._02.stereotype.dao;

import org.springframework.stereotype.Repository;

import com.unsubble._02.stereotype.model.Employee;


@Repository(value="employeeDAOImpl") // -> default value zaten bu
public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void saveEmployee(Employee employee) {
		System.out.println("saved: " + employee);
	}

	
}
