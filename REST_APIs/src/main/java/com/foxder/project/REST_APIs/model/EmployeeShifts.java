package com.foxder.project.REST_APIs.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeShifts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    Employee employee;

    @ManyToOne
    @JoinColumn(name = "shift_id")
    Shifts shift;
}
