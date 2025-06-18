package com.foxder.project.REST_APIs.service;

import com.foxder.project.REST_APIs.DTOs.request.employee.PostEmployeeRequest;
import com.foxder.project.REST_APIs.DTOs.request.employee.UpdateEmployeeRequest;
import com.foxder.project.REST_APIs.DTOs.request.shifts.ShiftEmployeeRequest;
import com.foxder.project.REST_APIs.DTOs.response.employee.EmployeeDetailResponse;
import com.foxder.project.REST_APIs.DTOs.response.employee.EmployeeResponse;
import com.foxder.project.REST_APIs.exception.EmployeeExistedException;
import com.foxder.project.REST_APIs.exception.EmployeeNotFoundException;
import com.foxder.project.REST_APIs.exception.ShiftNotFoundException;
import com.foxder.project.REST_APIs.mapper.EmployeeMapper;
import com.foxder.project.REST_APIs.model.Employee;
import com.foxder.project.REST_APIs.model.EmployeeShifts;
import com.foxder.project.REST_APIs.model.Shifts;
import com.foxder.project.REST_APIs.repository.EmployeeRepository;
import com.foxder.project.REST_APIs.repository.EmployeeShiftsRepository;
import com.foxder.project.REST_APIs.repository.ShiftsRepository;
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
    ShiftsRepository shiftsRepository;
    EmployeeShiftsRepository employeeShiftsRepository;
    EmployeeMapper employeeMapper;

    public List<EmployeeResponse> fetchAllEmployees() {
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        this.employeeRepository.findAll().forEach(employee ->
                employeeResponseList.add(this.employeeMapper.toEmployeeResponse(employee))
        );

        return employeeResponseList;
    }

    public EmployeeDetailResponse fetchEmployeeById(Long employeeId) {
        Employee employee = this.employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Employee ID: " + employeeId + " Not Found"));
        return employeeMapper.toEmployeeDetailResponse(employee);
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

    public EmployeeResponse updateEmployee(Long employeeId, UpdateEmployeeRequest employeeRequest) {
        Employee currentEmployee = this.employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Employee ID: " + employeeId + " Not Found"));

        this.employeeMapper.employeeRequestToEmployee(employeeRequest, currentEmployee);

        this.employeeRepository.save(currentEmployee);
        return employeeMapper.toEmployeeResponse(currentEmployee);
    }

    public EmployeeDetailResponse addShiftToEmployee(Long employeeId, ShiftEmployeeRequest shiftEmployeeRequest) {
        Employee currentEmployee = this.employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("Employee ID: " + employeeId + " Not Found"));
        Shifts currentShifts = this.shiftsRepository.findByShiftName(shiftEmployeeRequest.getPostShiftsRequest().getShiftName()).orElseThrow(() -> new ShiftNotFoundException(shiftEmployeeRequest.getPostShiftsRequest().getShiftName() + " Not Found"));

        EmployeeShifts employeeShifts = new EmployeeShifts();
        employeeShifts.setDate(shiftEmployeeRequest.getDate());
        employeeShifts.setEmployee(currentEmployee);
        employeeShifts.setShift(currentShifts);
        employeeShifts = this.employeeShiftsRepository.save(employeeShifts);
        currentEmployee.addShiftToEmployee(employeeShifts);
        currentEmployee = this.employeeRepository.save(currentEmployee);


        return  this.employeeMapper.toEmployeeDetailResponse(currentEmployee);

    }

    private void checkExistedEmployee(PostEmployeeRequest employeeRequest) {
        if (this.employeeRepository.existsByEmail(employeeRequest.getEmail())) {
            throw new EmployeeExistedException(employeeRequest.getEmail() + " already exists");
        }
    }
}

