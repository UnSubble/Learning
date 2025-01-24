package com.unsubble._03.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unsubble._03.hibernate.model.Person;

@Repository("springHibernateDAOImpl")
public class SpringHibernateDAOImpl implements SpringHibernateDAO{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public void insert(Person person) {
		Session session = getSession();
		Transaction transacion = session.beginTransaction();
		session.persist(person);
		transacion.commit();
		session.close();
	}
}
