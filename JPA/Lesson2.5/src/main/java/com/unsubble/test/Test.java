package com.unsubble.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.unsubble.entity.Employee;
import com.unsubble.entity.EmployeeType;
import com.unsubble.repository.EmployeeRepository;
import com.unsubble.repository.EmployeeRepositoryImpl;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		EmployeeRepository em = new EmployeeRepositoryImpl(entityManager);
		
		Employee employee = new Employee();
		employee.setName("ismail");
		employee.setSurname("dsa");
		employee.setSalary(45765);
		employee.setEmployeeType(EmployeeType.INTERN);
		employee.setStartDate(new Date());
		employee.setImage("content".getBytes());
		
		em.save(employee);
	}
}
