package com.unsubble.dao;

import java.util.List;

import com.unsubble.entity.Employee;

public interface EmployeeDAO {
	public Employee save(Employee employee);
	
	public Employee findById(int id);
	
	public List<Employee> findAll();
	
	public void remove(int id);
}
