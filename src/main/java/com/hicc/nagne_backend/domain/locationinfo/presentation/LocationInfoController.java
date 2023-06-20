package com.hicc.nagne_backend.domain.locationinfo.presentation;

import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import com.hicc.nagne_backend.domain.locationinfo.application.service.LocationInfoGetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LocationInfoController {

    private final LocationInfoGetUseCase locationInfoGetUseCase;

    @GetMapping("/locationInfo/{tripId}")
    public SliceResponse<LocationInfoResponse.LocationInfoUserResponse> getLocationInfo(@PathVariable Long tripId, Pageable pageable) {
        return locationInfoGetUseCase.getLocationInfo(tripId, pageable);
    }
}
