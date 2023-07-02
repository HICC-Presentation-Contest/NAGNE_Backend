package com.hicc.nagne_backend.domain.bookmark.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

public class BookMarkResponse { //내가 저장한 bookMark

    @Getter
    public static class BookMarkInfoResponse{
        @Schema(description = "여정 id", defaultValue = "tripId")
        private Long tripId;
        @Schema(description = "여정 지도 이미지", defaultValue = "tripImageUrl")
        private String tripImageUrl;
        @Schema(description = "북마크 여부", defaultValue = "isBookMark")
        private boolean isBookMark;

        @Builder
        public BookMarkInfoResponse(Long tripId, String tripImageUrl, boolean isBookMark) {
            this.tripId = tripId;
            this.tripImageUrl = tripImageUrl;
            this.isBookMark = isBookMark;
        }
    }

    @Getter
    public static class BookMarkCountResponse{
        @Schema(description = "북마크 수", defaultValue = "bookMarkCount")
        private Long bookMarkCount;

        public BookMarkCountResponse(Long bookMarkCount) {
            this.bookMarkCount = bookMarkCount;
        }
    }
}
