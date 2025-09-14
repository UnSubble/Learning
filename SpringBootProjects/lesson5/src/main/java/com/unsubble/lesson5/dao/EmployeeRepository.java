package com.unsubble.lesson5.dao;

import com.unsubble.lesson5.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// JpaRepository:
// Quick start için çok elverişli fakat basit metodlar var.
// ayrıca spring data rest için de gerekli. (ki o da quick start için elverişli)
//
// @RepositoryRestResource(path = "members")
// RepositoryRestResource:
// normalde res path'i default olarak "/employees" olması gerekirken biz onu değiştirdik.
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
