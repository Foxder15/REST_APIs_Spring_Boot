package com.foxder.project.REST_APIs.exception;

import com.foxder.project.REST_APIs.DTOs.response.ApiResponse;
import com.foxder.project.REST_APIs.model.Employee;
import jakarta.servlet.ServletException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        ApiResponse<Map<String, String>> apiResponse = new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), "Bad values", errors);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EmployeeExistedException.class)
    public ResponseEntity<ApiResponse<String>> handleEmployeeExistedException(EmployeeExistedException ex) {
        ApiResponse<String> apiResponse = new ApiResponse<>(HttpStatus.CONFLICT.value(), ex.getMessage(), null);
        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        ApiResponse<String> apiResponse = new ApiResponse<>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ShiftExistedException.class)
    public ResponseEntity<ApiResponse<String>> handleShiftExistedException(ShiftExistedException ex) {
        ApiResponse<String> apiResponse = new ApiResponse<>(HttpStatus.CONFLICT.value(), ex.getMessage(), null);
        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = ShiftNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleShiftNotFoundException(ShiftNotFoundException ex) {
        ApiResponse<String> apiResponse = new ApiResponse<>(HttpStatus.NOT_FOUND.value(), ex.getMessage(), null);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(value = RuntimeException.class)
//    public ResponseEntity<String> handleException(RuntimeException ex) {
//        return new ResponseEntity<>("Fail to request", HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(value = ServletException.class)
    public ResponseEntity<String> handleNoHandlerFoundException(ServletException ex) {
        return new ResponseEntity<>("Content not found", HttpStatus.NOT_FOUND);
    }
}
