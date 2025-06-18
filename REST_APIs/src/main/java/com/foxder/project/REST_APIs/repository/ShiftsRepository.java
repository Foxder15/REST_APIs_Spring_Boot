package com.foxder.project.REST_APIs.repository;

import com.foxder.project.REST_APIs.model.Shifts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShiftsRepository extends JpaRepository<Shifts, Long> {
    boolean existsByShiftName(String shiftName);
    Optional<Shifts> findByShiftName(String shiftName);
}
