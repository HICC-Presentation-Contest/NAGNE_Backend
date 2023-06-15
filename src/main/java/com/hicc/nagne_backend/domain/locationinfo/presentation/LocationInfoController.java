package com.hicc.nagne_backend.domain.locationinfo.presentation;

import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import com.hicc.nagne_backend.domain.locationinfo.application.service.LocationInfoGetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocationInfoController {

    private final LocationInfoGetUseCase locationInfoGetUseCase;

    @GetMapping("/locationInfo/{tripId}")
    public List<LocationInfoResponse.LocationInfoUserResponse> getLocationInfo(@PathVariable Long tripId) {
        return locationInfoGetUseCase.getLocationInfo(tripId);
    }
}
