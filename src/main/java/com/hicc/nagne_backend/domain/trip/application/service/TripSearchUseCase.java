package com.hicc.nagne_backend.domain.trip.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.application.mapper.TripMapper;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.trip.domain.service.TripQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TripSearchUseCase {

    private final TripQueryService tripQueryService;

    public SliceResponse<TripResponse.TripSearchResponse> getTripListByAddress(final String address, Pageable pageable){
        final Slice<Trip> tripList = tripQueryService.findTripListByAddress(address, pageable);
        return SliceResponse.of(getTripSearchResponseSlice(tripList));
    }

    private Slice<TripResponse.TripSearchResponse> getTripSearchResponseSlice(Slice<Trip> tripList) {
        return tripList.map(TripMapper::mapToTripSearchResponse);
    }
}
