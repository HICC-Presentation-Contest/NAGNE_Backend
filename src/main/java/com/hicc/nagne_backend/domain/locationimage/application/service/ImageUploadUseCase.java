package com.hicc.nagne_backend.domain.locationimage.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.domain.locationimage.domain.entity.LocationImage;
import com.hicc.nagne_backend.domain.locationimage.domain.service.ImageSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class ImageUploadUseCase {

    private final ImageSaveService imageSaveService;

    public void uploadImage(LocationImage locationImage) {
        imageSaveService.saveImage(locationImage);
    }
}
