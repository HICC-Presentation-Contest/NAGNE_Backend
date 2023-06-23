package com.hicc.nagne_backend.domain.locationinfo.application.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

public class LocationInfoRequest {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class LocationInfoCreate {

        @Schema(description = "장소", defaultValue = "address")
        private String address;
        @Schema(description = "설명", defaultValue = "description")
        private String description;
        @Schema(description = "순서", defaultValue = "sequence")
        private String sequence;
        @Schema(description = "이미지 리스트", defaultValue = "locationImage")
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
