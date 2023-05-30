package com.hicc.nagne_backend.domain.locationimage.application.service;

import com.hicc.nagne_backend.common.infra.s3.S3UploadService;
import com.hicc.nagne_backend.domain.locationimage.domain.service.ImageSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageUploadService {

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
