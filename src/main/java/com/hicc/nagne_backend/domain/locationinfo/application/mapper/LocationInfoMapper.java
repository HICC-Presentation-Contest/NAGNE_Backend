package com.hicc.nagne_backend.domain.locationinfo.application.mapper;

import com.hicc.nagne_backend.domain.locationinfo.application.dto.LocationInfoRequest;
import com.hicc.nagne_backend.domain.locationinfo.domain.entity.LocationInfo;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationInfoMapper {

    public static List<LocationInfo> mapToLocationInfo(Trip trip, List<LocationInfoRequest.LocationInfoCreate> locationInfoCreate) {
          return locationInfoCreate.stream()
                .map(locationInfo -> LocationInfo.builder()
                        .trip(trip)
                        .address(locationInfo.getAddress())
                        .description(locationInfo.getDescription())
                        .sequence(locationInfo.getSequence())
                        .build())
                .collect(Collectors.toList());
    }
}