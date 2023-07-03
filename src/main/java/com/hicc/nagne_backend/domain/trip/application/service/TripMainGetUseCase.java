package com.hicc.nagne_backend.domain.trip.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import com.hicc.nagne_backend.domain.locationinfo.application.mapper.LocationInfoMapper;
import com.hicc.nagne_backend.domain.locationinfo.domain.service.LatitudeLongitudeConvertAddressService;
import com.hicc.nagne_backend.domain.locationinfo.domain.service.LocationInfoQueryService;
import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.application.mapper.TripMapper;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.trip.domain.service.TripQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@UseCase
@RequiredArgsConstructor
@Transactional
public class TripMainGetUseCase {

    private final LatitudeLongitudeConvertAddressService latitudeLongitudeConvertAddressService;
    private final TripQueryService tripQueryService;
    private final LocationInfoQueryService locationInfoQueryService;

    public SliceResponse<TripResponse.TripMainPageResponse> getMainPageTrip(final String longitude, final String latitude, Pageable pageable) {
        final String address = latitudeLongitudeConvertAddressService.convertLatitudeLongitudeToAddress(longitude, latitude);
        log.info("address : {}", address);
        final Slice<Trip> tripList = tripQueryService.findMainPageTripList(address, pageable);
        final Slice<TripResponse.TripMainPageResponse> tripSearchResponseList = getTripMainPageResponseSlice(tripList);
        return SliceResponse.of(tripSearchResponseList);
    }

    public SliceResponse<TripResponse.TripMainPageResponse> getMainPageTripByPopularity(final String longitude, final String latitude, Pageable pageable) {
        final String address = latitudeLongitudeConvertAddressService.convertLatitudeLongitudeToAddress(longitude, latitude);
        final Slice<Trip> tripList = tripQueryService.findMainPageTripListByPopularity(address, pageable);
        final Slice<TripResponse.TripMainPageResponse> tripSearchResponseList = getTripMainPageResponseSlice(tripList);
        return SliceResponse.of(tripSearchResponseList);
    }

    private Slice<TripResponse.TripMainPageResponse> getTripMainPageResponseSlice(Slice<Trip> tripList) {
        return tripList.map(
                trip -> {
                    List<LocationInfoResponse.LocationInfoSimpleResponse> locationInfoSimpleResponseList = locationInfoQueryService.findByTripId(trip.getId()).stream()
                            .map(LocationInfoMapper::mapToLocationInfoSimpleResponse)
                            .collect(Collectors.toList());
                    return TripMapper.mapToTripMainPageResponse(trip, locationInfoSimpleResponseList);
                });
    }
}
