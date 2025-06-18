package com.foxder.project.REST_APIs.DTOs.response.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.foxder.project.REST_APIs.DTOs.response.shitfs.EmployeeShiftResponse;
import com.foxder.project.REST_APIs.model.EmployeeShifts;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDetailResponse {
    String email;
    String fullName;
    String position;
    String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy h:mma")
    LocalDateTime joined_date;
    List<EmployeeShiftResponse> shifts;
}
