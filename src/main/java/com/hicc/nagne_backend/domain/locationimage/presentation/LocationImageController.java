package com.hicc.nagne_backend.domain.locationimage.presentation;

import com.hicc.nagne_backend.domain.locationimage.application.service.ImageUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class LocationImageController {

    private final ImageUploadService imageUploadService;
    @PostMapping("/locationImage")
    public void uploadLocationImage(@RequestParam MultipartFile multipartFile){
        imageUploadService.uploadImage(multipartFile);
    }
}
