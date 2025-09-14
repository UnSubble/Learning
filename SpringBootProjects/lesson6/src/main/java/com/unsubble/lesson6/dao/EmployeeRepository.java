package com.unsubble.lesson6.dao;

import com.unsubble.lesson6.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
