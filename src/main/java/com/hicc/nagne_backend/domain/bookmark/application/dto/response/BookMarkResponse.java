package com.hicc.nagne_backend.domain.bookmark.application.dto.response;

import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class BookMarkResponse { //내가 저장한 bookMark

    @Getter
    public static class BookMarkInfoResponse{

        private Long tripId;
        private List<LocationInfoResponse.LocationInfoBookMarkResponse> locationInfo;

        @Builder
        public BookMarkInfoResponse(Long tripId, List<LocationInfoResponse.LocationInfoBookMarkResponse> locationInfo) {
            this.tripId = tripId;
            this.locationInfo = locationInfo;
        }
    }
}
