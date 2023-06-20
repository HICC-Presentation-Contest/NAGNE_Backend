package com.hicc.nagne_backend.domain.locationinfo.application.mapper;

import com.hicc.nagne_backend.domain.locationinfo.application.dto.request.LocationInfoRequest;
import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import com.hicc.nagne_backend.domain.locationinfo.domain.entity.Address;
import com.hicc.nagne_backend.domain.locationinfo.domain.entity.LocationInfo;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationInfoMapper
{
    public static LocationInfoResponse.LocationInfoUserResponse mapToLocationInfoUserResponse(LocationInfo locationInfo) {
        return LocationInfoResponse.LocationInfoUserResponse.builder()
                .place(locationInfo.getAddress().getPlaceName())
                .sequence(locationInfo.getSequence())
                .build();
    }

    public static LocationInfo mapToLocationInfo(Trip trip, LocationInfoRequest.LocationInfoCreate locationInfoCreate, Address address) {
        return LocationInfo.builder()
                .trip(trip)
                .address(address)
                .description(locationInfoCreate.getDescription())
                .sequence(locationInfoCreate.getSequence())
                .build();
    }

    public static LocationInfoResponse.LocationInfoDetailsResponse mapToLocationInfoDetailsResponse(LocationInfo locationInfo, String imageUrl) {
        return LocationInfoResponse.LocationInfoDetailsResponse.builder()
                .place(locationInfo.getAddress().getPlaceName())
                .description(locationInfo.getDescription())
                .sequence(locationInfo.getSequence())
                .imageUrl(imageUrl)
                .build();
    }
}
