package com.unsubble.lesson5._01;

import com.unsubble.lesson5.entity.Employee;
import com.unsubble.lesson5._01.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication(scanBasePackages = "com.unsubble.lesson5")
@RestController("/employee")
public class Lesson5Sec1Application {

    private EmployeeService service;

    @Autowired
    public Lesson5Sec1Application(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Employee employee) {
        service.update(id, employee);
    }
}
