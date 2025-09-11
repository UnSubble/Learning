package com.unsubble.app;

import com.unsubble._01.Person;
import com.unsubble._02.Lesson2Sec2Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.unsubble._01"})
// verilmezse sadece class'ın olduğu paket ve alt paketlere bakar.
@RestController
public class Lesson2Application {

    private Person person;

	public static void main(String[] args) {
        // SpringApplication.run(Lesson2Application.class, args);
        SpringApplication.run(Lesson2Sec2Application.class, args);
	}

    @Autowired
    public void setPerson(Person person) {
        this.person = person;
    }

    @GetMapping("/test")
    public String testPage() {
        return person.toString();
    }

}
