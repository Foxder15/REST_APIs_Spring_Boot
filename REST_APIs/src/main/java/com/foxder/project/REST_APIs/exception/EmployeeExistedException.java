package com.foxder.project.REST_APIs.exception;

public class EmployeeExistedException extends RuntimeException {
    public EmployeeExistedException(String message) {
        super(message);
    }
}
