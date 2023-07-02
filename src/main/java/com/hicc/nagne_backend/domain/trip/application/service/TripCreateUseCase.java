package com.hicc.nagne_backend.domain.trip.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.util.UserUtils;
import com.hicc.nagne_backend.domain.locationimage.application.mapper.LocationImageMapper;
import com.hicc.nagne_backend.domain.locationimage.domain.service.LocationImageSaveService;
import com.hicc.nagne_backend.domain.locationinfo.application.mapper.LocationInfoMapper;
import com.hicc.nagne_backend.domain.locationinfo.domain.entity.LocationInfo;
import com.hicc.nagne_backend.domain.locationinfo.domain.service.LocationInfoSaveService;
import com.hicc.nagne_backend.domain.s3.infrastructure.S3UploadService;
import com.hicc.nagne_backend.domain.tag.application.mapper.TagMapper;
import com.hicc.nagne_backend.domain.tag.domain.service.TagSaveService;
import com.hicc.nagne_backend.domain.trip.application.dto.request.TripRequest;
import com.hicc.nagne_backend.domain.trip.application.mapper.TripMapper;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.trip.domain.service.TripSaveService;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@UseCase
@RequiredArgsConstructor
@Transactional
public class TripCreateUseCase {

    private final TripSaveService tripSaveService;
    private final TagSaveService tagSaveService;
    private final LocationInfoSaveService locationInfoSaveService;
    private final UserUtils userUtils;
    private final S3UploadService s3UploadService;
    private final LocationImageSaveService locationImageSaveService;

    @Transactional
    public void createTrip(final TripRequest.TripCreateRequest tripCreateRequest) {
        final User user = userUtils.getUser();
        final String tripImageUrl = s3UploadService.upload(tripCreateRequest.getTripImage());
        final Trip trip = TripMapper.mapToTrip(tripCreateRequest, tripImageUrl,user);
        tripSaveService.save(trip);
        tripCreateRequest.getTag().forEach(tagCreate -> tagSaveService.save(TagMapper.mapToTag(trip, tagCreate)));
        tripCreateRequest.getLocationInfo().forEach(locationInfoCreateRequest -> {
            final LocationInfo locationInfo = LocationInfoMapper.mapToLocationInfo(trip, locationInfoCreateRequest);
            locationInfoSaveService.save(locationInfo);
            final String imgUrl = s3UploadService.upload(locationInfoCreateRequest.getLocationImage());
            locationImageSaveService.saveImage(LocationImageMapper.mapToLocationImage(imgUrl, locationInfo));
        });
    }
}
