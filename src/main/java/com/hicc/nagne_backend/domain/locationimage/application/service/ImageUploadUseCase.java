package com.hicc.nagne_backend.domain.locationimage.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.domain.locationimage.domain.service.ImageSaveService;
import com.hicc.nagne_backend.domain.s3.infrastructure.S3UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@UseCase
@RequiredArgsConstructor
public class ImageUploadUseCase {

    private final ImageSaveService imageSaveService;
    private final S3UploadService s3UploadService;

    public String uploadImage(MultipartFile multipartFile) throws IOException {

        /*
        LocationImage locationImage = LocationImage.builder()
                .imageUrl(multipartFile.getOriginalFilename())
                .build();

        imageSaveService.saveImage(locationImage);
        */

        return s3UploadService.upload(multipartFile);

    }
}
