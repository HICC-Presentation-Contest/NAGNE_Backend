package com.hicc.nagne_backend.domain.locationimage.application.service;

import com.hicc.nagne_backend.domain.locationimage.domain.entity.LocationImage;
import com.hicc.nagne_backend.domain.locationimage.domain.service.ImageSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ImageUploadService {

    private final ImageSaveService imageSaveService;
    public void uploadImage(MultipartFile multipartFile){

        LocationImage locationImage = LocationImage.builder()
                .imageUrl(multipartFile.getOriginalFilename())
                .build();

        imageSaveService.saveImage(locationImage);

    }
}
