package com.unsubble.lesson6._01;

import com.unsubble.lesson6.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.unsubble.lesson6")
public class Lesson6Sec1Application {

    private EmployeeRepository repository;

    @Autowired
    public Lesson6Sec1Application(EmployeeRepository repository) {
        this.repository = repository;
    }
}
