package com.unsubble.lesson3._01;

import com.unsubble.lesson3.dao.StudentDAO;
import com.unsubble.lesson3.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.unsubble.lesson3.dao"})
@EntityScan(basePackages = {"com.unsubble.lesson3.entity"})
public class Lesson3Sec1Application {

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            /*Student student = new Student("student name", "student last name", "student@mail.com");
            studentDAO.save(student);
            Student fromDb = studentDAO.findById(student.getId());
            System.out.println(fromDb);*/

            studentDAO.findAll().forEach(System.out::println);
        };
    }
}
