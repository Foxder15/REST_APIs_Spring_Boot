package com.foxder.project.REST_APIs.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    String email;
    @Column(nullable = false)
    String password;
    @Column(nullable = false)
    String fullName;
    @Column(nullable = false)
    String position;
    @Column(nullable = false)
    String status;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy h:mma")
    LocalDateTime joined_date;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<EmployeeShifts> shifts;

    public void addShiftToEmployee(EmployeeShifts shift) {
        if (this.shifts == null) {
            this.shifts = new ArrayList<>();
        }
        this.shifts.add(shift);
    }
}
