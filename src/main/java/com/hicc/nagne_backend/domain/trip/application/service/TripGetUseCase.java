package com.hicc.nagne_backend.domain.trip.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.common.util.UserUtils;
import com.hicc.nagne_backend.domain.bookmark.domain.service.BookMarkQueryService;
import com.hicc.nagne_backend.domain.locationimage.domain.service.LocationImageQueryService;
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
public class TripGetUseCase {

    private final TripQueryService tripQueryService;
    private final LocationInfoQueryService locationInfoQueryService;
    private final LocationImageQueryService locationImageQueryService;
    private final UserUtils userUtils;
    private final BookMarkQueryService bookMarkQueryService;

    public TripResponse.TripInfoResponse getTrip(Long tripId) {
        Trip trip = tripQueryService.findById(tripId);
        boolean bookMark = bookMarkQueryService.existsByUserIdAndTripId(userUtils.getUser().getId(), tripId);
        List<LocationInfoResponse.LocationInfoDetailsResponse> locationInfoDetailsResponseList =
                locationInfoQueryService.findByTripId(tripId).stream()
                        .map(locationInfo -> {
                            String imageUrl = locationImageQueryService.findImageUrlByLocationInfoId(locationInfo.getId());
                            return LocationInfoMapper.mapToLocationInfoDetailsResponse(locationInfo, imageUrl);
                        }).collect(Collectors.toList());
        TripResponse.TripInfoResponse tripInfoResponse = TripMapper.mapToTripInfoResponse(trip, locationInfoDetailsResponseList, bookMark);
        return tripInfoResponse;
    }

    public SliceResponse<TripResponse.TripSimpleResponse> getTripListByUserId(Long userId, Pageable pageable) {
        Slice<Trip> tripList = tripQueryService.findByUserId(userId, pageable);

        Slice<TripResponse.TripSimpleResponse> TripSimpleResponseList =
                tripList.map(trip ->
                {
                    Long tripId = trip.getId();
                    List<LocationInfo> locationInfoListByTripId = locationInfoQueryService.findByTripId(tripId);
                    List<LocationInfoResponse.LocationInfoSimpleResponse> locationInfoUserResponseList =
                            locationInfoListByTripId.stream().map(locationInfo -> {
                                return LocationInfoMapper.mapToLocationInfoSimpleResponse(locationInfo);
                            }).collect(Collectors.toList());
                    return TripMapper.mapToTripSimpleResponse(trip, locationInfoUserResponseList);
                });

        return SliceResponse.of(TripSimpleResponseList);
    }

    public SliceResponse<TripResponse.TripSearchResponse> getTripListByAddress(String address, Pageable pageable){
    	Slice<Trip> tripList = tripQueryService.findTripListByAddress(address, pageable);

        return SliceResponse.of(getTripSearchResponseSlice(tripList));
    }


    public SliceResponse<TripResponse.TripMainPageResponse> getMainPageTrip(String address, Pageable pageable) {
        Slice<Trip> tripList = tripQueryService.findMainPageTripList(address, pageable);

        Slice<TripResponse.TripMainPageResponse> tripSearchResponseList =
                tripList.map(trip ->
                {
                    Long tripId = trip.getId();
                    List<LocationInfo> locationInfoListByTripId = locationInfoQueryService.findByTripId(tripId);
                    List<LocationInfoResponse.LocationInfoMainPageResponse> LocationInfoMainPageResponseList =
                            locationInfoListByTripId.stream().map(locationInfo -> {
                                return LocationInfoMapper.mapToLocationInfoMainPageResponse(locationInfo);
                            }).collect(Collectors.toList());
                    return TripMapper.mapToTripMainPageResponse(trip, LocationInfoMainPageResponseList);
                });

        return SliceResponse.of(tripSearchResponseList);
    }

    public Slice getTripListByTag(String tagName, Pageable pageable) {
        Slice<Trip> tripList = tripQueryService.findTripListByTag(tagName, pageable);

        return getTripSearchResponseSlice(tripList);
    }

    private Slice getTripSearchResponseSlice(Slice<Trip> tripList) {
        Slice<TripResponse.TripSearchResponse> tripSearchResponseList =
                tripList.map(trip ->
                {
                    Long tripId = trip.getId();
                    List<LocationInfo> locationInfoListByTripId = locationInfoQueryService.findByTripId(tripId);
                    List<LocationInfoResponse.LocationInfoSimpleResponse> locationInfoUserResponseList =
                            locationInfoListByTripId.stream().map(locationInfo -> {
                                return LocationInfoMapper.mapToLocationInfoSimpleResponse(locationInfo);
                            }).collect(Collectors.toList());
                    return TripMapper.mapToTripSearchResponse(trip, locationInfoUserResponseList);
                });
        return tripSearchResponseList;
    }
}
