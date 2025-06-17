package com.foxder.project.REST_APIs.mapper;

import com.foxder.project.REST_APIs.DTOs.request.PostEmployeeRequest;
import com.foxder.project.REST_APIs.DTOs.request.UpdateEmployeeRequest;
import com.foxder.project.REST_APIs.DTOs.response.EmployeeResponse;
import com.foxder.project.REST_APIs.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee toEmployee(PostEmployeeRequest requestEmployee);

    EmployeeResponse toEmployeeResponse(Employee employeeEmployee);

    void employeeRequestToEmployee(UpdateEmployeeRequest requestEmployee, @MappingTarget Employee employee);
}
