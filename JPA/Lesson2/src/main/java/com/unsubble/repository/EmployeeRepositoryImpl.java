package com.unsubble.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.unsubble.entity.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	private EntityManager entityManager;
	
	public EmployeeRepositoryImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void save(Employee employee) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(employee);
		transaction.commit();
	}

	@Override
	public List<Employee> findAll() {
		 Query query = entityManager.createQuery("SELECT e FROM Employee_New_Name e");
		 List<Employee> employees = query.getResultList();
		 return employees;		
	}

	
}
