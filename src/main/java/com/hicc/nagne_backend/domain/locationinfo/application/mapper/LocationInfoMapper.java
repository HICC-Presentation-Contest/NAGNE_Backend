package com.hicc.nagne_backend.domain.locationinfo.application.mapper;

import com.hicc.nagne_backend.domain.locationinfo.application.dto.request.LocationInfoRequest;
import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import com.hicc.nagne_backend.domain.locationinfo.domain.entity.Address;
import com.hicc.nagne_backend.domain.locationinfo.domain.entity.LocationInfo;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationInfoMapper
{

    public static List<LocationInfoResponse.LocationInfoUserResponse> mapToLocationInfoUserResponse(List<LocationInfo> locationInfoList) {
        return locationInfoList.stream()
                .map(locationInfo -> LocationInfoResponse.LocationInfoUserResponse.builder()
                        .place(locationInfo.getAddress().getAddress())
                        .sequence(locationInfo.getSequence())
                        .build())
                .collect(Collectors.toList());
    }

    public static LocationInfo mapToLocationInfo(Trip trip, LocationInfoRequest.LocationInfoCreate locationInfoCreate, Address address) {
        return LocationInfo.builder()
                .trip(trip)
                .address(address)
                .description(locationInfoCreate.getDescription())
                .sequence(locationInfoCreate.getSequence())
                .build();
    }
}
