package com.hicc.nagne_backend.domain.locationinfo.application.dto.response;

import com.hicc.nagne_backend.domain.locationinfo.domain.entity.Address;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LocationInfoResponse {

    @Getter
    @NoArgsConstructor
    public static class LocationInfoMainPageResponse {
        @Schema(description = "위치 정보", defaultValue = "address")
        private Address address;
        @Schema(description = "순서", defaultValue = "sequence")
        private String sequence;

        @Builder
        public LocationInfoMainPageResponse(Address address, String sequence) {
            this.address = address;
            this.sequence = sequence;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class LocationInfoSimpleResponse {
        @Schema(description = "장소 이름", defaultValue = "placeName")
        private String placeName;
        @Schema(description = "순서", defaultValue = "sequence")
        private String sequence;

        @Builder
        public LocationInfoSimpleResponse(String placeName, String sequence) {
            this.placeName = placeName;
            this.sequence = sequence;
        }
    }

    @Getter
    public static class LocationInfoDetailsResponse{
        @Schema(description = "장소 정보", defaultValue = "place")
        private String place;
        @Schema(description = "설명", defaultValue = "description")
        private String description;
        @Schema(description = "순서", defaultValue = "sequence")
        private String sequence;
        @Schema(description = "이미지", defaultValue = "imageUrl")
        private String imageUrl;

        @Builder
        public LocationInfoDetailsResponse(String place, String description, String sequence, String imageUrl) {
            this.place = place;
            this.description = description;
            this.sequence = sequence;
            this.imageUrl = imageUrl;
        }
    }

    @Getter
    public static class LocationInfoBookMarkResponse{
        @Schema(description = "장소 정보", defaultValue = "address")
        private Address address;
        @Schema(description = "여행 순서", defaultValue = "sequence")
        private String sequence;

        @Builder
        public LocationInfoBookMarkResponse(Address address, String sequence) {
            this.address = address;
            this.sequence = sequence;
        }
    }

}
