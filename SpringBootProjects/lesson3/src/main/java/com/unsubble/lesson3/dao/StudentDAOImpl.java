package com.unsubble.lesson3.dao;

import com.unsubble.lesson3.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional // spring auto rollback ve commit sağlıyor.
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findStudentsByLastName(String lastName) {
        TypedQuery<Student> query = entityManager
                .createQuery("select s from Student s where s.lastName=:lastName", Student.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Student student) {
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        entityManager.remove(entityManager.find(Student.class, id));
    }
}
