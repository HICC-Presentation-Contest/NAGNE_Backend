package com.hicc.nagne_backend.domain.locationimage.domain.entity;

import com.hicc.nagne_backend.common.domain.BaseTimeEntity;
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
    private LocationImage locationImage;

    @Builder

    public LocationImage(String imageUrl, LocationImage locationImage) {
        this.imageUrl = imageUrl;
        this.locationImage = locationImage;
    }
}
