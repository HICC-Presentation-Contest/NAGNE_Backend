package com.hicc.nagne_backend.domain.locationimage.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.domain.locationimage.domain.entity.LocationImage;
import com.hicc.nagne_backend.domain.locationimage.domain.service.LocationImageSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class ImageUploadUseCase {

    private final LocationImageSaveService locationImageSaveService;

    public void uploadImage(LocationImage locationImage) {
        locationImageSaveService.saveImage(locationImage);
    }
}
