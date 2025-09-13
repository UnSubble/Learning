package com.unsubble.lesson4.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StudentException extends Exception {
    public StudentException(String message) {
        super(message);
    }
}
