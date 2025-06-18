package com.foxder.project.REST_APIs.mapper;

import com.foxder.project.REST_APIs.DTOs.request.shifts.PostShiftsRequest;
import com.foxder.project.REST_APIs.DTOs.response.shitfs.ShiftsResponse;
import com.foxder.project.REST_APIs.model.Shifts;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShiftsMapper {
    Shifts toShifts(PostShiftsRequest postShiftsRequest);
    ShiftsResponse toShiftsResponse(Shifts shifts);
}
