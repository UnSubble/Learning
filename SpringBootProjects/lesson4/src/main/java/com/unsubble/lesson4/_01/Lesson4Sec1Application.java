package com.unsubble.lesson4._01;

import com.unsubble.lesson4.exception.IdOutOfBoundsException;
import com.unsubble.lesson4.model.Student;
import com.unsubble.lesson4.response.StudentDeleteResponse;
import com.unsubble.lesson4.response.StudentUpdateResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/student")
public class Lesson4Sec1Application {

    @GetMapping
    public List<Student> allStudents() {
        Student student = new Student("test name", "test last name", "test@email.com");
        return List.of(student);
    }

    @GetMapping("/{id}")
    // eğer path variable ve parameter 100% eşleşiyorsa name vermeye gerek yok
    public Student getStudentById(@PathVariable("id") long id) throws IdOutOfBoundsException {
        if (id < 1)
            throw new IdOutOfBoundsException(String.format("Negative or zero id (%d) is not valid.", id));
        Student mockObj = new Student(id, "test name", "test last name", "test@domain.com");
        if (mockObj == null)
            throw new IdOutOfBoundsException();
        return mockObj;
    }

/*

//    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//    $$$$ Bunları açmak için com.unsubble.lesson4.handler.GlobalExceptionHandlerAdvice'ı kapat. $$$$
//    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    @ExceptionHandler
    public ResponseEntity<StudentNotFoundErrorResponse> handleIdOutOfBoundsException(IdOutOfBoundsException exception) {
        StudentNotFoundErrorResponse response = new StudentNotFoundErrorResponse(HttpStatus.NOT_FOUND.value(),
                new Date().getTime(), exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentNotFoundErrorResponse> handleOtherExceptions(Exception exception) {
        StudentNotFoundErrorResponse response = new StudentNotFoundErrorResponse(HttpStatus.NOT_FOUND.value(),
                new Date().getTime(), exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

*/

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {
        System.out.println("inserted student: " + student);
    }

    @PutMapping("/update")
    public ResponseEntity<StudentUpdateResponse> updateStudent(@RequestBody Student student)
                                                                    throws IdOutOfBoundsException {
        Student mockObj = new Student(1, "test name", "test last name", "test@domain.com");
        if (mockObj == null)
            throw new IdOutOfBoundsException();
        System.out.println("before update: " + mockObj);
        if (student.getEmail() != null && !student.getEmail().isEmpty())
            mockObj.setEmail(student.getEmail());
        if (student.getFirstName() != null && !student.getFirstName().isEmpty())
            mockObj.setFirstName(student.getFirstName());
        if (student.getLastName() != null && !student.getLastName().isEmpty())
            mockObj.setLastName(student.getLastName());
        System.out.println("after update: " + mockObj);
        StudentUpdateResponse response = new StudentUpdateResponse(HttpStatus.OK.value(), System.currentTimeMillis(),
                "The related student is updated.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StudentDeleteResponse> deleteStudent(@PathVariable("id") long id)
                                                                throws IdOutOfBoundsException {
        if (id < 1)
            throw new IdOutOfBoundsException(String.format("Negative or zero id (%d) is not valid.", id));
        Student mockObj = new Student(id, "test name", "test last name", "test@domain.com");
        if (mockObj == null)
            throw new IdOutOfBoundsException();
        System.out.println("deleted: " + mockObj);
        StudentDeleteResponse response = new StudentDeleteResponse(HttpStatus.OK.value(), System.currentTimeMillis(),
                "The deletion is successful.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
