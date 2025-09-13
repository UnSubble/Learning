package com.unsubble.lesson4.response;

public class StudentNotFoundErrorResponse extends CommonResponse {
    public StudentNotFoundErrorResponse(int statusCode, long timestamp, String message) {
        super(statusCode, timestamp, message);
    }
}
