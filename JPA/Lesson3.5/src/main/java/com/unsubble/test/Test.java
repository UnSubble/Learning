package com.unsubble.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.unsubble.entity.Address;
import com.unsubble.entity.Company;
import com.unsubble.entity.Department;
import com.unsubble.entity.Employee;
import com.unsubble.entity.EmployeeType;
import com.unsubble.entity.ParkingSpace;
import com.unsubble.repository.EmployeeRepository;
import com.unsubble.repository.EmployeeRepositoryImpl;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeManagement");
		EntityManager entityManager = factory.createEntityManager();

		EmployeeRepository em = new EmployeeRepositoryImpl(entityManager);

		Department department = new Department();
		department.setDeptName("IT - Dept");

		ParkingSpace parkingSpace = new ParkingSpace();
		parkingSpace.setFlat(-1);
		parkingSpace.setLocation("A-10");

		Employee employee = new Employee();
		employee.setName("ismail");
		employee.setSurname("dsa");
		employee.setSalary(45765);
		employee.setEmployeeType(EmployeeType.INTERN);
		employee.setStartDate(new Date());
		employee.setImage("content".getBytes());
		
		Address address = new Address("street1", "road1", "no1", "istanbul", "34000");
		employee.setAddress(address);
		
		Company company = new Company("HOB");
		
		Address address2 = new Address("street2", "road2", "no2", "istanbul", "34000");
		company.setAddress(address2);
		
		em.insertCompany(company);

		em.insertDepartment(department);
		em.insertParkingSpace(parkingSpace);

		employee.setDepartment(department);
		employee.setParkingSpace(parkingSpace);
		em.save(employee);

		entityManager.close();
		factory.close();
	}
}
