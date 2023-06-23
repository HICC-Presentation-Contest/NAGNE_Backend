package com.hicc.nagne_backend.domain.bookmark.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BookMarkRequest {

    @Getter
    @NoArgsConstructor
    public static class BookMarkCreateRequest {
        @Schema(description = "북마크한 여정 id", defaultValue = "tripId")
        private Long tripId;

        @Builder
        public BookMarkCreateRequest(Long tripId) {
            this.tripId = tripId;
        }
    }
}
