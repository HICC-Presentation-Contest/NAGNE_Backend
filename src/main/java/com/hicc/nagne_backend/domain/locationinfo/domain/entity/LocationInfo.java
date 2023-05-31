package com.hicc.nagne_backend.domain.locationinfo.domain.entity;

import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LocationInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    private String address; //위치
    private String description; //설명
    private String sequence; //순서

    @Builder
    public LocationInfo(Trip trip, String address, String description, String sequence) {
        this.trip = trip;
        this.address = address;
        this.description = description;
        this.sequence = sequence;
    }
}
