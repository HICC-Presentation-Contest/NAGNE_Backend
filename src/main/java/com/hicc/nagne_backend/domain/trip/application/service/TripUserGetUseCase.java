package com.hicc.nagne_backend.domain.trip.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.domain.bookmark.domain.service.BookMarkQueryService;
import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import com.hicc.nagne_backend.domain.locationinfo.application.mapper.LocationInfoMapper;
import com.hicc.nagne_backend.domain.locationinfo.domain.entity.LocationInfo;
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
public class TripUserGetUseCase {

    private final TripQueryService tripQueryService;
    private final LocationInfoQueryService locationInfoQueryService;
    private final BookMarkQueryService bookMarkQueryService;

    public SliceResponse<TripResponse.TripUserSimpleResponse> getTripSimpleListByUserId(Long userId, Pageable pageable) {
        final Slice<Trip> tripList = tripQueryService.findByUserId(userId, pageable);
        final Slice<TripResponse.TripUserSimpleResponse> TripSimpleResponseList = tripList.map(trip -> {
            Long tripId = trip.getId();
            List<LocationInfo> locationInfoListByTripId = locationInfoQueryService.findByTripId(tripId);
            List<LocationInfoResponse.LocationInfoSimpleResponse> locationInfoUserResponseList =
                    locationInfoListByTripId
                            .stream()
                            .map(LocationInfoMapper::mapToLocationInfoSimpleResponse)
                            .collect(Collectors.toList());
            return TripMapper.mapToTripSimpleResponse(trip, locationInfoUserResponseList);
        });

        return SliceResponse.of(TripSimpleResponseList);
    }

    public SliceResponse<TripResponse.TripUserResponse> getTripListByUserId(final Long userId, Pageable pageable){
        final Slice<Trip> tripList = tripQueryService.findByUserId(userId, pageable);
        final Slice<TripResponse.TripUserResponse> tripUserResponseSlice = tripList.map(trip -> {
            final Long tripId = trip.getId();
            final boolean isBookMark = bookMarkQueryService.existsByUserIdAndTripId(userId, tripId);
            return TripMapper.mapToTripUserResponse(trip, isBookMark);
        });
        return SliceResponse.of(tripUserResponseSlice);
    }
}
