package com.unsubble.lesson6;

import com.unsubble.lesson6._01.Lesson6Sec1Application;
import com.unsubble.lesson6._02.Lesson6Sec2Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson6Application {
    public static void main(String[] args) {
        // SpringApplication.run(Lesson6Sec1Application.class, args);
        SpringApplication.run(Lesson6Sec2Application.class, args);
    }
}
