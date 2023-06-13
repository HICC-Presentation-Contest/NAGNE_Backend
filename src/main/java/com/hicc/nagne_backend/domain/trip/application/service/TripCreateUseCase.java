package com.hicc.nagne_backend.domain.trip.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.util.UserUtils;
import com.hicc.nagne_backend.domain.locationimage.domain.entity.LocationImage;
import com.hicc.nagne_backend.domain.locationimage.domain.service.ImageSaveService;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@UseCase
@RequiredArgsConstructor
@Transactional
public class TripCreateUseCase {

    private final TripSaveService tripSaveService;
    private final TagSaveService tagSaveService;
    private final LocationInfoSaveService locationInfoSaveService;
    private final UserUtils userUtils;
    private final S3UploadService s3UploadService;
    private final ImageSaveService imageSaveService;


    @Transactional
    public void createTrip(TripRequest.TripCreateRequest tripCreateRequest) {
        User user = userUtils.getUser();
        Trip trip = TripMapper.mapToTrip(tripCreateRequest, user);

        tripCreateRequest.getTag().forEach(tagCreate ->
                tagSaveService.save(TagMapper.mapToTag(trip, tagCreate)));


        List<LocationInfo> locationInfoList = LocationInfoMapper.mapToLocationInfo(trip, tripCreateRequest.getLocationInfo());
        MultipartFile locationImg = tripCreateRequest.getLocationInfo().get(0).getLocationImage();

        String imgUrl = s3UploadService.upload(locationImg);

        locationInfoList.forEach(locationInfo -> {
            locationInfoSaveService.save(locationInfo);
            imageSaveService.saveImage(LocationImage.builder()
                    .locationInfo(locationInfo)
                    .imageUrl(imgUrl)
                    .build());
        });

        tripSaveService.save(trip);
    }
}
