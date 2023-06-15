package com.hicc.nagne_backend.domain.locationinfo.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import com.hicc.nagne_backend.domain.locationinfo.application.mapper.LocationInfoMapper;
import com.hicc.nagne_backend.domain.locationinfo.domain.entity.LocationInfo;
import com.hicc.nagne_backend.domain.locationinfo.domain.service.LocationInfoQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@UseCase
@RequiredArgsConstructor
@Transactional
public class LocationInfoGetUseCase {
    
    private final LocationInfoQueryService locationInfoQueryService;
    
    public List<LocationInfoResponse.LocationInfoUserResponse> getLocationInfo(Long tripId) {
        List<LocationInfo> LocationInfoList = locationInfoQueryService.findByTripId(tripId);
        return LocationInfoMapper.mapToLocationInfoUserResponse(LocationInfoList);
    }
}
