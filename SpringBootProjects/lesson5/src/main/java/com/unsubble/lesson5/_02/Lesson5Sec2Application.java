package com.unsubble.lesson5._02;

import com.unsubble.lesson5.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.unsubble.lesson5")
public class Lesson5Sec2Application {

    private EmployeeRepository repository;

    @Autowired
    public Lesson5Sec2Application(EmployeeRepository repository) {
        this.repository = repository;
    }
}
