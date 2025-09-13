package com.unsubble.lesson4.handler;

import com.unsubble.lesson4.exception.IdOutOfBoundsException;
import com.unsubble.lesson4.response.StudentNotFoundErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice // rest ile request arasına bir ara katman açar ve handle'lar.
public class GlobalExceptionHandlerAdvice {


    @ExceptionHandler
    public ResponseEntity<StudentNotFoundErrorResponse> handleIdOutOfBoundsException(IdOutOfBoundsException exception) {
        StudentNotFoundErrorResponse response = new StudentNotFoundErrorResponse(HttpStatus.NOT_FOUND.value(),
                new Date().getTime(), exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentNotFoundErrorResponse> handleOtherExceptions(Exception exception) {
        StudentNotFoundErrorResponse response = new StudentNotFoundErrorResponse(HttpStatus.BAD_REQUEST.value(),
                new Date().getTime(), exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
