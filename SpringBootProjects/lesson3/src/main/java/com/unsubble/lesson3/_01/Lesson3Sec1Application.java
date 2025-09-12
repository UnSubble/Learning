package com.unsubble.lesson3._01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.unsubble.lesson3.dao")
public class Lesson3Sec1Application {

    @Bean
    public CommandLineRunner commandLineRunner() {
        return runner -> System.out.println("hello world");
    }
}
