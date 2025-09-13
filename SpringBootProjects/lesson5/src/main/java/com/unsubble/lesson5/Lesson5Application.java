package com.unsubble.lesson5;

import com.unsubble.lesson5.entity.Employee;
import com.unsubble.lesson5.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication(scanBasePackages = "com.unsubble.lesson5")
@RestController("/employee")
public class Lesson5Application {

    private EmployeeService service;

    @Autowired
    public Lesson5Application(EmployeeService service) {
        this.service = service;
    }

	public static void main(String[] args) {
		SpringApplication.run(Lesson5Application.class, args);
	}

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable long id) {
        return service.findById(id);
    }

    @GetMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Employee employee) {
        service.update(id, employee);
    }
}
