package com.hicc.nagne_backend.domain.trip.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.domain.locationinfo.domain.service.LatitudeLongitudeConvertAddressService;
import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.application.mapper.TripMapper;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.trip.domain.service.TripQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@UseCase
@RequiredArgsConstructor
@Transactional
public class TripMainGetUseCase {

    private final LatitudeLongitudeConvertAddressService latitudeLongitudeConvertAddressService;
    private final TripQueryService tripQueryService;

    public SliceResponse<TripResponse.TripMainPageResponse> getMainPageTrip(final String longitude, final String latitude, Pageable pageable) {
        final String address = latitudeLongitudeConvertAddressService.convertLatitudeLongitudeToAddress(longitude, latitude);
        log.info("address : {}", address);
        final Slice<Trip> tripList = tripQueryService.findMainPageTripList(address, pageable);
        final Slice<TripResponse.TripMainPageResponse> tripSearchResponseList = tripList.map(TripMapper::mapToTripMainPageResponse);
        return SliceResponse.of(tripSearchResponseList);
    }

    public SliceResponse<TripResponse.TripMainPageResponse> getMainPageTripByPopularity(final String longitude,final String latitude, Pageable pageable) {
        final String address = latitudeLongitudeConvertAddressService.convertLatitudeLongitudeToAddress(longitude, latitude);
        final Slice<Trip> tripList = tripQueryService.findMainPageTripListByPopularity(address, pageable);
        final Slice<TripResponse.TripMainPageResponse> tripSearchResponseList = tripList.map(TripMapper::mapToTripMainPageResponse);
        return SliceResponse.of(tripSearchResponseList);
    }
}
