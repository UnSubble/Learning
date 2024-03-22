package com.unsubble.test;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.unsubble.entity.Department;
import com.unsubble.entity.Employee;
import com.unsubble.entity.EmployeeType;
import com.unsubble.repository.EmployeeRepository;
import com.unsubble.repository.EmployeeRepositoryImpl;

public class Test2 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeManagement");
		EntityManager entityManager = factory.createEntityManager();
		
		EmployeeRepository em = new EmployeeRepositoryImpl(entityManager);
		
		Department department = new Department();
		department.setDeptName("IT - Dept");
		
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
		
		employee2.setDepartment(department);
		em.save(employee2);
		
		employee.setDepartment(department);
		em.save(employee);
		
		entityManager.getTransaction().begin();
		department.getEmployees().add(employee);
		department.getEmployees().add(employee2);
		entityManager.getTransaction().commit();
		
		em.findAllEmployees().forEach(System.out::println);;
		em.findAllEmployeesName().forEach(System.out::println);
		em.findAllEmployeesNameGreaterThanSalary(50000).forEach(System.out::println);
		em.findAllEmployeesByNamedQuery().forEach(System.out::println);
		System.out.println(em.findByIdNamedQuery(2).getName());
		
		entityManager.close();
		factory.close();
	}
}
