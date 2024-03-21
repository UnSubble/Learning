package com.unsubble.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.unsubble.entity.Department;
import com.unsubble.entity.Employee;
import com.unsubble.entity.ParkingSpace;
import com.unsubble.entity.Phone;
import com.unsubble.entity.Project;

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
	public void insertDepartment(Department department) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(department);
		transaction.commit();		
	}

	@Override
	public void insertParkingSpace(ParkingSpace parkingSpace) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(parkingSpace);
		transaction.commit();
	}

	@Override
	public void insertPhone(Phone phone) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(phone);
		transaction.commit();
	}

	@Override
	public void insertProject(Project project) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(project);
		transaction.commit();
	}

	
}
