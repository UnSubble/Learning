package com.unsubble.repository;

import java.util.List;

import com.unsubble.entity.Department;
import com.unsubble.entity.Employee;
import com.unsubble.entity.ParkingSpace;
import com.unsubble.entity.Phone;
import com.unsubble.entity.Project;

public interface EmployeeRepository {
	
	public void save(Employee employee);
	
	public void insertDepartment(Department department);
	
	public void insertParkingSpace(ParkingSpace parkingSpace);
	
	public void insertPhone(Phone phone);
	
	public void insertProject(Project project);
	
	public List<Employee> findAllEmployees();
	
	public List<Employee> findAllEmployeesByNamedQuery();
	
	public List<String> findAllEmployeesName();
	
	public List<String> findAllEmployeesNameGreaterThanSalary(int salary);
	
	public Employee findByIdNamedQuery(int id);
}
