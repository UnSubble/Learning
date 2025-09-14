package com.unsubble.lesson5._01.service;

import com.unsubble.lesson5.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void add(Employee employee);

    List<Employee> findAll();

    Employee findById(long id);

    void update(long id, Employee employee);

    void deleteById(long id);
}
