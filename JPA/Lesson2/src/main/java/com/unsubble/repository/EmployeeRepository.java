package com.unsubble.repository;

import java.util.List;

import com.unsubble.entity.Employee;

public interface EmployeeRepository {
	
	public void save(Employee employee);
	
	public List<Employee> findAll();
}
