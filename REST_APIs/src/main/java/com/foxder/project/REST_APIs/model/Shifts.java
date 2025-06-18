package com.foxder.project.REST_APIs.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Shifts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    String shiftName;
    @Column(nullable = false)
    @JsonFormat(pattern = "HH:mm a")
    LocalTime shiftStart;
    @Column(nullable = false)
    @JsonFormat(pattern = "HH:mm a")
    LocalTime shiftEnd;
}
