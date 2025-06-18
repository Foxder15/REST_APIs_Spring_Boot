package com.foxder.project.REST_APIs.exception;

public class ShiftExistedException extends RuntimeException {
    public ShiftExistedException(String message) {
        super(message);
    }
}
