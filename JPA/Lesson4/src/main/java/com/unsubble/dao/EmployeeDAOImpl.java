package com.unsubble.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.unsubble.entity.Employee;
import com.unsubble.utility.EntityManagerUtility;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public Employee save(Employee employee) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(employee);
		transaction.commit();
		entityManager.close();
		return employee;
	}

	@Override
	public Employee findById(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		Employee found = entityManager.find(Employee.class, id);
		entityManager.close();
		return found;
	}

	@Override
	public List<Employee> findAll() {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		TypedQuery<Employee> query = entityManager.createQuery("Select e from Employee e", Employee.class);
		List<Employee> employees = query.getResultList();
		entityManager.close();
		return employees;
	}

	@Override
	public void remove(int id) {
		EntityManager entityManager = EntityManagerUtility.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Employee target = entityManager.find(Employee.class, id);
		if (target != null) {
			transaction.begin();
			entityManager.remove(target);
			transaction.commit();
		}
		entityManager.close();
	}

}
