package com.unsubble.lesson3.dao;

import com.unsubble.lesson3.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(long id);

    List<Student> findAll();

    List<Student> findStudentsByLastName(String lastName);

    void updateStudent(Student student);

    void delete(Student student);

    void deleteById(long id);
}
