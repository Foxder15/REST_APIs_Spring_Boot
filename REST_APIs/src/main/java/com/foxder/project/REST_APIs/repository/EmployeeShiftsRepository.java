package com.foxder.project.REST_APIs.repository;

import com.foxder.project.REST_APIs.model.EmployeeShifts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeShiftsRepository extends JpaRepository<EmployeeShifts, Long> {
}
