package com.unsubble.lesson6._03;

import com.unsubble.lesson6.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.unsubble.lesson6")
public class Lesson6Sec3Application {

    private EmployeeRepository repository;

    @Autowired
    public Lesson6Sec3Application(EmployeeRepository repository) {
        this.repository = repository;
    }
}
