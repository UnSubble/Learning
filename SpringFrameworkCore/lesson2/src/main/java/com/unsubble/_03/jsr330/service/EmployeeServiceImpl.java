package com.unsubble._03.jsr330.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.unsubble._03.jsr330.dao.EmployeeDAO;
import com.unsubble._03.jsr330.model.Employee;

@Named
public class EmployeeServiceImpl implements EmployeeService {
	
	@Inject
	private EmployeeDAO employeeDAO;

	@Override
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);
	}

	
}
