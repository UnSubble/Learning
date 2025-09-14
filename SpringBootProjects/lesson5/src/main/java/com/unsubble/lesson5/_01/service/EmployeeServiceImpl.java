package com.unsubble.lesson5._01.service;

import com.unsubble.lesson5.dao.EmployeeRepository;
import com.unsubble.lesson5.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Employee employee) {
        repository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(long id, Employee employee) {
        Employee target = repository.findById(id).orElse(employee);
        target.setFirstName(employee.getFirstName());
        target.setLastName(employee.getLastName());
        if (target != employee)
            repository.deleteById(id);
        repository.save(target);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
