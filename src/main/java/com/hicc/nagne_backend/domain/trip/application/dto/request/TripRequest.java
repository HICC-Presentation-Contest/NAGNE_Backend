package com.hicc.nagne_backend.domain.trip.application.dto.request;

import com.hicc.nagne_backend.domain.locationinfo.domain.entity.LocationInfo;
import com.hicc.nagne_backend.domain.tag.domain.entity.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class TripRequest {

    @Getter
    @NoArgsConstructor
    public static class TripCreateRequest {
        private String address;
        private String title;

        private List<Tag> tag;
        private List<LocationInfo> locationInfo;

        @Builder
        public TripCreateRequest(String address, String title, List<Tag> tag, List<LocationInfo> locationInfo) {
            this.address = address;
            this.title = title;
            this.tag = tag;
            this.locationInfo = locationInfo;
        }
    }
}
