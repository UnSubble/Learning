package com.unsubble.app;

import com.unsubble._01.Lesson8Sec1Application;
import com.unsubble._02.Lesson8Sec2Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson8Application {

	public static void main(String[] args) {
        // SpringApplication.run(Lesson8Sec1Application.class, args);
        SpringApplication.run(Lesson8Sec2Application.class, args);
	}

}
