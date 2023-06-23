package com.hicc.nagne_backend.domain.bookmark.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BookMarkRequest {

    @Getter
    @NoArgsConstructor
    public static class BookMarkCreateRequest {
        private Long tripId;

        @Builder
        public BookMarkCreateRequest(Long tripId) {
            this.tripId = tripId;
        }
    }
}
