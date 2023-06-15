package com.hicc.nagne_backend.domain.locationinfo.domain.service;

import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.domain.locationinfo.domain.entity.LocationInfo;
import com.hicc.nagne_backend.domain.locationinfo.domain.repository.LocationInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DomainService
@RequiredArgsConstructor
@Transactional
public class LocationInfoQueryService {

    private final LocationInfoRepository locationInfoRepository;
    public List<LocationInfo> findByTripId(Long tripId){
        return locationInfoRepository.findByTripId(tripId);
    }
}
