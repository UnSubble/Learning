package com.unsubble.lesson4._01.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Product error")
public class ProductException extends RuntimeException {
}
