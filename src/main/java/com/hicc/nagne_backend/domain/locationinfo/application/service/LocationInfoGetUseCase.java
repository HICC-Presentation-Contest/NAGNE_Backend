package com.hicc.nagne_backend.domain.locationinfo.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import com.hicc.nagne_backend.domain.locationinfo.application.mapper.LocationInfoMapper;
import com.hicc.nagne_backend.domain.locationinfo.domain.entity.LocationInfo;
import com.hicc.nagne_backend.domain.locationinfo.domain.service.LocationInfoQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class LocationInfoGetUseCase {
    
    private final LocationInfoQueryService locationInfoQueryService;
    
    public SliceResponse<LocationInfoResponse.LocationInfoUserResponse> getLocationInfo(Long tripId, Pageable pageable) {
        Slice<LocationInfo> LocationInfoList = locationInfoQueryService.findByTripId(tripId, pageable);

        Slice<LocationInfoResponse.LocationInfoUserResponse> LocationInfoUserResponse =
                LocationInfoList.map(locationInfo -> {
                    return LocationInfoMapper.mapToLocationInfoUserResponse(locationInfo);
                });

        return SliceResponse.of(LocationInfoUserResponse);
    }
}
