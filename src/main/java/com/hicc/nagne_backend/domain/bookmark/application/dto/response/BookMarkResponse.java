package com.hicc.nagne_backend.domain.bookmark.application.dto.response;

import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class BookMarkResponse { //내가 저장한 bookMark

    @Getter
    public static class BookMarkInfoResponse{
        @Schema(description = "여정 id", defaultValue = "tripId")
        private Long tripId;
        @Schema(description = "여정 정보", defaultValue = "locationInfo")
        private List<LocationInfoResponse.LocationInfoBookMarkResponse> locationInfo;

        @Builder
        public BookMarkInfoResponse(Long tripId, List<LocationInfoResponse.LocationInfoBookMarkResponse> locationInfo) {
            this.tripId = tripId;
            this.locationInfo = locationInfo;
        }
    }
}
