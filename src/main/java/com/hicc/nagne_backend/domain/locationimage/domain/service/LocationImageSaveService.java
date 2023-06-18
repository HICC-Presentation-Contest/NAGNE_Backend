package com.hicc.nagne_backend.domain.locationimage.domain.service;

import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.domain.locationimage.domain.entity.LocationImage;
import com.hicc.nagne_backend.domain.locationimage.domain.repostiory.LocationImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
@Transactional
public class LocationImageSaveService {

    private final LocationImageRepository locationImageRepository;
    public void saveImage(LocationImage locationImage){
        locationImageRepository.save(locationImage);
    }
}
