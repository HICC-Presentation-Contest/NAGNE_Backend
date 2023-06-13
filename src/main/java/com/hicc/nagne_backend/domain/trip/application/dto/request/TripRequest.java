package com.hicc.nagne_backend.domain.trip.application.dto.request;

import com.hicc.nagne_backend.domain.locationinfo.application.dto.LocationInfoRequest;
import com.hicc.nagne_backend.domain.tag.application.dto.TagRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class TripRequest {

    @Getter
    @NoArgsConstructor
    public static class TripCreateRequest {
        private String address;
        private String title;

        private List<TagRequest.TagCreate> tag;
        private List<LocationInfoRequest.LocationInfoCreate> locationInfo;
        private MultipartFile locationImg;

        @Builder
        public TripCreateRequest(String address, String title,
                                 List<TagRequest.TagCreate> tag,
                                 List<LocationInfoRequest.LocationInfoCreate> locationInfo,
                                 MultipartFile locationImg) {
            this.address = address;
            this.title = title;
            this.tag = tag;
            this.locationInfo = locationInfo;
            this.locationImg = locationImg;
        }
    }
}
