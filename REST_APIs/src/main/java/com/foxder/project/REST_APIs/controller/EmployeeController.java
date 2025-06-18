package com.foxder.project.REST_APIs.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.foxder.project.REST_APIs.DTOs.request.employee.PostEmployeeRequest;
import com.foxder.project.REST_APIs.DTOs.request.employee.UpdateEmployeeRequest;
import com.foxder.project.REST_APIs.DTOs.request.shifts.ShiftEmployeeRequest;
import com.foxder.project.REST_APIs.DTOs.response.ApiResponse;
import com.foxder.project.REST_APIs.DTOs.response.employee.EmployeeDetailResponse;
import com.foxder.project.REST_APIs.DTOs.response.employee.EmployeeResponse;
import com.foxder.project.REST_APIs.model.Employee;
import com.foxder.project.REST_APIs.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeController {
    
    EmployeeService employeeService;
    
    @GetMapping
    public ResponseEntity<ApiResponse<List<EmployeeResponse>>> fetchAllEmployees() {
        List<EmployeeResponse> employeeResponseList = this.employeeService.fetchAllEmployees();
        ApiResponse<List<EmployeeResponse>> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "Success", employeeResponseList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{Employee_id}")
    public ResponseEntity<ApiResponse<EmployeeDetailResponse>> fetchEmployeeById(@PathVariable("Employee_id") Long Employee_id) {
        EmployeeDetailResponse employeeDetailResponse = this.employeeService.fetchEmployeeById(Employee_id);
        ApiResponse<EmployeeDetailResponse> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "Success", employeeDetailResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> createEmployee(@Valid @RequestBody PostEmployeeRequest employeeRequest) {
        Employee employee = this.employeeService.createEmployee(employeeRequest);
        ApiResponse<Employee> apiResponse = new ApiResponse<>(HttpStatus.CREATED.value(), "Employee Created", employee);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{Employee_id}")
    public ResponseEntity<ApiResponse<Employee>> deleteEmployee(@PathVariable("Employee_id") Long Employee_id) {
        Employee employee = this.employeeService.deleteEmployee(Employee_id);
        ApiResponse<Employee> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "Employee Deleted", employee);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/{Employee_id}")
    public ResponseEntity<ApiResponse<EmployeeResponse>> updateEmployee(@PathVariable("Employee_id") Long Employee_id, @RequestBody UpdateEmployeeRequest employeeRequest) {
        EmployeeResponse employeeResponse = this.employeeService.updateEmployee(Employee_id, employeeRequest);
        ApiResponse<EmployeeResponse> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "Employee Updated", employeeResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/{Employee_id}/shifts")
    public ResponseEntity<ApiResponse<EmployeeDetailResponse>> addShiftToEmployee(@PathVariable("Employee_id") Long Employee_id,
                                                                                  @RequestBody ShiftEmployeeRequest shiftEmployeeRequest) {
        EmployeeDetailResponse employeeDetailResponse = this.employeeService.addShiftToEmployee(Employee_id, shiftEmployeeRequest);
        ApiResponse<EmployeeDetailResponse> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), "success", employeeDetailResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


}
