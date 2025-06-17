package com.foxder.project.REST_APIs.service;

import com.foxder.project.REST_APIs.DTOs.request.PostEmployeeRequest;
import com.foxder.project.REST_APIs.DTOs.request.UpdateEmployeeRequest;
import com.foxder.project.REST_APIs.DTOs.response.ApiResponse;
import com.foxder.project.REST_APIs.DTOs.response.EmployeeResponse;
import com.foxder.project.REST_APIs.exception.EmployeeExistedException;
import com.foxder.project.REST_APIs.exception.EmployeeNotFoundException;
import com.foxder.project.REST_APIs.mapper.EmployeeMapper;
import com.foxder.project.REST_APIs.model.Employee;
import com.foxder.project.REST_APIs.repository.EmployeeRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService {
    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;

    public List<EmployeeResponse> fetchAllEmployees() {
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        this.employeeRepository.findAll().forEach(employee ->
                employeeResponseList.add(this.employeeMapper.toEmployeeResponse(employee))
        );

        return employeeResponseList;
    }

    public EmployeeResponse fetchEmployeeById(Long employeeId) {
        Employee employee = this.employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Employee ID: " + employeeId + " Not Found"));
        return employeeMapper.toEmployeeResponse(employee);
    }

    public Employee createEmployee(PostEmployeeRequest employeeRequest) {

        checkExistedEmployee(employeeRequest);

        Employee employee = this.employeeMapper.toEmployee(employeeRequest);

        employee.setJoined_date(LocalDate.now().atTime(19, 0));

        return this.employeeRepository.save(employee);
    }

    public Employee deleteEmployee(Long employeeId) {
        Employee employee = this.employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Employee ID: " + employeeId + " Not Found"));
        this.employeeRepository.delete(employee);

        return employee;
    }

    private void checkExistedEmployee(PostEmployeeRequest employeeRequest) {
        if (this.employeeRepository.existsByEmail(employeeRequest.getEmail())) {
            throw new EmployeeExistedException(employeeRequest.getEmail() + " already exists");
        }
    }

    public EmployeeResponse updateEmployee(Long employeeId, UpdateEmployeeRequest employeeRequest) {
        Employee currentEmployee = this.employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Employee ID: " + employeeId + " Not Found"));

        this.employeeMapper.employeeRequestToEmployee(employeeRequest, currentEmployee);

        this.employeeRepository.save(currentEmployee);
        return employeeMapper.toEmployeeResponse(currentEmployee);
    }
}

