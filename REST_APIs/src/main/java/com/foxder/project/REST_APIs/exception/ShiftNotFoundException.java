package com.foxder.project.REST_APIs.exception;

public class ShiftNotFoundException extends RuntimeException {
    public ShiftNotFoundException(String message) {
        super(message);
    }
}
