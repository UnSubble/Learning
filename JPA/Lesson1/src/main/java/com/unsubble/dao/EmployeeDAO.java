package com.unsubble.dao;

import java.util.List;
import java.util.stream.Stream;

import com.unsubble.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class EmployeeDAO {

	private EntityManager entityManager;
	
	public EmployeeDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void saveEmployee(Employee employee) {
		// bu yaklaşım: programatic transaction
		EntityTransaction transaction = entityManager.getTransaction(); // transaction yapmazsak veriyi veri 
		transaction.begin();											// tabanına kaydetmez. (Aynı JDBC 
		entityManager.persist(employee);								// autocommit rollback olayı gibi)
		transaction.commit();
	}
	
	public Employee findEmployeeById(int id) {
		// read işleminde transaction'a gerek yok
		return entityManager.find(Employee.class, id);
	}
	
	public List<Employee> findAllEmployees() {
		Query query = entityManager.createQuery("SELECT e FROM Employee e");
		return (List<Employee>) query.getResultList();
	}
	
	public void removeEmployee(int id) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(findEmployeeById(id));
		transaction.commit();
	}
	
	public Employee raiseSalary(int id, int raise) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Employee found = findEmployeeById(id);
		if (found != null)
			found.setSalary(found.getSalary() + raise); // değeri iki transaction arasında güncellersek 
		transaction.commit();							// veri tabanına yansır.
		return found;
	}
}
