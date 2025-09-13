package com.unsubble.lesson4;

import com.unsubble.lesson4._01.Lesson4Sec1Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Lesson4Application {

	public static void main(String[] args) {
		SpringApplication.run(Lesson4Sec1Application.class, args);
	}

}
