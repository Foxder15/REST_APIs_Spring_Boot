package com.foxder.project.REST_APIs.controller;

import com.foxder.project.REST_APIs.DTOs.request.shifts.PostShiftsRequest;
import com.foxder.project.REST_APIs.DTOs.response.ApiResponse;
import com.foxder.project.REST_APIs.DTOs.response.shitfs.ShiftsResponse;
import com.foxder.project.REST_APIs.model.Shifts;
import com.foxder.project.REST_APIs.service.ShiftsService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shifts")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ShiftsController {
    ShiftsService shiftsService;

    // Fetch all shifts.
    @GetMapping
    public ResponseEntity<ApiResponse<List<ShiftsResponse>>> fetchAllShifts() {
        List<ShiftsResponse> shiftsResponseList = this.shiftsService.fetchAllShifts();
        ApiResponse<List<ShiftsResponse>> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), HttpStatus.OK.name(), shiftsResponseList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    // Post a new shifts.
    @PostMapping
    public ResponseEntity<ApiResponse<Shifts>>  save(@RequestBody PostShiftsRequest shiftsRequest) {
        Shifts shifts = shiftsService.save(shiftsRequest);
        ApiResponse<Shifts> apiResponse = new ApiResponse<>(HttpStatus.CREATED.value(), "success", shifts);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
