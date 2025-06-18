package com.foxder.project.REST_APIs.service;

import com.foxder.project.REST_APIs.DTOs.request.shifts.PostShiftsRequest;
import com.foxder.project.REST_APIs.DTOs.response.shitfs.ShiftsResponse;
import com.foxder.project.REST_APIs.exception.ShiftExistedException;
import com.foxder.project.REST_APIs.mapper.ShiftsMapper;
import com.foxder.project.REST_APIs.model.Shifts;
import com.foxder.project.REST_APIs.repository.ShiftsRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ShiftsService {
    ShiftsRepository shiftsRepository;
    ShiftsMapper shiftsMapper;

    public Shifts save(PostShiftsRequest shiftsRequest) {
        // Check if shift is existed, failed to save.
        if (this.shiftsRepository.existsByShiftName(shiftsRequest.getShiftName())) {
            throw new ShiftExistedException(shiftsRequest.getShiftName() + " already exists");
        }

        Shifts shifts = shiftsMapper.toShifts(shiftsRequest);
        return shiftsRepository.save(shifts);
    }

    public List<ShiftsResponse> fetchAllShifts() {
        List<ShiftsResponse> shiftsResponseList = new ArrayList<>();
        this.shiftsRepository.findAll().forEach(shifts ->
                shiftsResponseList.add(this.shiftsMapper.toShiftsResponse(shifts))
        );

        return shiftsResponseList;
    }
}
