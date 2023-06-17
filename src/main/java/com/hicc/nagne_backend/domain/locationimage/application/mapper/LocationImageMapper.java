package com.hicc.nagne_backend.domain.locationimage.application.mapper;

import com.hicc.nagne_backend.domain.locationimage.domain.entity.LocationImage;
import com.hicc.nagne_backend.domain.locationinfo.domain.entity.LocationInfo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationImageMapper {

    public static LocationImage mapToLocationImage(String imageUrl, LocationInfo locationInfo) {
        return LocationImage.builder()
                .imageUrl(imageUrl)
                .locationInfo(locationInfo)
                .build();
    }
}
