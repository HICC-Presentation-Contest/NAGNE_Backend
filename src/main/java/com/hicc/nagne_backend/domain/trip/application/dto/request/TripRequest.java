package com.hicc.nagne_backend.domain.trip.application.dto.request;

import com.hicc.nagne_backend.domain.locationinfo.application.dto.request.LocationInfoRequest;
import com.hicc.nagne_backend.domain.tag.application.dto.TagRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class TripRequest {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class TripCreateRequest {
        @Schema(description = "주소", defaultValue = "address")
        private String address;
        @Schema(description = "제목", defaultValue = "title")
        private String title;
        @Schema(description = "여행 이미지", defaultValue = "tripImage")
        private MultipartFile tripImage;
        @Schema(description = "태그", defaultValue = "tag")
        private List<TagRequest.TagCreate> tag;
        @Schema(description = "여행 장소 리스트", defaultValue = "locationInfoList")
        private List<LocationInfoRequest.LocationInfoCreate> locationInfo;

        @Builder
        public TripCreateRequest(String address, String title, MultipartFile tripImage,
                                 List<TagRequest.TagCreate> tag,
                                 List<LocationInfoRequest.LocationInfoCreate> locationInfo) {
            this.address = address;
            this.title = title;
            this.tripImage = tripImage;
            this.tag = tag;
            this.locationInfo = locationInfo;
        }

        @Override
        public String toString() {
            return "TripCreateRequest{" +
                    "address='" + address + '\'' +
                    ", title='" + title + '\'' +
                    ", tag=" + tag +
                    ", locationInfo=" + locationInfo +
                    '}';
        }
    }
}
