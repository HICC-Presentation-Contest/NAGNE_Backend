package com.hicc.nagne_backend.domain.trip.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.domain.locationimage.domain.service.LocationImageQueryService;
import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import com.hicc.nagne_backend.domain.locationinfo.application.mapper.LocationInfoMapper;
import com.hicc.nagne_backend.domain.locationinfo.domain.service.LocationInfoQueryService;
import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.application.mapper.TripMapper;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.trip.domain.service.TripQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@UseCase
@RequiredArgsConstructor
@Transactional
public class TripGetUseCase {

    private final TripQueryService tripQueryService;
    private final LocationInfoQueryService locationInfoQueryService;
    private final LocationImageQueryService locationImageQueryService;

    public TripResponse.TripInfoResponse getTrip(Long tripId) {
        Trip trip = tripQueryService.findById(tripId);
        List<LocationInfoResponse.LocationInfoDetailsResponse> locationInfoDetailsResponseList =
                locationInfoQueryService.findByTripId(tripId).stream()
                        .map(locationInfo -> {
                            String imageUrl = locationImageQueryService.findImageUrlByLocationInfoId(locationInfo.getId());
                            return LocationInfoMapper.mapToLocationInfoDetailsResponse(locationInfo, imageUrl);
                        }).collect(Collectors.toList());
        TripResponse.TripInfoResponse tripInfoResponse = TripMapper.mapToTripInfoResponse(trip, locationInfoDetailsResponseList);
        return tripInfoResponse;
    }

    public SliceResponse<TripResponse.TripSimpleResponse> getTripList(Long userId, Pageable pageable) {
        Slice<Trip> tripList = tripQueryService.findByUserId(userId, pageable);

        Slice<TripResponse.TripSimpleResponse> TripSimpleResponseList =
                tripList.map(trip ->
                {
                    return TripMapper.mapToTripSimpleResponse(trip);
                });

        return SliceResponse.of(TripSimpleResponseList);
    }
}
