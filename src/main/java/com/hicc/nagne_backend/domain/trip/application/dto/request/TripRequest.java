package com.hicc.nagne_backend.domain.trip.application.dto.request;

import lombok.Builder;
import lombok.Getter;

public class TripRequest {

    @Getter
    public static class TripCreateRequest {
        private long userId;

        private String address;
        private String title;

        @Builder
        public TripCreateRequest(long userId, String username, String address, String title) {
            this.userId = userId;
            this.address = address;
            this.title = title;
        }
    }
}
