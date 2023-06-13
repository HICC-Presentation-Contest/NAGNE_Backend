package com.hicc.nagne_backend.domain.locationinfo.domain.service;

import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.domain.locationinfo.domain.entity.LocationInfo;
import com.hicc.nagne_backend.domain.locationinfo.domain.repository.LocationInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
@Transactional
public class LocationInfoSaveService {

    private final LocationInfoRepository locationInfoRepository;
    public void save(LocationInfo locationInfo) {

        locationInfoRepository.save(locationInfo);
    }
}
