package com.foxder.project.REST_APIs.DTOs.request.shifts;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShiftEmployeeRequest {
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull
    @NotBlank
    LocalDate date;
    @Valid
    PostShiftsRequest postShiftsRequest;
}
