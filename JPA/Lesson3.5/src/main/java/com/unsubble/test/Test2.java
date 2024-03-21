package com.unsubble.test;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.unsubble.entity.Employee;
import com.unsubble.entity.EmployeeType;
import com.unsubble.repository.EmployeeRepository;
import com.unsubble.repository.EmployeeRepositoryImpl;

public class Test2 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeManagement");
		
		EntityManager entityManager = factory.createEntityManager();
		
		EmployeeRepository em = new EmployeeRepositoryImpl(entityManager);
		
		Employee employee = new Employee();
		employee.setName("ismail");
		employee.setSurname("dsa");
		employee.setSalary(45765);
		employee.setEmployeeType(EmployeeType.INTERN);
		employee.setStartDate(new Date());
		employee.setImage("content".getBytes());
		employee.setEmails(Arrays.asList("a@b.com","g@gmail.com", "b@c.com"));
		
		employee.setPhones(Map.of("Home", "55555", "Work", "456456", "Mobile", "547647"));
		
		em.save(employee);
		
		entityManager.close();
		factory.close();
	}
}
