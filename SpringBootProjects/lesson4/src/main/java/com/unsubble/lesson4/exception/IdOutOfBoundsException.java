package com.unsubble.lesson4.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IdOutOfBoundsException extends StudentException {
    public IdOutOfBoundsException(String message) {
        super(message);
    }
}
