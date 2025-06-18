package com.foxder.project.REST_APIs.mapper;

import com.foxder.project.REST_APIs.DTOs.request.employee.PostEmployeeRequest;
import com.foxder.project.REST_APIs.DTOs.request.employee.UpdateEmployeeRequest;
import com.foxder.project.REST_APIs.DTOs.response.employee.EmployeeDetailResponse;
import com.foxder.project.REST_APIs.DTOs.response.employee.EmployeeResponse;
import com.foxder.project.REST_APIs.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee toEmployee(PostEmployeeRequest requestEmployee);

    EmployeeResponse toEmployeeResponse(Employee employeeEmployee);

    EmployeeDetailResponse toEmployeeDetailResponse(Employee employeeEmployee);

    void employeeRequestToEmployee(UpdateEmployeeRequest requestEmployee, @MappingTarget Employee employee);
}
