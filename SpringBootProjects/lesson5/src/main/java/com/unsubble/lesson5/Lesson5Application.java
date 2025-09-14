package com.unsubble.lesson5;

import com.unsubble.lesson5._01.Lesson5Sec1Application;
import com.unsubble.lesson5._02.Lesson5Sec2Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson5Application {
    public static void main(String[] args) {
        // SpringApplication.run(Lesson5Sec1Application.class, args);
        SpringApplication.run(Lesson5Sec2Application.class, args);
    }
}
