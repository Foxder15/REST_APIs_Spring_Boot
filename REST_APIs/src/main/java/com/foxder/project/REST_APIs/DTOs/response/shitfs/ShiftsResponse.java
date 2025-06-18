package com.foxder.project.REST_APIs.DTOs.response.shitfs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShiftsResponse {
    String shiftName;
    @JsonFormat(pattern = "HH:mm a")
    LocalTime shiftStart;
    @JsonFormat(pattern = "HH:mm a")
    LocalTime shiftEnd;
}
