package com.hicc.nagne_backend.domain.locationinfo.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    private String address;
    private String longitude;
    private String latitude;

    @Builder
    public Address(String address, String longitude, String latitude) {
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
