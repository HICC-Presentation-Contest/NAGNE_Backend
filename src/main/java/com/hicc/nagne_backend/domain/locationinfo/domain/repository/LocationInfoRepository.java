package com.hicc.nagne_backend.domain.locationinfo.domain.repository;

import com.hicc.nagne_backend.domain.locationinfo.domain.entity.LocationInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationInfoRepository extends JpaRepository<LocationInfo, Long> {

    Slice<LocationInfo> findByTripId(Long tripId, Pageable pageable);

    List<LocationInfo> findByTripId(Long tripId);
}
