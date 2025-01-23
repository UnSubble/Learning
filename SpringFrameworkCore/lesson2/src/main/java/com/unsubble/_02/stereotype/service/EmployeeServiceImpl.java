package com.unsubble._02.stereotype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unsubble._02.stereotype.dao.EmployeeDAO;
import com.unsubble._02.stereotype.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired // -> constructor veya setter metoda ihtiyaç duymaz çünkü reflection ile halleder.
	private EmployeeDAO employeeDAO;

	@Override
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);
	}

	
}
