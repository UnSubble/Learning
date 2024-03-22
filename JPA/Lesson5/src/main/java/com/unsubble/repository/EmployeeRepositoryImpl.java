package com.unsubble.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

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

	@Override
	public List<Employee> queryEmployee() {
		TypedQuery<Employee> query = entityManager
				.createQuery("SELECT e from Employee e where e.salary ?1 BETWEEN ?2", Employee.class)
				.setParameter(1, 50000).setParameter(2, 55000);
		return query.getResultList();
	}

	@Override
	public void queryEmployeeCriteriaAPI() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
		Root<Employee> root = query.from(Employee.class);
		
		query.select(root);
		
		TypedQuery<Employee> typed = entityManager.createQuery(query);
		typed.getResultList().forEach(System.out::println);
		
		System.out.println("-----------------------");
		
		CriteriaBuilder builder2 = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<String> query2 = builder2.createQuery(String.class);
		Root<Employee> root2 = query2.from(Employee.class);
		
		query2.select(root2.get("name"));
		
		TypedQuery<String> typed2 = entityManager.createQuery(query2);
		typed2.getResultList().forEach(System.out::println);
		
		System.out.println("-----------------------");
		
		CriteriaBuilder builder3 = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Tuple> query3 = builder3.createQuery(Tuple.class);
		Root<Employee> root3 = query3.from(Employee.class);
		
		query3.select(builder3.tuple(root3.get("name"), root3.get("salary")));
		
		TypedQuery<Tuple> typed3 = entityManager.createQuery(query3);
		List<Tuple> list = typed3.getResultList();
		for (Tuple t : list) {
			System.out.println(t.get(0) + " " + t.get(1));
		}
		
		System.out.println("-----------------------");
		
		CriteriaBuilder builder4 = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<String> query4 = builder4.createQuery(String.class);
		Root<Employee> root4 = query4.from(Employee.class);
		
		query4.select(root4.get("department").get("deptName"));
		query4.where(builder4.equal(root4.get("name"), "ismail"));
		TypedQuery<String> typed4 = entityManager.createQuery(query4);
		System.out.println(typed4.getSingleResult());
	}
}
