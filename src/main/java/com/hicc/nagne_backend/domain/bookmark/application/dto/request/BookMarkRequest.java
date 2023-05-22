package com.hicc.nagne_backend.domain.bookmark.application.dto.request;

import lombok.Builder;
import lombok.Getter;

public class BookMarkRequest {

    @Getter
    public static class BookMarkCreateRequest {

        //북마크 화면에 지도 사진이 뜨길래 일단 이렇게만 받음
        private Long userId;
        private Long tripId;

        @Builder
        public BookMarkCreateRequest(Long userId, Long tripId) {
            this.userId = userId;
            this.tripId = tripId;
        }
    }
}
