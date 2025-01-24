package com.unsubble._02.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.unsubble._02.jpa.model.Person;

public class PersonDAOImpl implements PersonDAO {
	
	private EntityManagerFactory entityManagerFactory;
	
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public void insertPerson(Person person) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(person);
		transaction.commit();
	}

	@Override
	public List<Person> getAllPersons() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<Person> query = entityManager.createQuery("SELECT t FROM person_table t", Person.class);
		return query.getResultList();
	}
	
}
