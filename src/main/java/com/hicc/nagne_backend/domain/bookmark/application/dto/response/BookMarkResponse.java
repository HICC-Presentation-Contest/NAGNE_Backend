package com.hicc.nagne_backend.domain.bookmark.application.dto.response;

import lombok.Builder;
import lombok.Getter;

public class BookMarkResponse { //내가 저장한 bookMark

    @Getter
    public static class BookMarkInfoResponse{

        private Long tripId;


        @Builder
        public BookMarkInfoResponse(Long tripId){
            this.tripId = tripId;
        }
    }
}
