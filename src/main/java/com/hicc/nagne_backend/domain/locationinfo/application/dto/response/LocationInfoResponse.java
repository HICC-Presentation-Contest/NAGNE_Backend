package com.hicc.nagne_backend.domain.locationinfo.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LocationInfoResponse {

    @Getter
    @NoArgsConstructor
    public static class LocationInfoUserResponse {
        private String place;
        private String sequence;

        @Builder
        public LocationInfoUserResponse(String place, String sequence) {
            this.place = place;
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
}
