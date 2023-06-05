package com.hicc.nagne_backend.domain.locationinfo.domain.service;

import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.domain.locationinfo.domain.entity.LocationInfo;
import com.hicc.nagne_backend.domain.locationinfo.domain.repository.LocationInfoRepository;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DomainService
@RequiredArgsConstructor
@Transactional
public class LocationInfoSaveService {

    private final LocationInfoRepository locationInfoRepository;
    public void save(List<LocationInfo> locationInfoList, Trip trip) {

        locationInfoList.forEach(locationInfo ->
                locationInfoRepository.save(LocationInfo.builder()
                        .description(locationInfo.getDescription())
                        .address(locationInfo.getAddress())
                        .sequence(locationInfo.getSequence())
                        .trip(trip)
                        .build())
        );
    }
}
