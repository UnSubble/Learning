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
		
		Employee employee = new Employee();
		employee.setName("ismail");
		employee.setSurname("dsa");
		employee.setSalary(45765);
		employee.setEmployeeType(EmployeeType.INTERN);
		employee.setStartDate(new Date());
		employee.setImage("content".getBytes());
		employee.setDepartment(department);
		employee.setParkingSpace(parkingSpace);
		
		em.insertDepartment(department);

		// parkingSpace.setEmployee(employee); // hata verir çünkü ikisinin de aynı transaction içerisinde 
											   // atanması gerekiyor. Veya çalışması için @OneToOne(mappedBy="", 
											   // cascade = CascadeType.ALL) yapmamız gerekir. Veya com.unsubble.
											   // test.Test2'de olduğu gibi commit atabiliriz.
		
		em.insertParkingSpace(parkingSpace);
		
		em.save(employee);
			
		entityManager.close();
		factory.close();
	}
}
