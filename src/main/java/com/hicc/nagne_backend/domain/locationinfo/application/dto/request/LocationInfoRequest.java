package com.hicc.nagne_backend.domain.locationinfo.application.dto.request;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

public class LocationInfoRequest {

    @Getter
    @NoArgsConstructor
    public static class LocationInfoCreate {

        private String address; //위치
        private String description; //설명
        private String sequence; //순서
        private MultipartFile locationImage;

        @Builder
        public LocationInfoCreate(String address, String description, String sequence, MultipartFile locationImage) {
            this.address = address;
            this.description = description;
            this.sequence = sequence;
            this.locationImage = locationImage;
        }
    }
}
