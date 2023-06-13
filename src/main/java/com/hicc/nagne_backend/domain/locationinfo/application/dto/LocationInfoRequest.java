package com.hicc.nagne_backend.domain.locationinfo.application.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LocationInfoRequest {

    @Getter
    @NoArgsConstructor
    public static class LocationInfoCreate {

        private String address; //위치
        private String description; //설명
        private String sequence; //순서

        @Builder
        public LocationInfoCreate(String address, String description, String sequence) {
            this.address = address;
            this.description = description;
            this.sequence = sequence;
        }
    }
}
