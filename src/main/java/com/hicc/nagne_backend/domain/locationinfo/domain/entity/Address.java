package com.hicc.nagne_backend.domain.locationinfo.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    @Schema(description = "장소 이름")
    private String placeName;
    @Schema(description = "경도")
    private String longitude;
    @Schema(description = "위도")
    private String latitude;

    @Builder
    public Address(String placeName, String longitude, String latitude) {
        this.placeName = placeName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Address{" +
                "placeName='" + placeName + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
