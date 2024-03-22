package com.unsubble.service;

import java.util.List;

import com.unsubble.entity.Employee;

public interface EmployeeService {
	
	public Employee save(Employee employee);
	
	public Employee findById(int id);
	
	public List<Employee> findAll();
	
	public void remove(int id);
}
