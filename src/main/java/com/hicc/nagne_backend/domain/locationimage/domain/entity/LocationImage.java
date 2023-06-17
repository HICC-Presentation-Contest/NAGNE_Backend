package com.hicc.nagne_backend.domain.locationimage.domain.entity;

import com.hicc.nagne_backend.common.domain.BaseTimeEntity;
import com.hicc.nagne_backend.domain.locationinfo.domain.entity.LocationInfo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LocationImage extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_image_id")
    private Long id;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_info_id")
    private LocationInfo locationInfo;

    @Builder
    public LocationImage(String imageUrl, LocationInfo locationInfo) {
        this.imageUrl = imageUrl;
        this.locationInfo = locationInfo;
    }
}
