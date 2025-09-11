package com.unsubble.lesson1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Lesson1Application {

    @Value("${my.custom.prop}")
    private String prop;

	public static void main(String[] args) {
		SpringApplication.run(Lesson1Application.class, args);
	}

    @GetMapping("/test")
    public String helloSpring() {
        return "Hello, Spring! My prop:" + prop;
    }

}
