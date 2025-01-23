package com.unsubble._03.jsr330.dao;

import javax.inject.Named;

import com.unsubble._03.jsr330.model.Employee;


@Named
public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void saveEmployee(Employee employee) {
		System.out.println("saved: " + employee);
	}

	
}
