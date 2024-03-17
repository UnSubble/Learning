package com.unsubble.Main;

import com.unsubble.dao.EmployeeDAO;
import com.unsubble.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = factory.createEntityManager();
		
		EmployeeDAO dao = new EmployeeDAO(entityManager);
		
		Employee employee1 = new Employee(1, "suluman", "s", 5000);

		dao.saveEmployee(employee1);
		
		Employee found = dao.findEmployeeById(1);
		System.out.println(found);
		
		dao.removeEmployee(1);
	}
}
