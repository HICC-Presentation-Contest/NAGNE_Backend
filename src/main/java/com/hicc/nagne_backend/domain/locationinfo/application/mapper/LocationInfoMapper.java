package com.hicc.nagne_backend.domain.locationinfo.application.mapper;

import com.hicc.nagne_backend.domain.locationinfo.application.dto.request.LocationInfoRequest;
import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import com.hicc.nagne_backend.domain.locationinfo.domain.entity.Address;
import com.hicc.nagne_backend.domain.locationinfo.domain.entity.LocationInfo;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationInfoMapper
{
    public static LocationInfo mapToLocationInfo(Trip trip, LocationInfoRequest.LocationInfoCreate locationInfoCreate) {
        Address address = new Address(null, locationInfoCreate.getLongitude(), locationInfoCreate.getLatitude());
        log.info("address: {}", address);
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

    public static LocationInfoResponse.LocationInfoBookMarkResponse mapToLocationInfoBookMarkResponse(LocationInfo locationInfo) {
        return LocationInfoResponse.LocationInfoBookMarkResponse.builder()
                .address(locationInfo.getAddress())
                .sequence(locationInfo.getSequence())
                .build();
    }

    public static LocationInfoResponse.LocationInfoSimpleResponse mapToLocationInfoSimpleResponse(LocationInfo locationInfo) {
        return LocationInfoResponse.LocationInfoSimpleResponse.builder()
                .placeName(locationInfo.getAddress().getPlaceName())
                .sequence(locationInfo.getSequence())
                .build();
    }

    public static LocationInfoResponse.LocationInfoMainPageResponse mapToLocationInfoMainPageResponse(LocationInfo locationInfo) {
        return LocationInfoResponse.LocationInfoMainPageResponse.builder()
                .address(locationInfo.getAddress())
                .sequence(locationInfo.getSequence())
                .build();
    }
}
