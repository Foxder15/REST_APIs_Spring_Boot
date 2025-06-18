package com.foxder.project.REST_APIs.DTOs.request.shifts;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostShiftsRequest {
    @Size(min = 1, message = "Tên không được để trống")
    String shiftName;
    @NotNull@Size(min = 1, message = "Thời gian bắt đầu ca làm không được để trống")
    @JsonFormat(pattern = "HH:mm a")
    LocalTime shiftStart;
    @NotNull@Size(min = 1, message = "Thời gian kết thúc ca làm không được để trống")
    @JsonFormat(pattern = "HH:mm a")
    LocalTime shiftEnd;
}
