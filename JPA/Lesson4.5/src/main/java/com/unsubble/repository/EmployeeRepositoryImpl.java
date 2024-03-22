package com.unsubble.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

	public List<Employee> findAllEmployees() {
		TypedQuery<Employee> query = entityManager.createQuery("SELECT e from Employee e", Employee.class);
		return query.getResultList();
	}

	public List<String> findAllEmployeesName() {
		TypedQuery<String> query = entityManager.createQuery("SELECT e.name from Employee e", String.class);
		return query.getResultList();
	}

	public List<String> findAllEmployeesNameGreaterThanSalary(int salary) {
		// positional binding
//		TypedQuery<String> query = entityManager.createQuery("SELECT e.name from Employee e"
//		+ " WHERE e.salary > ?1", String.class).setParameter(1, salary);

		// Named parameter
		TypedQuery<String> query = entityManager
				.createQuery("SELECT e.name from Employee e" + " WHERE e.salary > :paramSalary", String.class)
				.setParameter("paramSalary", salary);

		return query.getResultList();
	}

	@Override
	public List<Employee> findAllEmployeesByNamedQuery() {
		TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findAllEmployees", Employee.class);
		return query.getResultList();
	}
	
	public Employee findByIdNamedQuery(int id) {
		TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findById", Employee.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
}
