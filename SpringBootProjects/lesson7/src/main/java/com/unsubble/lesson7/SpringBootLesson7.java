package com.unsubble.lesson7;

import com.unsubble.lesson7._01.controller.Lesson7Sec1Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.unsubble.lesson7")
public class SpringBootLesson7 {

    public static void main(String[] args) {
        SpringApplication.run(Lesson7Sec1Application.class, args);
    }
}
