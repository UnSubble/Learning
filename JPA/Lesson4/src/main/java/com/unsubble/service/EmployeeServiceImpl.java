package com.unsubble.service;

import java.util.List;

import com.unsubble.dao.EmployeeDAO;
import com.unsubble.dao.EmployeeDAOImpl;
import com.unsubble.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl() {
		this.employeeDAO = new EmployeeDAOImpl();
	}

	@Override
	public Employee save(Employee employee) {
		return employeeDAO.save(employee);
	}

	@Override
	public Employee findById(int id) {
		return employeeDAO.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public void remove(int id) {
		employeeDAO.remove(id);
	}

}
