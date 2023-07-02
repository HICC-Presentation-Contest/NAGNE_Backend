package com.hicc.nagne_backend.domain.trip.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.util.UserUtils;
import com.hicc.nagne_backend.domain.bookmark.domain.service.BookMarkQueryService;
import com.hicc.nagne_backend.domain.locationimage.domain.service.LocationImageQueryService;
import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import com.hicc.nagne_backend.domain.locationinfo.application.mapper.LocationInfoMapper;
import com.hicc.nagne_backend.domain.locationinfo.domain.service.LocationInfoQueryService;
import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.application.mapper.TripMapper;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.trip.domain.service.TripQueryService;
import lombok.RequiredArgsConstructor;
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
    private final UserUtils userUtils;
    private final BookMarkQueryService bookMarkQueryService;

    public TripResponse.TripInfoResponse getTrip(final Long tripId) {
        final Trip trip = tripQueryService.findById(tripId);
        final boolean bookMark = bookMarkQueryService.existsByUserIdAndTripId(userUtils.getUser().getId(), tripId);
        final List<LocationInfoResponse.LocationInfoDetailsResponse> locationInfoDetailsResponseList =
                locationInfoQueryService.findByTripId(tripId).stream()
                        .map(locationInfo -> {
                            final String imageUrl = locationImageQueryService.findImageUrlByLocationInfoId(locationInfo.getId());
                            return LocationInfoMapper.mapToLocationInfoDetailsResponse(locationInfo, imageUrl);
                        }).collect(Collectors.toList());
        return TripMapper.mapToTripInfoResponse(trip, locationInfoDetailsResponseList, bookMark);
    }

}
