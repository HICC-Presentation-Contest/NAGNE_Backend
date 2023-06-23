package com.hicc.nagne_backend.domain.locationinfo.application.dto.response;

import com.hicc.nagne_backend.domain.locationinfo.domain.entity.Address;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LocationInfoResponse {


    @Getter
    @NoArgsConstructor
    public static class LocationInfoSimpleResponse {
        private String placeName;
        private String sequence;

        @Builder
        public LocationInfoSimpleResponse(String placeName, String sequence) {
            this.placeName = placeName;
            this.sequence = sequence;
        }
    }

    @Getter
    public static class LocationInfoDetailsResponse{
        private String place;
        private String description;
        private String sequence;
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
        @Schema(description = "장소 정보")
        private Address address;
        @Schema(description = "여행 순서")
        private String sequence;

        @Builder
        public LocationInfoBookMarkResponse(Address address, String sequence) {
            this.address = address;
            this.sequence = sequence;
        }
    }

}
