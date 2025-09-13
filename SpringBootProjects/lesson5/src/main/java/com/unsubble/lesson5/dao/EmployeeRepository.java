package com.unsubble.lesson5.dao;

import com.unsubble.lesson5.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// Quick start için çok elverişli fakat basit metodlar var.
// ayrıca spring data rest için de gerekli. (ki o da quick start için elverişli)
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
