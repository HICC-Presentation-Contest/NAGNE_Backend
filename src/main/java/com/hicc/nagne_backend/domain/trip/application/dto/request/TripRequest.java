package com.hicc.nagne_backend.domain.trip.application.dto.request;

import com.hicc.nagne_backend.domain.locationinfo.application.dto.request.LocationInfoRequest;
import com.hicc.nagne_backend.domain.tag.application.dto.TagRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.List;

public class TripRequest {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class TripCreateRequest {
        private String address;
        private String title;

        private List<TagRequest.TagCreate> tag;
        private List<LocationInfoRequest.LocationInfoCreate> locationInfo;

        @Builder
        public TripCreateRequest(String address, String title,
                                 List<TagRequest.TagCreate> tag,
                                 List<LocationInfoRequest.LocationInfoCreate> locationInfo) {
            this.address = address;
            this.title = title;
            this.tag = tag;
            this.locationInfo = locationInfo;
        }
    }
}
