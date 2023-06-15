package com.hicc.nagne_backend.domain.locationinfo.domain.repository;

import com.hicc.nagne_backend.domain.locationinfo.domain.entity.LocationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationInfoRepository extends JpaRepository<LocationInfo, Long> {

    List<LocationInfo> findByTripId(Long tripId);
}
