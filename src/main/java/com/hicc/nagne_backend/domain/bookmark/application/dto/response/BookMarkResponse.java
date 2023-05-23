package com.hicc.nagne_backend.domain.bookmark.application.dto.response;

import lombok.Builder;
import lombok.Getter;

public class BookMarkResponse {

    @Getter
    public static class BookMarkInfoResponse{
        public Long tripId;

        @Builder
        public BookMarkInfoResponse(Long tripId){
            this.tripId = tripId;
        }
    }
}
