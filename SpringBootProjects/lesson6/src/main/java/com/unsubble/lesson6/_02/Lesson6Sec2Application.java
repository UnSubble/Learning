package com.unsubble.lesson6._02;

import com.unsubble.lesson6.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.unsubble.lesson6")
public class Lesson6Sec2Application {

    private EmployeeRepository repository;

    @Autowired
    public Lesson6Sec2Application(EmployeeRepository repository) {
        this.repository = repository;
    }
}
