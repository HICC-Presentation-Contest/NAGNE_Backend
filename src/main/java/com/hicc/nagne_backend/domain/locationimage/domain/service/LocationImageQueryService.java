package com.hicc.nagne_backend.domain.locationimage.domain.service;

import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.common.exception.Error;
import com.hicc.nagne_backend.domain.locationimage.domain.exception.ImageNotFoundException;
import com.hicc.nagne_backend.domain.locationimage.domain.repostiory.LocationImageRepository;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class LocationImageQueryService {

    private final LocationImageRepository locationImageRepository;

    public String findImageUrlByLocationInfoId(Long locationInfoId){
        return locationImageRepository.findFirstByLocationInfoId(locationInfoId)
                .orElseThrow(() -> new ImageNotFoundException(Error.LOCATION_IMAGE_NOT_FOUND))
                .getImageUrl();
    }
}
