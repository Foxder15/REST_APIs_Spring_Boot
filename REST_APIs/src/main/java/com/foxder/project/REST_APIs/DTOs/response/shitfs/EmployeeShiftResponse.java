package com.foxder.project.REST_APIs.DTOs.response.shitfs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeShiftResponse {
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;
    ShiftsResponse shift;
}
