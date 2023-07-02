package com.hicc.nagne_backend.domain.locationinfo.domain.entity;

import com.hicc.nagne_backend.common.domain.BaseTimeEntity;
import com.hicc.nagne_backend.domain.locationimage.domain.entity.LocationImage;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LocationInfo extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_info_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    private Address address;
    private String description; //설명
    private String sequence; //순서

    @OneToMany(mappedBy = "locationInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LocationImage> locationImageList = new ArrayList<>();

    @Builder
    public LocationInfo(Trip trip, Address address, String description, String sequence) {
        this.trip = trip;
        this.address = address;
        this.description = description;
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "LocationInfo{" +
                "id=" + id +
                ", address=" + address +
                ", description='" + description + '\'' +
                ", sequence='" + sequence + '\'' +
                '}';
    }
}
