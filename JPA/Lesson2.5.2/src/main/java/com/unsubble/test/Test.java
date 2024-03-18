package com.unsubble.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

		ParkingSpace parkingSpace2 = new ParkingSpace();
		
		Employee employee = new Employee();
		employee.setName("ismail");
		employee.setSurname("dsa");
		employee.setSalary(45765);
		employee.setEmployeeType(EmployeeType.INTERN);
		employee.setStartDate(new Date());
		employee.setImage("content".getBytes());
		
		Employee employee2 = new Employee();
		employee2.setName("asd");
		employee2.setSurname("dsa");
		employee2.setSalary(53621);
		employee2.setEmployeeType(EmployeeType.FULL_TIME);
		employee2.setStartDate(new Date(4587453));
		employee2.setImage("content".getBytes());
		
		em.insertDepartment(department);
		em.insertParkingSpace(parkingSpace);
		em.insertParkingSpace(parkingSpace2);
		
		employee2.setDepartment(department);
		employee2.setParkingSpace(parkingSpace2);
		em.save(employee2);
		
		employee.setDepartment(department);
		employee.setParkingSpace(parkingSpace);
		em.save(employee);
		
		
		entityManager.close();
		factory.close();
	}
}
