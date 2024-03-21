package com.unsubble.repository;

import java.util.List;

import com.unsubble.entity.Company;
import com.unsubble.entity.Department;
import com.unsubble.entity.Employee;
import com.unsubble.entity.ParkingSpace;

public interface EmployeeRepository {
	
	public void save(Employee employee);
	
	public void insertDepartment(Department department);
	
	public void insertParkingSpace(ParkingSpace parkingSpace);
	
	public void insertCompany(Company company);
}
